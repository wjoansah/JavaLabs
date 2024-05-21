package searchandsort;

public class SearchAlgorithms {
    public static int binarySearch(Integer[] items, int searchItem) {
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (items[mid] == searchItem) {
                return mid; // Element found at index mid
            } else if (items[mid] < searchItem) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }

    public static <T> int linearSearch(T[] items, T searchItem) {

        for (int i = 0; i < items.length; ++i) {
            if (items[i].equals(searchItem)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = {10, 20, 30, 40, 50, 60};
        int target = 40;

        int result = linearSearch(array, target);
        int binarySearchResult = binarySearch(array, 60);

        if (result != -1) {
            System.out.println("Element found with linear search at index: " + result);
        } else {
            System.out.println("Element not found");
        }


        if (binarySearchResult != -1) {
            System.out.println("Element found with binary search at index: " + binarySearchResult);
        } else {
            System.out.println("Element not found");
        }
    }
}
