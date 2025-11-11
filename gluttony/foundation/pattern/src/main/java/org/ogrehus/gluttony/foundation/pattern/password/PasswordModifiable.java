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

/**
 * Defines modification access to the structural features of Password.
 * 
 */
public interface PasswordModifiable {



	/**
	 * Changes the value of the structural feature value of password in this entity.
	 * 
	 * @param value The new value for the structural feature value of password.
	 * 
	 */
	void setValue(String value);
	
	
	
	/**
	 * Changes the value of the structural feature quality in this entity.
	 * 
	 * @param quality The new value for the structural feature quality of this entity.
	 * 
	 */
	void setQuality(PasswordQualityKind quality);
}