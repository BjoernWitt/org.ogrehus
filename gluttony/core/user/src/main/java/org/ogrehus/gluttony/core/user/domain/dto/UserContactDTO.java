/*
 * GNU Lesser General Public License v3.0
 * https://www.gnu.org/licenses/lgpl-3.0-standalone.html
 * 
 * Copyright (C) 2025 Björn Witt
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
package org.ogrehus.gluttony.core.user.domain.dto;

import java.util.UUID;

import org.ogrehus.gluttony.core.user.domain.api.model.contact.UserContactReadable;
import org.ogrehus.gluttony.foundation.pattern.contactable.ContactType;

public record UserContactDTO(
	  UUID uniqueIdentifier
	, String identifier
	, ContactType type
	, String name
	, String information
) implements
	UserContactReadable
{



	@Override
	public UUID getUniqueIdentifier() {
		return uniqueIdentifier;
	}



	@Override
	public String getName() {
		return name;
	}



	@Override
	public String getIdentifier() {
		return identifier;
	}



	@Override
	public ContactType getType() {
		return type;
	}



	@Override
	public String getInformation() {
		return information;
	}



//----------------------------------------------------------------------------------------------------------------------------------------------------



	public static UserContactDTO of(UserContactReadable contact) {
		return new UserContactDTO(
			  contact.getUniqueIdentifier()
			, contact.getIdentifier()
			, contact.getType()
			, contact.getName()
			, contact.getInformation());
	}



	public static UserContactDTO of(
		  String identifier
		, ContactType type
		, String name
		, String information
	) {
		return new UserContactDTO(null, identifier, type, name, information);
	}
}