public class SelectionSort {
    public static void sort(String[] input, int start) {
        if (start == input.length - 1) {
            return;
        }
        swap(input, start, findSmallest(input, start));
        sort(input, start + 1);
    }

    public static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static int findSmallest(String[] input, int start) {
        int smallest = start;
        for (int i = start; i < input.length; i++) {
            int cmp = input[i].compareTo(input[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }
}
