import java.util.Scanner;

//this clas is responsible for initializing the entire game

public class Game 
{
    private Parser parser;
    private Player player;
    private LanguagePacks lang;
    Room descendModule, orbitalModule, outsideOrbitalModule, outsideDescendModuleWest, outsideDescendModuleEast,
            serviceModuleWest, serviceModuleEast;
    Scanner reader = new Scanner(System.in);

    // initialises the players the parser and languagepack
    public Game() {
        parser = new Parser();
        player = new Player();
        lang = new LanguagePacks();
    }

    // creates all the rooms and item and links the exits together and sets items to
    // the right location
    private void createRooms() {

        // create the rooms
        descendModule = new Room(lang.getText("descendModule"),true,lang.getText("descendModuleInspection"));
        orbitalModule = new Room(lang.getText("orbitalModule"),true,lang.getText("orbitalModuleInspection"));
        outsideOrbitalModule = new Room(lang.getText("outsideOrbitalModule"),false,lang.getText("outsideOrbitalModuleInspection"));
        outsideDescendModuleWest = new Room(lang.getText("outsideDescendModuleWest"),false,lang.getText("outsideDescendModuleWestInspection"));
        outsideDescendModuleEast = new Room(lang.getText("outsideDescendModuleEast"),false,lang.getText("outsideDescendModuleEastInspection"));
        serviceModuleWest = new Room(lang.getText("serviceModuleWest"),false,lang.getText("serviceModuleWestInspection"));
        serviceModuleEast = new Room(lang.getText("serviceModuleEast"),false,lang.getText("serviceModuleEastInspection"));

        // initialise room exits
        descendModule.setExit(lang.getText("north"), orbitalModule);
        orbitalModule.setExit(lang.getText("north"), outsideOrbitalModule);
        orbitalModule.setExit(lang.getText("south"), descendModule);
        outsideOrbitalModule.setExit(lang.getText("south"), orbitalModule);
        outsideOrbitalModule.setExit(lang.getText("south-west"), outsideDescendModuleWest);
        outsideOrbitalModule.setExit(lang.getText("south-east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(lang.getText("north-east"), outsideOrbitalModule);
        outsideDescendModuleWest.setExit(lang.getText("east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(lang.getText("south"), serviceModuleWest);
        outsideDescendModuleEast.setExit(lang.getText("north-west"), outsideOrbitalModule);
        outsideDescendModuleEast.setExit(lang.getText("west"), outsideDescendModuleWest);
        outsideDescendModuleEast.setExit(lang.getText("south"), serviceModuleEast);
        serviceModuleWest.setExit(lang.getText("north"), outsideDescendModuleWest);
        serviceModuleWest.setExit(lang.getText("east"), serviceModuleEast);
        serviceModuleEast.setExit(lang.getText("north"), outsideDescendModuleEast);
        serviceModuleEast.setExit(lang.getText("west"), serviceModuleWest);

        // variables of all the items
        Item welder = new Item(lang.getText("welder"), 3, lang.getText("welderInspection"));
        Item weldingrods = new Item(lang.getText("weldingrods"), 1, lang.getText("weldingrodsInspection"));
        Item tape = new Item(lang.getText("tape"), 1,lang.getText("tapeInspection"));
        Item screwdriver = new Item(lang.getText("screwdriver"), 2, lang.getText("screwdriverInspection"));
        Item cables = new Item(lang.getText("cables"), 2, lang.getText("calesInspection"));
        Item solarpanel = new Item(lang.getText("solarpanel"), 6, lang.getText("solarpanelInspection"));

        // creates items with their location
        descendModule.setItem(welder);
        descendModule.setItem(weldingrods);
        orbitalModule.setItem(tape);
        descendModule.setItem(screwdriver);
        outsideDescendModuleWest.setItem(cables);
        serviceModuleEast.setItem(solarpanel);

        // creates reapairable objects
        descendModule.setRepairable(new RepairableObject(lang.getText("leak"), weldingrods, welder, lang.getText("leakInspection")));
        descendModule.setRepairable(new RepairableObject(lang.getText("navigationComputer"), cables, screwdriver, lang.getText("navigationComputerInspection")));
        serviceModuleEast.setRepairable(new RepairableObject((lang.getText("brokenColarPanel")), solarpanel, screwdriver, lang.getText("brokenSolarplanelInspection")));

        // start game inside decent module
        player.currentsuit = new Suit(lang.getText("brokenSuit"),false, lang.getText("brokenSuitInspection"));
        player.currentsuit.setMaterial(tape);
        player.currentRoom = descendModule;
        player.roomHistory.add(player.currentRoom);
    }

    // prints a map of the game plus where the player is at that moment
    private void printMap() {
        String noPlayer = "     ";
        String playerHere = " <○> ";

        String dcm = noPlayer;
        String omm = noPlayer;
        String oom = noPlayer;
        String odw = noPlayer;
        String ode = noPlayer;
        String smw = noPlayer;
        String sme = noPlayer;

        if (player.currentRoom == descendModule) {
            dcm = playerHere;
        }
        if (player.currentRoom == orbitalModule) {
            omm = playerHere;
        }
        if (player.currentRoom == outsideOrbitalModule) {
            oom = playerHere;
        }
        if (player.currentRoom == outsideDescendModuleWest) {
            odw = playerHere;
        }
        if (player.currentRoom == outsideDescendModuleEast) {
            ode = playerHere;
        }
        if (player.currentRoom == serviceModuleWest) {
            smw = playerHere;
        }
        if (player.currentRoom == serviceModuleEast) {
            sme = playerHere;
        }
        System.out.println();
        System.out.println(lang.getText("iAmAt")+playerHere);
        System.out.println();
        System.out.println("                  "+oom+"          N");
        System.out.println("                  :-^-:        W ○ O ");
        System.out.println("                 /     \\         Z");
        System.out.println("                0 "+omm+" 0");
        System.out.println("                 \\     /");
        System.out.println("                  :-^-:");
        System.out.println("                 /     \\");
        System.out.println("          "+odw+" 0 "+dcm+" 0 "+ode);
        System.out.println("                |_______|");
        System.out.println(" ______________ :/_\\_/_\\: _______________");
        System.out.println("|=|=|=|=|=|=|:A-|':|||:'|-A:|=|=|=|=|=|=|");
        System.out.println("^\"\"\"\"\"\"\"\"\"\"\"\"\"\" !::{o}::! \"\"\"\"\"\"\"\"\"\"\"\"\"\"^");
        System.out.println("             "+smw+"   "+sme);
    }

    // starts the game.
    public void play() {
        selectLanguage();
        createRooms();
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        // prints goodbye message
        System.out.println(lang.getText("quitgame"));
    }

    // selects a language depending on what language you selected
    private void selectLanguage() {
        System.out.println("please select a language");
        System.out.println("selecteer een taal A.u.b");

        String selectedLanguage = reader.nextLine().toLowerCase();

        switch (selectedLanguage) {
        case "nederlands":
            LanguagePacks.setlanguage(Language.DUTCH);
            break;

        case "english":
            LanguagePacks.setlanguage(Language.ENGLISH);
            break;

        default:
            selectLanguage();

        }
    }

    // prints a opening message for the player
    private void printWelcome() {
        System.out.println(lang.getText("TEST"));
        System.out.println();
        System.out.println(lang.getText("welcome1"));
        System.out.println(lang.getText("welcome2"));
        System.out.println(lang.getText("welcome3"));
        System.out.println(lang.getText("welcome4"));
        System.out.println(lang.getText("welcome5"));
        System.out.println(lang.getText("welcome6"));
        System.out.println(lang.getText("welcome7"));
        System.out.println();
        System.out.println(getLongDescription());
    }

    // prosseses a given command
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
        case UNKNOWN:
            System.out.println(lang.getText("unknownCommand"));
            break;

        case HELP:
            printHelp();
            break;

        case GO:
            goRoom(command);
            break;

        case QUIT:
            wantToQuit = quit(command);
            break;

        case INVENTORY:
            printInventory();
            break;

        case MAP:
            printMap();
            break;

        case TAKE:
            takeItem(command);
            break;

        case DROP:
            dropItem(command);
            break;

        case REAPAIR:
            repair(command);
            break;

        case BACK:
            goback();
            break;

        case INSPECT:
            inspect(command);
            break;
        }
        return wantToQuit;
    }

    public void inspect(Command command){
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to inspect
            System.out.println(lang.getText("inspectWhat"));
            return;
        }

        String secondWord = command.getSecondWord();
        Room currentRoom = player.currentRoom;
        Suit currentSuit = player.currentsuit;
        Item item = currentRoom.getItem(secondWord);
        RepairableObject repairableObject = currentRoom.getRepairableObject(secondWord);
        
        
        if (secondWord.equals(currentRoom.getShortDescription())){
            System.out.println(lang.getText("iAmAt") + currentRoom.getShortDescription());
            System.out.println(currentRoom.getInpection());
            System.out.println("items: "+ currentRoom.getRoomItems());
            System.out.println("repairables: " + currentRoom.getRoomRepairableObjects());
            System.out.println("oxygen:" + currentRoom.getOxygen());

            return;
        }
        if (repairableObject != null){
            System.out.println(repairableObject.getInspection());
            return;
        }
        if(item != null){
            System.out.println(item.getInspection());
            System.out.println("volume: ["+item.getVolume()+"]");
            return;
        }
        if(secondWord.equals(lang.getText("myself"))){
            System.out.println(lang.getText("myselfInspection"));
            return;
        }
        if(secondWord.equals(currentSuit.getDescription())){
            System.out.println(currentSuit.getInspection());
            return;
        }
        else{
            System.out.println(lang.getText("cantFind"));
        }
    }

    public void repair(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to rapiar
            System.out.println(lang.getText("repairWhat"));
            return;
        }

        String secondWord = command.getSecondWord();
        Suit suit = player.currentsuit;
        RepairableObject repairableObject = player.currentRoom.getRepairableObject(secondWord);

        if (suit.getDescription().equals(secondWord)){
            Item material = player.currentsuit.getMaterial();

            if (player.currentsuit.getAitight() == true){
                System.out.println(lang.getText("notBroken"));
                return;
            }
            else if (player.getItem(material.getDescription()) == null){
                System.out.println(lang.getText("noMaterial"));
                return;
            }
            else{
                player.currentsuit = new Suit(lang.getText("repairedSuit"), true, lang.getText("repairedSuitInspection"));
                System.out.println(secondWord + lang.getText("iRepair"));
                return;
            }
        }

        if (repairableObject != null) 
        {
            Item material = repairableObject.getMaterial();

            if (player.getItem(material.getDescription()) == null) {
                System.out.println(lang.getText("noMaterial"));
                return;
            }

            Item tool = repairableObject.getTool();

            if (player.getItem(tool.getDescription()) == null) {
                System.out.println(lang.getText("noTool"));
                return;
            } else 
            {
                player.removeItem(material.getDescription());
                player.currentRoom.removeRepairableObject(secondWord);
                System.out.println(lang.getText("iRepair") + secondWord);
                return;
            }
        }
        System.out.println(lang.getText("cantFind"));
            return;
    }

