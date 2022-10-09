import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String ALICE = "Alice";
    private static final String GRACE = "Grace";
    private static final String OSCAR = "Oscar";
    private static final String CAROL = "Carol";
    private static final String TRUDY = "Trudy";
    private static final String EVE = "Eve";
    private static final String BOB = "Bob";
    private static final String FRANK = "Frank";
    private static final String PEGGY = "Peggy";
    private static final String VICTOR = "Victor";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testOne(); // broadcastsTo
        testTwo(); // canReach #1
        testThree(); // canReach #2
        testFour(); // canReach #3
        testFive(); // receiversOf
        testSix(); //broadcastsTo
        testSeven(); //canReach #4
        testEight(); //receiversOf
        testNine(); //broadcastsTo
        testTen(); // receiversOf
    }

    private static void testOne() {
        int testNumber = 1;
        testBroadcastsToOrReceiversOf(testNumber, FRANK,
                Arrays.asList(EVE, PEGGY, VICTOR), true);
    }

    private static void testFive() {
        int testNumber = 5;
        testBroadcastsToOrReceiversOf(testNumber, ALICE,
                Arrays.asList(OSCAR, GRACE, CAROL, TRUDY), false);
    }

    private static void testTwo() {
        int testNumber = 2;
        testCanReach(testNumber, ALICE, CAROL, true);
    }

    private static void testThree() {
        int testNumber = 3;
        testCanReach(testNumber, CAROL, ALICE, false);
    }

    private static void testFour() {
        int testNumber = 4;
        testCanReach(testNumber, CAROL, CAROL, false);
    }
    private static void testSix() {
        int testNumber = 6;
        testBroadcastsToOrReceiversOf(testNumber, CAROL,
                Arrays.asList(TRUDY, GRACE, OSCAR), true);
    }
    private static void testSeven() {
        int testNumber = 7;
        testCanReach(testNumber, GRACE, ALICE, false);
    }
    private static void testEight() {
        int testNumber = 8;
        testBroadcastsToOrReceiversOf(testNumber, FRANK,
                Arrays.asList(PEGGY, EVE, OSCAR, ALICE, GRACE, CAROL, TRUDY, VICTOR, BOB), false);
    }
    private static void testNine() {
        int testNumber = 9;
        testBroadcastsToOrReceiversOf(testNumber, EVE,
                Arrays.asList(PEGGY, BOB), true);
    }
    private static void testTen() {
        int testNumber = 10;
        testBroadcastsToOrReceiversOf(testNumber, BOB,
                Arrays.asList(EVE, PEGGY, OSCAR, ALICE, GRACE,CAROL,TRUDY, VICTOR, FRANK), false);
    }

    private static Tweetter testSetup() {
        return new Tweetter();
    }

    private static void testBroadcastsToOrReceiversOf(
            int testNumber, String person, List<String> expectedResult,
            boolean broadcastsTo) {
        String testMessage = "(\"" + person + "\")`";
        if (broadcastsTo) {
            testMessage = "broadcastsTo" + testMessage;
        } else {
            testMessage = "receiversOf" + testMessage;
        }
        printTestStartFinish(testNumber, testMessage, true);

        Tweetter tweetter = testSetup();
        List<String> actualResult;
        if (broadcastsTo) {
            actualResult = tweetter.broadcastsTo(person);
        } else {
            actualResult = tweetter.receiversOf(person);
        }

        checkListEqualitySizeAndContents(actualResult, expectedResult);

        printTestStartFinish(testNumber, null, false);
    }

    private static void testCanReach(int testNumber, String source,
                                     String destination,
                                     boolean expectedResult) {
        String testMessage = "`canReach(\"" + source + "\", \"" + destination +
                "\")`";
        printTestStartFinish(testNumber, testMessage, true);

        Tweetter tweetter = testSetup();
        boolean actualResult = tweetter.canReach(source, destination);

        if (actualResult != expectedResult) {
            System.out.println("\tResult does not match expected result.\n\t" +
                    "\tExpected: " + expectedResult + ";\n\t\tReceived: " +
                    actualResult);
        } else {
            System.out.println("\tTest passed.");
        }

        printTestStartFinish(testNumber, null, false);
    }

    private static void printTestStartFinish(int number, String message,
                                             boolean start) {
        String outputMessage = "test-" + number;
        if (start) {
            outputMessage = "Starting " + outputMessage + ":\t" + message;
        } else {
            outputMessage = "Completed " + outputMessage + ".\n\n";
        }
        System.out.println(outputMessage);
    }



    private static boolean checkListEqualitySizeAndContents(
            List<String> actual, List<String> expected) {
        if (actual.size() > expected.size() ||
                actual.size() < expected.size()) {
            System.out.println("\tList is not expected size. Received a list " +
                    "of size " + actual.size() + ", but expected a list of " +
                    "size " + expected.size() + ".");
        } else if (!actual.containsAll(expected)){
            System.out.println("\tList does not contain all expected people. " +
                    "Received a list containing: ");
            for (String person : actual) {
                System.out.println("\t\t" + person);
            }
            System.out.println("\t...but expected to receive a list " +
                    "containing:");
            for (String person : expected) {
                System.out.println("\t\t" + person);
            }
        } else {
            System.out.println("\tTest passed.");
            return true;
        }
        return false;
    }
}
