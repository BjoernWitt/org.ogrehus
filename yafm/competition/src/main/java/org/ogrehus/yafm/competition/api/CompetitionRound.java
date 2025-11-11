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

import org.ogrehus.gluttony.foundation.pattern.nameable.Nameable;
import org.ogrehus.gluttony.foundation.pattern.identifiable.SequentialIndexable;

/**
 * A CompetitionRound represents a a match day or a tournament round as part of a competition.
 * 
 * @author Björn Witt
 * 
 */
public interface CompetitionRound
extends
	  Nameable
	, SequentialIndexable
{



	/**
	 * Provides the name of this competition round.
	 * <p>
	 * May be a simple description like match day 1, match day 2, etc.
	 * </p>
	 * 
	 * @return the name of this competition round.
	 */
	@Override
	String getName();



	/**
	 * Provides the number of matches that are part of this round.
	 * 
	 * @return The team that joins the competition, or is empty if this participant is a bye.
	 * 
	 */
	List<CompetitionMatch> getMatches();
	
	
	
	/**
	 * Provides the qualification round that provide the opponent for the next round, if exists.
	 * 
	 * @return the qualification round that provide the opponent for the next round.
	 * 
	 */
	List<CompetitionRound> getQualificationRounds();
}