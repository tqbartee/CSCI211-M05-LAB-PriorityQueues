import java.util.Arrays;
import java.util.PriorityQueue;

public class PQJavaTestV2 {
    LoggingPriorityQueue<KVStringPair> pq = new LoggingPriorityQueue<>();

    public PQJavaTestV2() {

        // //TODO: Part 2


    }

    public static void main(String[] args) {
        PQJavaTestV2 ourPQTest = new PQJavaTestV2();
        // Now print the final pq
        System.out.println("Final PQ is: " + Arrays.toString(ourPQTest.pq.toArray()));
        System.out.println("Log of activity is: \n" + ourPQTest.pq.getLog().toString());
    }
}
