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

import java.util.UUID;

/**
 * Defines modification access to the structural features of user information.
 * 
 * @author Björn Witt
 * 
 */
public interface UserInformationModifiable {



	/**
	 * Changes the value of the structural feature uniqueIdentifier in this user contact. 
	 * 
	 * @param uniqueIdentifier The new value for the structural feature uniqueIdentifier. 
	 * 
	 */
	void setUniqueIdentifier(UUID uniqueIdentifier);



	/**
	 * Changes the value of the structural feature identifier in this user contact. 
	 * 
	 * @param identifier The new value for the structural feature identifier. 
	 * 
	 */
	void setIdentifier(String identifier);



	/**
	 * Changes the value of the structural feature name in this user contact.
	 * 
	 * @param type The new value for the structural feature name.
	 * 
	 */
	void setName(String name);
}