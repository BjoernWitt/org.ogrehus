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
package org.ogrehus.gluttony.foundation.persistence.api.repository;

import java.util.Optional;

import org.ogrehus.gluttony.foundation.pattern.identifiable.UniqueIdentifiable;

/**
 * Identifiable repositories provide management by the identifiable structural feature of the entities.
 * 
 * <p>
 * This interface provides the identifiable access to the repositories content.
 * </p>
 * 
 * @param <TYPE> The unique identifiable type of the domain object.
 * 
 * @param <ID> The Type of of unique identifier. 
 * 
 */
public interface IdentifiableRepository<TYPE extends UniqueIdentifiable<ID>, ID>
extends
	Repository<TYPE>
{



	/**
	 * Provides the property name of the structural feature that acts as the unique identifier.
	 * 
	 * @return Name of the property that acts as the unique identifier, may not be {@code null}.
	 * 
	 */
	String getUniqueIdentifierPropertyName();



	/**
	 * Returns a single entity, if identifiable by an unique identifier.
	 * 
	 * @param identifier to indicate the specific entity.
	 *  
	 * @return An Optional of an entity, specified by the unique identifier.
	 * 
	 */
	Optional<TYPE> findByUniqueIdentifier(ID identifier);



	/**
	 * Returns a single entity, if identifiable by an unique identifier.
	 * 
	 * @param identifier to indicate the specific entity.
	 *  
	 * @return An Optional of an entity, specified by the unique identifier.
	 * 
	 */
	Iterable<TYPE> findAllByUniqueIdentifiers(Iterable<ID> identifier);
}