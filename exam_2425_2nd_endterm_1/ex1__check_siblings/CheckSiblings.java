package vn.io.tunaa.dsa.exam_2425_2nd_endterm_1.ex1__check_siblings;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"unchecked", "deprecation"})
class CheckSiblings {
    public boolean areSiblings(Node root, int val1, int val2) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                if (node.left.value == val1) {
                    return node.right != null && node.right.value == val2;
                }

                queue.add(node.left);
            }

            if (node.right != null) {
                if (node.right.value == val1) {
                    return node.left != null && node.left.value == val2;
                }

                queue.add(node.right);
            }
        }

        return false;
    }
}	 	  	 		      	     		   	       	 	
