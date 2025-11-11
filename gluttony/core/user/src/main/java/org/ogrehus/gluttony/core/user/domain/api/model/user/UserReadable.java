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
package org.ogrehus.gluttony.core.user.domain.api.model.user;

import org.ogrehus.gluttony.core.user.domain.api.model.contact.UserContactReadable;
import org.ogrehus.gluttony.core.user.domain.api.model.info.UserInformationReadable;
import org.ogrehus.gluttony.foundation.pattern.contactable.Contactable;
import org.ogrehus.gluttony.foundation.pattern.identifiable.UUIdentifiable;
import org.ogrehus.gluttony.foundation.pattern.password.PasswordReadable;

/**
 * This entity is a compound of the complex user information setup.
 * <p>
 * Its own properties are reduces to the minimal technical definition of identifier and validity for smart checking.
 * </p>
 * <p>
 * The references allow access to the full information setup.
 * </p>
 * 
 * @author Björn Witt
 * 
 */
public interface UserReadable<
	  INFO extends UserInformationReadable
	, CONTACT extends UserContactReadable
	, PASSWORD extends PasswordReadable
> extends
	  UUIdentifiable
	, Contactable<CONTACT>
{



	/**
	 * Provides an identifier shown to the outer world for recognition purpose. 
	 * <p>
	 * This identifier is no primary key, but must be unique within the application scope.
	 * This identifier shall not be null.
	 * </p>
	 * 
	 * @return The value of identifier.
	 * 
	 */
	String getIdentifier();



	/**
	 *	Defines, whether a value for the structural feature <code>identifier</code> can be provided by this entity or not.
	 * <p>
	 * Despite the value of <code>identifier</code> must be provided in general to fulfill the constraint of the relational model, the value may be 
	 * undefined for the time of entity creation.
	 * </p>
	 * 
	 * @return <code>true</code> if the structural feature <code>identifier</code> is defined and is not blank, otherwise <code>false</code>.
	 * 
	 */
	default boolean isIdentifierAvailable() {
		return getIdentifier() != null && !getIdentifier().isBlank();
	}



	/**
	 * Provides the language information that the user wants for indication for i18n. 
	 * <p>
	 * The value for language shall be in the range of provided languages that the application supports.
	 * This language may be <code>null</code> if no i18n is supported by the application.
	 * </p>
	 * 
	 * @return The value of identifier.
	 * 
	 */
	String getLanguage();



	/**
	 *	Defines, whether a value for the structural feature <code>language</code> can be provided by this entity or not.
	 * <p>
	 * Despite the value of <code>identifier</code> must be provided in general to fulfill the constraint of the relational model, the value may be 
	 * undefined for the time of entity creation.
	 * </p>
	 * 
	 * @return <code>true</code> if the structural feature <code>identifier</code> is defined and is not blank, otherwise <code>false</code>.
	 * 
	 */
	default boolean isLanguageAvailable() {
		return getLanguage() != null && !getLanguage().isBlank();
	}
}