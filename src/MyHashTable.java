public class MyHashTable <K, V> implements MyMap<K, V> {
    private final int DEFAULT_CAPACITY = 10;
    private Node<K, V>[] values;
    private int initialCapacity;

    public MyHashTable(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.values = new Node[initialCapacity];
    }
    public MyHashTable() {
        this.initialCapacity = DEFAULT_CAPACITY;
        this.values = new Node[DEFAULT_CAPACITY];
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        int hashcode;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getValueIndex(K key) {
        return Math.abs(hashCode() % initialCapacity);
    }

    @Override
    public void put(K key, V value) {
        int valueIndex = getValueIndex(key);
        Node<K, V> newNode = new Node<>(key, value, null);
        if (values[valueIndex] == null) {
            values[valueIndex] = newNode;
        } else {
            Node<K, V> currentNode = values[valueIndex];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
            }
        }
    }

    @Override
    public V get(K key) {
        int valueIndex = getValueIndex(key);
        Node<K, V> currentNode = values[valueIndex];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }return null;
    }

    @Override
    public V remove(K key) {
        int valueIndex = getValueIndex(key);
        Node<K, V> currentNode = values[valueIndex];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V removedValue = currentNode.value;
                if (previousNode == null) {
                    values[valueIndex] = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                } return removedValue;
            } previousNode = currentNode;
            currentNode = currentNode.next;
        } return null;
    }
}
