// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]


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
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    // Helper method to deserialize a string to a linked list
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] parts = data.substring(1, data.length() - 1).split(",");
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }
        return dummyHead.next;
    }

    // Helper method to serialize a linked list to a string (for testing)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to keep the head of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        int carry = 0;
        
        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Sum the values of the two nodes and the carry
            int sum = x + y + carry;
            
            // Update the carry for the next iteration
            carry = sum / 10;
            
            // Create a new node with the digit value (sum % 10)
            current.next = new ListNode(sum % 10);
            
            // Move to the next node in the result list
            current = current.next;
            
            // Move to the next nodes in l1 and l2 if they are not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If there is a carry left after the final addition, add a new node with the carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // Return the next node of the dummy node which is the head of the result list
        return dummyHead.next;
    }
}

// Test the solution
public class AddTwoNumbers {
    public static void main(String[] args) {
        // Create test cases
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");
        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);
        System.out.println(result.toString()); // Expected output: [7,0,8]
        
        l1 = ListNode.deserialize("[0]");
        l2 = ListNode.deserialize("[0]");
        result = sol.addTwoNumbers(l1, l2);
        System.out.println(result.toString()); // Expected output: [0]
        
        l1 = ListNode.deserialize("[9,9,9,9,9,9,9]");
        l2 = ListNode.deserialize("[9,9,9,9]");
        result = sol.addTwoNumbers(l1, l2);
        System.out.println(result.toString()); // Expected output: [8,9,9,9,0,0,0,1]
    }
}
