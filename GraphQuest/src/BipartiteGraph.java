import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();


            int arr[][]=new int[n][n];



            for (int i = 0; i < n; i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            System.out.println(greed(arr,n));
        }
    }

    static boolean greed(int[][]arr,int n){

        int curr[]=new int[n];
        Arrays.fill(curr,-1);
        boolean b=true;
        curr[0]=1;
        /////////////get first node


                //////////////
        for(int i=0;i<n;i++){
            ///parent has color

            ///parent do not have color
            if(curr[i]==-1){
                curr[i]=1;
            }
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    //unvisited
                    if(curr[j]==-1){
                        curr[j]=(curr[i]==1)?0:1;
                    }
                    else if(curr[j]==curr[i]){
                        b=false;
                    }
                }
            }
        }
        if(b){
            return true;
        }
        else {
            return false;
        }


//        boolean b=false;
//        node[] mat=new node[n];
//        for(int i=0;i<n;i++){
//            mat[i]=new node();
//            mat[i].index=i;
//        }
//
//
//        boolean visited[]=new boolean[n];
//        Queue<node> q=new LinkedList<node>();
//
//        mat[0].col=1;
//        q.add(mat[0]);
//        visited[0]=true;
//        while(!q.isEmpty()){
//            node curr=q.poll();
//            int i=curr.index;
//            for(int j=0;j<n;j++){
//                if(arr[i][j]==1){
//                    ////if unvisited
//                    if(mat[j].col==-1){
//                        if(curr.col==1){
//                            mat[j].col=0;
//                        }
//                        else if(curr.col==0){
//                            mat[j].col=1;
//                        }
//                        q.add(mat[j]);
//
//                    }
//                    else if(mat[j].col==curr.col){
//                        continue;
//                    }
//                    else {
//                        b=true;
//                        break;
//                    }
//
//
//                }
//            }
//
//
//        }
//        if(b){
//            System.out.println("1");
//        }
//        else {
//            System.out.println("0");
//        }
//

    }
}
