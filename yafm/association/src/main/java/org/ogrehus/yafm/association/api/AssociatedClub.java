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
package org.ogrehus.yafm.association.api;

import org.ogrehus.foundation.pattern.nameable.Acronymable;
import org.ogrehus.foundation.pattern.nameable.Nameable;

/**
 * An AssociatedClub represents a composite of teams, 
 * that are allowed to participate in competitions of an association.
 * 
 * @author Björn Witt
 * 
 */
public interface AssociatedClub
extends
	  Nameable
	, Acronymable
{
	// nothing defined here, is a composition or specialization of existing interface usages.
}