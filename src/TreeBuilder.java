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
		for (int i = 0; i <= data.length; i++) {
			dataQueue.enqueue(data[i]);
		}
		
		// create LinkedBinaryTree object.
		LinkedBinaryTree<T> tree;
		
		// set root node as the first element of dataQueue.
		tree = new LinkedBinaryTree<>(dataQueue.dequeue());
		
		// enqueue the root node on parentQueue.
		parentQueue.enqueue(tree.getRoot());
		
		
		 
		return null;
		
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
