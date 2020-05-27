import java.util.ArrayList;
import java.util.Scanner;

public class Divisibilitytree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        // dpmaker();
        while (c-- > 0) {

            int n = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<Integer>aal[]=new ArrayList[n];
            for(int i=0;i<n;i++){
                aal[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<e;i++){
                int from=sc.nextInt()-1;
                int to=sc.nextInt()-1;
                aal[to].add(from);

            }

            greed(aal,n);
        }
    }
    static int ans;
    static void greed(ArrayList<Integer>[]aal,int n){
        ans=0;
        int val=dfs(0,aal,n);
        System.out.println(ans);


    }
    static int dfs(int parent,ArrayList<Integer>[]aal,int n){

        int val=1;//for parent itself
        ////dfs on childrens
        for(int i=0;i<aal[parent].size();i++){
            val=val+dfs(aal[parent].get(i),aal,n);
        }
        //if becomes even detach it and return 0
        if(val%2==0 && val!=0 && parent!=0){
            ans++;
            val=0;
            //System.out.println("parent is "+parent+" as the parent is even "+val);
        }
      //  System.out.println("parent is "+parent+" and its value is"+val);

        return val;
    }
}
