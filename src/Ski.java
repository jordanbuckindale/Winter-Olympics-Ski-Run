/**
 * This class is the heart of the program in which the skier will go down the hill one step at a time based on the requirements explained in the Introduction.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date April 3rd 2022
 */

public class Ski<T> {

	/**
	 *  declares root node of tree.
	 */
	private BinaryTreeNode<SkiSegment> root;
	
	
	/**
	 * Takes in a String array with data about the node types. 
	 * @param data
	 */
	public Ski(String[] data) {
		
		// create array.
		SkiSegment[] segments;
		
		// initialize array.
		segments = new SkiSegment[data.length];
		
		// begin iterating through the array to copy data.
		for (int i = 0; i < data.length; i++) {
			
			// check to see if data[i] contains the jump.
			if (data[i].contains("jump")) {
				
				// create jump object. 
				JumpSegment jumpObj = new JumpSegment(String.valueOf(i), data[i]);
				
				// assign object to position in array.
				segments[i] = jumpObj;
			}
			
			// check to see if data[i] contains slalom.
			if (data[i].contains("slalom")) {
				
				// create slalom object. 
				SlalomSegment SlalomObj = new SlalomSegment(String.valueOf(i), data[i]);
				
				// assign object to position in array.
				segments[i] = SlalomObj;
			}
			
			else {
				
				// create plain ski object. 
				SkiSegment skiObj = new SkiSegment(String.valueOf(i), data[i]);
				
				// assign object to position in array.
				segments[i] = skiObj;
			}
		}
		
		// create tree object to start constructing slope.
		TreeBuilder<SkiSegment> tree;
		
		// initialize tree.
		tree = new TreeBuilder<>();
				
		// construct the tree with data in the array 'segements'.
		tree.buildTree(segments);
		
		// store root in instance variable root.
		this.root.getData();
	}
	
	/**
	 * Public method that returns the trees root node.
	 * @return tree's root node.
	 */
	public BinaryTreeNode<SkiSegment> getRoot() {
		 
		// return root.
		return this.root;
	}
	
	/**
	 * Public method that stores in a parameter node the sequence of the slope run so the whole path is recorded.
	 * @param node 
	 * @param sequence 
	 */
	public void skiNextSegment (BinaryTreeNode<SkiSegment> node, ArrayUnorderedList<SkiSegment> sequence) {
		
		// add data stored in parameter node to the end of the sequence so the whole path is recorded.
		sequence.addToRear(node.getData());
		
		// create child nodes that will be searched.
		BinaryTreeNode<SkiSegment> left = node.getLeft();
		BinaryTreeNode<SkiSegment> right = node.getRight();
		
		// if the left node is empty, then use right node.
		if (left == null && right != null) {
			skiNextSegment(right, sequence);
		}
		
		// if the right node is empty, then use left node.
		if (right == null && left != null) {
			skiNextSegment(left, sequence);
		}
		
		// if they both are not empty, evaluate the nodes.
		else {
			
			
		}
	}
}
