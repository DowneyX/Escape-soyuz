import java.util.Scanner;

//this clas is responsible for initializing the entire game

public class Game 
{
    private Parser parser;
    private Player player;
    private LanguagePacks languagePack;
    Room descendModule, orbitalModule, outsideOrbitalModule, outsideDescendModuleWest, outsideDescendModuleEast,
            serviceModuleWest, serviceModuleEast;
    Scanner reader = new Scanner(System.in);

    // initialises the players the parser and languagepack
    public Game() {
        parser = new Parser();
        player = new Player();
        languagePack = new LanguagePacks();
    }

    // creates all the rooms and item and links the exits together and sets items to
    // the right location
    private void createRooms() {

        // create the rooms
        descendModule = new Room(languagePack.getText("descendModule"),true);
        orbitalModule = new Room(languagePack.getText("orbitalModule"),true);
        outsideOrbitalModule = new Room(languagePack.getText("outsideOrbitalModule"),false);
        outsideDescendModuleWest = new Room(languagePack.getText("outsideDescendModuleWest"),false);
        outsideDescendModuleEast = new Room(languagePack.getText("outsideDescendModuleEast"),false);
        serviceModuleWest = new Room(languagePack.getText("serviceModuleWest"),false);
        serviceModuleEast = new Room(languagePack.getText("serviceModuleEast"),false);

        // initialise room exits
        descendModule.setExit(languagePack.getText("north"), orbitalModule);
        orbitalModule.setExit(languagePack.getText("north"), outsideOrbitalModule);
        orbitalModule.setExit(languagePack.getText("south"), descendModule);
        outsideOrbitalModule.setExit(languagePack.getText("south"), orbitalModule);
        outsideOrbitalModule.setExit(languagePack.getText("south-west"), outsideDescendModuleWest);
        outsideOrbitalModule.setExit(languagePack.getText("south-east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(languagePack.getText("north-east"), outsideOrbitalModule);
        outsideDescendModuleWest.setExit(languagePack.getText("east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(languagePack.getText("south"), serviceModuleWest);
        outsideDescendModuleEast.setExit(languagePack.getText("north-west"), outsideOrbitalModule);
        outsideDescendModuleEast.setExit(languagePack.getText("west"), outsideDescendModuleWest);
        outsideDescendModuleEast.setExit(languagePack.getText("south"), serviceModuleEast);
        serviceModuleWest.setExit(languagePack.getText("north"), outsideDescendModuleWest);
        serviceModuleWest.setExit(languagePack.getText("east"), serviceModuleEast);
        serviceModuleEast.setExit(languagePack.getText("north"), outsideDescendModuleEast);
        serviceModuleEast.setExit(languagePack.getText("west"), serviceModuleWest);

        // variables of all the items
        Item welder = new Item(languagePack.getText("welder"), 3);
        Item weldingrods = new Item(languagePack.getText("weldingrods"), 1);
        Item tape = new Item(languagePack.getText("tape"), 1);
        Item screwdriver = new Item(languagePack.getText("screwdriver"), 2);
        Item cables = new Item(languagePack.getText("cables"), 2);
        Item solarpanel = new Item(languagePack.getText("solarpanel"), 6);

        // creates items with their location
        descendModule.setItem(welder);
        descendModule.setItem(weldingrods);
        orbitalModule.setItem(tape);
        descendModule.setItem(screwdriver);
        outsideDescendModuleWest.setItem(cables);
        serviceModuleEast.setItem(solarpanel);

        // creates reapairable objects
        descendModule.setRepairable(new RepairableObject(languagePack.getText("leak"), weldingrods, welder));
        descendModule.setRepairable(new RepairableObject(languagePack.getText("navigation-computer"), cables, screwdriver));
        serviceModuleEast.setRepairable(new RepairableObject((languagePack.getText("solarpanel")), solarpanel, screwdriver));

        // start game inside decent module
        player.currentsuit = new Suit(languagePack.getText("broken-suit"),false);
        player.currentsuit.setMaterial(tape);
        player.currentRoom = descendModule;
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
        System.out.println(languagePack.getText("iam")+playerHere);
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
        System.out.println(languagePack.getText("quitgame"));
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
        System.out.println(languagePack.getText("TEST"));
        System.out.println();
        System.out.println(languagePack.getText("welcome1"));
        System.out.println(languagePack.getText("welcome2"));
        System.out.println(languagePack.getText("welcome3"));
        System.out.println(languagePack.getText("welcome4"));
        System.out.println(languagePack.getText("welcome5"));
        System.out.println(languagePack.getText("welcome6"));
        System.out.println(languagePack.getText("welcome7"));
        System.out.println();
        System.out.println(getLongDescription());
    }

    // prosseses a given command
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
        case UNKNOWN:
            System.out.println(languagePack.getText("unknowncomand"));
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

        case REAPAIR:
            repair(command);
            break;

        }
        return wantToQuit;
    }

    public void repair(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to rapiar
            System.out.println(languagePack.getText("repairwhat"));
            return;
        }

        String secondword = command.getSecondWord();
        Suit suit = player.currentsuit;
        RepairableObject repairableObject = player.currentRoom.getRepairableObject(secondword);

        if (suit.getDescription().equals(secondword))
        {
            Item material = player.currentsuit.getMaterial();

            if (player.currentsuit.getAitight() == true)
            {
                System.out.println(languagePack.getText("nomaterial"));
                return;
            }
            else if (player.getItem(material.getDescription()) == null) 
            {
                System.out.println(languagePack.getText("nomaterial"));
                return;
            }
            else
            {
                player.currentsuit = new Suit(languagePack.getText("repaired-suit"), true);
                System.out.println(languagePack.getText("irepair") + secondword);
                return;
            }
        }

        if (repairableObject != null) 
        {
            Item material = repairableObject.getMaterial();

            if (player.getItem(material.getDescription()) == null) {
                System.out.println(languagePack.getText("nomaterial"));
                return;
            }

            Item tool = repairableObject.getTool();

            if (player.getItem(tool.getDescription()) == null) {
                System.out.println(languagePack.getText("notool"));
                return;
            } else 
            {
                player.removeItem(material.getDescription());
                player.currentRoom.removeRepairableObject(secondword);
                System.out.println(languagePack.getText("irepair") + secondword);
                return;
            }
        }
        System.out.println(languagePack.getText("cantfind"));
            return;
    }

    // prints all the items that are in the players inventory
    private void printInventory() {
        String output = "";
        for (String key : player.inventory.keySet()) {
            output += player.inventory.get(key).getDescription() + ", ";
        }
        System.out.println(languagePack.getText("icarry"));
        System.out.println(output);
    }

    // gives a help message with all the commandwords
    private void printHelp() {
        System.out.println(languagePack.getText("help1"));
        System.out.println(languagePack.getText("help2"));
        System.out.println(languagePack.getText("help3"));
        System.out.println();
        System.out.println(languagePack.getText("help4"));
        parser.showCommands();
    }

    // drops a given item
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop.
            System.out.println(languagePack.getText("dropwhat"));
            return;
        }

