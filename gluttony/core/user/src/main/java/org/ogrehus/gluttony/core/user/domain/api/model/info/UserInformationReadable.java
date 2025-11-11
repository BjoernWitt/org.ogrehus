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
package org.ogrehus.gluttony.core.user.domain.api.model.info;

import java.util.Locale;

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;
import org.ogrehus.gluttony.foundation.pattern.identifiable.UUIdentifiable;

/**
 * Defines read access to the structural features of user information.
 * 
 * @author Björn Witt
 * 
 */
public interface UserInformationReadable
extends
	  UUIdentifiable
	, Nameable
{



	/**
	 * Provides an identifier shown to the users. 
	 * <p>
	 * <ul>
	 * <li>This identifier is no primary key, but must be unique within the application per user.</li>
	 * <li>This identifier shall not be null.</li>
	 * <ul>
	 * </p>
	 * 
	 * @return The value of identifier.
	 * 
	 */
	String getIdentifier();



	/**
	 * Detects whether a value for identifier can be provided or not.
	 * 
	 * @return {@code true} if the value of identifier is not null and is not blank, otherwise {@code false}.
	 * 
	 */
	default boolean isIdentifierAvailable() {
		return getIdentifier() != null && !getIdentifier().isBlank();
	}



	/**
	 * Provides a language ID that the user claims as the mother tongue. 
	 * <p>
	 * <ul>
	 * <li>The language shall be a textual representation of a Locale.</li>
	 * <li>This identifier shall not be null.</li>
	 * </ul>
	 * </p>
	 * 
	 * @return The value of language.
	 * 
	 */
	Locale getLanguage();



	/**
	 * Detects whether a value for language can be provided or not.
	 * 
	 * @return {@code true} if the value of language is not null and is not blank, otherwise {@code false}.
	 * 
	 */
	default boolean isLanguageAvailable() {
		return getLanguage() != null;
	}
}