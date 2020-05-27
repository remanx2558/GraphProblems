import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Findsumofdifferentcorrespondingbitsforallpairs {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();
        //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextLong();
            }
            greed(arr);
            sumBitDifferences(arr,arr.length);
        }
    }
    static void sumBitDifferences(long arr[], int n)
    {

        long []one=new long[32];
        long []zero=new long[32];
        long ans = 0; // Initialize result
        long M=1000000007;

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements
            // with i'th bit set
            long count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) == 0)
                    count++;

            // Add "count * (n - count) * 2"
            // to the answer
            one[i]= count;
            zero[i]=n-count;

            ans =((ans)%M+ ((count * (n - count) * 2)%M))%M;
        }

                for(int i=0;i<32;i++){

            System.out.print(one[i]+" ");
        }
        System.out.println();
        for(int i=0;i<32;i++){

            System.out.print(zero[i]+" ");
        }
        System.out.println(ans);
    }

    static void greed(long []arr){

        int []one=new int[32];
        int []zero=new int[32];
        for(int i=0;i<arr.length;i++){
            String str=Long.toString(arr[i],2);
            int f=0;
          //  System.out.println("working on "+str);
            for(int j=str.length()-1;j>=0;j--){
              //  System.out.println("position is "+j+"set to");
                if(str.charAt(j)=='1') {
                    one[f]++;
                    f++;
                 //   System.out.println("one at "+(f-1));
                }
                else {
                   // zero[f]++;
                    f++;
                   // System.out.println("zero at "+(f-1));
                }
            }
            ///////////////


        }
        for(int i=0;i<32;i++){
            zero[i]=arr.length-one[i];
        }
        for(int i=0;i<32;i++){

            System.out.print(one[i]+" ");
        }
        System.out.println();
        for(int i=0;i<32;i++){

            System.out.print(zero[i]+" ");
        }
long M=1000000007;
        long sum=0;
        for(int i=0;i<32;i++){

            sum=((sum)%M+(one[i]*zero[i])%M)%M;
        }
        System.out.println((2*sum)%M);


    }
}
