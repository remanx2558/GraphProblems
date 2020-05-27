import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumXORsubset {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();
        //Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            //Integer.parseInt(br.readLine());
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            greed(arr);
            // System.out.println(sumXOR(arr,arr.length));
        }
    }
    static void greed(int []arr){
        //////////////find max
        int max=Integer.MIN_VALUE;
        int indx=-1;


        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                indx=i;
            }
          //  System.out.println(Integer.toString(arr[i],2));
        }
        ///////////
        ArrayList<Integer>[]keeper=new ArrayList[Integer.toString(max,2).length()+1];

      //  Arrays.fill(keeper,new ArrayList<Integer>());

        for(int i=0;i<arr.length;i++){

            indx=Integer.toString(arr[i],2).length();
//            if(keeper[indx]>arr[i]){
//                keeper[indx]=arr[i];
//            }
            if(keeper[indx]==null){
                keeper[indx]=new ArrayList<Integer>();
                keeper[indx].add(arr[i]);
            }
            else{
                keeper[indx].add(arr[i]);
            }


        }
        /////////////
//        for(int i=0;i<keeper.length;i++){
//            System.out.print(keeper[i]+" ");
//        }

        //////////
        String str=Integer.toString(max,2);

        System.out.println("max is "+max+" with str is "+str);


        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){

                int posArr=str.length()-i;

//
//                System.out.println("found 0 at pos "+posArr+" cure that with "+keeper[posArr]);
//                if(keeper[posArr]!=10001){
//                    max=max^keeper[posArr];
//                    str=Integer.toString(max,2);
//                    System.out.println("new str is "+str+" max value is "+max);
//                }
                if(keeper[posArr]==null){
                    return;
                }else {
                    int size=keeper[posArr].size();
                    int sudomax=max;
                    for(int j=0;j<size;j++){
                        int val=keeper[posArr].get(j);
                        int ll=max^val;
                        if(ll>sudomax){}
                    }

                }

            }
        }
    }
}
