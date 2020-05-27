import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Nodesatevendistance {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n-1;i++){
                int x=sc.nextInt()-1;
                int y=sc.nextInt()-1;
                arr[x][y]=1;
                arr[y][x]=1;
            }
            greed(arr,n);



        }
    }
    static int nCr(int n, int r)
    {
        if(n<2){
            return 0;
        }
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }


    static void greed(int arr[][],int n){
        int col[]=new int[n];
        boolean vi[]=new boolean[n];

        col[0]=1;
        vi[0]=true;
        for(int i=0;i<n;i++){
            int parent=col[i];
            for(int j=0;j<n;j++){
                if(vi[j]==false && arr[i][j]==1){
                    vi[j]=true;
                    if(parent==1){
                        col[j]=2;
                    }
                    else if(parent==2){
                        col[j]=1;
                    }
                    //System.out.println("parent was "+i+"  child was "+j);
                }

            }
        }
        //////////
        int even=0;
        int odd=0;

        for(int i=0;i<n;i++){
            if(col[i]==1){
                even++;
            }
            else {
                odd++;
            }
           // System.out.print(col[i]+" ");
        }
        int sum=nCr(odd,2)+nCr(even,2);
        System.out.println(sum);



    }
}
