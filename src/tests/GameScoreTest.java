public class GameScoreTest extends UnitTestHarness {
    
    public static void main(String[] args) {

        // Setup UnitTestHarness
        GameScoreTest testController = new GameScoreTest();
        boolean showTestOutput = true;
        if ((args.length != 0) && (args[0].equals("hide")))
            showTestOutput = false;
        String testName;
        boolean testResult;

        // Setup global testing variables
        // Local variables defined in each testing block
        

        // Test 1
        {
            // Local UnitTest setup
            testName = "Test 1";
            testResult = false;
            if (!showTestOutput)
                testController.hideConsoleOut();

            String team1, team2;
            team1 = "Toronto";
            team2 = "New York";
            GameScore testGame = new GameScore(team1, team2);

            // Execute the test
            testGame.addPoint(team1);
            testGame.addPoint(team1);

            // Show test details, if run from build this will be hidden
            int team1Expected = 2;
            int team1Actual = testGame.getScoreByTeam(team1);
            System.out.println("\tExpect: " + team1Expected);
            System.out.println("\tActual: " + team1Actual);
            testResult = team1Expected == team1Actual;

            // evaluate test
            testController.evaluateTest(testResult, testName, showTestOutput);

        } // end test

        // Test 2
        {
            // Local UnitTest setup
            testName = "Test 2";
            testResult = false;
            if (!showTestOutput)
                testController.hideConsoleOut();

            String team1, team2;
            team1 = "Toronto";
            team2 = "New York";
            GameScore testGame = new GameScore(team1, team2);

            // Execute the test
            testGame.addPoint(team1);
            testGame.addPoint(team1);
            testGame.addPoint(team2);

            // Show test details, if run from build this will be hidden
            String scoreExpected = "Toronto - 2 vs New York - 1";
            String scoreActual = testGame.getScore();
            System.out.println("\tExpect: " + scoreExpected);
            System.out.println("\tActual: " + scoreActual);
            testResult = scoreExpected.equals(scoreActual);

            // evaluate test
            testController.evaluateTest(testResult, testName, showTestOutput);

        } // end test

        // Print final test results
        testController.printTestResults(testController.getClass().getSimpleName());

    } // end main

} // end class