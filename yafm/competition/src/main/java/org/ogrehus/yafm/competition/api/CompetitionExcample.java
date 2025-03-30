package org.ogrehus.yafm.competition.api;

import static org.ogrehus.yafm.competition.api.CompetitionExcample.CompetitionParticipants.*;
import static org.ogrehus.yafm.competition.api.CompetitionExcample.Competitions.BUNDESLIGA;
import static org.ogrehus.yafm.competition.api.CompetitionExcample.Competitions.BUNDESLIGA2;
import static org.ogrehus.yafm.competition.api.CompetitionExcample.Competitions.LIGA3;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CompetitionExcample {

	
	public static class Seasons {
		public static CompetitionSeason _23_24 = new CompetitionSeason() {
			@Override public LocalDateTime getStart() {return LocalDateTime.of(2024, 7, 15, 12, 0, 0);}
			@Override public String getName() {return "Saison 24/25";}
			@Override public LocalDateTime getEnd() {return LocalDateTime.of(2025, 7, 14, 12, 0, 0);}
			@Override public List<Competition> getCompetitions() {return Arrays.asList(BUNDESLIGA, BUNDESLIGA2, LIGA3);}
		};
	}
	
	public static class Competitions {
		public static Competition BUNDESLIGA = new Competition() {
			@Override public LocalDateTime getStart() {return LocalDateTime.of(2024, 7, 15, 12, 0, 0);}			
			@Override public List<CompetitionRound> getRounds() {return Arrays.asList(null);}
			@Override public List<CompetitionParticipant> getParticipants() {return Arrays.asList(CP001, CP002, CP003, CP004, CP005, CP006, CP007, CP008, CP009, CP010, CP011, CP012, CP013, CP014, CP015, CP016, CP017, CP018);}
			@Override public int getParticipantLimit() {return 18;}
			@Override public String getName() {return "Bundesliga";}
			@Override public byte[] getImage() {return null;}
			@Override public LocalDateTime getEnd() {return LocalDateTime.of(2025, 7, 14, 12, 0, 0);}
		};
		public static Competition BUNDESLIGA2 = new Competition() {
			@Override public LocalDateTime getStart() {return LocalDateTime.of(2024, 7, 15, 12, 0, 0);}			
			@Override public List<CompetitionRound> getRounds() {return Arrays.asList(null);}
			@Override public List<CompetitionParticipant> getParticipants() {return Arrays.asList(null);}
			@Override public int getParticipantLimit() {return 18;}
			@Override public String getName() {return "2. Bundesliga";}
			@Override public byte[] getImage() {return null;}
			@Override public LocalDateTime getEnd() {return LocalDateTime.of(2025, 7, 14, 12, 0, 0);}
		};
		public static Competition LIGA3 = new Competition() {
			@Override public LocalDateTime getStart() {return LocalDateTime.of(2024, 7, 15, 12, 0, 0);}			
			@Override public List<CompetitionRound> getRounds() {return Arrays.asList(null);}
			@Override public List<CompetitionParticipant> getParticipants() {return Arrays.asList(null);}
			@Override public int getParticipantLimit() {return 18;}
			@Override public String getName() {return "3. Liga";}
			@Override public byte[] getImage() {return null;}
			@Override public LocalDateTime getEnd() {return LocalDateTime.of(2025, 7, 14, 12, 0, 0);}
		};
	}
	
	public static class CompetitionParticipants {
		public static CompetitionParticipant CP001 = new CompetitionParticipant() {
			@Override public String getName() {return "Bayern München";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP002 = new CompetitionParticipant() {
			@Override public String getName() {return "Bayer 04 Leverkusen";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP003 = new CompetitionParticipant() {
			@Override public String getName() {return "Eintracht Frankfurt";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP004 = new CompetitionParticipant() {
			@Override public String getName() {return "RB Leipzig";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP005 = new CompetitionParticipant() {
			@Override public String getName() {return "SC Freiburg";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP006 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FSV Mainz 05";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP007 = new CompetitionParticipant() {
			@Override public String getName() {return "VfB Stuttgart";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP008 = new CompetitionParticipant() {
			@Override public String getName() {return "Bor. Mönchengladbach";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP009 = new CompetitionParticipant() {
			@Override public String getName() {return "VfL Wolfsburg";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP010 = new CompetitionParticipant() {
			@Override public String getName() {return "Werder Bremen";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP011 = new CompetitionParticipant() {
			@Override public String getName() {return "Borussia Dortmund";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP012 = new CompetitionParticipant() {
			@Override public String getName() {return "FC Augsburg";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP013 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FC Union Berlin";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP014 = new CompetitionParticipant() {
			@Override public String getName() {return "FC St. Pauli";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP015 = new CompetitionParticipant() {
			@Override public String getName() {return "TSG Hoffenheim";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP016 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FC Heidenheim";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP017 = new CompetitionParticipant() {
			@Override public String getName() {return "VfL Bochum";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP018 = new CompetitionParticipant() {
			@Override public String getName() {return "VfL Bochum";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
	}
}
