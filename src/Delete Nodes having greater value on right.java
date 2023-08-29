//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        Node h = null;
        Node p = null;
        Node curr1 = head;
        Node curr2 = head;
        while(curr1!=null) {
            int data = curr1.data;
            curr2 = curr1.next;
            boolean flag = true;
            while(curr2!=null) {
                if(curr2.data>curr1.data) {
                    flag = false;
                    break;
                }
                curr2 = curr2.next;
            }
            if(flag == true) {
                if(h == null) {
                    Node ele = new Node(curr1.data);
                    h = ele;
                    p = ele;
                } else {
                    Node ele = new Node(curr1.data);
                    p.next = ele;
                    p = p.next;
                }
            }
            curr1= curr1.next;
        }
        return h;
    }
}
  
