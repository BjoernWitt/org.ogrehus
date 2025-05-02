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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.ogrehus.foundation.pattern.nameable.Titleable;
import org.ogrehus.foundation.pattern.time.Startable;

/**
 * An CompetitionMatch represents a match that brings a decision about how this competition works out by a winner, looser or a draw.
 * 
 * @author Björn Witt
 * 
 */
public interface CompetitionMatch
extends
	  Titleable
	, Startable
{



	/**
	 * Provides the title of the match.
	 * <p>
	 * Might be a simple information containing the sequential index if not defined in other ways, or somethis special like 'final' or 'semi-final',
	 * etc...
	 * </p>
	 * 
	 * @return Title of this match.
	 * 
	 */
	default String getTitle() {
		return getHome().getTeamName() + " - " + getAway().getTeamName();
	}



	/**
	 * Provides the start date of the competition time interval.
	 * <p>
	 * The start date is included within the competition. That means, if 15th of July may be the start date, rounds may take place on the 15th of 
	 * July.
	 * 
	 * @return The start date of the season.
	 * 
	 */
	@Override LocalDateTime getStart();



	/**
	 * Provides the number of minutes the game shall last till it ends.
	 * 
	 * @return The number of minutes the game shall last till it ends.
	 * 
	 */
	int getGameTime();



	/**
	 * Provides the MatchCompetitor that plays in the role of the home team.
	 * 
	 * @return The MatchCompetitor that plays in the role of the home team. May not be <code>null</code>.
	 * 
	 */
	MatchCompetitor getHome();



	/**
	 * Provides the MatchCompetitor that plays in the role of the away team.
	 * 
	 * @return The MatchCompetitor that plays in the role of the away team. May not be <code>null</code>.
	 * 
	 */
	MatchCompetitor getAway();



	/**
	 * Provides information whether this match is type of a league game or an elimination match for a qualifying round.
	 * 
	 * @return The type of this match.
	 * 
	 */
	MatchType getMatchType();



	/**
	 * Provides information about the result of the match.
	 * 
	 * @return The result of the match
	 * 
	 */
	MatchResult getMatchResult();



	/**
	 * Provides information about the events that happened within this match.
	 * 
	 * @return The events that happened within this match.
	 * 
	 */
	List<MatchEvent> getEvents();
	
	
	
	/**
	 * Provides the participant that has won this match.
	 * 
	 * @return The winner of this match, if it exists, otherwise is empty.
	 * 
	 */
	Optional<CompetitionParticipant> getWinner();
}
