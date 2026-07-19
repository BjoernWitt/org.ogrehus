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
package org.ogrehus.examples.jakarta.faces.login.jsf;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.ogrehus.examples.jakarta.faces.login.dao.UserDao;
import org.ogrehus.examples.jakarta.faces.login.enums.Profile;
import org.ogrehus.examples.jakarta.faces.login.model.UserEnt;

import jakarta.inject.Named;

@Named
public class UserBean 
extends 
	GenericBean<UserEnt>
{

	@SuppressWarnings("unused")
	private Integer adminCode;
	@SuppressWarnings("unused")
	private Integer userCode;
	
	public Integer getAdminCode() {
		return Profile.Admin.getCode();
	}

	public Integer getUserCode() {
		return Profile.User.getCode();
	}

	public UserBean() {
		this.dao = new UserDao();
		this.model = new UserEnt();
		this.listOfElements = new ArrayList<UserEnt>();
	}
	
	@Override
	public void clearForm() {
		this.model = new UserEnt();
	}

	@Override
	public void setModel(UserEnt model) {
		this.model = model;
		
	}

	@Override
	public UserEnt getModel() {
		return this.model;
	}
	
	public String save(){
		
		if(this.model.getId() == null
	    && this.model.getPassword().isEmpty()){
			this.showMessage("Password can't be empty!");
		}else{
			if(this.model.getPassword().isEmpty()
		    && this.model.getId() != null){
				UserEnt user = this.dao.getById(this.model.getId());
				this.model.setPassword(user.getPassword());
			}else{
				this.model.setPassword(DigestUtils.shaHex(this.model.getPassword()));
			}
			this.dao.save(this.model);
			this.loadList();
			this.model.setPassword("");
			this.showMessage("Record saved!");
		}
		
		return "";
	}
	
	public void clearPassword(){
		this.model.setPassword("");
	}
	
}
