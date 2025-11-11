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

import java.util.Locale;
import java.util.UUID;

import org.ogrehus.gluttony.core.user.domain.api.model.info.UserInformationReadable;

/**
 * Defines an implementation of the user information.
 * 
 * @author Björn Witt
 * 
 */
public record UserInformationDTO(
	  UUID uniqueIdentifier
	, String identifier
	, String name
	, Locale language
) implements
	UserInformationReadable
{


	@Override
	public UUID getUniqueIdentifier() {
		return uniqueIdentifier;
	}



	@Override
	public String getIdentifier() {
		return identifier;
	}



	@Override
	public String getName() {
		return name;
	}



	@Override
	public Locale getLanguage() {
		return language;
	}



//----------------------------------------------------------------------------------------------------------------------------------------------------



	public static UserInformationDTO of(UserInformationReadable information) {
		return new UserInformationDTO(
			  information.getUniqueIdentifier()
			, information.getIdentifier()
			, information.getName()
			, information.getLanguage());
	}



	public static UserInformationDTO of(
		  String identifier
		, String name
		, Locale language
	) {
		return new UserInformationDTO(null, identifier, name, language);
	}
}