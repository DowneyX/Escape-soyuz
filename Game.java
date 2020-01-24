import java.util.Scanner;

//this clas is responsible for initializing the entire game

public class Game {
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
        System.out.println(text("quitGame"));
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

    // initialises items objects and suits
    public void createRooms() {

        // create the rooms
        descendModule = new Room(text("descendModule"), true, text("descendModuleInspection"));
        orbitalModule = new Room(text("orbitalModule"), true, text("orbitalModuleInspection"));
        outsideOrbitalModule = new Room(text("outsideOrbitalModule"), false, text("outsideOrbitalModuleInspection"));
        outsideDescendModuleWest = new Room(text("outsideDescendModuleWest"), false,
                text("outsideDescendModuleWestInspection"));
        outsideDescendModuleEast = new Room(text("outsideDescendModuleEast"), false,
                text("outsideDescendModuleEastInspection"));
        serviceModuleWest = new Room(text("serviceModuleWest"), false, text("serviceModuleWestInspection"));
        serviceModuleEast = new Room(text("serviceModuleEast"), false, text("serviceModuleEastInspection"));

        // initialise room exits
        descendModule.setExit(text("north"), orbitalModule);
        orbitalModule.setExit(text("north"), outsideOrbitalModule);
        orbitalModule.setExit(text("south"), descendModule);
        outsideOrbitalModule.setExit(text("south"), orbitalModule);
        outsideOrbitalModule.setExit(text("south-west"), outsideDescendModuleWest);
        outsideOrbitalModule.setExit(text("south-east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(text("north-east"), outsideOrbitalModule);
        outsideDescendModuleWest.setExit(text("east"), outsideDescendModuleEast);
        outsideDescendModuleWest.setExit(text("south"), serviceModuleWest);
        outsideDescendModuleEast.setExit(text("north-west"), outsideOrbitalModule);
        outsideDescendModuleEast.setExit(text("west"), outsideDescendModuleWest);
        outsideDescendModuleEast.setExit(text("south"), serviceModuleEast);
        serviceModuleWest.setExit(text("north"), outsideDescendModuleWest);
        serviceModuleWest.setExit(text("east"), serviceModuleEast);
        serviceModuleEast.setExit(text("north"), outsideDescendModuleEast);
        serviceModuleEast.setExit(text("west"), serviceModuleWest);

        // variables of all the items
        Item welder = new Item(text("welder"), 3, text("welderInspection"));
        Item weldingElectrodes = new Item(text("weldingElectrodes"), 1, text("weldingElectrodesInspection"));
        Item tape = new Item(text("tape"), 1, text("tapeInspection"));
        Item screwdriver = new Item(text("screwdriver"), 2, text("screwdriverInspection"));
        Item cables = new Item(text("cables"), 2, text("cablesInspection"));
        Item solarpanel = new Item(text("solarpanel"), 4, text("solarpanelInspection"));

        // variables of all repairable objects
        RepairableObject leak = new RepairableObject(text("leak"), weldingElectrodes, welder, text("leakInspection"));
        RepairableObject brokenNavigationComputer = new RepairableObject(text("brokenNavigationComputer"), cables,
                screwdriver, text("brokenNavigationComputerInspection"));
        RepairableObject brokenSolarpanel = new RepairableObject((text("brokenSolarpanel")), solarpanel, screwdriver,
                text("brokenSolarplanelInspection"));

        // variables of objects
        Object yuri = new Object(text("yuri"), text("yuriInspection"));
        Object viktor = new Object(text("viktor"), text("viktorInspection"));
        Object repairedSolarpanel = new Object(text("repairedSolarpanel"), text("repairedSolarpanelInspection"));
        Object repairedNanvigationComputer = new Object(text("repairedNavigationComputer"),
                text("repairedNavigationComputerInspection"));

        // variables of suits
        Suit brokenSuit = new Suit(text("brokenSuit"), false, text("brokenSuitInspection"), 1);
        Suit victorSuit = new Suit(text("viktorSuit"), false, text("viktorSuitInspection"), 8);
        Suit yuriSuit = new Suit(text("yuriSuit"), false, text("yuriSuitInspection"), 8);

        // sets items to their location
        descendModule.setItem(welder);
        descendModule.setItem(weldingElectrodes);
        orbitalModule.setItem(tape);
        descendModule.setItem(screwdriver);
        outsideDescendModuleWest.setItem(cables);
        serviceModuleEast.setItem(solarpanel);

        // sets reapairable objects to their location
        descendModule.setRepairable(leak);
        descendModule.setRepairable(brokenNavigationComputer);
        serviceModuleEast.setRepairable(brokenSolarpanel);

        // set object to thier location
        descendModule.setObject(yuri);
        descendModule.setObject(viktor);

        // sets replaceable objects in repairable object
        brokenSolarpanel.setReplaceObject(repairedSolarpanel);
        brokenNavigationComputer.setReplaceObject(repairedNanvigationComputer);

        // start game inside decent module
        player.setCurrentSuit(brokenSuit);
        player.getCurrentSuit().setMaterial(tape);
        player.setCurrentRoom(descendModule);
        player.addRoomHistory();
    }

    // prosseses a given command
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
        case UNKNOWN:
            System.out.println(text("unknownCommand"));
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
        case USE:
            use(command);
            break;
        }
        return wantToQuit;
    }

