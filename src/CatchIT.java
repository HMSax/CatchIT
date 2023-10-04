import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

//HUVUDPROGRAMMET - Körs med fördel i kommandotolken/command prompt för att clearScreen-metoden ska fungera.
public class CatchIT {
    public static void main(String[] args) throws InputMismatchException, IOException, InterruptedException {
        String playAgain;
        do {
            GameBoard gameBoard = new GameBoard();                                          //Sätter upp spelplanen
            gameBoard.setMarkerX(4, 0, MarkerX.markerX);
            gameBoard.setTargetIT(4, 9, TargetIT.targetIT);
            BufferedReader controller = new BufferedReader(new InputStreamReader(System.in));
            clearScreen();
            GameMessage.welcome();
            TimeUnit.SECONDS.sleep(3);
            boolean keepPlaying = true;
            while (keepPlaying) {
                clearScreen();
                GameMessage.howTo();
                System.out.println(gameBoard);
                String aSDW = controller.readLine().toLowerCase().trim();
                boolean correctController = true;
                while (correctController) {
                    if (aSDW.equals("a") || aSDW.equals("s") || aSDW.equals("d") || aSDW.equals("w")) {
                        gameBoard.moveMarker(aSDW);
                        clearScreen();
                        correctController = false;
                    } else {
                        GameMessage.tryAgain();
                        aSDW = controller.readLine().toLowerCase().trim();
                    }
                }
                if (gameBoard.locationOfMarkerX().equals(gameBoard.getTargetLocation())) {
                    clearScreen();
                    System.out.println("\n");
                    System.out.println(gameBoard);
                    GameMessage.winner();
                    keepPlaying = false;
                } else {
                    gameBoard.moveTarget();
                }
                if (gameBoard.locationOfTarget().equals(gameBoard.getMarkerLocation())) {
                    clearScreen();
                    System.out.println("\n");
                    System.out.println(gameBoard);
                    GameMessage.loser();
                    keepPlaying = false;
                }
            }
            GameMessage.playAgain();
            playAgain = controller.readLine().toLowerCase().trim();
        } while (playAgain.equals("yes"));
        GameMessage.goodbye();
    }

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
