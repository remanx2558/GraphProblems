import java.util.Scanner;

public class Distanceofnearestcellhaving1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            greed(arr,n,m);
        }
    }
    static void greed(int [][]arr,int n,int m){

//        int dp[][]=new int[n][m];
//        boolean b[][]=new boolean[n][m];
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                dp[i][j]=5000000;
//
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(arr[i][j]==1){
//                    dp[i][j]=0;
//                    b[i][j]=true;
//                    dfs(dp[i][j],i,j,n,m,dp,b);
//                    continue;
//                }
//
//            }
//        }
//        ////////////////
//
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++) {
//                System.out.print(dp[i][j]+" ");
//            }}
//        System.out.println();
//                ////////

    }
   static int xx[]={1,-1,0,0,-1,1,-1,1};
   static int yy[]={0,0,1,-1,1,-1,-1,1};
    static void dfs(int val,int i,int j,int n,int m,int[][]dp,boolean b[][]){
        for(int in=0;in<xx.length;in++){
            int xnew=i+xx[in];
            int ynew =j+yy[in];
            if(xnew>=0 && xnew<n && ynew>=0 && ynew<m && !b[xnew][ynew]){
                dp[xnew][ynew]=Math.min(dp[xnew][ynew],1+dp[i][j]);
                b[xnew][ynew]=true;
                dfs(dp[xnew][ynew],xnew,ynew,n,m,dp,b);
                b[xnew][ynew]=false;

            }
        }
    }
}
