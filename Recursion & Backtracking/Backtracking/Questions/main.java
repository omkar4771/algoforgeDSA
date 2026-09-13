public class main {



    public int spanofelement(int arr[]){

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){

            if(arr[i] < min){
                min = arr[i];
            }

            if(arr[i] > max){
                max = arr[i];
            }

        }
        int spannum = max-min ;

        return spannum;
    }

    public  int findtargetelement(int arr[], int tar){

        for(int i=0; i<arr.length ; i++){

            if(arr[i] == tar){
                return i;
            }
 
        }

        return  -1;
    }

    public static  void makebuildingFromArray(int arr[]){

        //find large element in array
        int large = 0;
        int size = arr.length;

        for(int i=0 ; i<arr.length; i++){
            if(large < arr[i]){
                large = arr[i];
            }
        }

        //print the building from array
        int templarge = large;

        //height - largest element
        for(int i=0 ; i <large ; i++){
            //row
            for(int j=0; j<size ; j++){
                //System.out.print(arr[j]+""+templarge);
                if(arr[j] >= templarge){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            templarge --;
            System.out.println();
        }
    }

    public static void addtwoArrays(int arr1[], int arr2[]){

        // find larger array
        int largerArray = Math.max(arr1.length, arr2.length);

        //create new array
        int[] ans = new int[largerArray];
        int lastidx = 1;

        for(int i=largerArray-1; i>=0; i--){

            int arr1idx = arr1.length-lastidx;
            int arr2idx = arr2.length-lastidx;

            if(arr1idx >=0 && arr2idx >= 0){
                ans[i] = arr1[arr1idx] + arr2[arr2idx];
            }else if (arr1idx >= 0 && arr2idx < 0) {
                ans[i] = arr1[arr1idx];
            }else if (arr1idx < 0 && arr2idx >= 0) {
                ans[i] = arr2[arr2idx];
            }
            lastidx++;
        }

        //print the arry's
        for(int i=0 ; i<ans.length ;i++){
            System.out.print(ans[i]+", ");
        }
    }

    public static void addtwoArraysnew(int arr[]){
    }

    public static void reverseArray(int arr[]){

        for(int i=0 ; i<arr.length/2 ; i++){

            //swap two number
            int firstNum = arr[i];
            int secondNum = arr[arr.length-1 - i];

            int thirdNum = firstNum;
            firstNum = secondNum;
            secondNum = thirdNum;

            arr[i] = firstNum;
            arr[arr.length-1 -i] = secondNum;
        }
        
        //print the arry's
        for(int i=0 ; i<arr.length ;i++){
            System.out.print(arr[i]+", ");
        }

    }

    public static void main(String[] args) {
        
        int[] arr1 = new int[4];
        int[] arr2 = new int[1];

        arr1 = new int[]{1, 9, 3, 4};  
        arr2 = new int[]{6,3};  

        //makebuildingFromArray(arr);

        //addtwoArrays(arr1,arr2);
        reverseArray(arr1);
    }
    
}
