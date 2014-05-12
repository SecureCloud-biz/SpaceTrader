/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package de.anderdonau.spacetrader;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;

import de.anderdonau.spacetrader.DataTypes.CrewMember;
import de.anderdonau.spacetrader.DataTypes.Gadgets;
import de.anderdonau.spacetrader.DataTypes.PoliceRecord;
import de.anderdonau.spacetrader.DataTypes.Politics;
import de.anderdonau.spacetrader.DataTypes.Reputation;
import de.anderdonau.spacetrader.DataTypes.SaveGame;
import de.anderdonau.spacetrader.DataTypes.Shields;
import de.anderdonau.spacetrader.DataTypes.Ship;
import de.anderdonau.spacetrader.DataTypes.ShipTypes;
import de.anderdonau.spacetrader.DataTypes.SolarSystem;
import de.anderdonau.spacetrader.DataTypes.SpecialEvents;
import de.anderdonau.spacetrader.DataTypes.Tradeitems;
import de.anderdonau.spacetrader.DataTypes.Weapons;

public class GameState implements Serializable {
	// Special Enables      // Comment these out to disable code
	public static final boolean _STRA_CHEAT_ = true; // Cheat Enable
	public static final boolean _STRA_SHIPYARDCREDITS_ = true; // Display Trade Credits in Ship Yard
	public static final boolean _INCLUDE_DEBUG_DIALOGS_ = true; // Include code for displaying Debug Alerts
	// Add Ships, Weapons, Shields, and Gadgets that don't show up normally
	public static final int EXTRAWEAPONS = 1;   // Number of weapons over standard
	public static final int EXTRAGADGETS = 1;   // Number of Gadgets over standard
	public static final int EXTRASHIELDS = 1;   // Number of Shields over standard
	public static final int EXTRASHIPS = 5;  // Number of Ships over standard
	public static final int DEFSEEDX = 521288629;
	public static final int DEFSEEDY = 362436069;
	public static final int MAXTRADEITEM = 10;
	public static final int MAXCREDITS = 99999999;
	public static final int MAXPRICE = 99999;
	public static final int MAXQUANTITY = 999;
	// Activity level of police, traders or pirates
	public static final int MAXACTIVITY = 8;
	// System status: normally this is uneventful, but sometimes a system has a
	// special event occurring. This influences some prices.
	public static final int MAXSTATUS = 8;
	public static final int UNEVENTFUL = 0;
	public static final int WAR = 1;
	public static final int PLAGUE = 2;
	public static final int DROUGHT = 3;
	public static final int BOREDOM = 4;
	public static final int COLD = 5;
	public static final int CROPFAILURE = 6;
	public static final int LACKOFWORKERS = 7;
	// Difficulty levels
	public static final int MAXDIFFICULTY = 5;
	public static final int BEGINNER = 0;
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;
	public static final int IMPOSSIBLE = 4;
	// Crewmembers. The commander is always the crewmember with index= 0;
	// Zeethibal is always the last
	public static final int MAXCREWMEMBER = 31;
	public static final int MAXSKILL = 10;
	// Skills
	public static final int PILOTSKILL = 0;
	public static final int FIGHTERSKILL = 1;
	public static final int TRADERSKILL = 2;
	public static final int ENGINEERSKILL = 3;
	public static final int MAXSKILLTYPE = 4;
	public static final int SKILLBONUS = 3;
	public static final int CLOAKBONUS = 2;
	// Tradeitems
	public static final int WATER = 0;
	public static final int FURS = 1;
	public static final int FOOD = 2;
	public static final int ORE = 3;
	public static final int GAMES = 4;
	public static final int FIREARMS = 5;
	public static final int MEDICINE = 6;
	public static final int MACHINERY = 7;
	public static final int NARCOTICS = 8;
	public static final int ROBOTS = 9;
	// Ship types
	public static final int MAXSHIPTYPE = 10;
	public static final int MAXRANGE = 20;
	public static final int MANTISTYPE = MAXSHIPTYPE + 2;
	public static final int SCARABTYPE = MAXSHIPTYPE + 3;
	public static final int BOTTLETYPE = MAXSHIPTYPE + 4;
	// Weapons
	public static final int MAXWEAPONTYPE = 3;
	public static final int PULSELASERWEAPON = 0;
	public static final int PULSELASERPOWER = 15;
	public static final int BEAMLASERWEAPON = 1;
	public static final int BEAMLASERPOWER = 25;
	public static final int MILITARYLASERWEAPON = 2;
	public static final int MILITARYLASERPOWER = 35;
	public static final int MORGANLASERWEAPON = 3;
	public static final int MORGANLASERPOWER = 85; // fixme!
	// Shields
	public static final int MAXSHIELDTYPE = 2;
	public static final int ENERGYSHIELD = 0;
	public static final int ESHIELDPOWER = 100;
	public static final int REFLECTIVESHIELD = 1;
	public static final int RSHIELDPOWER = 200;
	public static final int LIGHTNINGSHIELD = 2;
	public static final int LSHIELDPOWER = 350;
	// Hull Upgrade
	public static final int UPGRADEDHULL = 50;
	// Gadgets
	public static final int MAXGADGETTYPE = 5;
	public static final int EXTRABAYS = 0;
	public static final int AUTOREPAIRSYSTEM = 1;
	public static final int NAVIGATINGSYSTEM = 2;
	public static final int TARGETINGSYSTEM = 3;
	public static final int CLOAKINGDEVICE = 4;
	public static final int FUELCOMPACTOR = 5; // MAXGADGETTYPE += 1;
	// Police Action
	public static final int POLICE = 0;
	public static final int POLICEINSPECTION = 0;// Police asks to submit for inspection
	public static final int POLICEIGNORE = 1;// Police just ignores you
	public static final int POLICEATTACK = 2;// Police attacks you (sometimes on sight)
	public static final int POLICEFLEE = 3;// Police is fleeing
	public static final int MAXPOLICE = 9;
	// Pirate Actions
	public static final int PIRATE = 10;
	public static final int PIRATEATTACK = 10;// Pirate attacks
	public static final int PIRATEFLEE = 11;// Pirate flees
	public static final int PIRATEIGNORE = 12;// Pirate ignores you (because of cloak)
	public static final int PIRATESURRENDER = 13;// Pirate surrenders
	public static final int MAXPIRATE = 19;
	// Trader Actions
	public static final int TRADER = 20;
	public static final int TRADERIGNORE = 20;// Trader passes
	public static final int TRADERFLEE = 21;// Trader flees
	public static final int TRADERATTACK = 22;// Trader is attacking (after being provoked)
	public static final int TRADERSURRENDER = 23;// Trader surrenders
	public static final int TRADERSELL = 24;// Trader will sell products in orbit
	public static final int TRADERBUY = 25;// Trader will buy products in orbit
	public static final int TRADERNOTRADE = 26;// Player has declined to transact with Trader
	public static final int MAXTRADER = 29;
	// Space Monster Actions
	public static final int SPACEMONSTERATTACK = 30;
	public static final int SPACEMONSTERIGNORE = 31;
	public static final int MAXSPACEMONSTER = 39;
	// Dragonfly Actions
	public static final int DRAGONFLYATTACK = 40;
	public static final int DRAGONFLYIGNORE = 41;
	public static final int MAXDRAGONFLY = 49;
	public static final int MANTIS = 50;
	// Scarab Actions
	public static final int SCARABATTACK = 60;
	public static final int SCARABIGNORE = 61;
	public static final int MAXSCARAB = 69;
	// Famous Captain
	public static final int FAMOUSCAPTAIN = 70;
	public static final int FAMOUSCAPATTACK = 71;
	public static final int CAPTAINAHABENCOUNTER = 72;
	public static final int CAPTAINCONRADENCOUNTER = 73;
	public static final int CAPTAINHUIEENCOUNTER = 74;
	public static final int MAXFAMOUSCAPTAIN = 79;
	// Other Special Encounters
	public static final int MARIECELESTEENCOUNTER = 80;
	public static final int BOTTLEOLDENCOUNTER = 81;
	public static final int BOTTLEGOODENCOUNTER = 82;
	public static final int POSTMARIEPOLICEENCOUNTER = 83;
	// The commander's ship
	public static final int MAXWEAPON = 3;
	public static final int MAXSHIELD = 3;
	public static final int MAXGADGET = 3;
	public static final int MAXCREW = 3;
	public static final int MAXTRIBBLES = 100000;
	// Solar systems
	public static final int MAXSOLARSYSTEM = 120;
	public static final int ACAMARSYSTEM = 0;
	public static final int BARATASSYSTEM = 6;
	public static final int DALEDSYSTEM = 17;
	public static final int DEVIDIASYSTEM = 22;
	public static final int GEMULONSYSTEM = 32;
	public static final int JAPORISYSTEM = 41;
	public static final int KRAVATSYSTEM = 50;
	public static final int MELINASYSTEM = 59;
	public static final int NIXSYSTEM = 67;
	public static final int OGSYSTEM = 70;
	public static final int REGULASSYSTEM = 82;
	public static final int SOLSYSTEM = 92;
	public static final int UTOPIASYSTEM = 109;
	public static final int ZALKONSYSTEM = 118;
	// Special events
	public static final int COSTMOON = 500000;
	public static final int MAXSPECIALEVENT = 37;
	public static final int ENDFIXED = 7;
	public static final int MAXTEXT = 9;
	public static final int DRAGONFLYDESTROYED = 0;
	public static final int FLYBARATAS = 1;
	public static final int FLYMELINA = 2;
	public static final int FLYREGULAS = 3;
	public static final int MONSTERKILLED = 4;
	public static final int MEDICINEDELIVERY = 5;
	public static final int MOONBOUGHT = 6;  // ----- fixed locations precede
	public static final int MOONFORSALE = 7;
	public static final int SKILLINCREASE = 8;
	public static final int TRIBBLE = 9;
	public static final int ERASERECORD = 10;
	public static final int BUYTRIBBLE = 11;
	public static final int SPACEMONSTER = 12;
	public static final int DRAGONFLY = 13;
	public static final int CARGOFORSALE = 14;
	public static final int INSTALLLIGHTNINGSHIELD = 15;
	public static final int JAPORIDISEASE = 16;
	public static final int LOTTERYWINNER = 17;
	public static final int ARTIFACTDELIVERY = 18;
	public static final int ALIENARTIFACT = 19;
	public static final int AMBASSADORJAREK = 20;
	public static final int ALIENINVASION = 21;
	public static final int GEMULONINVADED = 22;
	public static final int GETFUELCOMPACTOR = 23;
	public static final int EXPERIMENT = 24;
	public static final int TRANSPORTWILD = 25;
	public static final int GETREACTOR = 26;
	public static final int GETSPECIALLASER = 27;
	public static final int SCARAB = 28;
	public static final int GETHULLUPGRADED = 29;  // ------ fixed locations follow
	public static final int SCARABDESTROYED = 30;
	public static final int REACTORDELIVERED = 31;
	public static final int JAREKGETSOUT = 32;
	public static final int GEMULONRESCUED = 33;
	public static final int EXPERIMENTSTOPPED = 34;
	public static final int EXPERIMENTNOTSTOPPED = 35;
	public static final int WILDGETSOUT = 36;
	// Max Number of Tribble Buttons
	public static final int TRIBBLESONSCREEN = 31;  // Other special events (Encounters)
	// First is probability in= 1000;that one could happen at all:
	public static final int CHANCEOFVERYRAREENCOUNTER = 5;
	public static final int MAXVERYRAREENCOUNTER = 6;
	public static final int MARIECELESTE = 0;
	public static final int CAPTAINAHAB = 1;
	public static final int CAPTAINCONRAD = 2;
	public static final int CAPTAINHUIE = 3;
	public static final int BOTTLEOLD = 4;
	public static final int BOTTLEGOOD = 5;  // Already done this encounter?
	public static final int ALREADYMARIE = 1;
	public static final int ALREADYAHAB = 2;
	public static final int ALREADYCONRAD = 4;
	public static final int ALREADYHUIE = 8;
	public static final int ALREADYBOTTLEOLD = 16;
	public static final int ALREADYBOTTLEGOOD = 32;
	// Propability in= 1000;that a trader will make offer while in orbit
	public static final int CHANCEOFTRADEINORBIT = 100;
	// Political systems (governments)
	public static final int MAXPOLITICS = 17;
	public static final int MAXSTRENGTH = 8;
	public static final int ANARCHY = 0;
	// Tech levels.
	public static final int MAXTECHLEVEL = 8;
	// Cargo Dumping Codes. These identify the operation so we can reuse
	// some of the Sell Cargo code.
	// SELL is obvious, Dump is when in dock, Jettison is when in space.
	public static final int SELLCARGO = 1;
	public static final int DUMPCARGO = 2;
	public static final int JETTISONCARGO = 3;
	// System sizes (influences the number of goods available)
	public static final int MAXSIZE = 5;
	// Newspaper Mastheads and Headlines have been moved into String Resources, where
	// they belong. Mastheads starting with codes will have the codes replaced as follows:
	// + -> System Name
	// * -> The System Name
	public static final int MAXMASTHEADS = 3;      // number of newspaper names per Political situation
	public static final int MAXSTORIES = 4;      // number of canned stories per Political situation
	public static final int NEWSINDENT1 = 5;      // pixels to indent= 1;t line of news story
	public static final int NEWSINDENT2 = 5;      // pixels to indent= 2;d line of news story
	public static final int STORYPROBABILITY = 50 / MAXTECHLEVEL; // probability of a story being shown
	public static final int MAXSPECIALNEWSEVENTS = 5;              // maximum number of special news events to keep for a system
	// // News Events that don't exactly match special events
	public static final int WILDARRESTED = 90;
	public static final int CAUGHTLITTERING = 91;
	public static final int EXPERIMENTPERFORMED = 92;
	public static final int ARRIVALVIASINGULARITY = 93;
	public static final int CAPTAINHUIEATTACKED = 100;
	public static final int CAPTAINCONRADATTACKED = 101;
	public static final int CAPTAINAHABATTACKED = 102;
	public static final int CAPTAINHUIEDESTROYED = 110;
	public static final int CAPTAINCONRADDESTROYED = 111;
	public static final int CAPTAINAHABDESTROYED = 112;
	// Police record
	public static final int MAXPOLICERECORD = 10;
	public static final int ATTACKPOLICESCORE = -3;
	public static final int KILLPOLICESCORE = -6;
	public static final int CAUGHTWITHWILDSCORE = -4;
	public static final int ATTACKTRADERSCORE = -2;
	public static final int PLUNDERTRADERSCORE = -2;
	public static final int KILLTRADERSCORE = -4;
	public static final int ATTACKPIRATESCORE = 0;
	public static final int KILLPIRATESCORE = 1;
	public static final int PLUNDERPIRATESCORE = -1;
	public static final int TRAFFICKING = -1;
	public static final int FLEEFROMINSPECTION = -2;
	public static final int TAKEMARIENARCOTICS = -4;
	// Police Record Score
	public static final int PSYCHOPATHSCORE = -70;
	public static final int VILLAINSCORE = -30;
	public static final int CRIMINALSCORE = -10;
	public static final int DUBIOUSSCORE = -5;
	public static final int CLEANSCORE = 0;
	public static final int LAWFULSCORE = 5;
	public static final int TRUSTEDSCORE = 10;
	public static final int HELPERSCORE = 25;
	public static final int HEROSCORE = 75;
	// Reputation (depends on number of kills)
	public static final int MAXREPUTATION = 9;
	public static final int HARMLESSREP = 0;
	public static final int MOSTLYHARMLESSREP = 10;
	public static final int POORREP = 20;
	public static final int AVERAGESCORE = 40;
	public static final int ABOVEAVERAGESCORE = 80;
	public static final int COMPETENTREP = 150;
	public static final int DANGEROUSREP = 300;
	public static final int DEADLYREP = 600;
	public static final int ELITESCORE = 1500;
	// Debt Control
	public static final int DEBTWARNING = 75000;
	public static final int DEBTTOOLARGE = 100000;
	public static final int MAXRESOURCES = 13;
	public static final int NOSPECIALRESOURCES = 0;
	public static final int MINERALRICH = 1;
	public static final int MINERALPOOR = 2;
	public static final int DESERT = 3;
	public static final int LOTSOFWATER = 4;
	public static final int RICHSOIL = 5;
	public static final int POORSOIL = 6;
	public static final int RICHFAUNA = 7;
	public static final int LIFELESS = 8;
	public static final int WEIRDMUSHROOMS = 9;
	public static final int LOTSOFHERBS = 10;
	public static final int ARTISTIC = 11;
	public static final int WARLIKE = 12;
	// Wormholes
	public static final int MAXWORMHOLE = 6;
	public static final int GALAXYWIDTH = 150;
	public static final int GALAXYHEIGHT = 110;
	public static final int SHORTRANGEWIDTH = 160;
	public static final int SHORTRANGEHEIGHT = 160;
	public static final int SHORTRANGEBOUNDSX = 10;
	public static final int BOUNDSX = 5;
	public static final int BOUNDSY = 20;
	public static final int MINDISTANCE = 6;
	public static final int CLOSEDISTANCE = 13;
	public static final int WORMHOLEDISTANCE = 3;
	public static final int EXTRAERASE = 3;  // (There are new functions for crunching down booleans and nibbles, which gain us a little room...)
	public static final int MAXFORFUTUREUSE = 96;
	// Resources. Some systems have special resources, which influences some prices.
	// this is in percentage, and will decrease by one every day.
	public static final int FABRICRIPINITIALPROBABILITY = 25;
	public static final int MAXHIGHSCORE = 3;
	public static final int KILLED = 0;
	public static final int RETIRED = 1;
	public static final int MOON = 2;
	public static final Tradeitems Tradeitems = new Tradeitems();
	public Politics Politics = new Politics();
	final PoliceRecord PoliceRecord = new PoliceRecord();
	final Reputation Reputation = new Reputation();
	final String[] Status = {"under no particular pressure",  // Uneventful
					                        "at war",        // Ore and Weapons in demand
					                        "ravaged by a plague",   // Medicine in demand
					                        "suffering from a drought",    // Water in demand
					                        "suffering from extreme boredom",  // Games and Narcotics in demand
					                        "suffering from a cold spell", // Furs in demand
					                        "suffering from a crop failure", // Food in demand
					                        "lacking enough workers"   // Machinery and Robots in demand
	};
	final String[] SpecialResources = {"Nothing special", "Mineral rich", "Mineral poor", "Desert", "Sweetwater oceans", "Rich soil", "Poor soil", "Rich fauna", "Lifeless", "Weird mushrooms", "Special herbs", "Artistic populace", "Warlike populace"};
	final String[] Activity = {"Absent", "Minimal", "Few", "Some", "Moderate", "Many", "Abundant", "Swarms"};
	final String[] MercenaryName = {"Jameson", "Alyssa", "Armatur", "Bentos", "C2U2", "Chi'Ti", "Crystal", "Dane", "Deirdre", "Doc", "Draco", "Iranda", "Jeremiah", "Jujubal", "Krydon", "Luis", "Mercedez", "Milete", "Muri-L", "Mystyc", "Nandi", "Orestes", "Pancho", "PS37", "Quarck", "Sosumi", "Uma", "Wesley", "Wonton", "Yorvick", "Zeethibal"};
	ShipTypes ShipTypes = new ShipTypes();
	Weapons Weapons = new Weapons();
	Shields Shields = new Shields();
	Gadgets Gadgets = new Gadgets();
	public SolarSystem[] SolarSystem = new SolarSystem[MAXSOLARSYSTEM];
	final SpecialEvents SpecialEvents = new SpecialEvents();
	public final String[] levelDesc = new String[]{"Beginner", "Easy", "Normal", "Hard", "Impossible"};
	final String[] SystemSize = {"Tiny", "Small", "Medium", "Large", "Huge"};
	final String[] techLevel = {"Pre-agricultural", "Agricultural", "Medieval", "Renaissance", "Early Industrial", "Industrial", "Post-industrial", "Hi-tech"};
	final String[] SolarSystemName = {"Acamar", "Adahn",    // The alternate personality for The Nameless One in "Planescape: Torment"
					                                 "Aldea", "Andevian", "Antedi", "Balosnee", "Baratas", "Brax",     // One of the heroes in Master of Magic
					                                 "Bretel",   // This is a Dutch device for keeping your pants up.
					                                 "Calondia", "Campor", "Capelle",    // The city I lived in while programming this game
					                                 "Carzon", "Castor",   // A Greek demi-god
					                                 "Cestus", "Cheron", "Courteney",  // After Courteney Cox...
					                                 "Daled", "Damast", "Davlos", "Deneb", "Deneva", "Devidia", "Draylon", "Drema", "Endor", "Esmee",    // One of the witches in Pratchett's Discworld
					                                 "Exo", "Ferris",   // Iron
					                                 "Festen",   // A great Scandinavian movie
					                                 "Fourmi",   // An ant, in French
					                                 "Frolix",   // A solar system in one of Philip K. Dick's novels
					                                 "Gemulon", "Guinifer",   // One way of writing the name of king Arthur's wife
					                                 "Hades",    // The underworld
					                                 "Hamlet",   // From Shakespeare
					                                 "Helena",   // Of Troy
					                                 "Hulst",    // A Dutch plant
					                                 "Iodine",   // An element
					                                 "Iralius", "Janus",    // A seldom encountered Dutch boy's name
					                                 "Japori", "Jarada", "Jason",    // A Greek hero
					                                 "Kaylon", "Khefka", "Kira",     // My dog's name
					                                 "Klaatu",   // From a classic SF movie
					                                 "Klaestron", "Korma",    // An Indian sauce
					                                 "Kravat",   // Interesting spelling of the French word for "tie"
					                                 "Krios", "Laertes",    // A king in a Greek tragedy
					                                 "Largo", "Lave",     // The starting system in Elite
					                                 "Ligon", "Lowry",    // The name of the "hero" in Terry Gilliam's "Brazil"
					                                 "Magrat",   // The second of the witches in Pratchett's Discworld
					                                 "Malcoria", "Melina", "Mentar",   // The Psilon home system in Master of Orion
					                                 "Merik", "Mintaka", "Montor",   // A city in Ultima III and Ultima VII part 2
					                                 "Mordan", "Myrthe",   // The name of my daughter (comment: Pieter Sproncks daughter)
					                                 "Nelvana", "Nix",      // An interesting spelling of a word meaning "nothing" in Dutch
					                                 "Nyle",     // An interesting spelling of the great river
					                                 "Odet", "Og",     // The last of the witches in Pratchett's Discworld
					                                 "Omega",    // The end of it all
					                                 "Omphalos",   // Greek for navel
					                                 "Orias", "Othello",    // From Shakespeare
					                                 "Parade",   // This word means the same in Dutch and in English
					                                 "Penthara", "Picard",   // The enigmatic captain from ST:TNG
					                                 "Pollux",   // Brother of Castor
					                                 "Quator", "Rakhar", "Ran",      // A film by Akira Kurosawa
					                                 "Regulas", "Relva", "Rhymus", "Rochani", "Rubicum",    // The river Ceasar crossed to get into Rome
					                                 "Rutia", "Sarpeidon", "Sefalla", "Seltrice", "Sigma", "Sol",      // That's our own solar system
					                                 "Somari", "Stakoron", "Styris", "Talani", "Tamus", "Tantalos",   // A king from a Greek tragedy
					                                 "Tanuga", "Tarchannen", "Terosa", "Thera",    // A seldom encountered Dutch girl's name
					                                 "Titan",    // The largest moon of Jupiter
					                                 "Torin",    // A hero from Master of Magic
					                                 "Triacus", "Turkana", "Tyrus", "Umberlee",   // A god from AD&D, which has a prominent role in Baldur's Gate
					                                 "Utopia",   // The ultimate goal
					                                 "Vadera", "Vagra", "Vandor", "Ventax", "Xenon", "Xerxes",   // A Greek hero
					                                 "Yew",      // A city which is in almost all of the Ultima games
					                                 "Yojimbo",    // A film by Akira Kurosawa
					                                 "Zalkon", "Zuul"      // From the first Ghostbusters movie
	};
	public int Credits = 1000;            // Current credits owned
	public int Debt = 0;               // Current Debt
	public int[] BuyPrice = new int[MAXTRADEITEM];    // Price list current system
	public int[] BuyingPrice = new int[MAXTRADEITEM]; // Total price paid for trade goods
	public int[] SellPrice = new int[MAXTRADEITEM];   // Price list current system
	public int[] ShipPrice = new int[MAXSHIPTYPE];    // Price list current system (recalculate when buy ship screen is entered)
	public int PoliceKills = 0;           // Number of police ships killed
	public int TraderKills = 0;           // Number of trader ships killed
	public int PirateKills = 0;           // Number of pirate ships killed
	public int PoliceRecordScore = 0;     //= 0;= Clean record
	public int ReputationScore = 0;       //= 0;= Harmless
	public int MonsterHull = 500;         // Hull strength of monster
	public int SkillPointsLeft = 16;      // Skillpoints to distribute at start of game
	public int CheatCounter = 0;
	public int CurForm = 0;                // Form to return to
	public int Days = 0;                   // Number of days playing
	public int EncounterType = 0;          // Type of current encounter
	public int GalacticChartSystem = 0;    // Current system on Galactic chart
	public int LeaveEmpty = 0;             // Number of cargo bays to leave empty when buying goods
	public int NewsSpecialEventCount = 0;  // Simplifies tracking what Quests have just been initiated or completed for the News System. This is not important enough to get saved.
	public int NoClaim = 0;                // Days of No-Claim
	public int SelectedShipType = 0;       // Selected Ship type for Shiptype Info screen
	public int TrackedSystem = -1;         // The short-range chart will display an arrow towards this system if the value is not -1
	public int WarpSystem = 0;             // Target system for warp
	public int Shortcut1 = 0;        // default shortcut= 1;= Buy Cargo
	public int Shortcut2 = 1;        // default shortcut= 2;= Sell Cargo
	public int Shortcut3 = 2;        // default shortcut= 3;= Shipyard
	public int Shortcut4 = 10;       // default shortcut= 4;= Short Range Warp
	public String[][] Shortcuts = {{"B", "Buy Cargo"}, {"S", "Sell Cargo"}, {"Y", "Ship Yard"}, {"E", "Buy Equipment"}, {"Q", "Sell Equipment"}, {"P", "Personnel"}, {"K", "Bank"}, {"I", "System Info"}, {"C", "Commander Status"}, {"G", "Galactic Chart"}, {"W", "Warp Chart"}};
	// the next two values are NOT saved between sessions -- they can only be changed via cheats.
	public int ChanceOfVeryRareEncounter = CHANCEOFVERYRAREENCOUNTER;
	public int ChanceOfTradeInOrbit = CHANCEOFTRADEINORBIT;
	public int Clicks = 0;                      // Distance from target system,= 0;= arrived
	public static int Difficulty = NORMAL;     // Difficulty level
	public int DragonflyStatus = 0;     //= 0;= Dragonfly not available,= 1;= Go to Baratas,= 2;= Go to Melina,= 3;= Go to Regulas,= 4;= Go to Zalkon,= 5;= Dragonfly destroyed
	public int ExperimentStatus = 0;    // Experiment;= 0;not given yet,1-11 days from start;= 12;performed,= 13;cancelled
	public int FabricRipProbability = 0; // if Experiment == 8; this is the probability of being warped to a random planet.
	public int InvasionStatus = 0;      // Status Alien invasion of Gemulon;= 0;not given yet;= 1;7=days from start;= 8;too late
	public int JaporiDiseaseStatus = 0; //= 0;= No disease,= 1;= Go to Japori (always at least= 10;medicine cannisters),= 2;= Assignment finished or canceled
	public int JarekStatus = 0;         // Ambassador Jarek= 0;not delivered;= 1;on board;= 2;delivered
	public int MonsterStatus = 0;       //= 0;= Space monster isn't available,= 1;= Space monster is in Acamar system,= 2;= Space monster is destroyed
	public int ReactorStatus = 0;     // Unstable Reactor Status:= 0;not encountered;= 1;20=days of mission (bays of fuel left == 10;- (ReactorStatus/2);= 21;delivered
	public int ScarabStatus = 0;    // Scarab:= 0;not given yet,= 1;not destroyed,= 2;destroyed, upgrade not performed,= 3;destroyed, hull upgrade performed
	public int VeryRareEncounter = 0;     // bit map for which Very Rare Encounter(s) have taken place (see traveler.c, around line= 1850;
	public int WildStatus = 0;    // Jonathan Wild:= 0;not delivered;= 1;on board;= 2;delivered
	public boolean APLscreen = false;           // Is true is the APL screen was last shown after the SRC
	public boolean AlreadyPaidForNewspaper = false; // once you buy a paper on a system, you don't have to pay again.
	public boolean AlwaysIgnorePirates = false; // Automatically ignores pirates when it is safe to do so
	public boolean AlwaysIgnorePolice = true;   // Automatically ignores police when it is safe to do so
	public boolean AlwaysIgnoreTradeInOrbit = false; // Automatically ignores Trade in Orbit when it is safe to do so
	public boolean AlwaysIgnoreTraders = false; // Automatically ignores traders when it is safe to do so
	public boolean AlwaysInfo = false;          // Will always go from SRC to Info
	public boolean ArrivedViaWormhole = false; // flag to indicate whether player arrived on current planet via wormhole
	public boolean ArtifactOnBoard = false;     // Alien artifact on board
	public boolean AttackFleeing = false;     // Continue attack on fleeing ship
	public boolean AutoAttack = false;      // Auto-attack mode
	public boolean AutoFlee = false;      // Auto-flee mode
	public boolean AutoFuel = false;            // Automatically get a full tank when arriving in a new system
	public boolean AutoRepair = false;          // Automatically get a full hull repair when arriving in a new system
	public boolean CanSuperWarp = false;   // Do you have the Portable Singularity on board?
	public boolean Continuous = false;      // Continuous attack/flee mode
	public boolean EscapePod = false;           // Escape Pod in ship
	public boolean GameLoaded = false;     // Indicates whether a game is loaded
	public boolean IdentifyStartup = false;  // Identify commander at game start
	public boolean Inspected = false;           // True when the commander has been inspected during the trip
	public boolean Insurance = false;           // Insurance bought
	public boolean JustLootedMarie = false;    // flag to indicate whether player looted Marie Celeste
	public boolean LitterWarning = false;    // Warning against littering has been issued.
	public boolean MoonBought = false;          // Indicates whether a moon is available at Utopia
	public boolean NewsAutoPay = false;    // by default, ask each time someone buys a newspaper
	public boolean PossibleToGoThroughRip = false; // if Dr Fehler's experiment happened, we can only go through one space-time rip per warp.
	public boolean PriceDifferences = false;    // Show price differences instead of absolute prices
	public boolean Raided = false;              // True when the commander has been raided during the trip
	public boolean RemindLoans = true;     // remind you every five days about outstanding loan balances
	public boolean ReserveMoney = false;        // Keep enough money for insurance and mercenaries
	public boolean SaveOnArrival = false;    // Autosave when arriving in a system
	public boolean SharePreferences = true;  // Share preferences between switched games.
	public boolean ShowTrackedRange = true;  // display range when tracking a system on Short Range Chart
	public boolean TextualEncounters = false;   // Show encounters as text.
	public boolean TrackAutoOff = true;    // Automatically stop tracking a system when you get to it?
	public boolean TribbleMessage = false;      // Is true if the Ship Yard on the current system informed you about the tribbles
	public boolean UseHWButtons = false;   // by default, don't use Hardware W buttons
	public int[] Wormhole = new int[GameState.MAXWORMHOLE];
	public int[] NewsEvents = new int[MAXSPECIALNEWSEVENTS]; // Array of news events.
	CrewMember[] CrewMember;
	public CrewMember[] Mercenary;
	public Ship Ship;
	public Ship Opponent;
	Ship SpaceMonster;
	Ship Scarab;
	Ship Dragonfly;
	String[][] NewsPaperNames = {{"* Arsenal", "The Grassroot", "Kick It!"},       /* Anarchy */
					                            {"The Daily Worker", "The People's Voice", "* Proletariat"},    /* Capitalist */
					                            {"Planet News", "* Times", "Interstate Update"},      /* Communist */
					                            {"The Objectivist", "* Market", "The Invisible Hand"},      /* Confederacy */
					                            {"+ Memo", "News From The Board", "Status Report"},     /* Corporate */
					                            {"Pulses", "Binary Stream", "The System Clock"},      /* Cybernetic */
					                            {"The Daily Planet", "* Majority", "Unanimity"},      /* Democracy */
					                            {"The Command", "Leader's Voice", "* Mandate"},       /* Dictatorship */
					                            {"State Tribune", "Motherland News", "Homeland Report"},    /* Fascist */
					                            {"News from the Keep", "The Town Crier", "* Herald"},     /* Feudal */
					                            {"General Report", "+ Dispatch", "* Sentry"},       /* Military */
					                            {"Royal Times", "The Loyal Subject", "The Fanfare"},      /* Monarchy */
					                            {"Pax Humani", "Principle", "* Chorus"},        /* Pacifist */
					                            {"All for One", "Brotherhood", "The People's Syndicate"},   /* Socialist */
					                            {"The Daily Koan", "Haiku", "One Hand Clapping"},     /* Satori */
					                            {"The Future", "Hardware Dispatch", "TechNews"},      /* Technocracy */
					                            {"The Spiritual Advisor", "Church Tidings", "The Temple Tribune"},  /* Theocracy */};
	static String[][] CannedNews = {{"Riots, Looting Mar Factional Negotiations.", "Communities Seek Consensus.", "Successful Bakunin Day Rally!", "Major Faction Conflict Expected for the Weekend!"}, {"Editorial: Taxes Too High!", "Market Indices Read Record Levels!", "Corporate Profits Up!", "Restrictions on Corporate Freedom Abolished by Courts!"}, {"Party Reports Productivity Increase.", "Counter-Revolutionary Bureaucrats Purged from Party!", "Party: Bold New Future Predicted!", "Politburo Approves New 5-Year Plan!"}, {"States Dispute Natural Resource Rights!", "States Denied Federal Funds over Local Laws!", "Southern States Resist Federal Taxation for Capital Projects!", "States Request Federal Intervention in Citrus Conflict!"}, {"Robot Shortages Predicted for Q4.", "Profitable Quarter Predicted.", "CEO: Corporate Rebranding Progressing.", "Advertising Budgets to Increase."}, {"Olympics: Software Beats Wetware in All Events!", "New Network Protocols To Be Deployed.", "Storage Banks to be Upgraded!", "System Backup Rescheduled."}, {"Local Elections on Schedule!", "Polls: Voter Satisfaction High!", "Campaign Spending Aids Economy!", "Police, Politicians Vow Improvements."}, {"New Palace Planned; Taxes Increase.", "Future Presents More Opportunities for Sacrifice!", "Insurrection Crushed: Rebels Executed!", "Police Powers to Increase!"}, {"Drug Smugglers Sentenced to Death!", "Aliens Required to Carry Visible Identification at All Times!", "Foreign Sabotage Suspected.", "Stricter Immigration Laws Installed."}, {"Farmers Drafted to Defend Lord's Castle!", "Report: Kingdoms Near Flashpoint!", "Baron Ignores Ultimatum!", "War of Succession Threatens!"}, {"Court-Martials Up 2% This Year.", "Editorial: Why Wait to Invade?", "HQ: Invasion Plans Reviewed.", "Weapons Research Increases Kill-Ratio!"}, {"King to Attend Celebrations.", "Queen's Birthday Celebration Ends in Riots!", "King Commissions New Artworks.", "Prince Exiled for Palace Plot!"}, {"Dialog Averts Eastern Conflict! ", "Universal Peace: Is it Possible?", "Editorial: Life in Harmony.", "Polls: Happiness Quotient High! "}, {"Government Promises Increased Welfare Benefits!", "State Denies Food Rationing Required to Prevent Famine.", "'Welfare Actually Boosts Economy,' Minister Says.", "Hoarder Lynched by Angry Mob!"}, {"Millions at Peace.", "Sun Rises.", "Countless Hearts Awaken.", "Serenity Reigns."}, {"New Processor Hits 10 ZettaHerz!", "Nanobot Output Exceeds Expectation.", "Last Human Judge Retires.", "Software Bug Causes Mass Confusion."}, {"High Priest to Hold Special Services.", "Temple Restoration Fund at 81%.", "Sacred Texts on Public Display.", "Dozen Blasphemers Excommunicated!"}};
	public String NameCommander;
	public Random rand = new Random();