    // prints a map of the game plus where the player is at that moment
    public void printMap() {
        String noPlayer = "     ";
        String playerHere = " <○> ";

        String dcm = noPlayer;
        String omm = noPlayer;
        String oom = noPlayer;
        String odw = noPlayer;
        String ode = noPlayer;
        String smw = noPlayer;
        String sme = noPlayer;

        if (player.getCurrentRoom() == descendModule) {
            dcm = playerHere;
        }
        if (player.getCurrentRoom() == orbitalModule) {
            omm = playerHere;
        }
        if (player.getCurrentRoom() == outsideOrbitalModule) {
            oom = playerHere;
        }
        if (player.getCurrentRoom() == outsideDescendModuleWest) {
            odw = playerHere;
        }
        if (player.getCurrentRoom() == outsideDescendModuleEast) {
            ode = playerHere;
        }
        if (player.getCurrentRoom() == serviceModuleWest) {
            smw = playerHere;
        }
        if (player.getCurrentRoom() == serviceModuleEast) {
            sme = playerHere;
        }
        System.out.println();
        System.out.println(text("iAmAt") + playerHere);
        System.out.println();
        System.out.println("                  " + oom + "          N");
        System.out.println("                  :-^-:        W ○ O ");
        System.out.println("                 /     \\         Z");
        System.out.println("                0 " + omm + " 0");
        System.out.println("                 \\     /");
        System.out.println("                  :-^-:");
        System.out.println("                 /     \\");
        System.out.println("          " + odw + " 0 " + dcm + " 0 " + ode);
        System.out.println("                |_______|");
        System.out.println(" ______________ :/_\\_/_\\: _______________");
        System.out.println("|=|=|=|=|=|=|:A-|':|||:'|-A:|=|=|=|=|=|=|");
        System.out.println("^\"\"\"\"\"\"\"\"\"\"\"\"\"\" !::{o}::! \"\"\"\"\"\"\"\"\"\"\"\"\"\"^");
        System.out.println("             " + smw + "   " + sme);
    }

    // prints a opening message for the player
    public void printWelcome() {
        System.out.println(text("TEST"));
        System.out.println();
        System.out.println(text("welcome"));
        System.out.println();
        System.out.println(text("oxygen") + "[" + player.getCurrentSuit().getSuitOxygen() + "]");
        System.out.println(text("iAmAt") + player.getCurrentRoom().getShortDescription());
        System.out.println(text("exit") + player.getCurrentRoom().getRoomExit());
    }

    // inspect
    public void inspect(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to inspect
            System.out.println(text("inspectWhat"));
            return;
        }

