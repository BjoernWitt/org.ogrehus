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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.ogrehus.gluttony.foundation.pattern.identifiable.UniqueIdentifiable;
import org.ogrehus.gluttony.foundation.persistence.api.repository.IdentifiableRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
public abstract class AbstractIdentifiableRepository<TYPE extends UniqueIdentifiable<ID>, ID>
extends 
	AbstractRepository<TYPE>
implements
	IdentifiableRepository<TYPE, ID>
{



	public AbstractIdentifiableRepository(EntityManager entityManager) {
		super(entityManager);
	}



	@Override
	public Optional<TYPE> findByUniqueIdentifier(ID identifier) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<TYPE> query = builder.createQuery(getDomainObjectType());

		var root = query.from(getDomainObjectType());
		query.where(builder.equal(root.get(getUniqueIdentifierPropertyName()), identifier));

		try {
			return Optional.ofNullable(this.entityManager.createQuery(query).getSingleResult());
		} catch (NoResultException nrEx) {
			return Optional.empty();
		}
	}



	@Override
	public Iterable<TYPE> findAllByUniqueIdentifiers(Iterable<ID> identifiers) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<TYPE> query = builder.createQuery(getDomainObjectType());
		var root = query.from(getDomainObjectType());
		
		Collection<ID> idList = new ArrayList<>();
		identifiers.forEach(idList::add);
		query.where(root.get(getUniqueIdentifierPropertyName()).in(idList));

		return this.entityManager.createQuery(query).getResultList();
	}
}