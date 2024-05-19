public class MyClass {
    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 9};
        int B[] = {3, 5};
        int C[] = {-1,3,-5,7,-9,2};
        int D[] = {1,1,1,3,4,4,4,5,5 };
        Node n = new Node(7);
        n.left = 3;
        n.right = 9;
        n.left.left = 2;
        n.right.right = 4;
        n.right.left = 1;
        //int[] C = substring(A, B);

       check2Sum1Array(12,  A);
       check2Sum2Array(10,  A, B);
       neg2Positive(C);
       mode2(D);
       print(neg2PosEfficient(C,0,1));
       print(intersection(A,B));
      // int A[] = {1, 3, 5, 7, 9};
      // int B[] = {3, 5};
       int C[] = new int[A.length + B.length - 2];
       print(intersectionRecursive(A,B,C, 0,0,0));
       print(intersectionEff(A,B));

    }

  public static int BinarySearchRec(int high, int low, int target){ // RECURSIVE
    int mid = high + low / 2;  // 0 - 100 , mid =  25 target 30  , 10
    if(target > mid){
     low = mid+1;
     return BinarySearch(high, low,target);
    }
    if(target < mid){
     high = mid -1;
     return BinarySearch(high, low,target);

    }
    if(mid == target){
     return mid;
    }
    else{ // NOT FOUND
     return -1;
    }
 }
 public static int BinarySearch(int high, int low, int target){
     int mid = high + low / 2;
     while(mid != target){
         if(target > mid){
             low = mid +1;
         }
         if(target < mid){
             high = mid-1;
         }
     }
     if(mid == target){
         return mid;
     }
     else{
         return -1;
     }
 }
 public static boolean BinarySearchBool(int A[], int tar) {
    int low = 0;
    int high = A.length - 1;
    int mid;

    while (low <= high) {
        mid = low + (high - low) / 2;
        if (tar < A[mid]) {
            high = mid - 1;
        } else if (tar > A[mid]) {
            low = mid + 1;
        } else {
            return true;
        }
    }
    return false;
}
public static int BinarySearchNum(int A[], int tar) {
    int low = 0;
    int high = A.length - 1;
    int mid;

    while (low <= high) {
        mid = low + (high - low) / 2;
        if (tar < A[mid]) {
            high = mid - 1;
        } else if (tar > A[mid]) {
            low = mid + 1;
        } else { 
            return mid;
        }
    }
    return -1;
}

 public static int[] merge(int C[], int B[]){
    int A[] = new int[C.length + B.length - 2];
    int intersection[] = new int[C.length + B.length - 2];
    int i = 0;
    int j = 0;
    int k = 0;
    int a = 0;
    while(i < C.length && j < B.length){
        if(C[i] < B[j]){
            A[k] = C[i];
            k = k+1;
            i = i+1;
        }
        else if(B[j] < C[i]){
            A[k] = B[j];
            k = k+1;
            j = j+1;
        }
        else{ // B[j] == C[i] DUPLICATES 
            intersection[a] = B[j]; // or C[i] doesn't matter since related to same elements
        }
    }
    return A;
}
public static int[] insertionSort(int C[]){ // Decrease & Conquer Algorithm
    int v = C[i];
    int i = 1;
    int j = i-1;
    while(C[j] > v && j < C.length){ // 5,3,6  i = 1(3) , j = 0(5) (5,5,6) , j = -1, i = 1 , j = 0  C[0] = 3 => C(3,5,6)
        C[j+1] = C[j]; 
        j--;
    }
    C[j+1] = v; // C[j+1] = 3
}
    public static int[] substring(int A[], int B[]) {
        int k = 0;
        int[] C = new int[A.length]; 
        
        for (int i = 0; i < A.length ; i++) {
            int j = 0;
            while (i  < A.length && j < B.length  && A[i + j] == B[j]) {
                System.out.println("MATCH");
                C[k] = B[j];
                k++;
                j++;
            }
        }
        return C; 
    }
    public static boolean check2Sum1Array(int k, int A[]){
        int sum = 0;
        boolean check = false;
        for(int i = 0; i< A.length-1 ; i++){
            for(int j = i+1; j < A.length ; j++){
                sum = A[i] + A[j];
                if(sum == k){
                    check =  true;
                    System.out.println("FOUND => " + A[i] + " + " + A[j] + " = " + sum );
                }
                else{
                    check =  false;
                    System.out.println("NOT FOUND");
                    break;
                }
            }
        }
        return check; 
    }
    public static boolean check2Sum2Array(int k, int A[], int B[]){
        boolean check = false;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){  
                int sum = A[i] + B[j];
                if(sum == k){
                    System.out.println("FOUND => " + A[i] + " + " + B[j] + " = " + sum);
                    check = true;
                    break; 
                } else {
                    System.out.println("NOT FOUND: " + A[i] + " + " + B[j] + " = " + sum);
                }
            }
            if(check) break;  
        }
        return check;
    }
    public static int[] neg2Positive(int C[]) {
        int i = 0;
        int j = i + 1;
        while (i < C.length-1 && C[i] < 0) {
                while (C[j] < 0 &&  j < C.length) {
                    System.out.println("BEFORE / " + j + "th: " + C[j] + " index && " + i + "th " + C[i] + " index");
                    int temp = C[j];
                    C[j] = C[i];
                    C[i] = temp; 
                    System.out.println("AFTER / " + j + "th: " + C[j] + " index && " + i + "th " + C[i] + " index");
                }
                i++;
        }
        for (int t=0 ; t < C.length; t++) {
            System.out.print(C[t] + " ");
        }
        return C;
    }
    public static int[] neg2PosArray(int C[]){ // Solved with Additional Array
        int B [] = new int [C.length];
        int i = 0;
        int j = 0;
        while(C[i] < 0 ){
            if(i <= C.length){ // repositioning negative elements
                C[i] = B[j];
                i++;
                j++;
            }
            else{ // i = size (last element) => Now reposition the + elements
                i = 0;
                if(C[i] > 0){
                    C[i] = B[j];
                }
            }
        }
        return B;
    } 
    public static int[] neg2PosEfficient(int C[], int i, int j){
        if( j < C.length && i < C.length-1){
         if(C[j] < 0){
             int temp = C[j];
             C[j] = C[i];
             C[i] = temp;
             return neg2PosEfficient(C, i + 1 , j+1);
         }
         
         return neg2PosEfficient(C, i, j+1);
         
        }
        return C; //sona geldiğinde 
    }
     public static void print(int C[]){
         for(int i = 0; i < C.length; i++){
             System.out.println(i+" th => " + C[i]);
         }
     }
    
    public static int[] searchSubArray(int C[], int  B[]){ 
        int i = 0;
        int j =0;
        boolean isSubArr;
        while(i < C.length && j < B.length){
            if(C[i] != B[j]){ 
                i++;
                isSubArr = false;
            }
            else{ // C[i] == B[j] 
                isSubArr  = true;
            }
        }
        if( i = C.length-1 && j = B.length-1){ // Array sayımı bittiyse
            return isSubArr;
        }
    }

    public static int[] intersection(int A[], int B[]) {  // Brute Force
        int C[] = new int[A.length + B.length - 2];
        int k=0;
        int i = 0; // C
       while( i < A.length ){
        int j = 0;
         while( j < B.length ){
            if(A[i] == B[j]){
                C[k] = B[j];
				k++;
            }
            j++;
        }
        i++;
       }
	   return C;
    }
    public static int[] intersectionRecursive(int A[], int B[], int C[], int i, int j, int k){ // Recursive O (N x M)
        // A[] = {1, 3, 5, 7, 9}; i
        // B[] = {3, 5};  j 
        if(i < A.length && j < B.length){
            if(A[i] == B[j]){
                C[k] = A[i];
                k = k+1;
                return intersectionRecursive(A,B,C, i+1, j+1, k+1);
            }
           else if(A.length > B.length){
              return intersectionRecursive(A,B,C, i+1, j, k);
            }
            else{
                return intersectionRecursive(A,B,C, i, j+1, k);
            }
        }
        return C;
    }
    public static int[] intersectionEff(int A[], int B[]){
        int i = 0; // A
        int j = 0; // B
        int k= 0;
        int C[] = new int[A.length + B.length - 2 ];
        while( i < A.length && j < B.length){
            if(A.length > B.length){ // A > B
                if(BinarySearchBool(A, B[j])){ // if B[j] exists in A
                    C[k] = B[j];
                    j++;
                    k++;
                }
            }
            else{ // B > A
                if(BinarySearchBool(B, A[i])){ // if A[i] exists in B
                    C[k] = A[i];
                    i++;
                    k++;
                }
            }
        }
        return C;
    }
   
    public static int mode(int A[]){ // BRUTE - Force Algorithm
        int count = 0;
        int maxCount = 0;
        int mode;
        for(int i = 0 ; i < A.length-1 ; i++){
            for(int  j = i+1 ; j< A.length ; j++){
                if(A[i] == A[j]){
                    count++;
                }
            } 
            if(count > maxCount){
                maxCount = count;
                mode = A[i];
            }
        }
        return mode;
    }
    // DESIGN AN EFFICIENT MODE ALGORITHM Low Complexity
    public static int mode2(int A[]){ // NLOGN
        // MERGESORT()
        int distance;
        int maxDistance= 0;
        int i= 0;
        int size = A.length;
        int num;
        while(i < size){ // 1,1,1,3,4,4,4,5,5 
            
            if(A[i] == A[i+1]){ 
                distance++;
                
            }
            else{ //when A[i] != A[i+1]
                if(distance > maxDistance){
                    maxDistance = distance;
                    num = A[i];
                }
                distance = 1;
            }
            i++;
        }
        return num;
    }
    public static int modeEff(int A[]){ // O(NlogN)
        int count = 0;
        int maxCount = 0;
        int num = A[0];
        int i = 0;
        while(i < A.length){
            if(BinarySearchBool(A, A[i])){ //BinarySearchBool( A array , A[i] = target (aranan) )
                count++;
                
            }
            if(count > maxCount){
                maxCount = count;
                num = A[i];
            }
            i++;
        }
        return num;
    }

    public static int minDistance(int A[]){
        int min = abs(A[0] - A[1]); // initialized
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1 ; j < A.length; j++){
                if(abs(A[j] - A[i]) < min){
                    min = abs(A[j]- A[i]);
                }
            }
        }
        return min;
    }
    public static int minDistance(int A[], int i, int min){
        int iMin;
        if( i < A.length && A[i] < min){
            iMin =  minDistance(A, i + 1, A[i]);
        }
        if(iMin < min){
            min  = iMin;
        }
        if(i  = A.length){
            return min;
        }
    }
   public static Node findAverageLeafTree(Node n, int A[]){ // n = 3 , n.left= 2, n.left.left = 1 n.left.right = 9 , n.right = 5 , n.right.left = 6, n.right.right = null
    int i = 0;
    int average = 0;
    if(n == null){
        return 0;
    }
    if(n.left == null && n.right == null){
       A[i] = n.value;
       i++;
        return n;
    }
    findAverageLeafTree(n.left, A);
    findAverageLeafTree(n.right, A);
    for(int j = 0; j< A.length; j++){
        average = A[j] + average;
    }
    average = average / A.length-1;
   }
   // Complexity T(N) = 2T(N/2) + N
   public static boolean subString(int A[], int B[]){ //A => algorithm, B => rithm
    boolean isSubs = false;
    for(int i = 0 ; i < B.length; i++){
        for(int j = 0; j < A.length; j++){
            if(B[i] == A[j]){
                isSubs = true;
                System.out.println(B[i]);
            }
        }
    }
     return isSubs;
   }
