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

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.ogrehus.examples.jakarta.faces.login.dao.UserDao;
import org.ogrehus.examples.jakarta.faces.login.model.UserEnt;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
public class LoginBean extends GenericBean<UserEnt>{
	
	private UserEnt loggedUser;
	
	public LoginBean() {
		this.dao = new UserDao();
		this.model = new UserEnt();
	}
	
	public String logOut(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.getSessionMap().clear();
		
		return "login.jsf";
	}
	
	public String login(){
		List<UserEnt> list = ((UserDao) dao).findByUsernamePassword(this.model.getName(),DigestUtils.shaHex(this.model.getPassword()));
		
		if(list.size() > 0){
			this.loggedUser = list.get(0);
			this.model.setPassword("");
			
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			externalContext.getSessionMap().put("loggedUser", this.model);
			
			return "index.jsf";
		}else{
			this.showMessage("Username or password incorrect!");	
		}
		return "";
	}
	
	public UserEnt getLoggedUser() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		UserEnt loggedUser = (UserEnt) externalContext.getSessionMap().get("loggedUser");
		
		return loggedUser;
	}

	public void setLoggedUser(UserEnt loggedUser) {
		this.loggedUser = loggedUser;
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
	
}
