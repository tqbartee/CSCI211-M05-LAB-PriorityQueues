import java.util.PriorityQueue;

public class LoggingPriorityQueue<E> extends PriorityQueue<E> {
    // Since we are creating a LoggingPriorityQueue object
    // that will persist for the entirety of its use
    // we can have a StringBuilder component that
    // maintain a human-readable "log" of prior operations
    private StringBuilder logBuilder = new StringBuilder();

    @Override
    public boolean add(E e) {
        logBuilder.append("Adding: ").append(e).append("\n");
        return super.add(e);
    }

    @Override
    public E poll() {
        E result = super.poll();
        logBuilder.append("Polling (Now Serving): ").append(result).append("\n");
        return result;
    }

    @Override
    public E peek() {
        E result = super.peek();
        logBuilder.append("Peeking: ").append(result).append("\n");
        return result;
    }

    public String getLog() {
        return logBuilder.toString();
    }
}
