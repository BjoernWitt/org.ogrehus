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
 * A MatchResult represents the final state of a match.
 * 
 * @author Björn Witt
 * 
 */
public interface MatchResult {



	/**
	 * Provides the information if a specific match competitor is the winner of this match.
	 * 
	 * @return <code>true</code> if the matchCompetitor is the winner of this match, <code>false</code> otherwise.
	 * 
	 */
	boolean isWinner(MatchCompetitor matchCompetitor);



	/**
	 * Provides the information, if no winner is available, because the match result was a draw.
	 * 
	 * @return <code>true</code> if home and away scored same number of goals, <code>false</code> otherwise.
	 * 
	 */
	default boolean isDraw() {
		return getGoalsAway() == getGoalsAway();
	}



	/**
	 * Provides the number of goals scored by the home team.
	 * 
	 * @return Number of goals scored by the home team.
	 * 
	 */
	int getGoalsHome();



	/**
	 * Provides the number of goals scored by the away team.
	 * 
	 * @return Number of goals scored by the home team.
	 * 
	 */
	int getGoalsAway();
}