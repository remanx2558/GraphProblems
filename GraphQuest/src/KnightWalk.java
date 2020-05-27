import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightWalk {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m=sc.nextInt();
            int x1=sc.nextInt()-1;
            int y1=sc.nextInt()-1;
            int x2=sc.nextInt()-1;
            int y2=sc.nextInt()-1;

            greed(n,m,x1,y1,x2,y2);
        }
    }
   static int xx[]={-2,-1,1,2,-2,-1,1,2};
    static int yy[]={-1,-2,-2,-1,1,2,2,1};
    static class node{
        int x;
        int y;
        int dis;
        node(int xxx,int yyy){
            x=xxx;
            y=yyy;
        }
    }
    static void greed(int n,int m,int x1,int y1,int x2,int y2){

        Queue<node> a=new LinkedList<node>();
        node start=new node(x1,y1);
        start.dis=0;
        a.add(start);

        //////////
        boolean b[][]=new boolean[n][m];
        b[x1][y1]=true;
//////////////////////////
        int mindis=Integer.MAX_VALUE;
        //////////////////
        while(!a.isEmpty()){
            node curr=a.poll();


            if(curr.x==x2 && curr.y==y2){
                if(curr.dis<mindis){
                    mindis=curr.dis;
                }
            }
            ///////////////
            b[curr.x][curr.y]=true;
            /////////////////
            for(int i=0;i<xx.length;i++){
                int xnew=curr.x+xx[i];
                int ynew=curr.y+yy[i];
                if(xnew>=0 && xnew<n && ynew>=0 && ynew<m && !b[xnew][ynew]){
                   b[xnew][ynew]=true;
                    node newnode=new node(xnew,ynew);
                    newnode.dis=curr.dis+1;
                    a.add(newnode);
                }
            }

            ///////////////////
        }

        if(mindis>500000){
            System.out.println("-1");
        }
        else{

            System.out.println(mindis);

        }//        int board[][]=new int[n][m];
//        for(int i=0;i<30;i++){
//            for(int j=0;j<30;j++){
//                board[i][j]=1100;
//            }
//        }
//        ///////////////////
//
//
//
//        for(int i=0;i<30;i++){
//            if(i+1<30){board[i][i+1]=1;}
//            if(i+2<30){board[i][i+2]=1;}if(i+3<30){board[i][i+3]=1;}if(i+4<30){board[i][i+4]=1;}
//            if(i+5<30){board[i][i+5]=1;}if(i+6<30){board[i][i+6]=1;}
//            board[i][i]=0;
//        }
//        ////////
//        for(int i=0;i<arr.length;i=i+2){
//            int from=arr[i]-1;
//            int to=arr[i+1]-1;
//            board[from][to]=0;
//        }
//        ////////////////////////board given
//        boss(board);
//
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
    }}
