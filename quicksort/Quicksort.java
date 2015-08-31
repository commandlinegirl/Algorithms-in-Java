import java.util.*;

/* 
 * Quicksort implementation in place. 
 * It is used in a few solutions to problems at www.hackerrank.com
 * https://www.hackerrank.com/domains/algorithms/arrays-and-sorting
 */
public class Quicksort {

    private static void swap(int[] ar, int a, int b) {
        if (a >= ar.length || b >= ar.length || a < 0 || b < 0) {
            throw new IllegalArgumentException("Incorrect array index");
        }
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    private static int partition(int[] ar, int lo, int hi) {
        if (lo >= ar.length || hi >= ar.length || lo < 0 || hi < 0) {
            throw new IllegalArgumentException("Incorrect array index");
        }
        int p = ar[hi]; 
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= p) {
                swap(ar, i, j);
                i++;  
            }
        }
        swap(ar, i, hi);
        return i;
    }
    
    private static void quickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int p = partition(ar, lo, hi);
            quickSort(ar, lo, p - 1);
            quickSort(ar, p + 1, hi);
            
        }
    }
    
    private static void printArray(int[] ar) {
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar, 0, ar.length - 1);
        printArray(ar); 
    }
}