	public GameState(String NameCommander) {
		int i, j, k, d, x, y;
		Boolean Redo, CloseFound, FreeWormhole;

		initializeBasic();

		if (NameCommander.length() == 0) {
			this.NameCommander = "Shelby";
		} else {
			this.NameCommander = NameCommander;
		}

		// Initialize Galaxy
		i = 0;
		while (i < GameState.MAXSOLARSYSTEM) {
			if (i < GameState.MAXWORMHOLE) {
				// Place the first system somewhere in the centre
				Log.d("gamestateinit", String.format("SolarSystem[%d].x = ((%d / 2) - GetRandom(%d)) + ((%d * (1 + 2 * (%d %% 3))) / 6))", i, GameState.CLOSEDISTANCE, GameState.CLOSEDISTANCE, GameState.GALAXYWIDTH, i));

				SolarSystem[i].x = (((GameState.CLOSEDISTANCE / 2) - GetRandom(GameState.CLOSEDISTANCE)) + ((GameState.GALAXYWIDTH * (1 + 2 * (i % 3))) / 6));
				SolarSystem[i].y = (((GameState.CLOSEDISTANCE / 2) - GetRandom(GameState.CLOSEDISTANCE)) + ((GameState.GALAXYHEIGHT * (i < 3 ? 1 : 3)) / 4));
				Wormhole[i] = i;
			} else {
				SolarSystem[i].x = (1 + GetRandom(GameState.GALAXYWIDTH - 2));
				SolarSystem[i].y = (1 + GetRandom(GameState.GALAXYHEIGHT - 2));
			}

			CloseFound = false;
			Redo = false;
			if (i >= GameState.MAXWORMHOLE) {
				for (j = 0; j < i; ++j) {
					//  Minimum distance between any two systems not to be accepted
					if (SqrDistance(SolarSystem[j], SolarSystem[i]) <= SQR(GameState.MINDISTANCE + 1)) {
						Redo = true;
						break;
					}

					// There should be at least one system which is closeby enough
					if (SqrDistance(SolarSystem[j], SolarSystem[i]) < SQR(GameState.CLOSEDISTANCE))
						CloseFound = true;
				}
			}
			if (Redo)
				continue;
			if ((i >= GameState.MAXWORMHOLE) && !CloseFound)
				continue;

			SolarSystem[i].techLevel = (char) (GetRandom(GameState.MAXTECHLEVEL));
			SolarSystem[i].politics = (char) (GetRandom(GameState.MAXPOLITICS));
			if (de.anderdonau.spacetrader.DataTypes.Politics.mPolitics[SolarSystem[i].politics].minTechLevel > SolarSystem[i].techLevel)
				continue;
			if (de.anderdonau.spacetrader.DataTypes.Politics.mPolitics[SolarSystem[i].politics].maxTechLevel < SolarSystem[i].techLevel)
				continue;

			if (GetRandom(5) >= 3)
				SolarSystem[i].specialResources = (char) (1 + GetRandom(GameState.MAXRESOURCES - 1));
			else
				SolarSystem[i].specialResources = 0;

			SolarSystem[i].size = (char) (GetRandom(GameState.MAXSIZE));

			if (GetRandom(100) < 15)
				SolarSystem[i].status = 1 + GetRandom(GameState.MAXSTATUS - 1);
			else
				SolarSystem[i].status = GameState.UNEVENTFUL;

			SolarSystem[i].nameIndex = i;
			SolarSystem[i].special = -1;
			SolarSystem[i].countDown = 0;
			SolarSystem[i].visited = false;

			SolarSystem[i].initializeTradeitems();

			++i;
		}

		// Randomize the system locations a bit more, otherwise the systems with the first
		// names in the alphabet are all in the centre
		for (i = 0; i < GameState.MAXSOLARSYSTEM; ++i) {
			d = 0;
			while (d < GameState.MAXWORMHOLE) {
				if (Wormhole[d] == i)
					break;
				++d;
			}
			j = GetRandom(GameState.MAXSOLARSYSTEM);
			if (WormholeExists(j, -1))
				continue;
			x = SolarSystem[i].x;
			y = SolarSystem[i].y;
			SolarSystem[i].x = SolarSystem[j].x;
			SolarSystem[i].y = SolarSystem[j].y;
			SolarSystem[j].x = x;
			SolarSystem[j].y = y;
			if (d < GameState.MAXWORMHOLE)
				Wormhole[d] = j;
		}

		// Randomize wormhole order
		for (i = 0; i < GameState.MAXWORMHOLE; ++i) {
			j = GetRandom(GameState.MAXWORMHOLE);
			x = Wormhole[i];
			Wormhole[i] = Wormhole[j];
			Wormhole[j] = x;
		}

		// Initialize mercenary list
		Mercenary[0].nameIndex = 0;
		Mercenary[0].pilot = 1;
		Mercenary[0].fighter = 1;
		Mercenary[0].trader = 1;
		Mercenary[0].engineer = 1;

		i = 1;
		while (i <= GameState.MAXCREWMEMBER) {
			Mercenary[i].curSystem = GetRandom(GameState.MAXSOLARSYSTEM);

			Redo = false;
			for (j = 1; j < i; ++j) {
				// Not more than one mercenary per system
				if (Mercenary[j].curSystem == Mercenary[i].curSystem) {
					Redo = true;
					break;
				}
			}
			// can't have another mercenary on Kravat, since Zeethibal could be there
			if (Mercenary[i].curSystem == GameState.KRAVATSYSTEM)
				Redo = true;
			if (Redo)
				continue;

			Mercenary[i].nameIndex = i;
			Mercenary[i].pilot = RandomSkill();
			Mercenary[i].fighter = RandomSkill();
			Mercenary[i].trader = RandomSkill();
			Mercenary[i].engineer = RandomSkill();

			++i;
		}

		// special individuals: Zeethibal, Jonathan Wild's Nephew
		Mercenary[GameState.MAXCREWMEMBER - 1].curSystem = 255;

		// Place special events
		SolarSystem[GameState.ACAMARSYSTEM].special = GameState.MONSTERKILLED;
		SolarSystem[GameState.BARATASSYSTEM].special = GameState.FLYBARATAS;
		SolarSystem[GameState.MELINASYSTEM].special = GameState.FLYMELINA;
		SolarSystem[GameState.REGULASSYSTEM].special = GameState.FLYREGULAS;
		SolarSystem[GameState.ZALKONSYSTEM].special = GameState.DRAGONFLYDESTROYED;
		SolarSystem[GameState.JAPORISYSTEM].special = GameState.MEDICINEDELIVERY;
		SolarSystem[GameState.UTOPIASYSTEM].special = GameState.MOONBOUGHT;
		SolarSystem[GameState.DEVIDIASYSTEM].special = GameState.JAREKGETSOUT;
		SolarSystem[GameState.KRAVATSYSTEM].special = GameState.WILDGETSOUT;

		// Assign a wormhole location endpoint for the Scarab.
		// It's possible that ALL wormhole destinations are already
		// taken. In that case, we don't offer the Scarab quest.
		FreeWormhole = false;
		k = 0;
		j = GetRandom(GameState.MAXWORMHOLE);
		while (SolarSystem[Wormhole[j]].special != -1 &&
						       Wormhole[j] != GameState.GEMULONSYSTEM && Wormhole[j] != GameState.DALEDSYSTEM && Wormhole[j] != GameState.NIXSYSTEM && k < 20) {
			j = GetRandom(GameState.MAXWORMHOLE);
			k++;
		}
		if (k < 20) {
			FreeWormhole = true;
			SolarSystem[Wormhole[j]].special = GameState.SCARABDESTROYED;
		}

		d = 999;
		k = -1;
		for (i = 0; i < GameState.MAXSOLARSYSTEM; ++i) {
			j = RealDistance(SolarSystem[GameState.NIXSYSTEM], SolarSystem[i]);
			if (j >= 70 && j < d && SolarSystem[i].special < 0 &&
							    d != GameState.GEMULONSYSTEM && d != GameState.DALEDSYSTEM) {
				k = i;
				d = j;
			}
		}
		if (k >= 0) {
			SolarSystem[k].special = GameState.GETREACTOR;
			SolarSystem[GameState.NIXSYSTEM].special = GameState.REACTORDELIVERED;
		}


		i = 0;
		while (i < GameState.MAXSOLARSYSTEM) {
			d = 1 + (GetRandom(GameState.MAXSOLARSYSTEM - 1));
			if (SolarSystem[d].special < 0 && SolarSystem[d].techLevel >= GameState.MAXTECHLEVEL - 1 &&
							    d != GameState.GEMULONSYSTEM && d != GameState.DALEDSYSTEM) {
				SolarSystem[d].special = GameState.ARTIFACTDELIVERY;
				break;
			}
			++i;
		}
		if (i >= GameState.MAXSOLARSYSTEM)
			SpecialEvents.mSpecialEvent[GameState.ALIENARTIFACT].occurrence = 0;


		d = 999;
		k = -1;
		for (i = 0; i < GameState.MAXSOLARSYSTEM; ++i) {
			j = RealDistance(SolarSystem[GameState.GEMULONSYSTEM], SolarSystem[i]);
			if (j >= 70 && j < d && SolarSystem[i].special < 0 &&
							    k != GameState.DALEDSYSTEM && k != GameState.GEMULONSYSTEM) {
				k = i;
				d = j;
			}
		}
		if (k >= 0) {
			SolarSystem[k].special = GameState.ALIENINVASION;
			SolarSystem[GameState.GEMULONSYSTEM].special = GameState.GEMULONRESCUED;
		}

		d = 999;
		k = -1;
		for (i = 0; i < GameState.MAXSOLARSYSTEM; ++i) {
			j = RealDistance(SolarSystem[GameState.DALEDSYSTEM], SolarSystem[i]);
			if (j >= 70 && j < d && SolarSystem[i].special < 0) {
				k = i;
				d = j;
			}
		}
		if (k >= 0) {
			SolarSystem[k].special = GameState.EXPERIMENT;
			SolarSystem[GameState.DALEDSYSTEM].special = GameState.EXPERIMENTSTOPPED;
		}


		for (i = GameState.MOONFORSALE; i < GameState.MAXSPECIALEVENT - GameState.ENDFIXED; ++i) {
			for (j = 0; j < SpecialEvents.mSpecialEvent[i].occurrence; ++j) {
				Redo = true;
				while (Redo) {
					d = 1 + GetRandom(GameState.MAXSOLARSYSTEM - 1);
					if (SolarSystem[d].special < 0) {
						if (FreeWormhole || i != GameState.SCARAB)
							SolarSystem[d].special = i;
						Redo = false;
					}
				}
			}
		}

		// Initialize Commander
		for (i = 0; i < 200; ++i) {
			Mercenary[0]/*COMMANDER*/.curSystem = GetRandom(GameState.MAXSOLARSYSTEM);
			if (SolarSystem[Mercenary[0].curSystem]/*CURSYSTEM*/.special >= 0)
				continue;

			// Seek at least an agricultural planet as startplanet (but not too hi-tech)
			if ((i < 100) && ((SolarSystem[Mercenary[0].curSystem]/*CURSYSTEM*/.techLevel <= 0) || (SolarSystem[Mercenary[0].curSystem]/*CURSYSTEM*/.techLevel >= 6)))
				continue;

			// Make sure at least three other systems can be reached
			d = 0;
			for (j = 0; j < GameState.MAXSOLARSYSTEM; ++j) {
				if (j == Mercenary[0]/*COMMANDER*/.curSystem)
					continue;
				if (SqrDistance(SolarSystem[j], SolarSystem[Mercenary[0].curSystem]/*CURSYSTEM*/) <= SQR(ShipTypes.ShipTypes[1].fuelTanks)) {
					++d;
					if (d >= 3)
						break;
				}
			}
			if (d < 3)
				continue;

			break;
		}

		Credits = 1000;
		Debt = 0;
		Days = 0;
		WarpSystem = Mercenary[0]/*COMMANDER*/.curSystem;
		PoliceKills = 0;
		TraderKills = 0;
		PirateKills = 0;
		PoliceRecordScore = 0;
		ReputationScore = 0;
		MonsterStatus = 0;
		DragonflyStatus = 0;
		ScarabStatus = 0;
		JaporiDiseaseStatus = 0;
		MoonBought = false;
		MonsterHull = ShipTypes.ShipTypes[SpaceMonster.type].hullStrength;
		EscapePod = false;
		Insurance = false;
		RemindLoans = true;
		NoClaim = 0;
		ArtifactOnBoard = false;
		for (i = 0; i < GameState.MAXTRADEITEM; ++i)
			BuyingPrice[i] = 0;
		TribbleMessage = false;
		JarekStatus = 0;
		InvasionStatus = 0;
		ExperimentStatus = 0;
		FabricRipProbability = 0;
		PossibleToGoThroughRip = false;
		ArrivedViaWormhole = false;
		VeryRareEncounter = 0;
		resetNewsEvents();
		WildStatus = 0;
		ReactorStatus = 0;
		TrackedSystem = -1;
		ShowTrackedRange = true;
		JustLootedMarie = false;
		ChanceOfVeryRareEncounter = GameState.CHANCEOFVERYRAREENCOUNTER;
		AlreadyPaidForNewspaper = false;
		CanSuperWarp = false;
		GameLoaded = false;

		// Initialize Ship
		Ship.type = 1;
		for (i = 0; i < GameState.MAXTRADEITEM; ++i)
			Ship.cargo[i] = 0;
		Ship.weapon[0] = 0;
		for (i = 1; i < GameState.MAXWEAPON; ++i)
			Ship.weapon[i] = -1;
		for (i = 0; i < GameState.MAXSHIELD; ++i) {
			Ship.shield[i] = -1;
			Ship.shieldStrength[i] = 0;
		}
		for (i = 0; i < GameState.MAXGADGET; ++i)
			Ship.gadget[i] = -1;
		Ship.crew[0] = 0;
		for (i = 1; i < GameState.MAXCREW; ++i) {
			Ship.crew[i] = -1;
		}
		Ship.fuel = GetFuelTanks();
		Ship.hull = ShipTypes.ShipTypes[Ship.type].hullStrength;
		Ship.tribbles = 0;

		SkillPointsLeft = 16;
	}
	public void initializeBasic() {
		int i;

		CrewMember = new CrewMember[GameState.MAXCREW];
		Mercenary = new CrewMember[GameState.MAXCREWMEMBER + 1];
		for (i=0; i <= GameState.MAXCREWMEMBER; i++) {
			Mercenary[i] = new CrewMember();
		}
		SolarSystem = new SolarSystem[GameState.MAXSOLARSYSTEM];
		for (i=0; i < GameState.MAXSOLARSYSTEM; i++){
			SolarSystem[i] = new SolarSystem();
		}


		final int[] cargo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		final int[] armament = {-1, -1, -1};
		final int[] shielding = {-1, -1, -1};
		final int[] shieldstrength = {0, 0, 0};
		final int[] gadgets = {-1, -1, -1};
		final int[] crew = {0, -1, -1};

		Ship = new Ship(1, // Gnat
						               cargo, // No cargo
						               armament, // One pulse laser
						               shielding, shieldstrength, // No shields
						               gadgets, // No gadgets
						               crew, // Commander on board
						               14, // Full tank
						               100, // Full hull strength
						               0); // No tribbles on board
		crew[0] = 1;
		Opponent = new Ship(1, // Gnat
						                   cargo, // No cargo
						                   armament, // One pulse laser
						                   shielding, shieldstrength, // No shields
						                   gadgets, // No gadgets
						                   crew, // Alyssa on board
						                   14, // Full tank
						                   100, // Full hull strength
						                   0); // No tribbles on board
		armament[0] = armament[1] = armament[2] = 2;
		crew[0] = MAXCREWMEMBER;
		SpaceMonster = new Ship(MAXSHIPTYPE, // Space monster
						                       cargo, // No cargo
						                       armament, // Three military lasers
						                       shielding, shieldstrength, // No shields
						                       gadgets, // No gadgets
						                       crew, // super stats
						                       1, // Full tank
						                       500, // Full hull strength
						                       0); // No tribbles on board
		armament[0] = armament[1] = 2;
		armament[2] = -1;
		Scarab = new Ship(MAXSHIPTYPE + 3, // Scarab
						                 cargo, // No cargo
						                 armament, // Two military lasers
						                 shielding, shieldstrength, // No shields
						                 gadgets, // No gadgets
						                 crew, // super stats
						                 1, // Full tank
						                 400, // Full hull strength
						                 0); // No tribbles on board
		armament[0] = 2;
		armament[1] = 0;
		armament[2] = -1;
		shielding[0] = shielding[1] = shielding[2] = LIGHTNINGSHIELD;
		shieldstrength[0] = shieldstrength[1] = shieldstrength[2] = LSHIELDPOWER;
		gadgets[0] = AUTOREPAIRSYSTEM;
		gadgets[1] = TARGETINGSYSTEM;
		gadgets[2] = -1;
		Dragonfly = new Ship(MAXSHIPTYPE + 1, // Dragonfly
						                    cargo, // No cargo
						                    armament, // One military laser and one pulselaser
						                    shielding, shieldstrength, // Three lightning shields
						                    gadgets, // Gadgets
						                    crew, // super stats
						                    1, // Full tank
						                    10, // Full hull strength (though this isn't much)
						                    0); // No tribbles on board
	}

