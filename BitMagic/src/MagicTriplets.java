import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MagicTriplets {
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
    static void sam(int []ar){


        int []dp=new int[ar.length+1];
        dp[0]=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<ar.length;i++){
            for(int j=i-1;j>=0;j--){
                if(ar[i]>ar[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        if(max<dp[i]){
                            max=dp[i];
                        }

                    }
                }else {
                    dp[i]=dp[i-1];
                }
            }
        }
        if(max<3){
            System.out.println("0");
            return;
        }
        long val=nc3(max);
        System.out.println("lcs is "+max);

        System.out.println(val);

            for(int j=0;j<ar.length;j++) {
                System.out.print(dp[j]+" ");
            }


            }
    static long nc3(int n){
        long dp[][]=new long[n+1][4];
        ///0th row
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        /////rest
        for(int i=1;i<n+1;i++){
            for(int j=1;j<4;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        ////////
        return dp[n][3];


    }
}
