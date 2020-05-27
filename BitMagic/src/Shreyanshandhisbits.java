import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Shreyanshandhisbits {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();
        //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            long n=s.nextLong();
            String str=Long.toString(n,2);
            greed(str);
        }
    }
    static void greed(String str){
       // System.out.println(str);
        int k=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                k++;
            }

            }
        dpmaker(str.length(),k);
        long ans=0;
        //////////1st one
     //   sum=sum+dp[str.length()-1][k];
      //  System.out.println("inital sum is"+sum);


        int n=str.length();
        int count=0;
        int totalones=k;
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)=='1')
            {
                ++count;
                //r==totalones-count+1
                //n==n-i+1
                if(n-i-1>=totalones-count+1)

                    ans=ans+dp[n-i-1][totalones-count+1];


            }
        }
        System.out.println(ans);



    }
    static long dp[][];
    static void dpmaker(int p,int o){
        dp=new long[p+1][o+1];
        ///////////////////
        for(int i=0;i<p+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<p+1;i++){
            for(int j=1;j<o+1;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
    }

}
