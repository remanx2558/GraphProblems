import java.util.Scanner;

public class EulerCircuitinaDirectedGraph {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int v = sc.nextInt();
            int e = sc.nextInt();
            int arr[]=new int[2*e];

                for(int j=0;j<2*e;j++){
                    arr[j]=sc.nextInt();
                }


            greed(arr,v,e);
        }
    }
    static void greed(int []arr,int n,int m){

        //0:in
        //1:out
        int dp[][]=new int[2][n];
        for(int i=0;i<arr.length;i=i+2){
            int from=arr[i];
            int to=arr[i+1];
            dp[0][to]++;
            dp[1][from]++;
        }
        boolean b=true;
        for (int i=0;i<n;i++){
            if(dp[0][i]==0||dp[1][i]==0||dp[0][i]!=dp[1][i]){
                b=false;
                break;
            }

        }
        if(b){
            System.out.println("1");
        }
        else{
            System.out.println("0");

        }
//        for (int i=0;i<n;i++){
//            System.out.print(dp[0][i]+" ");
//
//        }
//        System.out.println();
//        for (int i=0;i<n;i++){
//            System.out.print(dp[1][i]+" ");
//
//        }

    }

}
