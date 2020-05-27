import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordBoggle {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int d = sc.nextInt();
            String str[]=new String[d];

            for (int i = 0; i < d; i++) {str[i]=sc.next();}
            int n = sc.nextInt();
            int m = sc.nextInt();

            char mat[][]=new char[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                   mat[i][j] = sc.next().charAt(0);
            greed(mat,n,m,str);
        }
    }
    static void greed(char [][]boggler,int l,int m,String []dic){
//        for(int i=0;i<l;i++){
//            for(int j=0;j<m;j++){
//                System.out.println(boggler[i][j]+" ");
//            }
//            System.out.println();
//        }

        ArrayList<String> al=new ArrayList<String>();
        HashMap<String,Integer>hm=new HashMap<String, Integer>();
        for(int i=0;i<dic.length;i++){
            String str=dic[i];
            if(checker(str,boggler,l,m)){
                //smain=smain+str+" ";
                if(!hm.containsKey(str)){
                    hm.put(str,-1);
                    al.add(str);
                }

            }
        }
        Collections.sort(al);
        if(al.size()<1){
            System.out.print("-1");
        }else {
            for(int i=0;i<al.size();i++){
                System.out.print(al.get(i)+" ");
            }}
        System.out.println();
    }
    static boolean checker(String str,char[][] boo,int l,int m){

        boolean visited[][]=new boolean[l][m];
        boolean b=false;
                for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                if(dfs(0,str,l,m,boo,i,j,visited)==true){
                    b=true;
                  //  System.out.println("found a word "+str);
                }
            }

        }

        return b;
    }
    static boolean dfs(int index,String str,int l,int m,char[][]boo,int x,int y,boolean[][]visited){
        boolean b=false;

        if(boo[x][y]!=str.charAt(index)){
            return false;
        }
        //////check in 4 direction
        if(index>=str.length()){
            return false;
        }
        if(index==str.length()-1 && boo[x][y]==str.charAt(index)){
            return true;
        }
      //  System.out.println("x"+x+" y"+y+" booc:"+boo[x][y]+" strc:"+str.charAt(index));


        visited[x][y]=true;

        /////////////
        //up
        if(x+1<l && !visited[x+1][y] && dfs(index+1,str,l,m,boo,x+1,y,visited)){
            b=true;
        }
        //down
        if(x-1>=0 && !visited[x-1][y] &&dfs(index+1,str,l,m,boo,x-1,y,visited)){
            b=true;
        }
        //left
        if(y+1<m && !visited[x][y+1] &&dfs(index+1,str,l,m,boo,x,y+1,visited)){
            b=true;
        }
        //right
        if(y-1>=0 && !visited[x][y-1] &&dfs(index+1,str,l,m,boo,x,y-1,visited)){
            b=true;
        }

        ////////////////
        //up-left
        if(x+1<l && y+1<m &&!visited[x+1][y+1] && dfs(index+1,str,l,m,boo,x+1,y+1,visited)){
            b=true;
        }
        //down-left
        if(x-1>=0  && y+1<m && !visited[x-1][y+1] && dfs(index+1,str,l,m,boo,x-1,y+1,visited)){
            b=true;
        }
        //up-right
        if(y-1>=0  && x+1<l && !visited[x+1][y-1] &&dfs(index+1,str,l,m,boo,x+1,y-1,visited)){
            b=true;
        }
        //down ri
        if(y-1>=0 && x-1>=0 && !visited[x-1][y-1] &&dfs(index+1,str,l,m,boo,x-1,y-1,visited)){
            b=true;
        }
        /////
        visited[x][y]=false;
        return b;

    }
}
