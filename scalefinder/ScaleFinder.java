package scalefinder;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code ScaleFinder} program allows users to determine musical scales based on the number of sharps or flats.
 * Users provide an integer input (-7 to 7) representing the number of accidentals in a key signature.
 * The program then returns the corresponding major and minor scales along with their accidentals.
 * <p>
 * Supports:
 * <ul>
 *     <li>Major and minor scale lookup</li>
 *     <li>Handling invalid user input</li>
 *     <li>Displaying the correct order of sharps or flats</li>
 * </ul>
 *
 * @author Evangelos Theodorakis
 * @version 1.0
 */
public class ScaleFinder {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, String[]> scaleMap = new HashMap<>();

        scaleMap.put(0, new String[]{"C Major", "A Minor"});
        scaleMap.put(1, new String[]{"G Major", "E Minor"});
        scaleMap.put(2, new String[]{"D major", "B minor"});
        scaleMap.put(3, new String[]{"A major", "F♯ minor"});
        scaleMap.put(4, new String[]{"E major", "C♯ minor"});
        scaleMap.put(5, new String[]{"B major", "G♯ minor"});
        scaleMap.put(6, new String[]{"F♯ major", "D♯ minor"});
        scaleMap.put(7, new String[]{"C♯ major", "A♯ minor"});
        scaleMap.put(-1, new String[]{"F major", "E Minor"});
        scaleMap.put(-2, new String[]{"B♭ major", "G minor"});
        scaleMap.put(-3, new String[]{"E♭ major", "C Minor"});
        scaleMap.put(-4, new String[]{"A♭ major", "F Minor"});
        scaleMap.put(-5, new String[]{"D♭ major", "B♭ minor"});
        scaleMap.put(-6, new String[]{"G♭ major", "E♭ minor"});
        scaleMap.put(-7, new String[]{"C♭ major", "A♭ minor"});

        System.out.println("Please provide the number of sharps/flats to find the corresponding scale");
        System.out.println();
        System.out.println("Give a positive integer for  sharps, or a negative for flats");
        System.out.println("(eg. '3' returns the scales with 3 sharps, while '-6' returns the scales with 6 flats)");
        System.out.println();
        System.out.println("How many flats or sharps would you like the scale to have?");

        int accidentals = getUserInput();

        String[] scales = scaleMap.get(accidentals);
        if (scales != null) {
            if (accidentals == 0) {
                System.out.println("Scales with no accidentals" + scales[0] + " or " + scales[1]);
                System.out.println("It contains no sharps or flats, just like playing only the white piano keys!");
            } else if (accidentals >= 1) {
                System.out.println("Scales with " + accidentals + " sharp(s): " + scales[0] + " or " + scales[1]);
                System.out.println("These sharps are:");
                getAccidentalOrder(accidentals);
            } else {
                System.out.println("Scales with " + -accidentals + " flat(s): " + scales[0] + " or " + scales[1]);
                System.out.println("These flats are:");
                getAccidentalOrder(accidentals);
            }

        } else {
            System.out.println("No scales found for " + accidentals);
        }
    }

    public static int getUserInput() {
        int userInteger = 0;
        while (true) {
            try {
                userInteger = sc.nextInt();
                if (userInteger > 7 || userInteger < -7) {
                    System.out.println("Please provide a number between -7 and 7");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number between -7 and 7");
                sc.next();
                continue;
            }
            return userInteger;
        }
    }

    public static void getAccidentalOrder(int accidentals) {
        String[] sharpsOrder = {"F♯", "C♯", "G♯", "D♯", "A♯", "E♯", "B♯"};
        String[] flatsOrder = {"B♭", "E♭", "A♭", "D♭", "G♭", "C♭", "F♭"};

        if (accidentals > 0) {
            for (int i = 0; i <= accidentals - 1; i++) {
                System.out.print(sharpsOrder[i] + " ");
            }
        } else {
            for (int i = 0; i <= -accidentals - 1; i++) {
                System.out.print(flatsOrder[i] + " ");
            }
        }
    }
}
