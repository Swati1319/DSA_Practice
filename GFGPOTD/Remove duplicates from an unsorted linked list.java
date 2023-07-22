class Solution
{
    //Function to remove duplicates from unsorted linked list.
	public Node removeDuplicates(Node head)  
    { 
        //using set to store already seen values in list. 
        HashSet<Integer> hs = new HashSet<>(); 
      
        //using two pointers one of which stores first node other null.
        Node current = head; 
        Node prev = null; 
        
        //traversing over the linked list.
        while (current != null)  
        { 
            int curval = current.data; 
              
            //if data at current node is already present in set, we skip the 
            //current node and store the node next to current in link of prev. 
            if (hs.contains(curval)) { 
                prev.next = current.next;
                //deleting current node which contains duplicates. 
                current=null;
            }
            //else we just insert the data at current node in set and update 
            //prev to the current node.
            else { 
                hs.add(curval); 
                prev = current; 
            }
            //updating current to the next node of prev.
            current = prev.next; 
        } 
        return head;
    } 
}
