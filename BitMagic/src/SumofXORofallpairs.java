import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SumofXORofallpairs {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();
                //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=s.nextInt();
                    //Integer.parseInt(br.readLine());
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            greed(arr);
           // System.out.println(sumXOR(arr,arr.length));
        }
    }
    static void greed(int []arr){
        long zero[]=new long[32];
        long one[]=new long[32];

        /////////////
        for(int i=0;i<arr.length;i++){
            String str=Integer.toString(arr[i],2);
            //System.out.println(str);
            int f=0;
            for(int j=str.length()-1;j>=0;j--,f++){
                if(str.charAt(j)=='1'){
                    one[f]++;
                }
            }
        }
        ///////////
        for(int i=0;i<32;i++) {
            zero[i]=arr.length-one[i];
        }
            //////////////
        long sum=0;
        for(int i=0;i<32;i++){
            sum=sum+(zero[i]*one[i]*(int)Math.pow(2,i));
        }
        System.out.println(sum);
//        ///////////////
//        for(int i=0;i<32;i++){
//            System.out.print(one[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<32;i++){
//            System.out.print(zero[i]+" ");
//        }
//        ////////////////
//        System.out.println();

    }

    // Returns sum of bitwise OR
    // of all pairs
    static long sumXOR(int arr[], int n)
    {
        int zero[]=new int[32];
        int one[]=new int[32];
        long sum = 0;
        for (int i = 0; i < 32; i++)
        {
            // Count of zeros and ones
            int zc = 0, oc = 0;

            // Individual sum at each bit position
            long idsum = 0;

            for (int j = 0; j < n; j++)
            {
                if (arr[j] % 2 == 0)
                    zc++;

                else
                    oc++;
                arr[j] /= 2;
            }

            // calculating individual bit sum
            idsum = oc * zc * (1 << i);
            one[i]=oc;
            zero[i]=zc;

            // final sum
            sum += idsum;
        }
        for(int i=0;i<32;i++){
            System.out.print(one[i]+" ");
        }
        System.out.println();
        for(int i=0;i<32;i++){
            System.out.print(zero[i]+" ");
        }


        return sum;
    }
}
