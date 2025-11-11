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

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.ogrehus.gluttony.core.user.domain.api.model.contact.UserContactReadable;
import org.ogrehus.gluttony.core.user.domain.api.model.info.UserInformationReadable;
import org.ogrehus.gluttony.core.user.domain.api.model.user.UserReadable;
import org.ogrehus.gluttony.foundation.pattern.password.PasswordReadable;

public record UserDTO<
	  INFO extends UserInformationReadable
	, CONTACT extends UserContactReadable
	, PASSWORD extends PasswordReadable
>(
	  UUID uniqueIdentifier
	, String identifier
	, String language
	, List<CONTACT> contacts
) implements
	UserReadable<INFO, CONTACT, PASSWORD>
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
	public String getLanguage() {
		return language;
	}



	@Override
	public List<CONTACT> getContacts() {
		return contacts;
	}



//----------------------------------------------------------------------------------------------------------------------------------------------------



	public static <I extends UserInformationReadable, C extends UserContactReadable, P extends PasswordReadable> UserDTO<I, C, P> of(UserReadable<I, C, P> user) {
		return new UserDTO<I, C, P>(user.getUniqueIdentifier(), user.getIdentifier(), user.getLanguage(), Collections.emptyList());
	}



	public static <I extends UserInformationReadable, C extends UserContactReadable, P extends PasswordReadable> UserDTO<I, C, P> of(String identifier, String language) {
		return new UserDTO<I, C, P>(null, identifier, language, Collections.emptyList());
	}
}