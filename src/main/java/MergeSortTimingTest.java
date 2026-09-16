import edu.desu.testdatagenerator.TestArrayGenerator;
import edu.desu.timingevaluation.TimingEvaluation;

public class MergeSortTimingTest {

    // Default template
    // Steps for test run

    // 1 Ensure base method defined for test (likely a static method)

    // 2 Define code to build the data structures for the test
    // Usually from TestArrayGenerator

    // Next parts to be defined in method TimingTestRun
    // 3 Define test run parameters
    // Make these pass-in for the timing test
    public static void TimingTestRun(int n1, int n2, int timesToRun) {

        int inputArraySize1 = n1;
        int inputArraySize2 = n2;

        // 4 Build data structures to support the test
        int[] originalInputArray1, originalInputArray2;
        Integer[] thisIntegerArray1, thisIntegerArray2, testIntegerArray1, testIntegerArray2; // Store original for cloning

        System.out.println("Building main and test array...");
        originalInputArray1 = TestArrayGenerator.generateScrambledIntArray(inputArraySize1);
        thisIntegerArray1 = TestArrayGenerator.convertintArrayToInteger(originalInputArray1);

        // 5 Timestamp first run
        System.out.println("Running mergeSort...");
        long startTime = System.currentTimeMillis();

        // 6 Make first run
        for (int i = 0; i < timesToRun; i++) {
            testIntegerArray1 = thisIntegerArray1.clone();
            MergeSort.mergeSort(testIntegerArray1, new TestArrayGenerator.DefaultComparator());
        }

        // 7 Timestamp completion - calculate time
        double endTime = System.currentTimeMillis();
        double elapsed = endTime - startTime;
        String outputString = new String(Double.toString(elapsed));
        System.out.println(outputString);
        double elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);

        // 8. Make predictions for second run times - from Timing Evaluation
        TimingEvaluation ourTimingEvaluation = new TimingEvaluation();
        ourTimingEvaluation.setClassName(MergeSortTimingTest.class.getSimpleName());
        ourTimingEvaluation.generatePredictionValues(inputArraySize1,
                inputArraySize2, timesToRun, elapsedseconds);
        ourTimingEvaluation.printPredictionReport();

        // 9 Build data structures for second test
        System.out.println("Building main and test array...");
        originalInputArray2 = TestArrayGenerator.generateScrambledIntArray(inputArraySize2);
        thisIntegerArray2 = TestArrayGenerator.convertintArrayToInteger((int[]) originalInputArray2.clone());

        // 10 Timestamp second run start
        System.out.println("Running mergeSort...");
        startTime = System.currentTimeMillis();

        // 11 Make second run
        for (int i = 0; i < timesToRun; i++) {
            testIntegerArray2 = thisIntegerArray2.clone();
            MergeSort.mergeSort(testIntegerArray2, new TestArrayGenerator.DefaultComparator());
        }

        // 12 Timestamp completion - calculate time
        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;
        outputString = new String(Double.toString(elapsed));
        System.out.println(outputString);
        elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);

        // 13 Post-test analysis
        // Now call the post-test analysis to compare the
        // two times
        ourTimingEvaluation.generatePostTestValues(elapsedseconds);
        ourTimingEvaluation.printPostTestReport();
    }

    public static void main(String[] args) {
        System.out.println("Main called");
        int inputArraySize1;
        int inputArraySize2;
        int timesToRun;

        // When run by the verifier test, use small values for a quick smoke test.
        // Otherwise, use the original large values for a full benchmark.
        if ("true".equals(System.getProperty("is.student.test.run"))) {
            inputArraySize1 = 100;
            inputArraySize2 = 200;
            timesToRun = 10;
        } else {
            inputArraySize1 = 8388608;
            inputArraySize2 = 16777216;
            timesToRun = 1;
        }
        TimingTestRun(inputArraySize1, inputArraySize2, timesToRun);
    }

}
