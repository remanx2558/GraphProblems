import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sumofbitdifferences {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
                //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            //nteger.parseInt(br.readLine());
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            sam(arr);
        }
    }
    static void sam(int []arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                sum=sum+count(arr[i]^arr[j]);
            }
        }
        System.out.println(sum*2);

    }
    static int count(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
