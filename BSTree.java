package HW;

import java.util.*;

/*
1. generate 100 random integers from 1-99
2. store them in a linkedlist
3. build a binary tree of this linked list
4. make a recursive method to display the data
*/

//node class
class Node {
	
	Node left, right;
	int data;
	
	//constructor
	public Node(int n) {
		
		left = null;
		right = null;
		data = n;
	}
}

public class BSTree {

	private Node root;
	
	//constructor
	public BSTree() {
		
		root = null;
	}

	//insert data in tree
	public void insert(int data) {
		
		root = insert(root, data);
	}
	
	//inserts data recursively
	public Node insert(Node node, int data) {
		
		if (node == null)
			node = new Node(data);
		else {
			
			if (data <=node.data)
				
				 node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        
		return node;
    }
   
	/* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }
   
    private void inorder(Node r) {
        
    	if (r != null) {
    		
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    
    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }
   
    private void preorder(Node r) {
        
    	if (r != null) {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    
    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }
    
    private void postorder(Node r) {
        
    	if (r != null)  {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }
	public static void main (String[]args) {
		
		Random random = new Random();
		int[] array = new int[100];
		
		System.out.println("Random list: ");
		
		for (int i = 0; i < 100; i++ ) {
			
			array[i] = random.nextInt(99);
			System.out.print(array[i]+" ");
		}
	
		BSTree a = new BSTree();
		for (int i = 0; i < 100; i++) {
			
			a.insert(array[i]);
		}
		System.out.println();
		System.out.println("inorder list: ");
		a.inorder();
	}
	
}