	public GameState(SaveGame g){
		int i;
		initializeBasic();
		for (i=0; i<GameState.MAXCREWMEMBER; i++) {
			this.Mercenary[i] = g.Mercenary[i];
		}
		this.Opponent = g.Opponent;
		this.Ship = g.Ship;
		for (i=0; i<GameState.MAXSOLARSYSTEM; i++){
			this.SolarSystem[i] = g.SolarSystem[i];
		}
		this.NameCommander = g.NameCommander;
		this.AlreadyPaidForNewspaper = g.AlreadyPaidForNewspaper;
		this.AlwaysIgnorePirates = g.AlwaysIgnorePirates;
		this.AlwaysIgnorePolice = g.AlwaysIgnorePolice;
		this.AlwaysIgnoreTradeInOrbit = g.AlwaysIgnoreTradeInOrbit;
		this.AlwaysIgnoreTraders = g.AlwaysIgnoreTraders;
		this.AlwaysInfo = g.AlwaysInfo;
		this.ArrivedViaWormhole = g.ArrivedViaWormhole;
		this.ArtifactOnBoard = g.ArtifactOnBoard;
		this.AttackFleeing = g.AttackFleeing;
		this.AutoFuel = g.AutoFuel;
		this.AutoRepair = g.AutoRepair;
		this.CanSuperWarp = g.CanSuperWarp;
		this.Continuous = g.Continuous;
		this.EscapePod = g.EscapePod;
		this.GameLoaded = g.GameLoaded;
		this.IdentifyStartup = g.IdentifyStartup;
		this.Inspected = g.Inspected;
		this.Insurance = g.Insurance;
		this.JustLootedMarie = g.JustLootedMarie;
		this.LitterWarning = g.LitterWarning;
		this.MoonBought = g.MoonBought;
		this.NewsAutoPay = g.NewsAutoPay;
		this.PriceDifferences = g.PriceDifferences;
		this.Raided = g.Raided;
		this.RemindLoans = g.RemindLoans;
		this.ReserveMoney = g.ReserveMoney;
		this.SaveOnArrival = g.SaveOnArrival;
		this.SharePreferences = g.SharePreferences;
		this.ShowTrackedRange = g.ShowTrackedRange;
		this.TextualEncounters = g.TextualEncounters;
		this.TrackAutoOff = g.TrackAutoOff;
		this.TribbleMessage = g.TribbleMessage;
		this.Credits = g.Credits;
		this.Debt = g.Debt;
		this.MonsterHull = g.MonsterHull;
		this.PirateKills = g.PirateKills;
		this.PoliceKills = g.PoliceKills;
		this.PoliceRecordScore = g.PoliceRecordScore;
		this.ReputationScore = g.ReputationScore;
		this.TraderKills = g.TraderKills;

		this.Clicks = g.Clicks;
		this.CurForm = g.CurForm;
		this.Days = g.Days;
		this.DragonflyStatus = g.DragonflyStatus;
		this.EncounterType = g.EncounterType;
		this.ExperimentStatus = g.ExperimentStatus;
		this.FabricRipProbability = g.FabricRipProbability;
		this.GalacticChartSystem = g.GalacticChartSystem;
		this.InvasionStatus = g.InvasionStatus;
		this.JaporiDiseaseStatus = g.JaporiDiseaseStatus;
		this.JarekStatus = g.JarekStatus;
		this.LeaveEmpty = g.LeaveEmpty;
		this.MonsterStatus = g.MonsterStatus;
		this.NoClaim = g.NoClaim;
		this.ReactorStatus = g.ReactorStatus;
		this.ScarabStatus = g.ScarabStatus;
		this.SelectedShipType = g.SelectedShipType;
		this.Shortcut1 = g.Shortcut1;
		this.Shortcut2 = g.Shortcut2;
		this.Shortcut3 = g.Shortcut3;
		this.Shortcut4 = g.Shortcut4;
		this.TrackedSystem = g.TrackedSystem;
		this.VeryRareEncounter = g.VeryRareEncounter;
		this.WarpSystem = g.WarpSystem;
		this.WildStatus = g.WildStatus;
		this.Difficulty = g.Difficulty;

		for (i=0; i<GameState.MAXWORMHOLE; i++){
			this.Wormhole[i] = g.Wormhole[i];
		}
		for (i=0; i<GameState.MAXTRADEITEM; i++){
			this.BuyPrice[i] = g.BuyPrice[i];
			this.BuyingPrice[i] = g.BuyingPrice[i];
			this.SellPrice[i] = g.SellPrice[i];
		}
		for (i=0; i<GameState.MAXSHIPTYPE; i++){
			this.ShipPrice[i] = g.ShipPrice[i];
		}
	}
	public int GetRandom(int a) {
		return (rand.nextInt(a));
	}
	public int SQR(int a) {
		return (a * a);
	}
	public double SqrDistance(SolarSystem a, SolarSystem b) {
		return (SQR(a.x - b.x) + SQR(a.y - b.y));
	}

