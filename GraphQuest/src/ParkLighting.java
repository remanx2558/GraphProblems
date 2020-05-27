import java.util.Scanner;

public class ParkLighting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            greed(n,m);
        }
    }
    static void greed(int n,int m){

        long f=n*m;
        long c=0;
        if(f%2!=0){
            c=1;
        }
        f=f/2+c;
        System.out.println(f);

    }
    static void swap(long a,long b){
        long temp=a;
        a=b;
        b=temp;
        return;

    }
}
