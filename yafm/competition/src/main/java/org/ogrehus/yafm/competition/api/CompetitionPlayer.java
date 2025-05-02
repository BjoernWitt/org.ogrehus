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

import org.ogrehus.foundation.pattern.teamable.TeamMember;

/**
 * A CompetitionTeam represents a participant of the competition that contains a number of players that are allowed to join the competition.
 * 
 * @author Björn Witt
 * 
 */
public interface CompetitionPlayer
extends
	TeamMember
{



	/**
	 * Provides the name of the participative player.
	 * 
	 * @return The name of the participative player.
	 * 
	 */
	@Override
	String getName();
}