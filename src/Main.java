import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*
        double random = Math.random(); // Math.random() retourne un nombre entre 0 et 1 (double)
        int MAX = 6, MIN = 1;
        int result = (int)Math.floor(random*(MAX-MIN+1)+MIN);
        System.out.println(result);
        */

        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice(6);
            dices.add(dice);
        }
        int[] rollResults = new int[5];

        for (int i = 0; i < dices.size(); i++) {
            int result = dices.get(i).roll();
            rollResults[i] = result;
            //System.out.print(result + "|");
        }
        System.out.println();
        List<Integer> lockedIndexes = lockDices(rollResults);
    }

    public static List<Integer> lockDices(int[] rollResults) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> lockedIndexes = new HashSet<>(); // Les Set évitent les doublons contrairement aux List
        printLockStatus(rollResults, new ArrayList<>(lockedIndexes)); // Converti lockedIndexes en List
        System.out.println("Please enter the position of the dice(s) you want to lock separated with comas : ");
        String pattern = "^[1-5( *),( *)]*[1-5]$";
        boolean matches;
        String input;

        do {
            input = scanner.nextLine();
            matches = Pattern.matches(pattern, input);
            if (!matches) {
                System.out.println("Please enter a valid choice.");
            }
        } while (!matches);

        String[] splitInput = input.split("( *),( *)");
        for (String index : splitInput) {
            lockedIndexes.add(
                    Integer.parseInt(index)-1
            );
        }
        printLockStatus(rollResults, new ArrayList<>(lockedIndexes));
        return new ArrayList<>(lockedIndexes);
    }

    private static void printLockStatus(int[] rollResults, List<Integer> lockedIndexes) {
        printTableLineSeparator();
        System.out.print("|Value    | ");

        for (int i = 0; i < rollResults.length; i++) {
            System.out.print(rollResults[i] + " | ");
        }

        System.out.println();
        printTableLineSeparator();
        System.out.print("|Position | ");

        for (int i = 0; i < rollResults.length; i++) {
            System.out.print((i + 1) + " | ");
        }
        System.out.println();
        printTableLineSeparator();
        System.out.print("|Locked   |");

        for (int i = 0; i < rollResults.length; i++) {
            if (lockedIndexes.contains(i)) {
                System.out.print("Yes|");
            } else {
                System.out.print("No |");
            }
        }
        System.out.println();
        printTableLineSeparator();

    }

    private static void printTableLineSeparator() {
        System.out.println("|*****************************|");
    }
}

