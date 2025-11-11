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
package org.ogrehus.gluttony.foundation.pattern.nameable;

/**
 * An acronymable entity is an entity that has an acronym (shortcut).
 * 
 * A Acronymable provides access to a given acronym of the entity.
 * 
 * @author Björn Witt
 * 
 */
public interface Acronymable {



	/**
	 * Provides the acronym of this entity.
	 * 
	 * @return The acronym of this entity:
	 * 
	 */
	String getAcronym();



	/**
	 * Detects whether a value for acronym can be provided or not.
	 * 
	 * @return {@code true} if the value of Acronym is not null and is no zerostring, otherwise {@code false}.
	 * 
	 */
	default boolean isAcronymAvailable() {
		return getAcronym() != null && !getAcronym().isBlank();
	}
}