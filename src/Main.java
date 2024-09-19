//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public double findmedian (int[] arr1, int[] arr2) {

        int arr1min = 0;
        int arr1max = arr1.length-1;
        int arr2min = 0;
        int arr2max = arr2.length-1;

        return helper(arr1,arr2,arr1min,arr1max,arr2min,arr2max);
    }

    private double helper(int[] arr1,int[] arr2,int arr1min,int arr1max,int arr2min,int arr2max) {
        //Base case
        if(arr2max-arr2min==0){
            return (double) (arr1[arr1min] + arr2[arr2max]) /2;
        }

        if((arr1min+arr1max)%2==0){ //odd number of elements
            if(arr1[(arr1min+arr1max)/2]<arr2[(arr2min+arr2max)/2]){
                return helper(arr1,arr2,(arr1min+arr1max)/2,arr1max,arr2min,(arr2min+arr2max)/2);
            }else if(arr1[(arr1min+arr1max)/2]>arr2[(arr2min+arr2max)/2]){
                return helper(arr1,arr2,arr1min,(arr1min+arr1max)/2,(arr2min+arr2max)/2,arr2max);
            }else{
                return arr1[(arr1min+arr1max)/2]; // two middle number are same
            }
        }else{ //Even number of elements
            if(arr1[(arr1min+arr1max)/2]<arr2[(arr2min+arr2max)/2]&&arr1[(arr1min+arr1max)/2+1]>arr2[(arr2min+arr2max)/2+1]){
                return (double) (arr2[(arr2min+arr2max)/2] + arr2[(arr2min+arr2max)/2+1]) /2; // two middle from arr2 inside two middle from arr1
            }else if(arr1[(arr1min+arr1max)/2]>arr2[(arr2min+arr2max)/2]&&arr1[(arr1min+arr1max)/2+1]<arr2[(arr2min+arr2max)/2+1]){
                return (double) (arr1[(arr1min+arr1max)/2] + arr1[(arr1min+arr1max)/2+1]) /2; // two middle from arr1 inside two middle from arr2
            }else if(arr1[(arr1min+arr1max)/2]<arr2[(arr2min+arr2max)/2]&&arr1[(arr1min+arr1max)/2+1]<arr2[(arr2min+arr2max)/2+1]){
                return helper(arr1,arr2,(arr1min+arr1max)/2+1,arr1max,arr2min,(arr2min+arr2max)/2);
            }else{
                return helper(arr1,arr2,arr1min,(arr1min+arr1max)/2,(arr2min+arr2max)/2+1,arr2max);
            }
        }


    }

    public static void main(String[] args) {

        int[] arr1 = {1,15,20,23,100};
        int[] arr2 = {4,5,10,25,70};

        Main m = new Main();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        double mid = m.findmedian(arr1, arr2);
        System.out.println(mid);

    }
}