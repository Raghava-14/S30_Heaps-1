//Time = O(N log k), N is total number of nodes
//Space = O(k)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // If the input list of lists is null or empty, return null
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Create a PriorityQueue to store the nodes from all k lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                // Compare the values of the two nodes
                return n1.val - n2.val;
            }
        });
        
        // Add the head nodes of all k lists to the PriorityQueue
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        // Create a dummy node and a tail pointer to build the merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // Repeat until the PriorityQueue is empty
        while (!pq.isEmpty()) {
            // Take out the smallest node from the PriorityQueue
            ListNode node = pq.poll();
            // Add the node to the merged list
            tail.next = node;
            tail = node;
            // If the next node in the list exists, add it to the PriorityQueue
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        // Return the head node of the merged list
        return dummy.next;
    }
}
