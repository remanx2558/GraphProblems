import java.util.Scanner;

public class UnitAreaoflargestregionof1s {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m=sc.nextInt();

            int arr[][]=new int[n][m];



            for (int i = 0; i < n; i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            greed(arr,n,m);
        }
    }
    static int count;
    static int realcount;
    static void greed(int [][]arr,int n,int m){
realcount=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//        System.out.println();}



                for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count=0;


                if(arr[i][j]==1){
                    dfs(arr,n,m,i,j);
                   // System.out.println("count is "+count);

                }
            }
        }
        System.out.println(realcount);
    }
    static int xx[]={-1,0,1,-1,1,-1,0,1};
    static int yy[]={-1,-1,-1,0,0,1,1,1};

    static void dfs(int[][]arr,int n,int m,int x,int y){
        arr[x][y]=-1;
        count++;
        if(count>realcount){
            realcount=count;
        }
      //  System.out.println("x:"+x+" y:"+y+" count"+count);
        ////////dfs in 8 direction
        for(int i=0;i<xx.length;i++){
            int xnew=xx[i]+x;
            int ynew=yy[i]+y;
          //  System.out.println("xnew is "+xnew+" ynew is "+ynew);
            if(xnew>=0 && xnew<n && ynew>=0 && ynew<m && arr[xnew][ynew]==1){
                dfs(arr,n,m,xnew,ynew);
            }
        }

    }
}
