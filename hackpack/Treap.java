import java.util.*;

class Node {
    int value;
    int key;
    Node left = null;
    Node right = null;

    public Node(int value) {
        this.value = value;
        this.key = (int) (Math.random() * (int)(1e9));
    }

    public Node(int value, int key) {
        this.value = value;
        this.key = key;
    }
}

public class Treap {

    public final int oo = Integer.MAX_VALUE;
    Node treapRoot;

    /*
        Performs a right rotation of a givenn subtree's root. 
        A right rotation consists of the following

            Let R be the given subtree root
			r						L
		   / \	 Right Rotation    / \
		  L   R	 –------->	      X   r
		 / \						 / \
		X   Y						Y   R
          
        @returns the new subtree root
    */
    private Node rightRotation(Node root) {
        Node L = root.left;
        Node X = L.right;

        L.right = root;
        root.left = X;

        return L;
    }

    /*
        Performs a left rotation of a givenn subtree's root. 
        A left rotation consists of the following

        Let r be the given subtree root
		  r						   R
		 / \	  Left Rotation	  / \
		L   R	  –------>	     r   Y
		   / \				    / \
          X   Y				   L   X
        
        @returns the new subtree root
    */
    private Node leftRotation(Node root) {
        Node R = root.right;
        Node Y = R.left;

        R.left = root;
        root.right = Y;

        return R;
    }

    /*
     * Inserts a given value into a treap, modifying it's structure if needed
     * 
     * @returns the new root of the treap after insertio
     */
    public Node insert(int value) {
        return treapRoot = insert(treapRoot, value);
    }

    public Node insert(Node root, int value) {
        // Base Case: We found an empty spot where we can insert
        if (root == null)
            return new Node(value);

        // Our current root is greater than the value given, so go left
        if (root.value > value) {
            root.left = insert(root.left, value);

            // If we violated heap priority, rotations are needed
            if (root.left != null && root.left.key > root.key)
                root = rightRotation(root);
        }

        // Our current root is less than the value given, so go right
        else {
            root.right = insert(root.right, value);

            // If we violated heap priority, rotations are needed
            if (root.right != null && root.right.key > root.key)
                root = leftRotation(root);
        }

        return root;
    }

    /*
     * Searches through a treap to see if a given value exists. If the value does
     * exists, removes it from the tree. Otherwise, do nothing.
     * 
     * @returns the new root of the treap after deletion
     */
    public Node delete(int value) {
        return treapRoot = delete(treapRoot, value);
    }

    public Node delete(Node root, int value) {
        // Base Case: Value not found in treap
        if (root == null)
            return null;

        // Our current root is greater than the value we are searchign for, go left
        if (root.value > value)
            root.left = delete(root.left, value);

        // Our current root is less than the value we are searching for, so go right
        else if (root.value < value)
            root.right = delete(root.right, value);

        // We found the value we are searching for
        else {
            // Case 1: Node to be deleted has no children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2: Node to be deleted has one child
            else if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
                root = (root.left != null) ? root.left : root.right;
            }

            // Case 3: Node to be deleted has two children
            else if (root.left != null && root.right != null) {
                // Left child has higher priority than right child
                if (root.left.key < root.right.key) {
                    root = leftRotation(root);
                    root.left = delete(root.left, value);
                }
                // Right child has greater-than/equal priority than left child
                else {
                    root = rightRotation(root);
                    root.right = delete(root.right, value);
                }
            }
        }

        return root;
    }

    /*
     * Searches through a treap to see if a given value exists
     * 
     * @returns The node containing the value if found, null otherwise
     */
    public Node search(int value) {
        Node root = treapRoot;

        while (root != null) {
            // Our current root is greater than the value we are searchign for, go left
            if (root.value > value)
                root = root.left;

            // Our current root is less than the value we are searching for, so go right
            else if (root.value < value)
                root = root.right;

            // We found the value we are searching for
            else
                return root;
        }

        // If we made it down here, we did not find our value in the treap
        return null;
    }

    /*
     * Splits a treap into two sets of data, returning the root of a dummy node.
     * 
     * @returns The new root of the subtree, which is a dummy node. 
     *          The left child of the node is a set X1, the right child is a set X2
     */
    private Node split(Node root) {
        return root = insert(root, oo);
    }

    /*
        Joins two sets into one by merging the two children of a dummy root node

        @returns The new root of the subtree
    */
    private Node join(Node root) {
        return delete(treapRoot, root.value);
    }

    /*
        Performs a preorder of the entire tree, printing out values as you traverse
    */
    public void preorder() {
        if (treapRoot == null)
            return;

        ArrayDeque<Node> s = new ArrayDeque<>();
        s.offer(treapRoot);

        while (!s.isEmpty()) {
            Node cur = s.pollLast();
            System.out.print(cur.value + " ");

            if (cur.right != null)
                s.offer(cur.right);
            if (cur.left != null)
                s.offer(cur.left);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
    }
}