package lab9;
import java.util.Random;

class Node {
    public int value;
    public Node left;
    public Node right;
}

class Tree {

    public Node insert(Node root, int v) {
        if (root == null) {
            root = new Node();
            root.value = v;
        } else if (v < root.value) {
            root.left = insert(root.left, v);
        } else {
            root.right = insert(root.right, v);
        }

        return root;
    }

    public void traversePre(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        traversePre(root.left);
        traversePre(root.right);
    }
    
    public void traverseIn(Node root) {
    	if(root == null) {
    		return;
    	}
    	
    	traverseIn(root.left);
    	System.out.print(root.value + " ");
    	traverseIn(root.right);
    }
    
    public void traversPost(Node root) {
    	if(root == null) {
    		return;
    	}
    	
    	traversPost(root.left);
    	traversPost(root.right);
    	System.out.print(root.value + " ");
    }
    
    public int countNodes(Node root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int countLeaves(Node root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	
    	return countLeaves(root.left) + countLeaves(root.right);
    }
    
    public Node createMirrorImage(Node root) {
    	if(root != null) {
	    	Node tmp = root.left;
	    	root.left = root.right;
	    	root.right = tmp;
	    	createMirrorImage(root.left);
	    	createMirrorImage(root.right);
    	}
    	
    	return root;
    }
}

class BinarySearchTree {
    public static void main(String[] args) {
        Node root = null;
        Tree bst = new Tree();
        root = bst.insert(root , 25);
        root = bst.insert(root , 20);
        root = bst.insert(root , 15);
        root = bst.insert(root , 23);
        root = bst.insert(root , 10);
        root = bst.insert(root , 18);
        root = bst.insert(root , 30);
        root = bst.insert(root , 28);
        root = bst.insert(root , 35);
        root = bst.insert(root , 33);
        root = bst.insert(root , 45);
        root = bst.insert(root , 29);
        root = bst.insert(root , 29);
        
        bst.traversePre(root);
        System.out.println();
        bst.traverseIn(root);
        System.out.println();
        bst.traversPost(root);
        
        System.out.println();
        int count = bst.countNodes(root);
        System.out.println("Count: " + count);
        int leaves = bst.countLeaves(root);
        System.out.println("Leaves: " + leaves);
        
        bst.createMirrorImage(root);
        bst.traverseIn(root);
//        final int SIZE = 2000000;
//        int[] a = new int[SIZE];
//
//        System.out.printf("Generating random array with %d values...%n", SIZE);
//
//        Random random = new Random();
//        long start = System.nanoTime();
//
//        for (int i = 0; i < SIZE; i++) {
//            a[i] = random.nextInt(10000);
//        }
//
//        long end = System.nanoTime();
//
//        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
//        System.out.printf("Filling the tree with %d nodes...%n", SIZE);
//
//        start = System.nanoTime();
//
//        for (int i = 0; i < SIZE; i++) {
//            root = bst.insert(root, a[i]);
//        }
//
//        end = System.nanoTime();
//
//        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
//        System.out.printf("Traversing all %d nodes in tree...%n", SIZE);
//
//        start = System.nanoTime();
//
//        bst.traverse(root);
//
//        end = System.nanoTime();
//
//        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
    }
}