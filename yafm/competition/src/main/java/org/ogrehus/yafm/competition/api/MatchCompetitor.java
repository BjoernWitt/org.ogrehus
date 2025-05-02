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
import java.util.Optional;

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
	default boolean isBye() {
		return getParticipant().isBye();
	}



	/**
	 * Provides the information of the name of the participating team. 
	 * 
	 * @return The name of the participating team.
	 * 
	 */
	default String getTeamName() {
		CompetitionParticipant participant = getParticipant();
		
		if (participant.isBye()) {
			return "Freilos"; // TODO: I18N
		}
		
		Optional<CompetitionTeam> team = participant.getTeam();
		if (team.isPresent()) {
			return team.get().getName();
		}
		
		return "Unbekannt"; // TODO: I18N
	}



	/**
	 * Provides the participant acting as the match competitor in this match.
	 * <p>
	 * This participant must point to a CompetitionParticipant. Even if this CompetitionParticipant is a bye.
	 * </p> 
	 * 
	 * @return The participant acting as the match competitor in this match. May not be <code>null</code>.
	 * 
	 */
	CompetitionParticipant getParticipant();



	/**
	 * Provides the lineup of a competitor, that contains a number of competition players that are allowed to join the match.
	 * 
	 * @return A List of competition players that are allowed to join the match. May be an empty, if the participant is a bye. 
	 * May not be <code>null</code>.
	 * 
	 */
	List<TeamLineup> getLineup();
}