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
 * An EventType represents a classification of an event that will describe an informative relevant event in a match.
 * 
 * @author Björn Witt
 * 
 */
public enum EventType {

	  GAME_START
	, GAME_END
	, GOAL
	, KICK_OFF
	, PLAYER_SUBSTITUTION
	, YELLOW_CARD
	, RED_CARD
	, PENALITY_KICK
	, FREE_KICK
	, PLAYER_INJURY
	, CORNER_KICK
	, GOAL_KICK
	, OFFSIDE
	, THROW_IN
	, INJURY_TIME
	, GAME_INTERRUPTION
	, INCORRECT_DECISION
	, GENERAL_SITUATION
	;
}