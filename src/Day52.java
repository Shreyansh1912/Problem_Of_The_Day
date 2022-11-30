//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reorderlist(Node head) {
          int n=0;

        Node curr=head;

        while(curr!=null){

            curr=curr.next;

            n++;

        }

        int half=(n+1)/2;

        curr=head;

        for(int i=0;i<half-1;i++){

            curr=curr.next;

        }

 

        // reverse second half

        Node temp=curr;

        curr=curr.next;

        temp.next=null;

        

        Node prev=null;

        while(curr!=null){

            Node next=curr.next;

            curr.next=prev;

            prev=curr;

            curr=next;

        }
//creating new List by combining 2 halfs

        Node newHead=prev;

        curr=head;

        while(curr!=null && newHead!=null){

            Node next=curr.next;

            curr.next=newHead;

            curr=curr.next;

            newHead=next;

        }

        return head;

    }

}
