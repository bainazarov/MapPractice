

public class TestOfMap {
    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyHashTable<>(10);

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3,"Three");

        if (map.get(1) == "One") {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        map.put(4,"Four");
        if (map.get(4) == "Four") {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        map.remove(4);
        if (map.get(4) != "Four") {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
