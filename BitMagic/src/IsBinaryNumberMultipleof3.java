import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IsBinaryNumberMultipleof3 {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();
        //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            String str=s.next();
            int counteven=0;
            int countodd=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='1' && i%2==0){
                    counteven++;
                }
                if(str.charAt(i)=='1' && i%2!=0){
                    countodd++;
                }
            }
            /////////////
            if(Math.abs(counteven-countodd)%3==0){
                System.out.println("1");
            }
            else{
                System.out.println("0");

            }
        }
    }
}
