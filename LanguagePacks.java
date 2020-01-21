import java.util.HashMap;

/**
 * Write a description of class LanguagePacks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LanguagePacks
{
    
    HashMap<String, String> english = new HashMap<String, String>();
    HashMap<String, String> dutch = new HashMap<String, String>();
    
    public static HashMap<String, CommandWord> dutchCommands = new HashMap<String, CommandWord>();
    public static HashMap<String, CommandWord> englishCommands = new HashMap<String, CommandWord>();
    
    private static Language language = null;

    /**
     * Constructor for objects of class LanguagePacks
     */
    public LanguagePacks()
    {
        
        //english
        
        
        //english commands
        englishCommands.put("go",CommandWord.GO);
        englishCommands.put("take",CommandWord.TAKE);
        englishCommands.put("drop", CommandWord.DROP);
        englishCommands.put("quit",CommandWord.QUIT);
        englishCommands.put("help",CommandWord.HELP);
        englishCommands.put("inventory",CommandWord.INVENTORY);
        englishCommands.put("map",CommandWord.MAP);
        englishCommands.put("repair", CommandWord.REAPAIR);
        englishCommands.put("back", CommandWord.BACK);
        
        //english selected
        english.put("TEST", "English selected");

        //directions in english
        english.put("exit","exits: ");
        english.put("north","north");
        english.put("east","east");
        english.put("south","south");
        english.put("west","west");
        english.put("north-east","north-east");
        english.put("south-east","south-east");
        english.put("south-west","south-west");
        english.put("north-west","north-west");
        
        //rooms in english
        english.put("descendModule","in the descend module");
        english.put("orbitalModule","in the orbital module");
        english.put("outsideOrbitalModule","outside the orbital module");
        english.put("outsideDescendModuleWest","outside the west side of the decent module");
        english.put("outsideDescendModuleEast","outside the east side of the decent module");
        english.put("serviceModuleWest","outside the west side of the service module");
        english.put("serviceModuleEast","outside the east side of the service module");
        
        //items/objects in english
        english.put("leak","leak");
        english.put("navigation-computer","navigation-computer");
        english.put("broken-suit","broken-suit");
        english.put("repaired-suit","repaired-suit");
        english.put("welder","welder");
        english.put("tape","tape");
        english.put("screwdriver","screwdriver");
        english.put("cables","cables");
        english.put("solarpanel","solarpanel");
        english.put("weldingrods","welding-rods");
        
        //welcome in english
        english.put("welcome1","You wake up in a soyuz spacecraft.");
        english.put("welcome2","You don't remember anything.");
        english.put("welcome3","The entire spacecraft is out of power.");
        english.put("welcome4","It looks like the 2 people inside of the spacecraft are dead.");
        english.put("welcome5","You should inspect youself to check if you are okay.");
        english.put("welcome6","Try and get the spacecraft operational again and return home.");
        english.put("welcome7","Type 'help' if you need help.");
        
        //help in english
        english.put("help1","You have amnesia and you are in a soyuz spacecraft.");
        english.put("help2","Try and get the spacecraft operational again.");
        english.put("help3","Repair things that are broken and return home.");
        english.put("help4","Your command words are:");
        
        //do what / gowhere in english
        english.put("dropwhat","Drop what?");
        english.put("takewhat","Take what?");
        english.put("gowhere","Go where?");
        english.put("quitwhat","Quit what?");
        english.put("repairwhat","Repair what?");
        
        //cant do / cant go in english
        english.put("cantfind","I cant find that.");
        english.put("cantgo","I can't go there.");
        english.put("nospace","I don't have space in my inventory.");
        english.put("nomaterial","I don't have the nessary material in my inventory.");
        english.put("notool","I don't have the nessary tool in my inventory.");
        english.put("cantback","I cant go back any further.");

        //i did in english
        english.put("idrop"," droped");
        english.put("itake"," taken");
        english.put("icarry","I am carrying: ");
        english.put("iam","I am ");
        english.put("irepair"," repaired");
        
        //death in dutch
        dutch.put("death","You died");
        dutch.put("cause1", "You treid to go outside while you had a puncture in your suit.");
        
        //quit in english
        english.put("quitgame","Thank you for playing goodbye ^.^");
        
        //unknown in english
        english.put("unknowncomand","I dont know what you mean...");
        
        dutch.put("TEST", "Nederlands geselecteerd.");
        
        //dutch

        //dutch commands
        dutchCommands.put("ga",CommandWord.GO);
        dutchCommands.put("pak",CommandWord.TAKE);
        dutchCommands.put("laatvallen",CommandWord.DROP);
        dutchCommands.put("verlaat",CommandWord.QUIT);
        dutchCommands.put("hulp",CommandWord.HELP);
        dutchCommands.put("inventaris",CommandWord.INVENTORY);
        dutchCommands.put("kaart",CommandWord.MAP);
        dutchCommands.put("repareer", CommandWord.REAPAIR);
        dutchCommands.put("terug", CommandWord.BACK);
        
        //directions in dutch
        dutch.put("exit","uitgangen: ");
        dutch.put("north","noord");
        dutch.put("east","oost");
        dutch.put("south","zuid");
        dutch.put("west","west");
        dutch.put("north-east","noord-oost");
        dutch.put("south-east","zuid-oost");
        dutch.put("south-west","zuid-west");
        dutch.put("north-west","noord-west");
        
        //rooms in dutch
        dutch.put("descendModule","in de terugkeermodule");
        dutch.put("orbitalModule","in de ruimtemodule");
        dutch.put("outsideOrbitalModule","buiten de ruimtemodule");
        dutch.put("outsideDescendModuleWest","buiten aan de westerlijke zijde van de terugkeermodule");
        dutch.put("outsideDescendModuleEast","buiten aan de oosterlijke zijde van de terugkeermodule");
        dutch.put("serviceModuleWest","buiten aan de westerlijke zijde van de instrumentenmodule");
        dutch.put("serviceModuleEast","buiten aan de oosterlijke zijde van de instrumentenmodule");

        //items/objects in dutch
        dutch.put("leak","lek");
        dutch.put("navigation-computer","navigatie-computer");
        dutch.put("broken-suit", "kapot-pak");
        dutch.put("repaired-suit", "gerepareerd-pak");
        dutch.put("welder","lasser");
        dutch.put("weldingrods","lasstafen");
        dutch.put("tape","tape");
        dutch.put("screwdriver","schroevendraaier");
        dutch.put("cables","kabels");
        dutch.put("solarpanel","zonnenpaneel");
          
        //welcome in dutch
        dutch.put("welcome1","Je word wakker in een soyus ruimte voertuig.");
        dutch.put("welcome2","Je herrinert je niks meer.");
        dutch.put("welcome3","Het helevoertuig heeft geen stroom meer.");
        dutch.put("welcome4","het lijkt er op dat de 2 mensen in het voertuig dood zijn.");
        dutch.put("welcome5","Inspecteer jezelf om te kijken of alles goed is.");
        dutch.put("welcome6","Probeer het voetuig werkent te krijgen en ga terug naar huis");
        dutch.put("welcome7","Tiep 'hulp' als je hulp nodig hept");
        
        //help in dutch
        dutch.put("help1","Je hebt geheugenverlies en je bent in een soyuz ruimtevoertuig.");
        dutch.put("help2","Probeer het voertuig weer werkende te krijgen.");
        dutch.put("help3","Repareer dingen die kapot zijn en ga terug naar huis");
        dutch.put("help4","Je commando worden zijn:");

        //do what / gowhere in dutch
        dutch.put("dropwhat","Laat wat vallen?");
        dutch.put("takewhat","pak wat?");
        dutch.put("gowhere","Gaa waarheen?");
        dutch.put("quitwhat","Verlaat wat?");
        dutch.put("repairwhat","Repareer wat?");
        
        
        //cant do / cant go in dutch
        dutch.put("cantfind","Ik kan dat niet vinden.");
        dutch.put("cantgo","Daar kan Ik niet heen.");
        dutch.put("nospace","Ik heb geen ruimte in mijn inventaris.");
        dutch.put("nomaterial","Ik heb niet het benodigde material in mijn inventaris.");
        dutch.put("notool","Ik heb niet et benodigde gereedschap in mijn inventaris.");
        dutch.put("cantback","Ik kan niet verder terug.");

        //i did in dutch
        dutch.put("idrop"," latenvallen");
        dutch.put("itake"," opgepakt");
        dutch.put("irepair"," gerepareerd");
        dutch.put("icarry","ik draag: ");
        dutch.put("iam","ik ben ");

        //death in dutch
        dutch.put("death","je bent dood gegaan");
        dutch.put("cause1", "je probeerde naar buiten te gaan met een gat in je pak");
 
        //quit in dutch
        dutch.put("quitgame","Dank u wel voor het spelen, vaarwel ^.^");

        //unkown in dutch
        dutch.put("unknowncomand","Ik weet niet wat je bedoelt...");
        
    }
    
    public static void setlanguage(Language newLanguage)
    {
        language = newLanguage;
    }
    
    public Language getlanguage()
    {
        return language;
    }
    
    public String getText(String key)
    {
        switch (language)
        {
            case DUTCH:
            return dutch.get(key);
            
            case ENGLISH:
            return english.get(key);
            
            default:
            return english.get(key);
            
        }
    }
    
    public static HashMap<String, CommandWord> getVallidCommands()
    {
        switch (language)
        {
            case DUTCH:
            return dutchCommands;
            
            case ENGLISH:
            return englishCommands;
            
            default:
            return englishCommands;
            
        }
    }
}
