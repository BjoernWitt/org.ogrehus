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

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;
import org.ogrehus.gluttony.foundation.pattern.time.Intervalable;

/**
 * An Competition represents a contest unites a number of competitionParticipant and competition rounds that can register the details of the matches.
 * 
 * @author Björn Witt
 * 
 */
public interface Competition
extends
	  Nameable
	, Intervalable
{



	/**
	 * Provides the name of the competition.
	 * 
	 * @return Name of the club.
	 * 
	 */
	@Override String getName();



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
	 * Provides the end date of the competition time interval.
	 * <p>
	 * The end date is included within the competition. That means, if 14th of July may be the end date, rounds may take place on the 14th of July.
	 * 
	 * @return The start date of the season.
	 * 
	 */
	@Override LocalDateTime getEnd();



	/**
	 * Provides an image that represents a visual identification the competition
	 * 
	 * @return The image data of the representing competition.
	 * 
	 */
	byte[] getImage();



	/**
	 * Provides the maximal number of participants that are allowed to join this competition.
	 * 
	 * @return Max number of max participants that are allowed to join this competition.
	 * 
	 */
	int getParticipantLimit();



	/**
	 * Provides the participants of this competition.
	 * 
	 * @return The participants of this competition.
	 * 
	 */
	List<CompetitionParticipant> getParticipants();



	/**
	 * Provides the rounds that structures this competition.
	 * 
	 * @return The rounds of this competition.
	 * 
	 */
	List<CompetitionRound> getRounds();
}