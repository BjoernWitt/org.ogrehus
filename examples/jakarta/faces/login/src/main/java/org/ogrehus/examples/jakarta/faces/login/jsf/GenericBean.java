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

import org.ogrehus.examples.jakarta.faces.login.dao.GenericDao;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

abstract class GenericBean<T> {
	
	protected T model;
	protected GenericDao<T, Integer> dao;
	protected List<T> listOfElements;
	
	@PostConstruct
	public void loadList(){
		if(dao != null){
			this.listOfElements = dao.findAll();
		}
	}
	
	public abstract void clearForm();
	
	public abstract void setModel(T model);
	
	public abstract T getModel();
	
	public String removeRecord(){
		
		this.dao.delete(this.model);
		this.loadList();
		this.clearForm();
		this.showMessage("Record deleted!");
		return "";
	}
	
	public List<T> getListOfElements() {
		return this.listOfElements;
	}
	public void setListOfElements(List<T> list) {
		this.listOfElements = list;
	}
	
	public String save(){
		this.dao.save(this.model);
		this.loadList();
		this.showMessage("Record saved!");
		return "";
	}
	
	public String newRecord(){
		this.clearForm();
		return "";
	}
	
	public void showMessage(String msg){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Notice",msg);
		context.addMessage(null, message);
	}
	
}
