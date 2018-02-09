public class BubbleSort {

    public static int[] sort(int[] A) {
        int n = A.length;
        boolean swapped = false;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n-i); j++) {
                if(A[j-1] > A[j]) {
                    int tmp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = tmp;       
                }    
            }
        }
        return A;
    }
   
    public static void main(String[] args) {
        int[] before = {3, 4, 1, 6, 7, 400, 5};
        int[] after = BubbleSort.sort(before);     
        for(int i = 0; i<after.length; i++) {
            System.out.println(after[i]);
        }     
    }
}
