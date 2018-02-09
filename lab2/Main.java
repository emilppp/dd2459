import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	//int[] A = readInput("tests/test.txt");
    	//System.out.println(BinarySearch.search((BubbleSort.sort(A)), 5));//
    	//System.out.println(BinarySearch.search((BubbleSort.sort(A)), 0));//
        generateRandomTestCases(10, 5);
        generatePairWiseTestCases(10);
    }	//readTestToFile("tests/test2.txt", A);
    

    public static int[] readInput(String testName) throws IOException {
    	String filepath = new File(testName).getAbsolutePath();
    	Scanner scanner = new Scanner(new FileReader(filepath));
		int length = scanner.nextInt();
    	int[] A = new int[length];
    	for(int i = 0; i < length; i++){
    		A[i] = scanner.nextInt();
    	}
    	return A;
    }

    public static void readTestToFile(String testName, int[] A) throws IOException {
    	String filepath = new File(testName).getAbsolutePath();
    	BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
    	bw.append(Integer.toString(A.length) + "\r\n");
    	for(int i = 0; i < A.length; i++) {
    		bw.append(Integer.toString(A[i]) + "\r\n");
    	}
    	bw.close();
    }

    public static void generateRandomTestCases(int N, int amount) throws IOException {
        Random random = new Random();
        for(int i = 0; i < amount; i++) {
            int[] A = new int[N];
            for(int j = 0; j < N; j++) {
                A[j] = random.nextInt(101) - 50; // -50 -> 50
            }
            readTestToFile("tests/randomTest" + i + ".txt", A);
        }
    }

    public static void generatePairWiseTestCases(int N) throws IOException {
        // 0-wise
        int[] A = new int[N];
        for(int j = 0; j < N; j++) {
            A[j] = 0;
        }
        readTestToFile("tests/0wiseTest.txt", A); 
        
        // 1-wise
        for(int i = 0; i < N; i++) {
            A = new int[N];
            for(int j = 0; j < N; j++) {
                A[j] = 0;
            }
            if(i % 2 == 0)
                A[i] = 1;
            else 
                A[i] = -1;
            readTestToFile("tests/1wiseTest" + i + ".txt", A);
        }

        // 2-wise
        for(int i = 0; i < N; i++) {
            A = new int[N];
            for(int k = 0; k < N; k++) {
                    A[k] = 0; 
            }
             if(i % 2 == 0)
                A[i] = 1;
            else
                A[i] = -1;

            for(int j = i+1; j < N; j++) {
                if(j % 2 == 0)
                    A[j] = 1;
                else
                    A[j] = -1;

                readTestToFile("tests/2wiseTest" + i + "-" + j + ".txt", A);

                A[j] = 0;
            }
        
        }
    }
}
