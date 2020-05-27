import java.util.Scanner;

public class YourSocialNetwork {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int arr[]=new int[n-1];
            for(int i=0;i<n-1;i++){
                arr[i]=sc.nextInt()-1;
            }
            greed(arr,n);
        }
    }
    static void greed(int []arr,int n){
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int count=1;
                boolean b=false;
                String str=(i+1)+" "+(j+1);
                int k=i;
                int sam=0;
                while(k-1>=0 && arr[k-1]!=j && sam<=(i-j+1)){
                    k=arr[k-1];
                    count++;
                    sam++;
                }
                if(k-1>=0 && arr[k-1]==j){
                    b=true;
                    str=str+" "+count+" ";

                }

                if(b){
                    System.out.print(str);
                }


            }
        }
        System.out.println();

    }
}
