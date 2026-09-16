import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.PriorityQueue;

class PriorityQueueTest {

    // Part 1
    @Test
    void test1() {
        PQJavaTestV1 ourPQTest = new PQJavaTestV1();
        PriorityQueue pq = ourPQTest.pq;
        String outputString = Arrays.toString(pq.toArray());
        Assertions.assertEquals(outputString, "[Key: 9, Value: C]");
    }

    // Part 2
    @Test
    void test2() {
        PQJavaTestV2 ourPQTest = new PQJavaTestV2();
        LoggingPriorityQueue pq = ourPQTest.pq;
        String outputString = pq.getLog();
        // Remove trailing return
        if (outputString.endsWith("\n")) {
            outputString = outputString.substring(0, outputString.length() - 1);
        }
        String expectedOutput = "Adding: Key: 5, Value: A\n" +
                "Adding: Key: 9, Value: C\n" +
                "Adding: Key: 3, Value: B\n" +
                "Peeking: Key: 3, Value: B\n" +
                "Polling (Now Serving): Key: 3, Value: B\n" +
                "Adding: Key: 7, Value: D\n" +
                "Polling (Now Serving): Key: 5, Value: A\n" +
                "Polling (Now Serving): Key: 7, Value: D";
        Assertions.assertEquals(expectedOutput, outputString);
    }

    @Test
    void testPQSortJava_IntegersNaturalOrder() {
        Integer[] testArray = {5, 1, 3, 2, 4};
        Integer[] expectedArray = {1, 2, 3, 4, 5};
        PQSortJava.PQSortJava(testArray, java.util.Comparator.naturalOrder());
        Assertions.assertArrayEquals(expectedArray, testArray);
    }

    @Test
    void testPQSortJava_IntegersReverseOrder() {
        Integer[] testArray = {5, 1, 3, 2, 4};
        Integer[] expectedArray = {5, 4, 3, 2, 1};
        PQSortJava.PQSortJava(testArray, java.util.Comparator.reverseOrder());
        Assertions.assertArrayEquals(expectedArray, testArray);
    }

    @Test
    void testPQSortJava_StringsNaturalOrder() {
        String[] testArray = {"banana", "apple", "cherry"};
        String[] expectedArray = {"apple", "banana", "cherry"};
        PQSortJava.PQSortJava(testArray, java.util.Comparator.naturalOrder());
        Assertions.assertArrayEquals(expectedArray, testArray);
    }

    @Test
    void testPQSortJavaTimingTest_RunCompletes() {
        File file = new File("src/main/java/PQSortJavaTimingTest.java");
        if (!file.exists()) {
            Assertions.fail("PQSortJavaTimingTest.java not found, so this test could not be run.");
            return;
        }

        // Redirect System.out to capture output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // Set system property to trigger small test run
        System.setProperty("is.student.test.run", "true");

        try {
            // Call the timing test run method using reflection
            try {
                Class<?> pqTimingTestClass = Class.forName("PQSortJavaTimingTest");
                Method timingTestRunMethod = pqTimingTestClass.getMethod("TimingTestRun", int.class, int.class, int.class);
                timingTestRunMethod.invoke(null, 100, 200, 10);

                // Assert that output was produced
                String output = bos.toString();
                Assertions.assertFalse(output.isEmpty(), "Output should not be empty");
                Assertions.assertTrue(output.contains("Time in seconds is:"), "Output should contain timing information");
                Assertions.assertTrue(output.contains("Running PQSortJava..."), "Output should indicate PQSortJava is running");

            } catch (Exception e) {
                Assertions.fail("Failed to run PQSortJavaTimingTest using reflection. Error: " + e.getMessage());
            }

        } finally {
            // Restore original System.out and clear system property
            System.setOut(originalOut);
            System.clearProperty("is.student.test.run");
        }
    }
}
