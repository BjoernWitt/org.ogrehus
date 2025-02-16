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

import java.util.List;

/**
 * A MatchCompetitor represents a competitor of a match that is beset by a CompetitionParticipant of this competition.
 * 
 * @author Björn Witt
 * 
 */
public interface MatchCompetitor {



	/**
	 * Provides the information, if this match competitor represents no real competitor and act as a free win opponent in a tournament.
	 * 
	 * @return <code>true</code> if this this match competitor represents no real team and will lose the match, <code>false</code> otherwise.
	 * 
	 */
	boolean isBye();



	/**
	 * Provides the participant acting as the match competitor in this match.
	 * 
	 * @return The participant acting as the match competitor in this match.
	 * 
	 */
	CompetitionParticipant getParticipant();



	/**
	 * Provides the linup of a competitor, that contains a number of competition players that are allowed to join the match.
	 * 
	 * @return A List of competition players that are allowed to join the match.
	 * 
	 */
	List<TeamLineup> getLineup();
}