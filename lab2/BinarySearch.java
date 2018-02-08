public class BinarySearch {


    public static int search(int[] a, int key) {
        int x = 0;
        int l = 1;
        int r = a.length-1;
        while(key != a[x] && (l <= r)) {
            x = (l+r) / 2;
            if(key < a[x])
                r=x-1;
            else
                l=x+1;
        }
        if(key==a[x])
            return x;
        else 
            return -1;
    }

    // public static int[] sort(int[] A) {
    // int n = A.length;
    // boolean swapped = false;
    // for(int i = 0; i < n; i++) {
    //     for(int j = 1; j < (n-i); j++) {
    //         if(A[j-1] > A[j]) {
    //             int tmp = A[j-1];
    //             A[j-1] = A[j];
    //             A[j] = tmp;       
    //         }    
    //     }
    // }
    // return A;
    // }
    
    public static void main(String[] args) {
        int[] A = {1, 4, 5, 6, 7, 8, 9, 12, 1337, 9000};
        System.out.println(BinarySearch.search(A, 12));
        System.out.println(BinarySearch.search(A, 1273981273));
        
        int[] B = {1, 3, 2, 800, 76, 35, 10, 19, 4};

        System.out.println(BinarySearch.search(BubbleSort.sort(B), 76));
    }

}
