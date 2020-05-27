import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MariaBreakstheSelfisolation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            greed(arr,n);
        }
    }
    static void greed(int []arr,int n){

        Arrays.sort(arr);
        int count=1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=(i+1)){
                count=(i+1)+1;
                break;
            }
        }

        System.out.println(count);





    }
}
