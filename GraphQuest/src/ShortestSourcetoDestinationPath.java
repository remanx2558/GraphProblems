import java.util.Scanner;

public class ShortestSourcetoDestinationPath {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m=sc.nextInt();


            node [][]arr=new node[n][m];
            int f=0;

            for (int i = 0; i < n; i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=new node();
                    arr[i][j].v=sc.nextInt();
                    arr[i][j].f=f++;

                }
            }
            int x=sc.nextInt();
            int y=sc.nextInt();

            greed(arr,x,y,n,m);
        }
    }
    static class node{
        int f;
        int v;
    }
    static void greed(node [][]arr,int x,int y,int n,int m){

        int dp[][]=new int[n*m][n*m];
        for(int i=0;i<n*m;i++){
            for(int j=0;j<m*n;j++) {
                dp[i][j]=1000000;

            }}
                int f=0;
        int destiny=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(x==i && y==j){
                    destiny=arr[i][j].f;
                }

                if(arr[i][j].v==1){
                    int from=arr[i][j].f;
                    //up
                    if(i+1<n){
                        int to=arr[i+1][j].f;
                        dp[to][from]=1;
                    }
                    if(i-1>=0){
                        int to=arr[i-1][j].f;
                        dp[to][from]=1;
                    }if(j+1<m){
                        int to=arr[i][j+1].f;
                        dp[to][from]=1;
                    }if(j-1>=0){
                        int to=arr[i][j-1].f;
                        dp[to][from]=1;
                    }
                }
                f++;
            }
        }
        boss(dp,n*m,destiny);



    }
    static void boss(int [][]board,int kk,int destiney){
        int dp[]=new int [kk];
        for(int i=0;i<kk;i++){
            dp[i]=board[0][i];
        }
        ////////////////
        for(int via=0;via<kk;via++){
            for(int to=0;to<kk;to++){
                if(dp[to]>dp[via]+board[via][to]){
                    dp[to]=dp[via]+board[via][to];
                }
            }
        }

//        for(int via=0;via<kk;via++){
//            for(int to=0;to<kk;to++){
//                System.out.print(board[via][to]+" ");
//            }
//            System.out.println();
//        }
        for(int i=0;i<kk;i++){
            System.out.print(dp[i]+" ");
        }
        if(dp[destiney]>=1000000){
            System.out.println("-1");
        }else{
            System.out.println(dp[destiney]);

        }
    }
}
