import java.util.Arrays;
import java.util.PriorityQueue;

public class PQJavaTestV1 {
    PriorityQueue<KVStringPair> pq = new PriorityQueue<>();

    public PQJavaTestV1() {

        // //TODO: Part 1



    }

    public static void main(String[] args) {
        PQJavaTestV1 ourPQTest = new PQJavaTestV1();
        // Now print the final pq
        System.out.println("Final PQ is: " + Arrays.toString(ourPQTest.pq.toArray()));
    }
}
