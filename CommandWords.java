import java.util.HashMap;

/**
 * this is the game class
 * this contains the entire game
 *
 * @author Douwe Klip
 * @version 08/01/2020
 */

public class CommandWords
{
     /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     * if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        HashMap<String, CommandWord> validCommands = LanguagePacks.getVallidCommands();
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        HashMap<String, CommandWord> validCommands = LanguagePacks.getVallidCommands();
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        HashMap<String, CommandWord> validCommands = LanguagePacks.getVallidCommands();
        for(String command : validCommands.keySet()) {
            System.out.print(command + ",  ");
        }
        System.out.println();
    }
}
