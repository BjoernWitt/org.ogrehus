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

import org.ogrehus.foundation.pattern.nameable.Titleable;

/**
 * A CompetitionTeam represents a participant of the competition that contains a number of players that are allowed to join the competition.
 * 
 * @author Björn Witt
 * 
 */
public interface TeamLineup
extends
	Titleable
{



	/**
	 * Provides the jersey number that identifies the player in a match.
	 * 
	 * @return The jersey number that identifies the player in a match.
	 * 
	 */
	int getJerseyNumber();



	/**
	 * Provides the title of a participative player in a match competitor.
	 * 
	 * @return The title of a participative player in a match competitor.
	 * 
	 */
	@Override
	String getTitle();



	/**
	 * Provides a reference to a competition player who is beset in a team lineup.
	 * 
	 * @return The reference to a competition player who is beset in a team lineup.
	 * 
	 */
	CompetitionPlayer getPlayer();
}