    // prints all the items that are in the players inventory
    private void printInventory() {
        System.out.println(lang.getText("iWear")+player.currentsuit.getDescription());
        System.out.println(lang.getText("iCarry"));
        System.out.println(player.GetInventoryItems());
        System.out.println(lang.getText("spaceLeft")+"[" + (player.inventoryVolume - player.getInventoryVolume())+"]");

    }

    // gives a help message with all the commandwords
    private void printHelp() {
        System.out.println(lang.getText("help1"));
        System.out.println(lang.getText("help2"));
        System.out.println(lang.getText("help3"));
        System.out.println();
        System.out.println(lang.getText("help4"));
        parser.showCommands();
    }

    // drops a given item
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop.
            System.out.println(lang.getText("dropWhat"));
            return;
        }

        String item = command.getSecondWord();
        Item newitem = player.getItem(item);

        // try to drop item
        if (newitem == null) {
            System.out.println(lang.getText("cantFind"));
        } else {
            player.removeItem(item);
            player.currentRoom.setItem(newitem);
            System.out.println( item + lang.getText("iDrop"));
        }
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take.
            System.out.println(lang.getText("takeWhat"));
            return;
        }

        // gets the item from the room.
        String item = command.getSecondWord();
        Item newitem = player.currentRoom.getItem(item);

        if (newitem == null) {
            System.out.println(lang.getText("cantFind"));
            return;
        }

        // calculates the volume of of the inventory + the volume of the item
        int totalVolume = newitem.getVolume() + player.getInventoryVolume();

        if (totalVolume > player.inventoryVolume) {
            System.out.println(lang.getText("noSpace"));
        } else {
            player.inventory.put(item, newitem);
            player.currentRoom.removeItem(item);
            System.out.println( item + lang.getText("iTake"));
        }
    }

    // goes to the room with the given direction
    private void goRoom(Command command) 
    {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(lang.getText("goWhere"));
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.currentRoom.getExit(direction);
        

        if (nextRoom == null) {
            System.out.println(lang.getText("cantGo"));
        } else {
            player.currentRoom = nextRoom;
            if (player.currentRoom.getOxygen() == false && player.currentsuit.getAitight() == false) 
            {
                System.out.println(lang.getText("death"));
                System.out.println(lang.getText("cause1"));
                System.exit(0);
            }
            player.roomHistory.add(player.currentRoom);
            System.out.println(getLongDescription());
        }
    }

    private void goback()
    {
        if (player.roomHistory.size() < 2 )
        {
            System.out.println(lang.getText("cantGoBack"));
            return;
        }
        else
        {
            Room previousRoom = player.roomHistory.get(player.roomHistory.size()-2);
            player.currentRoom = previousRoom;
            player.roomHistory.remove(player.roomHistory.size()-1);
            System.out.println(getLongDescription());
        }
    }

    // returns a long description with information about the rooms exits
    public String getLongDescription() {
        return lang.getText("iAmAt") + player.currentRoom.getShortDescription() + ".\n"
                + lang.getText("exit") + player.currentRoom.getExitString();
    }

    // checks if you want to quit the game and then quits the game
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println(lang.getText("quitWhat"));
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