        String item = command.getSecondWord();
        Item newitem = player.getItem(item);

        // try to drop item
        if (newitem == null) {
            System.out.println(languagePack.getText("cantfind"));
        } else {
            player.removeItem(item);
            player.currentRoom.setItem(newitem);
            System.out.println( item + languagePack.getText("idrop"));
        }
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take.
            System.out.println(languagePack.getText("takewhat"));
            return;
        }

        // gets the item from the room.
        String item = command.getSecondWord();
        Item newitem = player.currentRoom.getItem(item);

        if (newitem == null) {
            System.out.println(languagePack.getText("cantfind"));
            return;
        }

        // calculates the volume of of the inventory + the volume of the item
        int totalVolume = newitem.getVolume() + player.getInventoryVolume();

        if (totalVolume > player.inventoryVolume) {
            System.out.println(languagePack.getText("nospace"));
        } else {
            player.inventory.put(item, newitem);
            player.currentRoom.removeItem(item);
            System.out.println( item + languagePack.getText("itake"));
        }
    }

    // goes to the room with the given direction
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(languagePack.getText("gowhere"));
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println(languagePack.getText("cantgo"));
        } else {
            player.currentRoom = nextRoom;
            if (player.currentRoom.getOxygen() == false && player.currentsuit.getAitight() == false) 
            {
                System.out.println(languagePack.getText("death"));
                System.out.println(languagePack.getText("cause1"));
                System.exit(0);
            }
            System.out.println(getLongDescription());
        }
    }

    // returns a long description with information about the rooms exits
    public String getLongDescription() {
        return languagePack.getText("iam") + player.currentRoom.getShortDescription() + ".\n"
                + languagePack.getText("exit") + player.currentRoom.getExitString();
    }

    // checks if you want to quit the game and then quits the game
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println(languagePack.getText("quitwhat"));
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
