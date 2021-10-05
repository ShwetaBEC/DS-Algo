package datastructures;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int value;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
		this.left = this.right = null;
	}
}

class Tree{
	
	Node root;
	int maxLevel = 0;
	
	Tree(){
		this.root = null;
	}
	
	public void insert(int value) {
		this.root = insertRecursively(this.root, value);
	}
	
	public Node insertRecursively(Node root, int value) {
		
		if(root == null) {
			root = new Node(value);
			return root;
		}
		if(value < root.value) {
			root.left = insertRecursively(root.left, value);
		}else {
			root.right = insertRecursively(root.right, value);
		}
		
		return root;
	}
	
	public void lookup(int value) {
		
	}
	
	public int height(Node root) {
      	// Write your code here.
          if(root == null){
              return 0;
          }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
	
	public void traverseRecursively(Node root) {
	/**
	 * In-order traversal
	 */
		if(root == null)
			return;
		
		traverseRecursively(root.left);
		System.out.print(root.value+ " ");
		traverseRecursively(root.right);
		
	}
	
	public void preOrderTraversal(Node root) {
		/**
		 * In-order traversal
		 */
			if(root == null)
				return;
			
			System.out.print(root.value + " ");
			
			traverseRecursively(root.left);
			traverseRecursively(root.right);
			
		}
	
	public void levelOrderTraversal(Node node) {
		/**
		 * In-order traversal
		 */
			Queue<Node> q = new LinkedList<Node>();
			
			/*
			 * if(node == null) { return; }
			 */
			
			q.add(node);
			
			while(!q.isEmpty()) {
				
				Node n = q.peek();
				System.out.print(n.value+ " ");
				q.remove();
				
				if(n.left != null) {
					q.add(n.left);
				}
				
				if(n.right != null) {
					q.add(n.right);
				}
			}
		}
	
	public void leftView(Node node) {
		maxLevel = 0;
		leftView(node, 1);
	}
	
	public void leftView(Node node, int level) {
		
		if(node == null) 
			return;
		
		 if(level > maxLevel) {
			 System.out.print(node.value + " ");
			 maxLevel = level;
		 }
		 
		 leftView(node.left, level +1);
		 leftView(node.right, level + 1);
			
		}
	
	public void rightView(Node root) {
		maxLevel = 0;
		rightView(root, 1);
	}
	
	public void rightView(Node node, int level) {
		
		if(node == null)
			return;
		
		if(level > maxLevel) {
			System.out.print(node.value + " ");
			maxLevel = level;
		}
		
		rightView(node.right, level +1);
		rightView(node.left, level +1);
	}
	
	public int sum(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		return Math.max(sum(root.left), sum(root.right)) + root.value;
	}
	
	public void remove(Node root, int val) {
		
		if (root != null) {
			
			Node parentNode = null;
			Node currentNode = root;
			
			while(currentNode != null) {
				
				if(val < currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.left;
				}else if(val > currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.right;
				}else {
					if(currentNode.right == null) {
						
						if(parentNode == null) {
							this.root = currentNode.left;
							//this.root.right = currentNode.right;
						}
						
						parentNode.right = currentNode.left;
						currentNode.left = null; //Deleted node
					}else if(currentNode.left == null) {
						
						if(parentNode == null) {
							this.root = currentNode.right;
							//this.root.left = currentNode.left;
						}
						
						parentNode.right = currentNode.right;
						currentNode.right = null; //Deleted node
					}else {
						
						//Get leftmost node of right subtree
						Node m = null;
						Node n = currentNode.right;
						while(n.left != null) {
							m = n;
							n = n.left;
						}
						
						m = null;
						
						n.left = currentNode.left;
						n.right = currentNode.right;
						currentNode = null;
						
						parentNode.right = n;
					}
				}
			}
		}
	}
	
	boolean isBST(Node root)
    {
        
        if(root == null){
            return true;
        }
        
        /*if(root.left == null){
            return isBST(root.right);
        }
        
        if(root.right == null){
            return isBST(root.left);
        }*/
        
        if(root.left != null && root.left.value >= root.value){
            return false;
        }
        
       
        
        if(root.right != null && root.right.value <= root.value){
            return false;
        }
        
        if(isBST(root.left) && isBST(root.right)){
            return true;
        }
        
        return false;
        
    }
	
	void mirror(Node node) {
        // Your code here
        
        if(node == null){
            return;
        }
        
        mirror(node.left);
        mirror(node.right);
        
        Node t = node.left;
        node.left = node.right;
        node.right = t;
        
    }
	
	public static boolean isSymmetric(Node root)
    {
        // add your code here;
        
        return mirror(root, root);
        
    }
    
    public static boolean mirror(Node node1, Node node2) {
        // Your code here
        
        if(node1 == null && node2 == null){
            return true;
        }
        
        if(node1 != null && node2 != null && node1.value == node2.value){
            return mirror(node1.left, node2.right) && mirror(node1.right, node2.left);

        }
        
        return false;
        
    }
	
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    if((root1 == null && root2 != null) || (root2 == null && root1 != null)){
	        return false;
	    }
	    
	    if(root1 == null && root2 == null){
	        return true;
	    }
	    
	    if(root1.value != root2.value){
	        return false;
	    }
	    
	    return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));

	}

	/*
	 * private void insertIteratively(int value) { if(root == null) { root = new
	 * Node(value); }else { Node currentNode = root; while(true) { if(value <
	 * currentNode.value) { if(currentNode.left == null) { currentNode.left = new
	 * Node(value); } currentNode = currentNode.left; }else { if(currentNode.right
	 * == null) { currentNode.right = new Node(value); } currentNode =
	 * currentNode.right; } } } }
	 * private void traverseIteratively(Node root) { Node currentNode = root;
	 * 
	 * while(currentNode != null) { if(currentNode.left == null) {
	 * System.out.println(currentNode.value); }else if(currentNode.left != null){
	 * currentNode = currentNode.left; } } }
	 * 
	 * 
	 */
}

public class MyCustomTree {

	public static void main(String[] args) {
		
		Tree t = new Tree();
		t.insert(5);
		t.insert(15);
		t.insert(5);
		t.insert(3);
		t.insert(18);
		t.insert(2);
		t.insert(10);
		
		System.out.println("In Order Traversal");
		t.traverseRecursively(t.root);
		
		System.out.println("\nLevel Order Traversal");
		t.levelOrderTraversal(t.root);
		
		System.out.println("\nHeight is "+t.height(t.root));
		
		System.out.println("Left view is ");
		t.leftView(t.root);
		
		System.out.println("Right view is ");
		t.rightView(t.root);
		
		System.out.println("\nTree path having max sum is "+t.sum(t.root));
		
		t.isBST(t.root);
	}
}