        String secondWord = command.getSecondWord();
        Room currentroom = player.getCurrentRoom();
        Suit currentSuit = player.getCurrentSuit();
        Item item = currentroom.getItem(secondWord);
        RepairableObject repairableObject = currentroom.getRepairableObject(secondWord);
        Object object = currentroom.getObject(secondWord);

        if (secondWord.equals(currentroom.getShortDescription())) {
            System.out.println(text("iAmAt") + currentroom.getShortDescription());
            System.out.println(currentroom.getInpection());
            System.out.println(text("objects") + currentroom.getRoomObjects());
            System.out.println(text("items") + currentroom.getRoomItems());
            System.out.println(text("repairables") + currentroom.getRoomRepairableObjects());
            System.out.println(text("oxygen") + currentroom.getOxygen());

            return;
        }
        if (object != null) {
            System.out.println(object.getInspection());
            return;
        }
        if (repairableObject != null) {
            System.out.println(repairableObject.getInspection());
            return;
        }
        if (item != null) {
            System.out.println(item.getInspection());
            System.out.println(text("space") + "[" + item.getVolume() + "]");
            return;
        }
        if (secondWord.equals(text("myself"))) {
            System.out.println(text("myselfInspection"));
            return;
        }
        if (secondWord.equals(currentSuit.getDescription())) {
            System.out.println(currentSuit.getInspection());
            return;
        } else {
            System.out.println(text("cantFind"));
        }
    }

    // uses speific objects
    public void use(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to use
            System.out.println(text("useWhat"));
            return;
        }

        String secondWord = command.getSecondWord();
        Object object = player.getCurrentRoom().getObject(secondWord);

        if (object == null) {
            System.out.println(text("cantFind"));
            return;
        }
        if (object.getDescription().equals(text("repairedNavigationComputer"))
                && serviceModuleEast.getObject(text("repairedSolarpanel")) == null) {
            System.out.println(text("noElectricity"));
            return;
        }
        if (object.getDescription().equals(text("repairedNavigationComputer"))
                && serviceModuleEast.getObject(text("repairedSolarpanel")) != null
                && descendModule.getRepairableObject(text("leak")) == null) {
            System.out.println(text("youWin"));
            System.out.println("quitGame");
            System.exit(0);
            return;
        }
        if (object.getDescription().equals(text("repairedNavigationComputer"))
                && serviceModuleEast.getObject(text("repairedSolarpanel")) != null) {
            System.out.println(text("deathCause3"));
            System.exit(0);
            return;
        }

    }

    // repairs repairables
    public void repair(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to rapiar
            System.out.println(text("repairWhat"));
            return;
        }

        String secondWord = command.getSecondWord();
        Suit suit = player.getCurrentSuit();
        RepairableObject repairableObject = player.getCurrentRoom().getRepairableObject(secondWord);

        if (suit.getDescription().equals(secondWord)) {
            Item material = player.getCurrentSuit().getMaterial();

            if (player.getCurrentSuit().getAitight() == true) {
                System.out.println(text("notBroken"));
                return;
            } else if (player.getItem(material.getDescription()) == null) {
                System.out.println(text("noMaterial"));
                return;
            } else {
                player.removeItem(player.getCurrentSuit().getMaterial().getDescription());
                player.setCurrentSuit(new Suit(text("repairedSuit"), true, text("repairedSuitInspection"), 7));
                System.out.println(secondWord + text("iRepair"));
                return;
            }
        }

        if (repairableObject != null) {
            Item material = repairableObject.getMaterial();
            Item tool = repairableObject.getTool();
            Object replaceObject = repairableObject.getReplaceObject();

            if (player.getItem(material.getDescription()) == null) {
                System.out.println(text("noMaterial"));
                return;
            }
            if (player.getItem(tool.getDescription()) == null) {
                System.out.println(text("noTool"));
                return;
            } else {
                if (replaceObject != null) {
                    player.getCurrentRoom().setObject(replaceObject);
                }
                player.removeItem(material.getDescription());
                player.getCurrentRoom().removeRepairableObject(secondWord);
                System.out.println(secondWord + text("iRepair"));
                return;
            }
        }
        System.out.println(text("cantFind"));
        return;
    }

    // prints all the items that are in the players inventory
    public void printInventory() {
        System.out.println(text("iWear") + player.getCurrentSuit().getDescription());
        System.out.println(text("iCarry"));
        System.out.println(player.GetInventoryItems());
        System.out.println(text("spaceLeft") + "[" + (player.getInventoryVolume() - player.getInventorySpace()) + "]");

    }

    // prints a help message with all the commandwords
    public void printHelp() {
        System.out.println(text("help1"));
        System.out.println(text("help2"));
        System.out.println(text("help3"));
        System.out.println();
        System.out.println(text("help4"));
        parser.showCommands();
    }

    // drops a given item
    public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop.
            System.out.println(text("dropWhat"));
            return;
        }

        String item = command.getSecondWord();
        Item newitem = player.getItem(item);

        // try to drop item
        if (newitem == null) {
            System.out.println(text("cantFind"));
        } else {
            player.removeItem(item);
            player.getCurrentRoom().setItem(newitem);
            System.out.println(item + text("iDrop"));
        }
    }

    // takes a given item
    public void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take.
            System.out.println(text("takeWhat"));
            return;
        }

        // gets the item from the room.
        String item = command.getSecondWord();
        Item newitem = player.getCurrentRoom().getItem(item);

        if (newitem == null) {
            System.out.println(text("cantFind"));
            return;
        }

        // calculates the volume of of the inventory + the volume of the item
        int totalVolume = newitem.getVolume() + player.getInventorySpace();

        if (totalVolume > player.getInventoryVolume()) {
            System.out.println(text("noSpace"));
        } else {
            player.putInInventory(newitem);
            player.getCurrentRoom().removeItem(item);
            System.out.println(item + text("iTake"));
        }
    }

    // player goes to the room with the given direction
    public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(text("goWhere"));
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println(text("cantGo"));
        } else {
            player.setCurrentRoom(nextRoom);
            if (!player.getCurrentRoom().getOxygen()) {
                player.getCurrentSuit().loweroxygen();
                ;
                if (!player.getCurrentSuit().getAitight()) {
                    System.out.println(text("deathCause1"));
                    System.exit(0);
                }
            }
            if (player.getCurrentRoom().getOxygen()) {
                player.getCurrentSuit().refilOxygen();
            }

            if (player.getCurrentSuit().getSuitOxygen() == 0) {
                System.out.println(text("deathCause2"));
                System.exit(0);
            }
            player.addRoomHistory();
            System.out.println(text("oxygen") + "[" + player.getCurrentSuit().getSuitOxygen() + "]");
            System.out.println(text("iAmAt") + player.getCurrentRoom().getShortDescription());
            System.out.println(text("exit") + player.getCurrentRoom().getRoomExit());
        }
    }

    // player goes back from where they came
    public void goback() {
        if (player.getRoomHistory().size() < 2) {
            System.out.println(text("cantGoBack"));
            return;
        } else {
            Room previousRoom = player.getRoomHistory().get(player.getRoomHistory().size() - 2);
            player.setCurrentRoom(previousRoom);
            if (!player.getCurrentRoom().getOxygen()) {
                player.getCurrentSuit().loweroxygen();
                ;
            }
            if (player.getCurrentRoom().getOxygen()) {
                player.getCurrentSuit().refilOxygen();
            }
            if (player.getCurrentSuit().getSuitOxygen() == 0) {
                System.out.println(text("deathCause2"));
                System.exit(0);
            }
            player.getRoomHistory().remove(player.getRoomHistory().size() - 1);
            System.out.println(text("oxygen") + "[" + player.getCurrentSuit().getSuitOxygen() + "]");
            System.out.println(text("iAmAt") + player.getCurrentRoom().getShortDescription());
            System.out.println(text("exit") + player.getCurrentRoom().getRoomExit());
        }
    }

    public String text(String text) {
        String output;
        output = lang.getText(text);
        return output;
    }

    // checks if you want to quit the game and then quits the game
    public boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println(text("quitWhat"));
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }
}
