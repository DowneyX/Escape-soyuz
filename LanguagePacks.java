import java.util.HashMap;

// this class contains all the translations for all the languages.

public class LanguagePacks {

    HashMap<String, String> english = new HashMap<String, String>();
    HashMap<String, String> dutch = new HashMap<String, String>();

    public static HashMap<String, CommandWord> dutchCommands = new HashMap<String, CommandWord>();
    public static HashMap<String, CommandWord> englishCommands = new HashMap<String, CommandWord>();

    private static Language language = null;

    // constructor
    public LanguagePacks() {
        // english
        english.put("TEST", "English selected");

        // english commands
        englishCommands.put("go", CommandWord.GO);
        englishCommands.put("take", CommandWord.TAKE);
        englishCommands.put("drop", CommandWord.DROP);
        englishCommands.put("quit", CommandWord.QUIT);
        englishCommands.put("help", CommandWord.HELP);
        englishCommands.put("inventory", CommandWord.INVENTORY);
        englishCommands.put("map", CommandWord.MAP);
        englishCommands.put("repair", CommandWord.REAPAIR);
        englishCommands.put("back", CommandWord.BACK);
        englishCommands.put("inspect", CommandWord.INSPECT);
        englishCommands.put("use", CommandWord.USE);

        // directions in english
        english.put("exit", "exits: ");
        english.put("north", "north");
        english.put("east", "east");
        english.put("south", "south");
        english.put("west", "west");
        english.put("north-east", "north-east");
        english.put("south-east", "south-east");
        english.put("south-west", "south-west");
        english.put("north-west", "north-west");

        // roomdescriptions in english
        english.put("descendModule", "descend-module");
        english.put("orbitalModule", "orbital-module");
        english.put("outsideOrbitalModule", "outside-orbital-module");
        english.put("outsideDescendModuleWest", "descent-module-west");
        english.put("outsideDescendModuleEast", "descent-module-east");
        english.put("serviceModuleWest", "service-module-west");
        english.put("serviceModuleEast", "service-module-east");

        // items/objects in english
        english.put("leak", "leak");
        english.put("yuri", "yuri");
        english.put("viktor", "viktor");
        english.put("brokenNavigationComputer", "broken-navigation-computer");
        english.put("repairedNavigationComputer", "repaired-navigation-computer");
        english.put("repairedSolarpanel", "repaired-solarpanel");
        english.put("brokenSuit", "broken-suit");
        english.put("repairedSuit", "repaired-suit");
        english.put("welder", "welder");
        english.put("tape", "tape");
        english.put("screwdriver", "screwdriver");
        english.put("cables", "cables");
        english.put("solarpanel", "solarpanel");
        english.put("weldingElectrodes", "welding-electrodes");
        english.put("brokenSolarpanel", "broken-solarpanel");
        english.put("myself", "myself");

        // inspections in english
        english.put("repairedSolarpanelInspection", "we should have power now");
        english.put("repairedNavigationComputerInspection", "this should work now.");
        english.put("yuriInspection", "Yuri is dead, maybe i could take his suit");
        english.put("viktorInspection", "viktor is dead, maybe i could take his suit");
        english.put("leakInspection",
                "Doesn't look like oxygen is leaking though, \n I could probably fix it with some welding materials.");
        english.put("brokenNavigationComputerInspection", "If I had a screwdriver and some cables i could fix this.");
        english.put("brokenSuitInspection", "I could probably repair this if i had some tape.");
        english.put("repairedSuitInspection", "Thats some fine craftman ship.");
        english.put("welderInspection", "I could weld with this if i had some welding-electrodes.");
        english.put("tapeInspection", "I can probably repair my suit with this.");
        english.put("screwdriverInspection", "Its a screwdriver.");
        english.put("cablesInspection", "these are cables.");
        english.put("solarpanelInspection", "This shouldn't be floating around here.");
        english.put("weldingElectrodesInspection", "I can weld with these if i had a welder.");
        english.put("brokenSolarpanelInspection",
                "This is proably the cause of my electricity problem, \n I could fix this if i had a solarpanel en a screwdriver.");
        english.put("descendModuleInspection", "Looks like viktor and yuri are dead.");
        english.put("orbitalModuleInspection", "its nice and spacious here.");
        english.put("outsideOrbitalModuleInspection", "It looks beautifull outside.");
        english.put("outsideDescendModuleWestInspection", "It looks beautifull outside.");
        english.put("outsideDescendModuleEastInspection", "It looks beautifull outside.");
        english.put("serviceModuleWestInspection", "It looks beautifull outside.");
        english.put("serviceModuleEastInspection", "It looks beautifull outside.");
        english.put("myselfInspection", "I seem to be fine appart from my amnesia.");

        // welcome in english
        english.put("welcome",
                "You wake up in a soyuz spacecraft.\nYou don't remember anything.\nThe entire spacecraft is out of power.\nIt looks like the 2 people inside of the spacecraft are dead.\nYou should inspect youself to check if you are okay.\nTry and get the spacecraft operational again and return home.\nType 'help' if you need help.");

        // help in english
        english.put("help1", "You have amnesia and you are in a soyuz spacecraft.");
        english.put("help2", "Try and get the spacecraft operational again.");
        english.put("help3", "Repair things that are broken and return home.");
        english.put("help4", "Your command words are:");

        // do what / gowhere in english
        english.put("dropWhat", "Drop what?");
        english.put("takeWhat", "Take what?");
        english.put("goWhere", "Go where?");
        english.put("quitWhat", "Quit what?");
        english.put("repairWhat", "Repair what?");
        english.put("inspectWhat", "Inspect what?");
        english.put("useWhat", "Use What?");

        // cant do / cant go in english
        english.put("cantFind", "I cant find that.");
        english.put("cantGo", "I can't go there.");
        english.put("noSpace", "I don't have space in my inventory.");
        english.put("noMaterial", "I don't have the nessary material in my inventory.");
        english.put("noTool", "I don't have the nessary tool in my inventory.");
        english.put("cantGoBack", "I cant go back any further.");
        english.put("notBroken", "This isnt broken.");
        english.put("noElectricity", "mmh doesn't look like there is any electricity");

        // i did in english
        english.put("iDrop", " droped");
        english.put("iTake", " taken");
        english.put("iCarry", "I am carrying: ");
        english.put("iAmAt", "I am at: ");
        english.put("iRepair", " repaired");
        english.put("iWear", "I'm wearing: ");

        // stating in english
        english.put("spaceLeft", "Space left in my inventory: ");
        english.put("space", "space: ");
        english.put("oxygen", "oxygen: ");
        english.put("repairables", "to repair: ");
        english.put("items", "items: ");
        english.put("objects", "objects: ");

        // lose/win in english
        english.put("deathCause1", "You died.\nYou treid to go outside while you had a puncture in your suit.");
        english.put("deathCause2", "You died.\nYou ran out of oxygen.");
        english.put("deathCause3",
                "You died.\nyou treid to return home but you burned up on re-entry \n You must have forgoten to repair something critical.");
        english.put("youWin", "You safely returned home");

        // quit in english
        english.put("quitGame", "Thank you for playing goodbye ^.^");

        // unknown in english
        english.put("unknownCommand", "I dont know what you mean...");

        // dutch
        dutch.put("TEST", "Nederlands geselecteerd.");

        // dutch commands
        dutchCommands.put("ga", CommandWord.GO);
        dutchCommands.put("pak", CommandWord.TAKE);
        dutchCommands.put("laatvallen", CommandWord.DROP);
        dutchCommands.put("verlaat", CommandWord.QUIT);
        dutchCommands.put("hulp", CommandWord.HELP);
        dutchCommands.put("inventaris", CommandWord.INVENTORY);
        dutchCommands.put("kaart", CommandWord.MAP);
        dutchCommands.put("repareer", CommandWord.REAPAIR);
        dutchCommands.put("terug", CommandWord.BACK);
        dutchCommands.put("inspecteer", CommandWord.INSPECT);
        dutchCommands.put("gebruik", CommandWord.USE);

        // directions in dutch
        dutch.put("exit", "uitgangen: ");
        dutch.put("north", "noord");
        dutch.put("east", "oost");
        dutch.put("south", "zuid");
        dutch.put("west", "west");
        dutch.put("north-east", "noordoost");
        dutch.put("south-east", "zuidoost");
        dutch.put("south-west", "zuidwest");
        dutch.put("north-west", "noordwest");

        // rooms in dutch
        dutch.put("descendModule", "terugkeermodule");
        dutch.put("orbitalModule", "ruimtemodule");
        dutch.put("outsideOrbitalModule", "ruimtemodule-buiten");
        dutch.put("outsideDescendModuleWest", "terugkeermodule-west");
        dutch.put("outsideDescendModuleEast", "terugkeermodule-oost");
        dutch.put("serviceModuleWest", "instrumentenmodule-west");
        dutch.put("serviceModuleEast", "instrumentenmodule-oost");

        // items/objects in dutch
        dutch.put("yuri", "yuri");
        dutch.put("viktor", "viktor");
        dutch.put("repairedNavigationComputer", "gerepareerd-navigatie-computer");
        dutch.put("repairedSolarpanel", "gerepareerd-zonnenpanel");
        dutch.put("leak", "lek");
        dutch.put("brokenNavigationComputer", "kapot-navigatie-computer");
        dutch.put("brokenSuit", "kapot-pak");
        dutch.put("repairedSuit", "gerepareerd-pak");
        dutch.put("welder", "lasser");
        dutch.put("weldingElectrodes", "las-electroden");
        dutch.put("tape", "tape");
        dutch.put("screwdriver", "schroevendraaier");
        dutch.put("cables", "kabels");
        dutch.put("solarpanel", "zonnenpaneel");
        dutch.put("brokenSolarpanel", "kapot-zonnenpaneel");
        dutch.put("myself", "mijzelf");

        // inspections in dutch
        dutch.put("brokenSolarpanelInspection",
                "Als ik een schroevendraaier en een zonnenpaneel ad kan ik dit repareren");
        dutch.put("repairedSolarpanelInspection", "Ik zou nu stroom moeten hebben");
        dutch.put("repairedNavigationComputerInspection", "Dit zou moeten werken");
        dutch.put("yuriInspection", "Yuri is dood, mischien kan ik zijn pak gebruiken");
        dutch.put("viktorInspection", "viktor is dood, mischien kan ik zijn pak gebruiken");
        dutch.put("leakInspection",
                "lijkt er niet op dat er zuurstof ontsnapt,\n Ik zou dit kunnen maken als ik een lasser en lasstafen had.");
        dutch.put("brokenNavigationComputerInspection",
                "Als Ik een schroevendraaier en kabels had kan ik dit repareren.");
        dutch.put("brokenSuitInspection", "Ik zou dit kunnen repareren als ik tape had.");
        dutch.put("repairedSuitInspection", "Dat is nou vakmanschap.");
        dutch.put("welderInspection", "Ik kan hier mee lassen al ik lassatafen had.");
        dutch.put("tapeInspection", "ik zou mijn pak hier mee kunnen rapareren.");
        dutch.put("screwdriverInspection", "dit is een schroevendraaier.");
        dutch.put("cablesInspection", "dit zijn kabels.");
        dutch.put("solarpanelInspection", "dit zou hier niet moeten zweven.");
        dutch.put("weldingElectrodesInspection", "Ik kan hier mee lassen als ik een lasser had.");
        dutch.put("brokenSolarpanelInspection",
                "dit is waarschijnlijk de reden dat ik geen stroom heb, \nIk zou dit kunnen repareren als ik een zonnen-paneel en een schroeven draaier had.");
        dutch.put("descendModuleInspection", "Lijkt er op dat viktor en yuri dood zijn.");
        dutch.put("orbitalModuleInspection", "Ik heb hier veel ruimte.");
        dutch.put("outsideOrbitalModuleInspection", "het ziet er buiten mooi uit.");
        dutch.put("outsideDescendModuleWestInspection", "het ziet er buiten mooi uit.");
        dutch.put("outsideDescendModuleEastInspection", "het ziet er buiten mooi uit.");
        dutch.put("serviceModuleWestInspection", "het ziet er buiten mooi uit.");
        dutch.put("serviceModuleEastInspection", "het ziet er buiten mooi uit.");
        dutch.put("myselfInspection", "alles is goed op mijn geheugenverlies naa.");

        // welcome in dutch
        dutch.put("welcome",
                "Je word wakker in een soyus ruimte voertuig.\nJe herrinert je niks meer.\n Het helevoertuig heeft geen stroom meer.\nhet lijkt er op dat de 2 mensen in het voertuig dood zijn.\nInspecteer jezelf om te kijken of alles goed is.\nProbeer het voetuig werkent te krijgen en ga terug naar huis.\nTiep 'hulp' als je hulp nodig hept.");

        // help in dutch
        dutch.put("help1", "Je hebt geheugenverlies en je bent in een soyuz ruimtevoertuig.");
        dutch.put("help2", "Probeer het voertuig weer werkende te krijgen.");
        dutch.put("help3", "Repareer dingen die kapot zijn en ga terug naar huis.");
        dutch.put("help4", "Je commando worden zijn:");

        // do what / gowhere in dutch
        dutch.put("dropWhat", "Laat wat vallen?");
        dutch.put("takeWhat", "Pak wat?");
        dutch.put("goWhere", "Gaa waarheen?");
        dutch.put("quitWhat", "Verlaat wat?");
        dutch.put("repairWhat", "Repareer wat?");
        dutch.put("inspectWhat", "Inspecteer wat?");
        english.put("useWhat", "gebruik Wat?");

        // cant do / cant go in dutch
        dutch.put("cantFind", "Ik kan dat niet vinden.");
        dutch.put("cantGo", "Daar kan Ik niet heen.");
        dutch.put("noSpace", "Ik heb geen ruimte in mijn inventaris.");
        dutch.put("noMaterial", "Ik heb niet het benodigde material in mijn inventaris.");
        dutch.put("noTool", "Ik heb niet et benodigde gereedschap in mijn inventaris.");
        dutch.put("cantGoBack", "Ik kan niet verder terug.");
        dutch.put("notBroken", "Dit is niet kapot.");
        dutch.put("noElectricity", "mmh lijkt er op dat er geen stroom is.");

        // i did in dutch
        dutch.put("iDrop", " latenvallen");
        dutch.put("iTake", " opgepakt");
        dutch.put("iRepair", " gerepareerd");
        dutch.put("iCarry", "Ik draag bij mij: ");
        dutch.put("iAmAt", "Ik bevind mij bij: ");
        dutch.put("iWear", "Ik heb aan: ");

        // stating in dutch
        dutch.put("spaceLeft", "Ruimte over in mijn inventaris: ");
        dutch.put("space", "Ruimte: ");
        dutch.put("oxygen", "Zuurstof: ");
        dutch.put("repairables", "Te repareren: ");
        dutch.put("items", "Voorwerpen: ");
        dutch.put("objects", "objecten: ");

        // lose/win in dutch
        dutch.put("deathCause1", "je bent dood,\nje probeerde naar buiten te gaan terwel je een gat in je pak had.");
        dutch.put("deathCause2", "je bent dood, \nje had geen zuurstof meer");
        dutch.put("deathCause3",
                "je bent dood, \nJe probeerde terug te keren maar je was opgebrand tijdens de terugkering \n Je bent vergeten iets belangerijks te repareren.");
        dutch.put("youWin", "je bent veilig terug gekeerd naar huis.");

        // quit in dutch
        dutch.put("quitGame", "Dank u wel voor het spelen,  vaarwel ^.^");

        // unkown in dutch
        dutch.put("unknownCommand", "Ik weet niet wat je bedoelt...");

    }

    public static void setlanguage(Language newLanguage) {
        language = newLanguage;
    }

    public Language getlanguage() {
        return language;
    }

    public String getText(String key) {
        switch (language) {
        case DUTCH:
            return dutch.get(key);

        case ENGLISH:
            return english.get(key);

        default:
            return english.get(key);

        }
    }

    public static HashMap<String, CommandWord> getVallidCommands() {
        switch (language) {
        case DUTCH:
            return dutchCommands;

        case ENGLISH:
            return englishCommands;

        default:
            return englishCommands;
        }
    }
}
