/*
 * GNU Lesser General Public License v3.0
 * https://www.gnu.org/licenses/lgpl-3.0-standalone.html
 * 
 * Copyright (C) 2026 Björn Witt
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 */
package org.ogrehus.examples.jakarta.security.jwt;

import java.math.BigDecimal;
import java.util.Optional;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;

@ApplicationScoped
@DeclareRoles({"ViewBalance", "Debtor", "Creditor", "Debtor2", "Whale"})
@Path("/")
@DenyAll
public class MySecureWallet {
	
    private double whaleLimit = 1000;
    private BigDecimal usdBalance = new BigDecimal("100000.0000");
    private BigDecimal bitcoinXrate = new BigDecimal("4538.0000");
    private BigDecimal ethereumXrate = new BigDecimal("328.0000");

    @Inject
    private JsonWebToken jwt;

    @Inject
    @Claim("warningLimit")
    private Instance<Optional<JsonNumber>> warningLimitInstance;

    @GET
    @Path("/balance")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ViewBalance", "Debtor", "Creditor"})
    public JsonObject getBalance() {
        return generateBalanceInfo();
    }

    @GET
    @Path("/debit")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Debtor", "Debtor2"})
    public Response debit(@QueryParam("amount") String amount,
                          @Context SecurityContext securityContext) {
        Double dAmount = Double.valueOf(amount);
        if (dAmount > whaleLimit) {
            if (securityContext.isUserInRole("Whale")) {
                // Validate the spending limit from the token claim
                JsonNumber spendingLimit = jwt.getClaim("spendingLimit");
                if (spendingLimit == null || spendingLimit.doubleValue() < dAmount) {
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }
            } else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }
        usdBalance = usdBalance.subtract(new BigDecimal(amount));
        return Response.ok(generateBalanceInfo()).build();
    }

    @GET
    @Path("/credit")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("Creditor")
    public JsonObject credit(@QueryParam("amount") String amount) {
        usdBalance = usdBalance.add(new BigDecimal(amount));
        return generateBalanceInfo();
    }

    private JsonObject generateBalanceInfo() {
        BigDecimal balanceInBitcoins = usdBalance.divide(bitcoinXrate, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal balanceInEthereum = usdBalance.divide(ethereumXrate, BigDecimal.ROUND_HALF_EVEN);
        JsonObjectBuilder result = Json.createObjectBuilder()
                .add("usd", usdBalance)
                .add("bitcoin", balanceInBitcoins)
                .add("ethereum", balanceInEthereum);

        Optional<JsonNumber> warningLimit = warningLimitInstance.get();
        if (warningLimit.isPresent()) {
            if (warningLimit.get().doubleValue() > usdBalance.doubleValue()) {
                String warningMsg = String.format("balance is below warning limit: %s", warningLimit.get());
                result.add("warning", warningMsg);
            }
        }

        return result.build();
    }

}