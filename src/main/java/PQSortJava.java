import java.util.Comparator;
import java.util.PriorityQueue;

public class PQSortJava {

    public static <K> void PQSortJava(K[] S, Comparator<K> comp) {
        int n = S.length;
        // Define the PQ to store the input array
        PriorityQueue<K> pq = new PriorityQueue<>(comp);

        // TODO: put in code with pq.add and pq.poll

    }

    public static void main(String[] args) {
        Integer[] testArray = {5, 1, 3, 2, 4};
        PQSortJava.PQSortJava(testArray, Comparator.naturalOrder());
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i]);
        }
    }

}
