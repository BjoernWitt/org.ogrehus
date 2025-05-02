package org.ogrehus.yafm.competition.api;

import static org.ogrehus.yafm.competition.api.CompetitionExample.CompetitionParticipants.*;
import static org.ogrehus.yafm.competition.api.CompetitionExample.CompetitionPlayers.*;
import static org.ogrehus.yafm.competition.api.CompetitionExample.CompetitionRounds.BL1_ST_1;
import static org.ogrehus.yafm.competition.api.CompetitionExample.CompetitionTeams.CP001_T01;
import static org.ogrehus.yafm.competition.api.CompetitionExample.CompetitionTeams.CP002_T01;
import static org.ogrehus.yafm.competition.api.CompetitionExample.Competitions.BUNDESLIGA;
import static org.ogrehus.yafm.competition.api.CompetitionExample.Competitions.BUNDESLIGA2;
import static org.ogrehus.yafm.competition.api.CompetitionExample.Competitions.LIGA3;
import static org.ogrehus.yafm.competition.api.CompetitionExample.MatchResults._23_24_BL1_ST_1_M1_Result;
import static org.ogrehus.yafm.competition.api.MatchType.LEAGUE;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CompetitionExample {

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
			@Override public List<CompetitionRound> getRounds() {return Arrays.asList(BL1_ST_1);}
			@Override public List<CompetitionParticipant> getParticipants() {return Arrays.asList(CP001, CP002, CP003, CP004, CP005, CP006, CP007
				, CP008, CP009, CP010, CP011, CP012, CP013, CP014, CP015, CP016, CP017, CP018);}
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
		// definition pattern by record
		public static CompetitionParticipant PARTICIPANT(String name, CompetitionTeam team) { return new Participant(name, team);} 
		public record Participant(String name, CompetitionTeam team) implements CompetitionParticipant { 
			@Override public String getName() { return name; }
			@Override public Optional<CompetitionTeam> getTeam() { return Optional.ofNullable(team);} 
		}
		// data
		public static CompetitionParticipant CP001 = PARTICIPANT("FC Bayern München AG", CP001_T01);
		public static CompetitionParticipant CP002 = PARTICIPANT("Bayer 04 Leverkusen Fußball GmbH", CP002_T01);
		public static CompetitionParticipant CP003 = PARTICIPANT("Eintracht Frankfurt", null);
		public static CompetitionParticipant CP004 = new CompetitionParticipant() {
			@Override public String getName() {return "RB Leipzig";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP005 = new CompetitionParticipant() {
			@Override public String getName() {return "SC Freiburg";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP006 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FSV Mainz 05";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP007 = new CompetitionParticipant() {
			@Override public String getName() {return "VfB Stuttgart";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP008 = new CompetitionParticipant() {
			@Override public String getName() {return "Bor. Mönchengladbach";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP009 = new CompetitionParticipant() {
			@Override public String getName() {return "VfL Wolfsburg";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP010 = new CompetitionParticipant() {
			@Override public String getName() {return "Werder Bremen";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP011 = new CompetitionParticipant() {
			@Override public String getName() {return "Borussia Dortmund";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP012 = new CompetitionParticipant() {
			@Override public String getName() {return "FC Augsburg";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP013 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FC Union Berlin";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP014 = new CompetitionParticipant() {
			@Override public String getName() {return "FC St. Pauli";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP015 = new CompetitionParticipant() {
			@Override public String getName() {return "TSG Hoffenheim";}
			@Override public boolean isBye() {return false;}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP016 = new CompetitionParticipant() {
			@Override public String getName() {return "1. FC Heidenheim";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP017 = new CompetitionParticipant() {
			@Override public String getName() {return "VfL Bochum";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
		public static CompetitionParticipant CP018 = new CompetitionParticipant() {
			@Override public String getName() {return "Holstein Kiel";}
			@Override public Optional<CompetitionTeam> getTeam() {return Optional.empty();}
		};
	}



	public static class CompetitionTeams {
		public static CompetitionTeam CP001_T01 = new CompetitionTeam() {
			@Override public String getName() { return "Bayern München"; }
			@Override public Collection<CompetitionPlayer> getTeamMembers() { return Arrays.asList(CP001_T01_P01_NEUER, CP001_T01_P02_UPAMECANO
				, CP001_T01_P03_KIM, CP001_T01_P03_KIM, CP001_T01_P06_KIMICH, CP001_T01_P07_GNABRY, CP001_T01_P08_GORETZKA, CP001_T01_P09_KANE
				, CP001_T01_P10_SANE, CP001_T01_P11_COMAN, CP001_T01_P15_DIER, CP001_T01_P16_PALHINHA, CP001_T01_P17_OLISE, CP001_T01_P18_PERETZ
				, CP001_T01_P19_DAVIES, CP001_T01_P21_ITO, CP001_T01_P22_GUERREIRO, CP001_T01_P23_BOEY, CP001_T01_P24_VIDOVIC, CP001_T01_P25_MUELLER
				, CP001_T01_P26_ULREICH, CP001_T01_P27_LAIMER, CP001_T01_P28_BUCHMANN, CP001_T01_P40_URBIG, CP001_T01_P42_MUSIALA
				, CP001_T01_P44_STANISIC, CP001_T01_P45_PAVLOVIC); }
		};
		public static CompetitionTeam CP001_T02 = new CompetitionTeam() {
			@Override public String getName() { return "Bayern München II"; }
			@Override public Collection<CompetitionPlayer> getTeamMembers() {return null;}
		}; 
		public static CompetitionTeam CP002_T01 = new CompetitionTeam() {
			@Override public String getName() { return "Bayer 04 Leverkusen"; }
			@Override public Collection<CompetitionPlayer> getTeamMembers() { return Arrays.asList(CP002_T01_P01_HRADECKY, CP002_T01_P03_HINCAPIE
					, CP002_T01_P04_TAH, CP002_T01_P05_HERMOSO, CP002_T01_P07_HOFMANN, CP002_T01_P08_ANDRICH, CP002_T01_P10_WIRTZ
					, CP002_T01_P11_TERRIER, CP002_T01_P12_TAPSOBA, CP002_T01_P13_ARTHUR, CP002_T01_P14_SCHICK, CP002_T01_P16_BUENDIA
					, CP002_T01_P17_KOVAR, CP002_T01_P18_SARCO, CP002_T01_P19_TELLA, CP002_T01_P20_GRIMALDO, CP002_T01_P21_ALDI
					, CP002_T01_P22_BONIFACE, CP002_T01_P23_MUKIELE, CP002_T01_P24_GARCIA, CP002_T01_P25_PALACIOS, CP002_T01_P30_FRIMPONG
					, CP002_T01_P34_XHAKA, CP002_T01_P36_LOMP, CP002_T01_P44_BELOCIAN, CP002_T01_P48_NOVODOMSKY); 
			}
		}; 
		public static CompetitionTeam CP003_T01 = new CompetitionTeam() {
			@Override public String getName() { return "Eintracht Frankfurt"; }
			@Override public Collection<CompetitionPlayer> getTeamMembers() { return Arrays.asList(CP003_T01_P01_TRAPP, CP003_T01_P03_THEATE
					, CP003_T01_P04_KOCH, CP003_T01_P05_AMENDA, CP003_T01_P06_HOJLUND, CP003_T01_P08_CHAIBI, CP003_T01_P09_Matanivic
					, CP003_T01_P11_EKITIKE, CP003_T01_P13_KRISTENSEN, CP003_T01_P15_SKHIRI, CP003_T01_P16_LARSON, CP003_T01_P17_WAHI
					, CP003_T01_P18_DAHOUD, CP003_T01_P19_BAHOYA, CP003_T01_P20_UZUN, CP003_T01_P21_BROWN, CP003_T01_P22_CHANDLER
					, CP003_T01_P23_LISZTES, CP003_T01_P26_EBIMBE, CP003_T01_P27_GOETZE, CP003_T01_P29_NKOUNKOU, CP003_T01_P30_BATSHUAYI
					, CP003_T01_P33_GRAHL, CP003_T01_P34_COLLINS, CP003_T01_P35_TUTA, CP003_T01_P36_KNAUFF, CP003_T01_P40_SANTOS); 
			}
		}; 
		
	}


	public static class CompetitionRounds {
		public static CompetitionRound BL1_ST_1 = new CompetitionRound() {
			@Override public int getSequentialIndex() { return Round._01; }
			@Override public List<CompetitionRound> getQualificationRounds() { return Collections.emptyList(); }
			@Override public String getName() { return null; }
			@Override public List<CompetitionMatch> getMatches() { return null; }
		};
	}



	public static class CompetitionMatches {
		public static CompetitionMatch _23_24_BL1_ST_1_M_1 = new CompetitionMatch() {
			@Override public LocalDateTime getStart() { return LocalDateTime.of(2024,8, 23, 20, 30, 00); }
			@Override public MatchType getMatchType() { return LEAGUE; }
			@Override public MatchResult getMatchResult() { return _23_24_BL1_ST_1_M1_Result; }
			@Override public MatchCompetitor getHome() { return MatchCompetitors._23_24_BL1_ST_1_M1_Home; }
			@Override public int getGameTime() { return 90; }
			@Override public List<MatchEvent> getEvents() { return null; }
			@Override public MatchCompetitor getAway() { return null; }
			@Override public Optional<CompetitionParticipant> getWinner() { return Optional.empty(); }
		};
	}



	public static class MatchResults {
		// definition pattern by record
		public static MatchResult RESULT(int home, int away) { return new Match(home, away);} 
		public record Match(int home, int away) implements MatchResult {
			@Override public int getGoalsHome() { return home; }
			@Override public int getGoalsAway() { return away; } 
		}
		// data		
		public static MatchResult _23_24_BL1_ST_1_M1_Result = RESULT(2, 3);
	}



	public static class MatchCompetitors {
		// definition pattern by record
		public static MatchCompetitor COMPETITOR(CompetitionParticipant participant, List<TeamLineup> lineup) { return new Competitor(participant, lineup);} 
		public record Competitor(CompetitionParticipant participant, List<TeamLineup> lineup) implements MatchCompetitor { 
			@Override public CompetitionParticipant getParticipant() { return participant; }
			@Override public List<TeamLineup> getLineup() { return lineup; }
		}
		// data
		public static MatchCompetitor _23_24_BL1_ST_1_M1_Home = COMPETITOR(CP008, null);
	}



	public static class CompetitionPlayers {
		// definition pattern by record
		public static CompetitionPlayer PLAYER(String name) { return new Player(name);} 
		public record Player(String name) implements CompetitionPlayer { @Override public String getName() { return name; } }
		// data
		public static CompetitionPlayer CP001_T01_P01_NEUER 	= PLAYER("Manuel Neuer");
		public static CompetitionPlayer CP001_T01_P02_UPAMECANO = PLAYER("Dayot Upamecano");
		public static CompetitionPlayer CP001_T01_P03_KIM 		= PLAYER("Min-Jae Kim");
		public static CompetitionPlayer CP001_T01_P06_KIMICH 	= PLAYER("Joshua Kimmich");
		public static CompetitionPlayer CP001_T01_P07_GNABRY 	= PLAYER("Serge Gnabry");
		public static CompetitionPlayer CP001_T01_P08_GORETZKA 	= PLAYER("Leon Goretzka");
		public static CompetitionPlayer CP001_T01_P09_KANE		= PLAYER("Harry Kane");
		public static CompetitionPlayer CP001_T01_P10_SANE		= PLAYER("Leroy Sané");
		public static CompetitionPlayer CP001_T01_P11_COMAN		= PLAYER("Kingsley Coman");
		public static CompetitionPlayer CP001_T01_P15_DIER		= PLAYER("Eric Dier");
		public static CompetitionPlayer CP001_T01_P16_PALHINHA	= PLAYER("João Palhinha");
		public static CompetitionPlayer CP001_T01_P17_OLISE		= PLAYER("Michael Olise");
		public static CompetitionPlayer CP001_T01_P18_PERETZ	= PLAYER("Daniel Peretz");
		public static CompetitionPlayer CP001_T01_P19_DAVIES	= PLAYER("Alphonso Davies");
		public static CompetitionPlayer CP001_T01_P21_ITO		= PLAYER("Hiroki Ito");
		public static CompetitionPlayer CP001_T01_P22_GUERREIRO	= PLAYER("Raphaël Guerreiro");
		public static CompetitionPlayer CP001_T01_P23_BOEY		= PLAYER("Sacha Boey");
		public static CompetitionPlayer CP001_T01_P24_VIDOVIC	= PLAYER("Gabriel Vidovic");
		public static CompetitionPlayer CP001_T01_P25_MUELLER	= PLAYER("Thomas Müller");
		public static CompetitionPlayer CP001_T01_P26_ULREICH	= PLAYER("Sven Ulreich");
		public static CompetitionPlayer CP001_T01_P27_LAIMER	= PLAYER("Konrad Laimer");
		public static CompetitionPlayer CP001_T01_P28_BUCHMANN	= PLAYER("Tarek Buchmann");
		public static CompetitionPlayer CP001_T01_P40_URBIG		= PLAYER("Jonas Urbig");
		public static CompetitionPlayer CP001_T01_P42_MUSIALA	= PLAYER("Jamal Musiala");
		public static CompetitionPlayer CP001_T01_P44_STANISIC	= PLAYER("Josip Stanisic");
		public static CompetitionPlayer CP001_T01_P45_PAVLOVIC	= PLAYER("Aleksandar Pavlovic");
		
		public static CompetitionPlayer CP002_T01_P01_HRADECKY 	= PLAYER("Lukas Hradecky");
		public static CompetitionPlayer CP002_T01_P03_HINCAPIE 	= PLAYER("Piero Hincapié");
		public static CompetitionPlayer CP002_T01_P04_TAH	 	= PLAYER("Jonathan Tah");
		public static CompetitionPlayer CP002_T01_P05_HERMOSO 	= PLAYER("Mario Hermoso");
		public static CompetitionPlayer CP002_T01_P07_HOFMANN 	= PLAYER("Jonas Hofmann");
		public static CompetitionPlayer CP002_T01_P08_ANDRICH 	= PLAYER("Robert Andrich");
		public static CompetitionPlayer CP002_T01_P10_WIRTZ 	= PLAYER("Florian Wirtz");
		public static CompetitionPlayer CP002_T01_P11_TERRIER 	= PLAYER("Martin Terrier");
		public static CompetitionPlayer CP002_T01_P12_TAPSOBA 	= PLAYER("Edmond Tapsoba");
		public static CompetitionPlayer CP002_T01_P13_ARTHUR 	= PLAYER("Arthur");
		public static CompetitionPlayer CP002_T01_P14_SCHICK 	= PLAYER("Patrik Schick");
		public static CompetitionPlayer CP002_T01_P16_BUENDIA 	= PLAYER("Emiliano Buendía");
		public static CompetitionPlayer CP002_T01_P17_KOVAR 	= PLAYER("Matej Kovar");
		public static CompetitionPlayer CP002_T01_P18_SARCO 	= PLAYER("Alejo Sarco");
		public static CompetitionPlayer CP002_T01_P19_TELLA 	= PLAYER("Nathan Tella");
		public static CompetitionPlayer CP002_T01_P20_GRIMALDO 	= PLAYER("Alejandro Grimaldo");
		public static CompetitionPlayer CP002_T01_P21_ALDI 		= PLAYER("Amine Adli");
		public static CompetitionPlayer CP002_T01_P22_BONIFACE 	= PLAYER("Victor Boniface");
		public static CompetitionPlayer CP002_T01_P23_MUKIELE 	= PLAYER("Nordi Mukiele");
		public static CompetitionPlayer CP002_T01_P24_GARCIA 	= PLAYER("Aleix García");
		public static CompetitionPlayer CP002_T01_P25_PALACIOS 	= PLAYER("Exequiel Palacios");
		public static CompetitionPlayer CP002_T01_P30_FRIMPONG 	= PLAYER("Jeremie Frimpong");
		public static CompetitionPlayer CP002_T01_P34_XHAKA 	= PLAYER("Granit Xhaka");
		public static CompetitionPlayer CP002_T01_P36_LOMP 		= PLAYER("Niklas Lomb");
		public static CompetitionPlayer CP002_T01_P44_BELOCIAN 	= PLAYER("Jeanuël Belocian");
		public static CompetitionPlayer CP002_T01_P48_NOVODOMSKY= PLAYER("Luca Novodomsky");

		public static CompetitionPlayer CP003_T01_P01_TRAPP 	= PLAYER("Kevin Trapp");
		public static CompetitionPlayer CP003_T01_P03_THEATE 	= PLAYER("Arthur Theate");
		public static CompetitionPlayer CP003_T01_P04_KOCH 		= PLAYER("Robin Koch");
		public static CompetitionPlayer CP003_T01_P05_AMENDA 	= PLAYER("Aurèle Amenda");
		public static CompetitionPlayer CP003_T01_P06_HOJLUND 	= PLAYER("Oscar Højlund");
		public static CompetitionPlayer CP003_T01_P08_CHAIBI 	= PLAYER("Farès Chaïbi");
		public static CompetitionPlayer CP003_T01_P09_Matanivic	= PLAYER("Igor Matanovic");
		public static CompetitionPlayer CP003_T01_P11_EKITIKE 	= PLAYER("Hugo Ekitiké");
		public static CompetitionPlayer CP003_T01_P13_KRISTENSEN= PLAYER("Rasmus Kristensen");
		public static CompetitionPlayer CP003_T01_P15_SKHIRI 	= PLAYER("Ellyes Skhiri");
		public static CompetitionPlayer CP003_T01_P16_LARSON 	= PLAYER("Hugo Larsson");
		public static CompetitionPlayer CP003_T01_P17_WAHI	 	= PLAYER("Elye Wahi");
		public static CompetitionPlayer CP003_T01_P18_DAHOUD 	= PLAYER("Mahmoud Dahoud");
		public static CompetitionPlayer CP003_T01_P19_BAHOYA 	= PLAYER("Jean-Mattéo Bahoya");
		public static CompetitionPlayer CP003_T01_P20_UZUN	 	= PLAYER("Can Uzun");
		public static CompetitionPlayer CP003_T01_P21_BROWN 	= PLAYER("Nathaniel Brown");
		public static CompetitionPlayer CP003_T01_P22_CHANDLER 	= PLAYER("Timothy Chandler");
		public static CompetitionPlayer CP003_T01_P23_LISZTES 	= PLAYER("Krisztián Lisztes");
		public static CompetitionPlayer CP003_T01_P26_EBIMBE 	= PLAYER("Junior Dina Ebimbe");
		public static CompetitionPlayer CP003_T01_P27_GOETZE 	= PLAYER("Mario Götze");
		public static CompetitionPlayer CP003_T01_P29_NKOUNKOU 	= PLAYER("Niels Nkounkou");
		public static CompetitionPlayer CP003_T01_P30_BATSHUAYI	= PLAYER("Michy Batshuayi");
		public static CompetitionPlayer CP003_T01_P33_GRAHL 	= PLAYER("Jens Grahl");
		public static CompetitionPlayer CP003_T01_P34_COLLINS 	= PLAYER("Nnamdi Collins");
		public static CompetitionPlayer CP003_T01_P35_TUTA	 	= PLAYER("Tuta");
		public static CompetitionPlayer CP003_T01_P36_KNAUFF 	= PLAYER("Ansgar Knauff");
		public static CompetitionPlayer CP003_T01_P40_SANTOS 	= PLAYER("Kauã Santos");
	}



	public class Round {
		public static final int _01 = 0;
		public static final int _02 = 1;
		public static final int _03 = 2;
		public static final int _04 = 3;
		public static final int _05 = 4;
		public static final int _06 = 5;
		public static final int _07 = 6;
		public static final int _08 = 7;
		public static final int _09 = 8;
		public static final int _10 = 9;
		public static final int _11 = 10;
		public static final int _12 = 11;
		public static final int _13 = 12;
		public static final int _14 = 13;
		public static final int _15 = 14;
		public static final int _16 = 15;
		public static final int _17 = 16;
		public static final int _18 = 17;
		public static final int _19 = 18;
		public static final int _20 = 19;
		public static final int _21 = 20;
		public static final int _22 = 21;
		public static final int _23 = 22;
		public static final int _24 = 23;
		public static final int _25 = 24;
		public static final int _26 = 25;
		public static final int _27 = 26;
		public static final int _28 = 27;
		public static final int _29 = 28;
		public static final int _30 = 29;
		public static final int _31 = 30;
		public static final int _32 = 31;
		public static final int _33 = 32;
		public static final int _34 = 33;
		public static final int _35 = 34;
		public static final int _36 = 35;
		public static final int _37 = 36;
		public static final int _38 = 37;
	}
}
