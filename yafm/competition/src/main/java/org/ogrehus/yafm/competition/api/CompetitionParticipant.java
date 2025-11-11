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

import java.util.Optional;

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;

/**
 * A CompetitionParticipant represents a competitor of the match competition that can be filled by a joining team or as a bye member.
 * <p>
 * A CompetitionParticipant can be seen as a club that provides a participating team for the competition. 
 * </p>
 * 
 * @author Björn Witt
 * 
 */
public interface CompetitionParticipant
extends
	Nameable
{



	/**
	 * Provides the information, if this participant represents no real competitor and act as a free win opponent in a match.
	 * 
	 * @return <code>true</code> if this participant provides no team and will always lose every match, <code>false</code> otherwise.
	 * 
	 */
	default boolean isBye() {
		return getTeam().isEmpty();
	}



	/**
	 * Provides the team acting as the participant in this competition.
	 * 
	 * @return The team that joins the competition, or empty if this participant is a bye.
	 * 
	 */
	Optional<CompetitionTeam> getTeam();



	/**
	 * Provides the name of the participating club that acts a the competition participant.
	 * 
	 * @return The name of the participating club. This must not be the same as the team name. May not be <code>null</code>.
	 * 
	 */
	@Override
	String getName();
}