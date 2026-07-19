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
package org.ogrehus.examples.jakarta.faces.login.model;

import org.hibernate.validator.constraints.Range;
import org.ogrehus.examples.jakarta.faces.login.enums.Profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserEnt 
implements 
	EntityInterface<Integer>
{

	@Id
	@GeneratedValue(generator="user_id_seq")
	@SequenceGenerator(name="user_id_seq",sequenceName="user_id_seq",allocationSize=1)
	private Integer id;
	
	@NotEmpty(message="Name can not be empty")
	@Size(min=4,max=50, message="Name should have between 4 and 50 characters")
	@Column(unique = true)
	private String name;
	
	private String password;
	
	@Column(nullable=false)
	@Range(min=1,max=2)
	@NotNull(message="Profile can not be empty")
	private Integer profile;
	
	@Transient
	private Profile profileEnum;
	
	public Integer getProfile() {
		return profile;
	}

	public void setProfile(Integer profile) {
		this.profile = profile;
	}

	public Profile getProfileEnum() {
		return profileEnum;
	}

	public void setProfileEnum(Profile profileEnum) {
		this.profileEnum = profileEnum;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
