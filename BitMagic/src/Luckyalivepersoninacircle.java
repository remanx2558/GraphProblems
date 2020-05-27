import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Luckyalivepersoninacircle {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=Integer.parseInt(br.readLine());
            method(n);
        }
    }
    static void method(int n){

    //    System.out.println("inside function");

        node root =new node(1);
        int last=1;
        node curr=root;
        for(int i=2;i<=n;i++){
            node newnode=new node(i);
            curr.next=newnode;
            curr=newnode;
           // System.out.println("created value is "+curr.val);

        }
        curr.next=root;
        ///////////////////////////

        /////////////////////////////////
        curr=root;

        while(curr.next.val!=curr.val && curr.next.next.val!=curr.val){


            if(curr.next.val==curr.next.next.val){}
            curr.next=curr.next.next;
            curr=curr.next;


            if(curr!=null){
                last=curr.val;

            }
            else if(curr.next==curr || curr.next.next==curr){break;}
        }
        System.out.println(last);
        ///////////////////////////

    }
    static class node{
        int val;
        node next;
        node(int vall){
            val=vall;
        }
    }
}
