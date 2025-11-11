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

import java.util.List;

/**
 * Repositories abstract the persistence and search of domain objects.
 * <p>
 * Repositories separate the technical infrastructure and all access mechanisms from the business logic layer.
 * </p>
 * <p>
 * This interface provides the most general access to the repositories content.
 * </p>
 * 
 * @param <TYPE> Type of the domain object.
 * 
 */
public interface Repository<TYPE> {



	/**
	 * Provides the java class of this domain object (entity).
	 * 
	 * @return The type of class of this repository. 
	 * 
	 */
	Class<TYPE> getDomainObjectType();



	/**
	 * Returns the number of entities available.
	 * 
	 * @return Number of available entities.
	 * 
	 */
	long count();



	/**
	 * Returns all instances available in this repository.
	 * 
	 * @return All available instances.
	 * 
	 */
	List<TYPE> findAll();
}