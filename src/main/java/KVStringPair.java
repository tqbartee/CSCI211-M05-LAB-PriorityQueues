public class KVStringPair implements Comparable<KVStringPair> {
    private Integer key;
    private String value;

    public KVStringPair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() { return key; }
    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    @Override
    public int compareTo(KVStringPair other) {
        return Integer.compare(this.key, other.getKey());
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + value;
    }
}
