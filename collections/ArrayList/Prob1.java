
import java.util.Arrays;

class Prob1 {

    public <T> void swap(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            T tmp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = tmp;
        }
    }

    public <T extends Comparable<T>> void recordOccurences(T[] arr) {
        Arrays.sort(arr);

        int maxCount = 1;
        int minCount = Integer.MAX_VALUE;

        T maxElement = arr[0];
        T minElement = arr[0];

        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxElement = arr[i - 1];
                }

                if (count < minCount) {
                    minCount = count;
                    minElement = arr[i - 1];
                }

                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            maxElement = arr[arr.length - 1];
        }

        if (count < minCount) {
            minCount = count;
            minElement = arr[arr.length - 1];
        }

        System.out.println("Max occurred: " + maxElement + " -> " + maxCount);
        System.out.println("Min occurred: " + minElement + " -> " + minCount);
    }

    public static void main(String[] args) {
        Prob1 h = new Prob1();

        Integer[] nums = {1, 2, 2, 3, 1, 1, 4};
        h.recordOccurences(nums);

        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        h.recordOccurences(words);

        Character[] chars = {'a', 'b', 'a', 'c', 'b', 'a'};
        h.recordOccurences(chars);

        System.out.println("\nBefore swap: " + Arrays.toString(nums));
        h.swap(nums);
        System.out.println("After swap: " + Arrays.toString(nums));
    }
}