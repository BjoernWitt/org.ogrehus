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
 * This interface provides the modification access to the repositories content.
 * </p>
 * 
 * @param <T> Type of the domain object.
 * 
 */
public interface WriteRepository<T> {



	/**
	 * Saves a given entity into this repository.
	 * <p>
	 * This method detects whether an update or insert is needed by evaluating the primary key: 
	 * <ul>
	 * <li>If the values of the primary key matches an entity of this repository, all changes will be updated.</li>
	 * <li>If the values of the primary key cannot be found in this repository, the entity will be inserted.
	 * </ul>
	 * 
	 * @param entity given entity to be saved.
	 * 
	 * @return The saved entity or <code>null</code>, in case of any failure while saving.
	 * 
	 * @param <S> Any inherited instance from <T> 
	 */
	<S extends T> S save(S entity);



	/**
	 * Saves a number of entities to this repository.
	 * 
	 * This method detects whether an update or insert is needed by evaluating the primary key:
	 * <ul>
	 * <li>If the values of the primary key matches an entity of this repository, all changes will be updated.</li>
	 * <li>If the values of the primary key cannot be found in this repository, the entity will be inserted.
	 * </ul>
	 * 
	 * @param <S>
	 * @param entities
	 * 
	 * @return
	 * 
	 */
	<S extends T> List<S> saveAll(List<S> entities);



	/**
	 * Deletes a given entity form this repository.
	 * 
	 * @return <code>true</code>, if the entity is no longer content of this repository, otherwise <code>false</code>. 
	 * 
	 */
	boolean delete(T entity);



	/**
	 * Deletes all entities from this repository.
	 * 
	 * @return The number of deleted entities. 
	 * 
	 */
	long deleteAll();
}