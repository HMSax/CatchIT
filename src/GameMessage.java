/*
Här har jag samlat alla meddelanden som spelet skriver ut vid olika händelser.
Detta för att göra koden mer lättöverskådlig och snabbare kunna hitta och redigera meddelanden,
 */
public class GameMessage {
    static void welcome() {
        System.out.println("Welcome to Catch IT! You are Hunter X.");
    }

    static void howTo() {
        System.out.println("Write A,S,D or W (and press enter) to move the HX left(A),right(D),up(W) or down(S)");
        System.out.println("and try to catch IT. WARNING: Don't let it catch you! You move before IT moves.");
    }

    static void tryAgain() {
        System.out.println("Try again! Use A,S,D or W.");
    }

    static void moveOutsideBoard() {
        System.out.println("You are trying to move outside the board or didn't write A,S,D or W. Try again!");
    }

    static void winner() {
        System.out.println("You caught IT! Yay!");
    }

    static void loser() {
        System.out.println("It caught YOU! Oh no!");
    }

    static void playAgain() {
        System.out.println("Play again? (Yes/No)");
    }

    static void goodbye() {
        System.out.println("Goodbye!");
    }
}
