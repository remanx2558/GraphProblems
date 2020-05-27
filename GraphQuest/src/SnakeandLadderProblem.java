import java.util.Scanner;

public class SnakeandLadderProblem {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int d = sc.nextInt();


            int []arr=new int[2*d];
            for (int i = 0; i < d*2; i++) {arr[i]=sc.nextInt();}

            greed(arr);
        }
    }
    static void greed(int[]arr){

        int board[][]=new int[30][30];
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                board[i][j]=1100;
            }
        }
        ///////////////////
        for(int i=0;i<30;i++){
            if(i+1<30){board[i][i+1]=1;}
            if(i+2<30){board[i][i+2]=1;}if(i+3<30){board[i][i+3]=1;}if(i+4<30){board[i][i+4]=1;}
            if(i+5<30){board[i][i+5]=1;}if(i+6<30){board[i][i+6]=1;}
            board[i][i]=0;
        }
        ////////
        for(int i=0;i<arr.length;i=i+2){
            int from=arr[i]-1;
            int to=arr[i+1]-1;
            board[from][to]=0;
        }
        ////////////////////////board given
        boss(board);
    }
    static void boss(int [][]board){
        int dp[]=new int [30];
        for(int i=0;i<30;i++){
            dp[i]=board[0][i];
        }
        ////////////////
        for(int via=0;via<30;via++){
            for(int to=0;to<30;to++){
                if(dp[to]>dp[via]+board[via][to]){
                    dp[to]=dp[via]+board[via][to];
                }
            }
        }
        System.out.println(dp[29]);
    }
}
