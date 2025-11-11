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
package org.ogrehus.gluttony.foundation.pattern.password;

import org.ogrehus.gluttony.foundation.pattern.time.Timestampable;

/**
 * Defines read access to the structural features of a password.
 * <p>
 * A password can be describes by a value and the kind of its quality level.
 * </p>
 * 
 * @author Björn Witt
 * 
 */
public interface PasswordReadable
extends
	Timestampable
{



	/**
	 * Provides the value of this password. 
	 * 
	 * @return The value of this password.
	 * 
	 */
	String getValue();



	/**
	 * Detects whether a value for the password can be provided or not.
	 * 
	 * @return {@code true} if the value of this password is not null and is not blank, otherwise {@code false}.
	 * 
	 */
	default boolean isValueAvailable() {
		return getValue() != null && !getValue().isBlank();
	}



	/**
	 * Provides the kind of quality that this password complains regarding to security demands. 
	 * 
	 * @return The kind of quality of this password.
	 * 
	 */
	PasswordQualityKind getQuality();



	/**
	 * Detects whether a value for quality can be provided or not.
	 * 
	 * @return {@code true} if the value of quality is not null, otherwise {@code false}.
	 * 
	 */
	default boolean isQualityAvailable() {
		return getQuality() != null;
	}
}