import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;



public class Main  {

    public static void generateTests() throws IOException {

        String filepath = new File("tests/randomTest200.txt").getAbsolutePath();
    	BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));

        String filepath2 = new File("tests/pairWiseTest200.txt").getAbsolutePath();
    	BufferedWriter bw2 = new BufferedWriter(new FileWriter(filepath2));

        generateRandomTestCases(200, 20000, bw);
        generatePairWiseTestCases(200, bw2);

        bw.close();
        bw2.close();
    }

    public static int[] readInput(Scanner scanner) throws IOException {
		int length = scanner.nextInt();
    	int[] A = new int[length];
    	for(int i = 0; i < length; i++){
    		A[i] = scanner.nextInt();
    	}
    	return A;
    }

    public static void readTestToFile(BufferedWriter bw, int[] A) throws IOException {
    
    	bw.append(Integer.toString(A.length) + " ");
    	for(int i = 0; i < A.length; i++) {
    		bw.append(Integer.toString(A[i]) + " ");
    	}
        bw.append("\r\n");
    }

    public static void generateRandomTestCases(int N, int amount, BufferedWriter bw) throws IOException {
        Random random = new Random();
        for(int i = 0; i < amount; i++) {
            int[] A = new int[N];
            for(int j = 0; j < N; j++) {
                A[j] = random.nextInt(101) - 50; // -50 -> 50
            }
            readTestToFile(bw, A);
        }
    }

    public static void generatePairWiseTestCases(int N, BufferedWriter bw) throws IOException {
        // 0-wise
        int[] A = new int[N];
        for(int j = 0; j < N; j++) {
            A[j] = 0;
        }
        readTestToFile(bw, A); 
        
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
            readTestToFile(bw, A);
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

                readTestToFile(bw, A);

                A[j] = 0;
            }
        
        }
    }

    public static void generateKey() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("tests/keyPairWise200.txt").getAbsolutePath()));
        Scanner scanner = new Scanner(new FileReader(new File("tests/pairWiseTest200.txt").getAbsolutePath()));
        
        Random random = new Random();
        while(scanner.hasNextInt()) {
            int[] A = readInput(scanner);
            int toFind = A[random.nextInt(200)];
            bw.append(Integer.toString(BinarySearch.search(BubbleSort.sort(A), toFind)));
            bw.append("\r\n");
        }
        bw.close();
        
    }
    public static void runRandomTests() throws IOException {

            Scanner scanner = new Scanner(new FileReader(new File("tests/pairWiseTest200.txt").getAbsolutePath()));
            String filepath = new File("tests/keyPairWise200.txt").getAbsolutePath();
            // Scanner scanner = new Scanner(new FileReader(new File("tests/randomTest200.txt").getAbsolutePath()));
            // String filepath = new File("tests/keyRandom200.txt").getAbsolutePath();
            Scanner scannerOracle = new Scanner(new FileReader(filepath));
            boolean first = true;
            int counter = 1;
            int amount = 0;
            while(scanner.hasNextInt()) {
                
                int[] A = readInput(scanner);
                int[] B = A.clone();
                Arrays.sort(B);
                int oracleVal = scannerOracle.nextInt();
                int toFind = B[oracleVal];
               
                int res = BinarySearch.search(BubbleSort.sort(A), toFind);

                if(oracleVal != res) {
                    if(first) {
                        System.out.println(counter);
                        first = false;
                    }
                    amount++;
                }
                counter++;
            }
            System.out.println(amount);
            //bw.close();
                
    }

    public static void main(String[] args) throws IOException {
      //  runRandomTests();
        // generateTests();
        //generateKey();
        runRandomTests();
    }

}


    

