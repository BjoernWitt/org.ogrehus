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
package org.ogrehus.gluttony.core.element.api;

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;
import org.ogrehus.gluttony.foundation.pattern.identifiable.UniqueIdentifiable;

/**
 * A core element provides access to the properties: name and identifier.
 * 
 * @author Björn Witt
 * 
 * @param <ID> Type of the identifier (may be int, long, String, UUID, etc.).
 * 
 */
public interface CoreElement<ID>
extends
	  Element
	, Nameable
	, UniqueIdentifiable<ID>
{

}