	public boolean WormholeExists(int a, int b) {
		int i;

		i = 0;
		while (i < MAXWORMHOLE) {
			if (Wormhole[i] == a) {
				break;
			}
			++i;
		}

		if (i < MAXWORMHOLE) {
			if (b < 0) {
				return true;
			} else if (i < MAXWORMHOLE - 1) {
				if (Wormhole[i + 1] == b) {
					return true;
				}
			} else if (Wormhole[0] == b) {
				return true;
			}
		}
		return false;
	}
	public int RealDistance( SolarSystem a, SolarSystem b ){
		return (int) Math.sqrt(SqrDistance(a, b));
	}
	public int RandomSkill() {
		return 1 + GetRandom( 5 ) + GetRandom( 6 );
	}
	public int GetFuelTanks() {
		// *************************************************************************
		// Determine size of fueltanks
		// *************************************************************************
		return (HasGadget(this.Ship, FUELCOMPACTOR) ? 18 : ShipTypes.ShipTypes[Ship.type].fuelTanks);
	}
	boolean HasGadget( Ship sh, int Gg ) {
		int i;

		for (i=0; i<MAXGADGET; ++i)
		{
			if (sh.gadget[i] < 0)
				continue;
			if (sh.gadget[i] == Gg)
				return true;
		}

		return false;
	}
	void resetNewsEvents(){
		NewsSpecialEventCount = 0;
	}
	int GetForHire(){
		int ForHire = -1;
		int i;

		for (i=1; i<MAXCREWMEMBER; ++i)
		{
			if (i == Ship.crew[1] || i == Ship.crew[2])
				continue;
			if (Mercenary[i].curSystem == Mercenary[0].curSystem)
			{
				ForHire = i;
				break;
			}
		}
		return ForHire;
	}
	public int AvailableQuarters() {
		return ShipTypes.ShipTypes[Ship.type].crewQuarters - (JarekStatus == 1 ? 1 : 0) - (WildStatus == 1 ? 1 : 0);
	}
	public int MercenaryPriceHire(int idx){
		int price;
		if (idx < 0 || (idx >= MAXCREWMEMBER && WildStatus == 2)){
			price = 0; // This would be Zeethibal, who joins for free after Wild's quest.
		} else {
			price = ((Mercenary[idx].pilot + Mercenary[idx].fighter + Mercenary[idx].trader + Mercenary[idx].engineer) * 3);
		}
		return price;
	}
	public int OpenQuests(){
		int r = 0;

		if (MonsterStatus == 1)
			++r;

		if (DragonflyStatus >= 1 && DragonflyStatus <= 4)
			++r;
		else if (SolarSystem[ZALKONSYSTEM].special == INSTALLLIGHTNINGSHIELD)
			++r;

		if (JaporiDiseaseStatus == 1)
			++r;

		if (ArtifactOnBoard)
			++r;

		if (WildStatus == 1)
			++r;

		if (JarekStatus == 1)
			++r;

		if (InvasionStatus >= 1 && InvasionStatus < 7)
			++r;
		else if (SolarSystem[GEMULONSYSTEM].special == GETFUELCOMPACTOR)
			++r;

		if (ExperimentStatus >= 1 && ExperimentStatus < 11)
			++r;

		if (ReactorStatus >= 1 && ReactorStatus < 21)
			++r;

		if (SolarSystem[NIXSYSTEM].special == GETSPECIALLASER)
			++r;

		if (ScarabStatus == 1)
			++r;

		if (Ship.tribbles > 0)
			++r;

		if (MoonBought)
			++r;

		return r;
	}
	public int CurrentWorth() {
		return (CurrentShipPrice( false ) + Credits - Debt + (MoonBought ? COSTMOON : 0));
	}
	public int CurrentShipPrice(boolean ForInsurance) {
		int i;
		int CurPrice;

		CurPrice = CurrentShipPriceWithoutCargo(ForInsurance);
		for (i=0; i<MAXTRADEITEM; ++i){
			CurPrice += BuyingPrice[i];
		}
		return CurPrice;
	}
	public int CurrentShipPriceWithoutCargo(boolean ForInsurance) {
		int i;
		int CurPrice;

		CurPrice =
						// Trade-in value is three-fourths the original price
						((ShipTypes.ShipTypes[Ship.type].price * (Ship.tribbles > 0 && !ForInsurance? 1 : 3)) / 4)
										// subtract repair costs
										- (GetHullStrength() - Ship.hull) * ShipTypes.ShipTypes[Ship.type].repairCosts
										// subtract costs to fill tank with fuel
										- (ShipTypes.ShipTypes[Ship.type].fuelTanks - GetFuel()) * ShipTypes.ShipTypes[Ship.type].costOfFuel;
		// Add 2/3 of the price of each item of equipment
		for (i=0; i<MAXWEAPON; ++i)
			if (Ship.weapon[i] >= 0)
				CurPrice += WEAPONSELLPRICE( i );
		for (i=0; i<MAXSHIELD; ++i)
			if (Ship.shield[i] >= 0)
				CurPrice += SHIELDSELLPRICE( i );
		for (i=0; i<MAXGADGET; ++i)
			if (Ship.gadget[i] >= 0)
				CurPrice += GADGETSELLPRICE( i );

		return CurPrice;
	}
	public int GetHullStrength() {
		if (ScarabStatus == 3)
			return ShipTypes.ShipTypes[Ship.type].hullStrength + UPGRADEDHULL;
		else
			return ShipTypes.ShipTypes[Ship.type].hullStrength;
	}
	public int GetFuel() {
		return Math.min(Ship.fuel, GetFuelTanks());
	}
	public int WEAPONSELLPRICE( int a ){
		return (BaseSellPrice(Ship.weapon[a], Weapons.mWeapons[Ship.weapon[a]].price));
	}
	public int SHIELDSELLPRICE( int a ){
		return (BaseSellPrice(Ship.shield[a], Shields.mShields[Ship.shield[a]].price));
	}
	public int GADGETSELLPRICE( int a ){
		return (BaseSellPrice(Ship.gadget[a], Gadgets.mGadgets[Ship.gadget[a]].price));
	}
	int BasePrice(int ItemTechLevel, int Price) {
		// *************************************************************************
		// Determine base price of item
		// *************************************************************************
		SolarSystem CURSYSTEM = SolarSystem[Mercenary[0].curSystem];
		return ((ItemTechLevel > CURSYSTEM.techLevel) ? 0 :
						        ((Price * (100 - TraderSkill(Ship))) / 100));
	}
	int BaseSellPrice(int Index, int Price) {
		// *************************************************************************
		// Determine selling price
		// *************************************************************************
		return (Index >= 0 ? ((Price * 3) / 4) : 0);
	}
	public int AdaptDifficulty(int Level) {
		// *************************************************************************
		// Adapt a skill to the difficulty level
		// *************************************************************************
		if (Difficulty == BEGINNER || Difficulty == EASY)
			return (Level+1);
		else if (Difficulty == IMPOSSIBLE)
			return Math.max(1, Level - 1);
		else
			return Level;
	}
	public int FighterSkill( Ship Sh ) {
		// *************************************************************************
		// Fighter skill
		// *************************************************************************
		int i;
		int MaxSkill;

		MaxSkill = Mercenary[Sh.crew[0]].fighter;

		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.crew[i] < 0)
				break;
			if (Mercenary[Sh.crew[i]].fighter > MaxSkill)
				MaxSkill = Mercenary[Sh.crew[i]].fighter;
		}

		if (HasGadget( Sh, TARGETINGSYSTEM ))
			MaxSkill += SKILLBONUS;

		return AdaptDifficulty(MaxSkill);
	}

	public int PilotSkill(Ship Sh) {
		// *************************************************************************
		// Pilot skill
		// *************************************************************************
		int i;
		int MaxSkill;

		MaxSkill = Mercenary[Sh.crew[0]].pilot;

		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.crew[i] < 0)
				break;
			if (Mercenary[Sh.crew[i]].pilot > MaxSkill)
				MaxSkill = Mercenary[Sh.crew[i]].pilot;
		}

		if (HasGadget( Sh, NAVIGATINGSYSTEM ))
			MaxSkill += SKILLBONUS;
		if (HasGadget( Sh, CLOAKINGDEVICE ))
			MaxSkill += CLOAKBONUS;

		return AdaptDifficulty( MaxSkill );
	}
	int TraderSkill(Ship Sh) {
		// *************************************************************************
		// Trader skill
		// *************************************************************************
		int i;
		int MaxSkill;

		MaxSkill = Mercenary[Sh.crew[0]].trader;

		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.crew[i] < 0)
				break;
			if (Mercenary[Sh.crew[i]].trader > MaxSkill)
				MaxSkill = Mercenary[Sh.crew[i]].trader;
		}

		if (JarekStatus >= 2)
			++MaxSkill;

		return AdaptDifficulty(MaxSkill);
	}

	int EngineerSkill(Ship Sh) {
		// *************************************************************************
		// Engineer skill
		// *************************************************************************
		int i;
		int MaxSkill;

		MaxSkill = Mercenary[Sh.crew[0]].engineer;

		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.crew[i] < 0)
				break;
			if (Mercenary[Sh.crew[i]].engineer > MaxSkill)
				MaxSkill = Mercenary[Sh.crew[i]].engineer;
		}

		if (HasGadget( Sh, AUTOREPAIRSYSTEM ))
			MaxSkill += SKILLBONUS;

		return AdaptDifficulty(MaxSkill);
	}

	public void RecalculateSellPrices() {
		// *************************************************************************
		// After erasure of police record, selling prices must be recalculated
		// *************************************************************************
		int i;

		for (i=0; i<MAXTRADEITEM; ++i)
			SellPrice[i] = (SellPrice[i] * 100) / 90;
	}
	public int TotalCargoBays() {
		// *************************************************************************
		// Calculate total cargo bays
		// *************************************************************************
		int Bays;
		int i;

		Bays = ShipTypes.ShipTypes[Ship.type].cargoBays;
		for (i=0; i<MAXGADGET; ++i)
			if (Ship.gadget[i] == EXTRABAYS)
				Bays += 5;
		if (JaporiDiseaseStatus == 1)
			Bays -= 10;
		// since the quest ends when the reactor
		if (ReactorStatus > 0 && ReactorStatus < 21)
			Bays -= (5 + 10 - (ReactorStatus - 1)/2);

		return Bays;
	}
	public int FilledCargoBays() {
		// *************************************************************************
		// Calculate total filled cargo bays
		// *************************************************************************
		int sum, i;

		sum = 0;
		for (i=0; i<MAXTRADEITEM; ++i)
			sum = sum + Ship.cargo[i];

		return sum;
	}

	// *************************************************************************
	// Money available to spend
	// *************************************************************************
	public int MercenaryMoney(){
		int i, ToPay;

		ToPay = 0;
		for (i=1; i<MAXCREW; ++i)
			if (Ship.crew[i] >= 0)
				ToPay += MercenaryPriceHire(Ship.crew[i]);

		return ToPay;
	}
	public int InsuranceMoney(){
		if (!Insurance)
			return 0;
		else
			return (Math.max(1, (((CurrentShipPriceWithoutCargo( true ) * 5) / 2000) * (100 - Math.min( NoClaim, 90 )) / 100) ));
	}
	int ToSpend(){
		if (!ReserveMoney)
			return Credits;
		return Math.max(0,  Credits - MercenaryMoney() - InsuranceMoney());
	}
	public boolean AnyEmptySlots(Ship ship) {
		int j;

		for (j=0; j< ShipTypes.ShipTypes[ship.type].weaponSlots; ++j){
			if (ship.weapon[j] < 0){
				return true;
			}
		}
		for (j=0; j< ShipTypes.ShipTypes[ship.type].shieldSlots; ++j){
			if (ship.shield[j] < 0){
				return true;
			}
		}
		for (j=0; j< ShipTypes.ShipTypes[ship.type].gadgetSlots; ++j){
			if (ship.gadget[j] < 0){
				return true;
			}
		}
		return false;
	}
	public int GetFirstEmptySlot(int Slots, int[] Item ) {
		int FirstEmptySlot, j;

		FirstEmptySlot = -1;
		for (j=0; j<Slots; ++j){
			if (Item[j] < 0){
				FirstEmptySlot = j;
				break;
			}
		}
		return FirstEmptySlot;
	}
	public int MaxLoan() {
		return (int) (PoliceRecordScore >= CLEANSCORE ? Math.min(25000L, Math.max(1000L, ((CurrentWorth() / 10L) / 500L) * 500L)) : 500L);
	}
}