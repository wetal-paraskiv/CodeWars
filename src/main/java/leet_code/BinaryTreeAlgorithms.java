package leet_code;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BinaryTreeAlgorithms {
    // https://www.youtube.com/watch?v=fAAZixBzIAI

    public static void main(String[] args) {
        Instant start = Instant.now();

        BinaryTreeAlgorithms run = new BinaryTreeAlgorithms();
        TreeNode binaryTree = run.createBinaryTree();
        TreeNode binaryTree7 = run.createBinaryTree7();
        TreeNode binaryTree3 = run.createBinaryTree3();

//        leet_code.ListNode listNode1 = new leet_code.ListNode(1);
//        leet_code.ListNode listNode2 = new leet_code.ListNode(1);
//        leet_code.ListNode listNode3 = new leet_code.ListNode(2);
//        leet_code.ListNode listNode4 = new leet_code.ListNode(2);
//        leet_code.ListNode listNode5 = new leet_code.ListNode(9);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        leetCode.deleteDuplicates(listNode1);

//        System.out.println("inOrderTraversal: " + leetCode.inOrderTraversal(binaryTree));
//        System.out.println("preOrderTraversal: " + leetCode.preOrderTraversal(binaryTree));
//        System.out.println("preOrderTraversalRecursive: " + leetCode.preOrderTraversalRecursive(binaryTree));
//        System.out.println("traversePostOrderWithoutRecursion: ");
//        leetCode.traversePostOrderWithoutRecursion(binaryTree);
//        System.out.println(leetCode.isSameTree(binaryTree, binaryTree));
//        System.out.println(leetCode.isSameTree(binaryTree, binaryTree7));
//        System.out.println(run.breadthFirstValues(binaryTree));
//        System.out.println(run.breadthFirstValues(binaryTree7));
//        int valueForSearch = 7;
//        if (run.searchForNodeValueRecursive(binaryTree, valueForSearch) != null) {
//            System.out.println(run.searchForNodeValueRecursive(binaryTree, valueForSearch).val);
//        } else System.out.println("not found!");
//        if (run.breadthSearchForNodeValue(binaryTree7, valueForSearch) != null) {
//            System.out.println(run.searchForNodeValueRecursive(binaryTree7, valueForSearch).val);
//        } else System.out.println("not found!");
//        System.out.println(run.sumOfAllNodes(binaryTree));
//        System.out.println(run.sumOfAllNodes(binaryTree7));
//        System.out.println(run.sumOfAllNodesRecursive(binaryTree));
//        System.out.println(run.sumOfAllNodesRecursive(binaryTree7));
//        System.out.println(run.minValOfTree(binaryTree7));
//        System.out.println(run.minValOfTreeRecursive(binaryTree7));
//        System.out.println(run.maxSumPathTree(binaryTree));
//        System.out.println(run.maxSumPathTree(binaryTree7));
//        System.out.println(run.maxDepth(binaryTree));
//        System.out.println(run.maxDepth(binaryTree7));
        System.out.println(run.maxDepth(binaryTree3));


        Instant finish = Instant.now();
        System.out.println("executed in: " + Duration.between(start, finish).toMillis() + " ms");

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;
        if (currNode == null || currNode.next == null)
            return head;
        else {
            while (currNode.next != null) {
                if (currNode.val == currNode.next.val)
                    currNode.next = currNode.next.next;
                else
                    currNode = currNode.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesEU(ListNode head) {
        int linkedListLength = 0;
        ListNode firstHead = head;

        // get the length of leet_code.ListNode
        while (head.next != null) {
            head = head.next;
            linkedListLength += 1;
        }

        // set the head to the start
        head = firstHead;

        for (int i = 0; i < linkedListLength; i++) {
            if (head.val == head.next.val) {

                // move to the left all nodes and delete the last one
                for (int j = i; j < linkedListLength; j++) {
                    head.val = head.next.val;
                    head = head.next;
                }
                head.next = null;
                head = firstHead;

                // set head to the pos where we stopped for moving all nodes
                for (int j = 0; j < i - 2; j++) {
                    head = head.next;
                }
            }
            head = head.next;
        }

        head = firstHead;
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        head = firstHead;
        return head;
    }

    // Binary Tree traversal Depth-first Search
    // There are three different orders for traversing a tree using DFS:
    // Preorder Traversal, Inorder Traversal, Postorder Traversal
    private TreeNode createBinaryTree() {
        TreeNode root;
        TreeNode first = new TreeNode(0);
        TreeNode secondLeft = new TreeNode(1);
        TreeNode secondRight = new TreeNode(2);
        TreeNode secondLeftLeft = new TreeNode(3);
        TreeNode secondLeftRight = new TreeNode(4);
        TreeNode secondRightLeft = new TreeNode(5);
        TreeNode secondRightRight = new TreeNode(6);
        root = first;
        first.left = secondLeft;
        first.right = secondRight;
        secondLeft.left = secondLeftLeft;
        secondLeft.right = secondLeftRight;
        secondRight.left = secondRightLeft;
        secondRight.right = secondRightRight;
        return root;
    }

    private TreeNode createBinaryTree7() {
        TreeNode root;
        TreeNode first = new TreeNode(0);
        TreeNode secondLeft = new TreeNode(1);
        TreeNode secondRight = new TreeNode(2);
        TreeNode secondLeftLeft = new TreeNode(3);
        TreeNode secondLeftRight = new TreeNode(4);
        TreeNode secondRightLeft = new TreeNode(5);
        TreeNode secondRightRight = new TreeNode(6);
        TreeNode last = new TreeNode(7);
        root = first;
        first.left = secondLeft;
        first.right = secondRight;
        secondLeft.left = secondLeftLeft;
        secondLeft.right = secondLeftRight;
        secondRight.left = secondRightLeft;
        secondRight.right = secondRightRight;
        secondRightRight.right = last;
        return root;
    }

    private TreeNode createBinaryTree3() {
        TreeNode root;
        TreeNode first = new TreeNode(1);
        TreeNode secondLeft = new TreeNode(2);
        TreeNode secondRight = new TreeNode(3);
        root = first;
        first.left = secondLeft;
        first.right = secondRight;
        return root;
    }

    // InOrder we traverse the left subtree first, then the root, then finally the right subtree.
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTech(root, list);
        return list;
    }

    public void inOrderTech(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTech(node.left, list);
            list.add(node.val);
            inOrderTech(node.right, list);
        }
    }

    // PreOrder we traverse the root first, then the left and right subtrees.
    public ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> valArrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return valArrayList;
        stack.add(root);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }
            valArrayList.add(current.val);
        }
        return valArrayList;
    }

    public List<Integer> preOrderTraversalRecursive(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        preOrderTechRecursive(node, list);
        return list;
    }

    private void preOrderTechRecursive(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preOrderTechRecursive(node.left, list);
            preOrderTechRecursive(node.right, list);
        }
    }

    // PostOrder we traverse the left and right subtree before we traverse the root.
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.val);
        }
    }

    public void traversePostOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right ||
                                       (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                System.out.print(current.val + ", ");
//                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        System.out.println("\n");
    }

    // breadth first values from binary Tree
    public List<Integer> breadthFirstValues(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return list;
    }

    public TreeNode breadthSearchForNodeValue(TreeNode node, int value) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (node == null) return null;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == value) return current;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }

    public TreeNode recursiveSearchForNodeValue(TreeNode node, int value) {
        if (node != null) {
            if (node.val == value) {
                return node;
            } else {
                TreeNode tmp = recursiveSearchForNodeValue(node.left, value);
                // if we find it at left we return it
                if (tmp != null) return tmp;
                // else we return the result of the search in the right node
                return recursiveSearchForNodeValue(node.right, value);
            }
        }
        return null;
    }

    public int sumOfAllNodes(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int sum = 0;
        if (root == null) return sum;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sum += current.val;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return sum;
    }

    public int sumOfAllNodesRecursive(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfAllNodesRecursive(root.left) + sumOfAllNodesRecursive(root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public int minValOfTree(TreeNode root) {
        int minVal = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val < minVal) minVal = current.val;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return minVal;
    }

    public int minValOfTreeRecursive(TreeNode root) {
        if (root == null) return 0;
        int rootVal = root.val;
        int minVal = Math.min(rootVal, minValOfTreeRecursive(root.left));
        return Math.min(minVal, minValOfTreeRecursive(root.right));
    }

    public int maxSumPathTree(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int maxChildPathSum = Math.max(maxSumPathTree(root.left), maxSumPathTree(root.right));
        return root.val + maxChildPathSum;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymUtil(root.left, root.right);
    }

    private boolean isSymUtil(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right ? true : false;
        }
        return (left.val == right.val) &&
               isSymUtil(left.left, right.right) &&
               isSymUtil(left.right, right.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
//        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


}
