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

import org.ogrehus.yafm.association.api.AssociatedClub;
import org.ogrehus.yafm.association.api.ClubMembership;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class ClubMembershipAdapter 
implements 
	JsonbAdapter<ClubMembership, JsonObject>
{



	@Override
	public JsonObject adaptToJson(ClubMembership membership) {
		return Json.createObjectBuilder()
				   .add("member", new AssociatedClubAdapter().adaptToJson(membership.getMember()))
				   .build();
	}



	@Override
	public ClubMembership adaptFromJson(JsonObject json) {
		return new ClubMembership() {
			@Override public AssociatedClub getMember() { return new AssociatedClubAdapter().adaptFromJson(json.getJsonObject("member")); }
		};
	}
}