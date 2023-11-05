// import java.util.*;
import java.util.Random;
public class ShellSort {

    public static final int C = 4;
    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void compareExchange(int[] a, int i, int j) {
        if (((i < j) && (a[i] > a[j])) || ((i > j) && (a[i] < a[j]))) {
            exchange(a,i,j);
        }
    }
    // implementasi dari shaker pass
    public static void permuteRandom(int a[], Random rand) {
        for (int i =0; i<a.length;i++) {
            exchange(a, i, rand.nextInt(a.length-i)+i);
        }
    }
    public static void compareRegions(int[] a, int s, int t, int offset, Random rand){
        int mate[] = new int[offset];
        for (int count =0; count<C; count++) {
            for(int i = 0; i<offset; i++) mate[i] = i;
            permuteRandom(mate, rand);
            for(int i =0; i <offset; i++) compareExchange(a, s+i, t+mate[i]);
        }
    }
    // implementasi dari brick pass
    public static void randomizedShellSort(int[] a) {
        int n = a.length;
        Random rand = new Random();
        for (int offset = n/2; offset > 0; offset /= 2) {
            for (int i = 0; i < n - offset; i += offset) {
                compareRegions(a, i, i+offset,offset, rand);
            }
            for (int i = n - offset; i >= offset; i -= offset) {
                compareRegions(a, i-offset, i, offset, rand);
            }
            for (int i = 0; i < n - 3*offset; i += offset) {
                compareRegions(a, i, i+3*offset, offset, rand);
            }
            for (int i = 0; i < n - 2*offset; i += offset) {
                compareRegions(a, i, i+2*offset, offset, rand);
            }
            for (int i = 0; i < n; i += 2*offset) {
                compareRegions(a, i, i+offset,offset, rand);
            }
            for (int i = offset; i < n - offset; i += 2*offset) {
                compareRegions(a, i, i+offset,offset, rand);
            }
        }
    }
    /* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
    public static void main(String args[])
    {
        int arr[] = { 12, 2, 11, 13, 5, 30, 8, 17 };
        System.out.println("Data: 12, 2, 11, 13, 5, 30, 8, 17");
        ShellSort.randomizedShellSort(arr);
 
        System.out.println("Sorted data with Randomized Shellsort:");
        printArray(arr);
    }
}