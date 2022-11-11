/* Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
Input: head = [1,2,3,4]
Output: [2,1,4,3]*/

public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        // Point the next of dummy node to the head
        dummy.next = head;
        // This node will be used to traverse the list
        ListNode current = dummy;
        // Loop until we reach to the second last node
        while (current.next != null && current.next.next != null) {
            // First node of the pair
            ListNode first = current.next;
            // Second node of the pair
            ListNode second = current.next.next;
            // Point the next of first node to the node after second node
            first.next = second.next;
            // Now the current node's next should be the second node
            current.next = second;
            // Linking the original second node to the first node
            current.next.next = first;
            // Move the pointer two nodes ahead
            current = current.next.next;
        }
        return dummy.next;
        
    }
