import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalysisProgram {
    public static void main(String[] args) {
        System.out.println("Analisis Program"); 

        // evaluasi eksperimen terhadap data ukuran kecil dan status sorted
        String filename = "small_sorted.txt"; 
        int[] data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran kecil dengan status sorted: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran kecil dan status random
        filename = "small_random.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran kecil dengan status random: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran kecil dan status reversed
        filename = "small_reversed.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran kecil dengan status reversed: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran sedang dan status sorted
        filename = "medium_sorted.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran sedang dengan status sorted: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");
        
        // evaluasi eksperimen terhadap data ukuran sedang dan status random
        filename = "medium_random.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran sedang dengan status random: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran sedang dan status reversed
        filename = "medium_reversed.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran sedang dengan status reversed: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran besar dan status sorted
        filename = "large_sorted.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran besar dengan status sorted: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran besar dan status random
        filename = "large_random.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran besar dengan status random: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");

        // evaluasi eksperimen terhadap data ukuran besar dan status reversed
        filename = "large_reversed.txt"; 
        data = readDataFromFile(filename);
        System.out.println("Hasil evaluasi sorting data ukuran besar dengan status reversed: ");
        System.out.println(evaluateMaxHeapSort(data));
        System.out.println(evaluateRandomizedShellSort(data));
        System.out.println("\n");


    }
    public static int[] readDataFromFile(String filename) {
        int[] data = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int count = 0;
            
            // Hitung jumlah baris di file
            while ((line = reader.readLine()) != null) {
                count++;
            }

            reader.close();

            // Inisialisasi array integer berdasarkan jumlah baris
            data = new int[count];

            // Kembali ke awal file
            reader = new BufferedReader(new FileReader(filename));
            int i = 0;

            // Baca dan konversi baris ke dalam array integer
            while ((line = reader.readLine()) != null) {
                data[i] = Integer.parseInt(line);
                i++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public static String evaluateMaxHeapSort(int[] data) {
        long startTime = System.nanoTime();
        MaxHeapSort.sort(data);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime); 
        double executionTimeInMillies = executionTime / (double) 1000000;
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double kilobytes = (double) memoryUsed / (double) 1024;

        return "Max-Heap Sort: \n- Waktu Eksekusi: " + executionTimeInMillies + " ms \n- Penggunaan Memori: " + kilobytes + " kilobytes";
    }
    public static String evaluateRandomizedShellSort(int[] data) {
        long startTime = System.nanoTime();
        ShellSort.randomizedShellSort(data);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        double executionTimeInMillies = executionTime / (double) 1000000;
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double kilobytes = (double) memoryUsed / (double) 1024;

        return "Randomized Shellsort: \n  Waktu Eksekusi: " + executionTimeInMillies + " ms \n- Penggunaan Memori: " + kilobytes + " kilobytes";
    }

}
