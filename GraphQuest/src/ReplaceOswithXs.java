import java.util.Scanner;

public class ReplaceOswithXs {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {

            int n = sc.nextInt();
            int m=sc.nextInt();
           // String str[]=sc.next().split(" ");
            char arr[][]=new char[n][m];
            int f=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.next().charAt(0);
                            //str.charAt(f);
                   // f++;
                }
            }
            greed(arr,n,m);
        }
    }
    static void greed(char[][] arr,int n,int m){
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        ///////////////////////
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='O'){

                    //up
                    boolean up=false;
                    for(int k=i;k>=0;k--){
                        if(arr[k][j]=='X'){
                            up=true;
                        }
                    }
                    //down
                    boolean down=false;
                    for(int k=i;k<n;k++){
                        if(arr[k][j]=='X'){
                            down=true;
                        }
                    }//left
                    boolean left=false;
                    for(int k=j;k>=0;k--){
                        if(arr[i][k]=='X'){
                            left=true;
                        }
                    }//right
                    boolean right=false;
                    for(int k=j;k<m;k++){
                        if(arr[i][k]=='X'){
                            right=true;
                        }
                    }
                    if(up && left && down && right){
                        //System.out.println("got one");
                        arr[i][j]='X';
                    }


                }

            }
        }
        /////////////
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                System.out.print(arr[i][j]+" ");
            }}
        System.out.println();
                ///////////


    }
}