public static boolean subStringEff(int A[], int B[]) {
   // mergesort(A);
    boolean isSubs = false;
    int i = 0; // A
    int j = 0; // B 
    while (j < B.length && i < A.length) {
        if (BinarySearchBool(B, A[i])) {
            System.out.println("A is " + A[i] + " B is " + B[j]);
            isSubs = true;
            j++;
        } 
        i++;
    }
    return isSubs;
}

   // TREE'S
   public static Node numOfEvenNodes(Node n){
    if(n = null){
        return 0;
    }
    if(n.value % 2 == 0){
        return numOfEvenNodes(n.left) + numOfEvenNodes(n.right) + 1;
    }
    return numOfEvenNodes(n.left) + numOfEvenNodes(n.right);
   }
   // 1 Tree, 1 Graph , 1 Brute Force and Efficient Algorithm by using BST . (NOT MERGESORT)
   public static int sum(int A[], target){  // brute force n^2
    for(int i = 0; i < A.length ; i++){
        for(int j = i+1; j < A.length - 1;  j++){
            if(A[i] + A[j] == target){
                return target;
            }
        }
     }
       return -1;
   }
   // USE Efficient Algorithm BST 
   public static int sumEff(int A[], int target){
    int size = A.length -1;
    int high = size
    int min = 0;
    int mid = high + min / 2;
    int targetPair = target - A[mid];
    while(high < low){
        if(targetPair < A[mid]){
            high = mid - 1;
        }
        if(targetPair > A[mid]){
            low = mid + 1;
        }
        if(targetPair == A[mid]){
            return target;
        }
    }
    // target == mid

   }
   // Use Efficient Algorithm BST & Recursive : 
   public static int sumEff2(int A[], int target, high, low){
    int size = A.length - 1;
    int mid = high + min / 2;
    int targetPair = target - A[mid];

    if(targetPair < A[mid]){
        return sumEff2(A, target, mid -1, low);
    }
    if(targetPair > A[mid]){
        return sumEff2(A, target, high, mid+1);
    }
    if(targetPair == A[mid]){
        return target;
    }

   }
   public static int max(int a, int b, int c){
    int max = a;
    if(max < b && max > c && max > a){
        max = b;
    }
    if(max < c && max > b  && max > a){
        max = c;
    }
     return max;
   }
   public static Node findMaxBT(Node n) {
      if(n == null){
        return 0;
      }
     if(n.left == null && n.right == null){
      return n.value;
     }
     return max(n.value, findMaxBT(n.left), findMaxBT(n.right));
     } 

}





