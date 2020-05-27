import java.util.Scanner;

public class Constructbinarypalindromebyrepeatedappendingandtrimming {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        // dpmaker();
        while (c-- > 0) {

            int n=sc.nextInt();
            int k=sc.nextInt();

            greed(n,k);
        }
    }
    static void greed(int n,int k){
        int g[]=new int [n];
        ///step 1:first is one
        g[0]=1;
        ///step 2:last is one
        g[n-1]=1;
        ////step3:repeat after i repeat at i+k
        for(int i=0;i<n;i=i=i+k){
            g[i]=1;
        }
        ///step 4:repeat from last
        for(int i=n-1;i>=0;i--){
            int pic=g[i];
            for(int j=i;j>=0;j=j-k){
                g[j]=pic;
            }
        }
        String str="";
        for(int i=0;i<n;i++){
            str=str+g[i];
        }
        System.out.println(str);




    }
}
