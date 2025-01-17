import java.util.Scanner;

/**
 * this is the game class this contains the entire game
 *
 * @author Douwe Klip
 * @version 1.0
 */
public class Parser {
    private CommandWords commands; // holds all valid command words
    private Scanner reader; // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine; // will hold the full input line
        String word1 = null;
        String word2 = null;
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.print("> "); // print prompt
        inputLine = reader.nextLine();
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next(); // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next(); // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Print out a list of valid command words.
     */
    public void showCommands() {
        commands.showAll();
    }
}
