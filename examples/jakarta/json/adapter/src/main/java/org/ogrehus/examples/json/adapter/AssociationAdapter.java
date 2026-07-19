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
package org.ogrehus.examples.json.adapter;

import java.util.Collections;
import java.util.Set;

import org.ogrehus.yafm.association.api.Association;
import org.ogrehus.yafm.association.api.AssociationMembership;
import org.ogrehus.yafm.association.api.Membership;
import org.ogrehus.yafm.association.api.AssociationOrganization;
import org.ogrehus.yafm.association.api.ClubMembership;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AssociationAdapter 
implements 
	JsonbAdapter<Association<AssociationOrganization>, JsonObject>
{



	@Override
	public JsonObject adaptToJson(Association<AssociationOrganization> association)	{
		JsonArrayBuilder memberBuilder = Json.createArrayBuilder();
		
		for (Membership<?> membership : association.getMemberships()) {
			if (membership instanceof ClubMembership clubMembership ) {
				memberBuilder.add(new ClubMembershipAdapter().adaptToJson(clubMembership));
			}
			if (membership instanceof AssociationMembership associationMembership ) {
				memberBuilder.add(new AssociationMembershipAdapter().adaptToJson(associationMembership));
			}
		}
		
		return Json.createObjectBuilder()
				   .add("name", association.getName())
				   .add("acronym", association.getAcronym())
				   .add("organization", new AssociationOrganizationAdapter().adaptToJson(association.getOrganization()))
				   .add("memberships", memberBuilder) 
				   .build();
	}



	@Override
	public Association<AssociationOrganization> adaptFromJson(JsonObject json) {
		return new Association<AssociationOrganization>() {
			@Override public AssociationOrganization getOrganization() { return new AssociationOrganizationAdapter().adaptFromJson(json.getJsonObject("organization")); }
			@Override public String getName() { return json.getString("name", ""); }
			@Override public Set<Membership<?>> getMemberships() { return Collections.emptySet(); }
			@Override public String getAcronym() { return json.getString("acronym", ""); }
		};
	}
}