package vn.io.tunaa.dsa.exam_2526_1st_midterm_2.ex1__tree_min_leaf_value_and_count_nodes_at_level;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * Tìm giá trị của nút lá có giá trị nhỏ nhất.
     *
     * @param root nút gốc của cây nhị phân
     * @return giá trị nút lá nhỏ nhất
     */
    public int minLeafValue(Node root) {
        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (root.left == null) {
            return minLeafValue(root.right);
        }

        if (root.right == null) {
            return minLeafValue(root.left);
        }

        return Math.min(
                minLeafValue(root.left),
                minLeafValue(root.right)
        );
    }

    /**
     * Đếm số nút nằm ở tầng thứ level trong cây nhị phân.
     *
     * @param root nút gốc của cây nhị phân
     * @param level tầng cần đếm số nút (bắt đầu từ 1 cho tầng gốc)
     * @return số nút ở tầng thứ level; nếu level vượt quá chiều cao cây thì trả về 0
     */
    public int countNodesAtLevel(Node root, int level) {	 	  	 		      	     		   	       	 	
        int currentLevel = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && level != currentLevel) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                if (node != null) {
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

        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count += 1;
        }

        return count;
    }
}
	 	  	 		      	     		   	       	 	
