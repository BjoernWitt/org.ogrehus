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
package org.ogrehus.gluttony.foundation.persistence.jpa.repository;

import java.util.List;

import org.ogrehus.gluttony.foundation.persistence.api.repository.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

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
public abstract class AbstractRepository<TYPE>
implements
	Repository<TYPE>
{



	protected final EntityManager entityManager;



	public AbstractRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	/**
	 * Returns the number of entities available.
	 * 
	 * @return Number of available entities.
	 * 
	 */
	@Override
	public long count() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		var root = query.from(getDomainObjectType());
		query.select(builder.count(root));

		return this.entityManager.createQuery(query).getSingleResult();
	}



	/**
	 * Returns all instances available in this repository.
	 * 
	 * @return All available instances.
	 * 
	 */
	@Override 
	public List<TYPE> findAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<TYPE> query = builder.createQuery(getDomainObjectType());
		
		var root = query.from(getDomainObjectType());
		query.select(root);

		return this.entityManager.createQuery(query).getResultList();
	}
}