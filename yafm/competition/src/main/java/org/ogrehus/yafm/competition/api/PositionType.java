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
package org.ogrehus.yafm.competition.api;

/**
 * A PositionType represents a role of a player in a match.
 * 
 * https://www.1x1sport.de/fussballtaktik/grundordnungen/
 * 
 * @author Björn Witt
 * 
 */
public enum PositionType {
	  KEEPER
	, RV	// Rechter Verteidiger
	, IV	// Innenverteidiger
	, LV	// Linker Verteidiger
	, ZDM	// Zentrales, defensives Mittelfeld
	, ZOM	// Zentrales, offensives Mittelfeld
	, ZM	// Zentrales Mittelfeld
	, RM	// Rechtes Mittelfeld
	, LM	// Linkes Mittelfeld
	, OM	// Offensives Mittelfeld
	, DM	// Defensives Mittelfeld
	, RF	// Linker Flügel
	, LF	// Linker Flügel
	, RS	// Rechter Stürmer
	, LS	// Linker Stürmer
	, ST	// Stürmer
	, HS	// Halber Stürmer
 	, SUBSTITUTE
	;
}
