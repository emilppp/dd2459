import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) throws IOException {
    	int[] A = readInput("tests/test.txt");
    	//System.out.println(BinarySearch.search((BubbleSort.sort(A)), 5));//
    	//System.out.println(BinarySearch.search((BubbleSort.sort(A)), 0));//

    	readTestToFile("tests/test2.txt", A);
    }

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
    	for(int i = 0; i < A.length; i++){
    		bw.append(Integer.toString(A[i]) + "\r\n");
    	}
    	bw.close();
    }
}