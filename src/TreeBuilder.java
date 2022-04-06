/**
 * This class is used to create the binary trees for the program.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date April 3rd 2022
 */

public class TreeBuilder<T> {

	 
	/** 
	 * Takes in a T array input parameter which contains the set of values that will be inserted in the new trees nodes.
	 * @param data contains the set of values for the tree.
	 * @return completed tree.
	 */
	public LinkedBinaryTree<T> buildTree(T[] data) {
		 
		// initialize queues.
		LinkedQueue<T> dataQueue = new LinkedQueue<>();
		LinkedQueue<BinaryTreeNode<T>> parentQueue = new LinkedQueue<>();
		
		// put elements of T array into dataQueue.
		for (int i = 0; i < data.length; i++) {
			dataQueue.enqueue(data[i]);
		}
		
		// create LinkedBinaryTree object.
		LinkedBinaryTree<T> tree;
		
		// set root node as the first element of dataQueue.
		tree = new LinkedBinaryTree<>(dataQueue.dequeue());
		
		// enqueue the root node on parentQueue.
		parentQueue.enqueue(tree.getRoot());
		
		while (!dataQueue.isEmpty()) {
			
			// declare left and right nodes.
			BinaryTreeNode<T> a = new BinaryTreeNode<>(dataQueue.dequeue());
			BinaryTreeNode<T> b = new BinaryTreeNode<>(dataQueue.dequeue());
			
			// decare parent node.
			BinaryTreeNode<T> parent = parentQueue.dequeue();
				
			// check to see if left node is null.
			if (a.getData() != null) {
				
				// set left node as a value.
				parent.setLeft(a);
				// add parent node back to queue.
				parentQueue.enqueue(a);
			}
			
			// check to see if right node is null.
			if (b.getData() != null) {
				
				// set right node as b value.
				parent.setRight(b);
				// add parent node back to queue.
				parentQueue.enqueue(b);
			}			
		}
		 
		// return built tree.
		return tree;
		
	}
	
	
	
	
	// TEST HARNESS...
	
//	public static void main(String[] args) {
//	
//		int[] data = {1, 1, 1};
//		LinkedQueue dataQueue = new LinkedQueue<>();
//		for (int i = 0; i < data.length; i++) {
//			dataQueue.enqueue(data[i]);
//			
//		}
//		for (int i = 0; i < data.length; i++) {
//			System.out.println(dataQueue.toString());
//		}
//	}
}
