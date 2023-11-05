import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GenerateData {

    public static void main(String[] args) {
        System.out.println("Start generating data..."); 

        int smallSize = (int) Math.pow(2, 9);
        int mediumSize = (int) Math.pow(2, 13);
        int largeSize = (int) Math.pow(2, 16);

        int[] smallSorted = generateSortedData(smallSize);
        String fileSmallSorted =  "small_sorted.txt";
        saveDataToFile(smallSorted, fileSmallSorted);

        int[] smallRandom = generateRandomData(smallSize, 1000);
        String fileSmallRandom =  "small_random.txt";
        saveDataToFile(smallRandom, fileSmallRandom);

        int[] smallReversed = generateReversedData(smallSize);
        String fileSmallReversed =  "small_reversed.txt";
        saveDataToFile(smallReversed, fileSmallReversed);

        int[] mediumSorted = generateSortedData(mediumSize);
        String fileMediumSorted =  "medium_sorted.txt";
        saveDataToFile(mediumSorted, fileMediumSorted);

        int[] mediumRandom = generateRandomData(mediumSize, 10000);
        String fileMediumRandom =  "medium_random.txt";
        saveDataToFile(mediumRandom, fileMediumRandom);

        int[] mediumReversed = generateReversedData(mediumSize);
        String fileMediumReversed =  "medium_reversed.txt";
        saveDataToFile(mediumReversed, fileMediumReversed);

        int[] largeSorted = generateSortedData(largeSize);
        String fileLargeSorted =  "large_sorted.txt";
        saveDataToFile(largeSorted, fileLargeSorted);

        int[] largeRandom = generateRandomData(largeSize, 100000);
        String fileLargeRandom =  "large_random.txt";
        saveDataToFile(largeRandom, fileLargeRandom);

        int[] largeReversed = generateReversedData(largeSize);
        String fileLargeReversed = "large_reversed.txt";
        saveDataToFile(largeReversed, fileLargeReversed);
        
    }

    // Fungsi untuk menghasilkan data terurut
    public static int[] generateSortedData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        return data;
    }

    // Fungsi untuk menghasilkan data acak
    public static int[] generateRandomData(int size, int max) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(max + 1); // Menghasilkan angka acak antara 0 dan 999
        }
        return data;
    }

    // Fungsi untuk menghasilkan data terbalik
    public static int[] generateReversedData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = size - 1 - i;
        }
        return data;
    }
    // Fungsi untuk mencetak data
    public static void printData(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    public static void saveDataToFile(int[] data, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int value : data) {
                writer.write(Integer.toString(value));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
