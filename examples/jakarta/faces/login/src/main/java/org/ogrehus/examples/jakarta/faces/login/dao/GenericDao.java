/*
 * GNU Lesser General Public License v3.0
 * https://www.gnu.org/licenses/lgpl-3.0-standalone.html
 * 
 * Copyright (C) 2026 Björn Witt
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
package org.ogrehus.examples.jakarta.faces.login.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.ogrehus.examples.jakarta.faces.login.util.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class GenericDao<T, PK extends Serializable> {



	protected EntityManager entityManager;



	protected Class<T> entityClass;



	EntityManagerFactory factory;



	@SuppressWarnings("unchecked")
	public GenericDao(){
		entityManager = Util.getEntityManager();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		
		this.entityClass = ((Class<T>) genericSuperclass.getActualTypeArguments()[0]);
	}



	public T save(final T entity){
		T entityReturn = null;
		try {
			this.entityManager.getTransaction().begin();
			entityReturn = entityManager.merge(entity);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entityReturn;
	}



	public T getById(final PK id){
		T t = null;
		
		try {
			this.entityManager.getTransaction().begin();
			t = this.entityManager.find(entityClass, id);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}



	public void delete(final T entity){
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}



	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		entityManager.getTransaction().begin();
		List<T> entityReturn = entityManager.createQuery("FROM "+entityClass.getName()).getResultList();
		entityManager.getTransaction().commit();
		return entityReturn;
	}



	public Session getSession(){
		return (Session) entityManager.getDelegate();
	}
}