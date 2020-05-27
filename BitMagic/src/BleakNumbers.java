import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BleakNumbers {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        greed();
        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=Integer.parseInt(br.readLine());
            method(n);
        }
    }
    static void method(int n){
        boolean b=true;
        for(int i=1;i<=n;i++){
            if(dp[i]+i==n){
                b=false;
                break;
            }
        }

        if(b){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
   static int []dp=new int[10001];
    static void greed(){
        dp[0]=0;
        for(int i=1;i<10001;i++){
            dp[i]=call(Integer.toString(i,2));
        }

    }
    static int call(String str){
        int count=0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j)=='1'){
                count++;
            }
        }
        return count;
    }
}
