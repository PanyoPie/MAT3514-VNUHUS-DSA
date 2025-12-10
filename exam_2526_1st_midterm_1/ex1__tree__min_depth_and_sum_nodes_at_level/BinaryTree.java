package vn.io.tunaa.dsa.exam_2526_1st_midterm_1.ex1__tree__min_depth_and_sum_nodes_at_level;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * Tính độ dài nhỏ nhất từ nút gốc (root) đến một nút lá của một cây nhị phân.
     *
     * @param root nút gốc của cây nhị phân
     * @return độ dài nhỏ nhất từ nút gốc (root) đến một nút lá
     */
    public int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(
                minDepth(root.left),
                minDepth(root.right)
        ) + 1;
    }

    /**
     * Tính tổng giá trị của tất cả các nút nằm ở tầng thứ level trong cây nhị phân.
     *
     * @param root nút gốc của cây nhị phân
     * @param level tầng cần tính tổng (bắt đầu từ 1 cho tầng gốc)
     * @return tổng giá trị của các nút ở tầng level, nếu level vượt quá chiều cao cây thì trả về 0
     */
    public int sumNodesAtLevel(Node root, int level) {	 	  	 		      	     		   	       	 	
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

        int sum = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            sum += node.data;
        }

        return sum;
    }

    public static void main(String[] args) {
        Node root = new Node(67);

        root.left = new Node(35);
        root.left.left = new Node(31);
        root.left.right = new Node(33);
        root.left.left.left = new Node(18);
        root.left.left.right = new Node(24);

        root.right = new Node(37);
        root.right.left = new Node(36);
        root.right.right = new Node(69);
        root.right.right.right = new Node(10);

        System.out.println((new BinaryTree()).minDepth(root));
        System.out.println((new BinaryTree()).sumNodesAtLevel(root, 1));
        System.out.println((new BinaryTree()).sumNodesAtLevel(root, 2));
        System.out.println((new BinaryTree()).sumNodesAtLevel(root, 3));
        System.out.println((new BinaryTree()).sumNodesAtLevel(root, 4));
    }	 	  	 		      	     		   	       	 	
}
