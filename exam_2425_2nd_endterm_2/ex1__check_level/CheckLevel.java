package vn.io.tunaa.dsa.exam_2425_2nd_endterm_2.ex1__check_level;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"unchecked", "deprecation"})
class CheckLevel {
    public boolean isSameLevel(Node root, int val1, int val2) {
        int level1 = 0, level2 = 0, currentLevel = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        whileLoop: while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                if (node != null) {
                    if (node.value == val1) level1 = currentLevel;
                    if (node.value == val2) level2 = currentLevel;

                    if (level1 != 0 && level2 != 0) break whileLoop;

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            currentLevel++;
        }

        return level1 == level2;
    }	 	  	 		      	     		   	       	 	
}