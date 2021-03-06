public class mergesort {
    //Hunter Browning-Smith
    //Assignment 6
    //IT2660

    public static void main(String[] args) {
        int length = 100; //want to sort an array of 100 values
        int[] actual = new int[length];
        randomizeArray(actual, length);

        System.out.println("Unsorted Sequence: ");
        for (int i = 0; i<actual.length; i++) {
            System.out.println(actual[i]);
        }

        mergeSort(actual, actual.length);

        System.out.println("Sorted Sequence: ");
        for (int i = 0; i<actual.length;i++) {
            System.out.println(actual[i]);
        }

    }

    public static void randomizeArray(int[] actual, int length) {
        for (int i = 0; i < length; i++) {
            actual[i] = (int)(Math.random()*length); //Math.random produces a double value between 0.00 and 1.00
        }
    }

    public static void mergeSort(int[] actual, int n) {
        if (n < 2) { //perform this method until the integer array size can no longer be split
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid]; //create left array variable
        int[] r = new int[n - mid]; //create right array variable

        for (int i = 0; i < mid; i++) {
            l[i] = actual[i]; //populate left array
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = actual[i]; //populate right array

        }

        //recursive methods execute until "l" and "r" array lengths are less than 2
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(actual, l, r, mid, n-mid);

    }

    public static void merge(int[] actual, int[] l, int[] r, int left, int right) {
        int i = 0; //i is the position placeholder integer of left "l" array (i = 0 is position 0)
        int j = 0; //j is the position placeholder integer of right "r" array (j = 0 is position 0)
        int k = 0; //k is the position placeholder integer of whole "actual" array (k = 0 is position 0)
        while (i < left && j < right) {
            if (l[i] <= r[j]) { //Assign the smaller value of the two "l" (left) and "r" (right) arrays to the "actual" array
                actual[k++] = l[i++];
            } else {
                actual[k++] = r[j++];
            }
        }
        
        //Assign the smaller value of the two "l" (left) and "r" (right) arrays to the "actual" array
            
        while (i < left) {
            actual[k++] = l[i++];
        }
        while (j < right) {
            actual[k++] = r[j++];
        }
    }
}
