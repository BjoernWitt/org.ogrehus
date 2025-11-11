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
package org.ogrehus.gluttony.core.user.domain.jpa.entity;

import static jakarta.persistence.GenerationType.UUID;

import java.util.List;
import java.util.UUID;

import org.ogrehus.gluttony.core.user.domain.api.model.contact.UserContact;
import org.ogrehus.gluttony.core.user.domain.api.model.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


/**
 * UserEntity is responsible to organize all User structural capabilities regarding to JPA actions.
 * 
 * @author Björn Witt
 * 
 */
@Entity
@Table( uniqueConstraints = { @UniqueConstraint(columnNames = { "identifier" } ) } )
public class UserEntity
implements 
	User
{

	@Id
	@GeneratedValue(strategy = UUID)
	@Column
	private UUID uniqueIdentifier;



	@Column(unique = true)
	private String identifier;



	@Column
	private String name;



	@Column	
	private String language;



	/**
	 *  Creates a user entity with by specific structural features.
	 * 
	 * @param uniqueIdentifier A UUID that identifies the user entity in the persistence scope.
	 * @param identifier A String that identifies the user in the application scope.
	 * @param name A String containing the name of the user.
	 * @param language A String containing the type of language of the user.
	 * 
	 */
	public UserEntity(UUID uniqueIdentifier, String identifier, String name, String language) {
		this(identifier, name, language);
		this.uniqueIdentifier = uniqueIdentifier;
	}



	/**
	 *  Creates a user entity with by specific structural features.
	 * 
	 * @param identifier A String that identifies the user in the application scope.
	 * @param name A String containing the name of the user.
	 * @param language A String containing the type of language of the user.
	 * 
	 */
	public UserEntity(String identifier, String name, String language) {
		this.identifier = identifier;
		this.name = name;
		this.language = language;
	}



	@Override
	public UUID getUniqueIdentifier() {
		return this.uniqueIdentifier;
	}



	@Override
	public void setUniqueIdentifier(UUID uuid) {
		this.uniqueIdentifier = uuid;
	}



	@Override
	public String getIdentifier() {
		return this.identifier;
	}



	@Override
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}	



	@Override
	public String getName() {
		return this.name;
	}



	@Override
	public String getLanguage() {
		return this.language;
	}



	@Override
	public List<UserContact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}
}