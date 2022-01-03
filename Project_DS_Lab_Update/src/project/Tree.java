package project;

import java.io.Serializable;

public class Tree implements Serializable {
	private static final long serialVersionUID = 1L;
	private Node root; // first node of tree

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Tree() {
		root = null;
	}

	/**
	 * 
	 * @param id
	 * @return getting the id
	 */
	public Student find(int id) {
		Node current = root;
		if (root == null)
			return null;
		while (current.student.getId() != id) {
			if (id < current.student.getId()) // go left?
				current = current.leftChild;
			else // or go right?
				current = current.rightChild;
			if (current == null) // if no child,
				return null; // didn't find it
		}
		return current.student;
	}

	/**
	 * 
	 * @param inserting a student
	 */
	public void insert(Student s) {
		if (find(s.getId()) != null) {
			System.out.println("student Already exist");
		} else {
			Node newNode = new Node(); // make new node
			newNode.student = s; // insert data
			if (root == null)
				root = newNode;
			else { // root occupied
				Node current = root; // start at root
				Node parent;
				while (true) {
					parent = current;
					if (s.getId() < current.student.getId()) { // go left?
						current = current.leftChild;
						if (current == null) // if end of the line,
						{ // insert on left
							parent.leftChild = newNode;
							return;
						}
					} // end if go left
					else // or go right?
					{
						current = current.rightChild;
						if (current == null) // if end of the line
						{ // insert on right
							parent.rightChild = newNode;
							return;
						}
					} // end else go right
				} // end while
			} // end else not root
			if (s.getId() != 000000000)
				System.out.println("student has been successfully added");
		}
	} // end insert()

	/**
	 * 
	 * @param id
	 * @return remove student
	 */
	public boolean remove(int id) // delete node with given key
	{ // (assumes non-empty list)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.student.getId() != id) // search for node
		{
			parent = current;
			if (id < current.student.getId()) // go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			} else // or go right?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) // end of the line,
				return false; // didn't find it
		} // end while
			// found node to delete

		// if no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null; // tree is empty
			else if (isLeftChild)
				parent.leftChild = null; // disconnect
			else // from parent
				parent.rightChild = null;
		}

		// if no right child, replace with left subtree
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		// if no left child, replace with right subtree
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		else // two children, so replace with inorder successor
		{
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);

			// connect parent of current to successor instead
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		} // end else two children
			// (successor cannot have a left child)
		return true; // success
	} // end delete()

	/**
	 * 
	 * @param delNode
	 * @return
	 */
	public Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while (current != null) // until no more
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if (successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/**
	 * 
	 * @param localRoot
	 */
	public void preOrder(Node localRoot) {// root left right
		if (localRoot != null) {
			System.out.print(localRoot.student);
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * 
	 * @param localRoot
	 */
	public void inOrder(Node localRoot) {// left root right
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.student);
			inOrder(localRoot.rightChild);
		}
	}

}
