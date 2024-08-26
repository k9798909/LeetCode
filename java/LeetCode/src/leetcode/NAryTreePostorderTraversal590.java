package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of an n-ary tree, return the postorder traversal of its nodes'
 * values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 */
public class NAryTreePostorderTraversal590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(Node root,List<Integer> result) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            postorder(node,result);
        }
        
        result.add(root.val);
    }

}
