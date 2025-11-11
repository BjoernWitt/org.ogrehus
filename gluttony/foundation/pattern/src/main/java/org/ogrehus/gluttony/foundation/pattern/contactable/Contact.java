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
package org.ogrehus.gluttony.foundation.pattern.contactable;

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;

/**
 * A contact provides access to a given information of contact type and value.
 *
 * @author Björn Witt
 * 
 */
public interface Contact
extends
	Nameable
{



	ContactType getType();



	/**
	 * Returns {@code true} if a value of the structural feature type is available, otherwise {@code false}.
	 * 
	 * @return {@code true} if the value of type is not null, otherwise {@code false}
	 * 
	 */
	default boolean isTypeAvailable() {
		return getType() != null;
	}



	/**
	 * Provides the information of this contact entity.
	 * 
	 * @return The information of this contact entity.
	 * 
	 */
	String getInformation();



	/**
	 * Returns {@code true} if a value of the structural feature information is available, otherwise {@code false}.
	 * 
	 * @return {@code true} if the value of information is not null and is no zerostring, otherwise {@code false}
	 * 
	 */
	default boolean isInformationAvailable() {
		return getInformation() != null && !getInformation().isBlank();
	}
}