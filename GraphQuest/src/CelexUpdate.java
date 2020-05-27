import java.util.Scanner;

public class CelexUpdate {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
       // dpmaker();
        while (c-- > 0) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int d1=x2-x1;
            int d2=y2-y1;
            greed(d1,d2);
        }
    }
    static void greed(int d1,int d2){
        if(d1<0 ||d2<0){
            System.out.println("0");
            return;
        }
        long n=d1+d2;
//
//        for(int i=0;i<5;i++){
//            for(int j=0;j<i;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }



        long r=Math.min(d1,d2);
        System.out.println(ncr(n,r));
    }


    static int m=10000;

    static long ncr(long n,long r){


        if(r==0){
            return 1;
        }
        else if(r==1){
            return n;
        }
        else if(n==0 || n==1){
            return 1;
        }
        else {
            long k=(n-1)*(ncr(n-1,r-1));
            k=k/(r-1);
            return k;
        }
//        else if(n<m){
//            return dp[(int)n][(int)r];
//        }



    }
}
