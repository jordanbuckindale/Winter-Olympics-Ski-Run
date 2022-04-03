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
				JumpSegment jumpObj = new JumpSegment(String.valueOf(i),data[i]);
				
				// assign object to position in array.
				segments[i] = jumpObj;
			}
			
			// check to see if data[i] contains slalom.
			if (data[i].contains("slalom")) {
				
				// create slalom object. 
				SlalomSegment SlalomObj = new SlalomSegment(String.valueOf(i),data[i]);
				
				// assign object to position in array.
				segments[i] = SlalomObj;
			}
			
			else {
				
				// create plain ski object. 
				SkiSegment skiObj = new SkiSegment(String.valueOf(i),data[i]);
				
				segments[i] = skiObj;
			}
		}
		
		// create tree to start constructing slope.
		TreeBuilder<T> tree;
		
		// initialize tree.
		tree = new TreeBuilder<T>();
				
		// construct the tree with data in the array 'segements'.
		tree.buildTree((T[]) data);
		
		// store root in instance variable root.
		this.root.setData(tree.getRoot()); 
		
	
		
		
	}
	
	/**
	 * Public method that returns the trees root node.
	 * @return tree's root node.
	 */
	public BinaryTreeNode<SkiSegment> getRoot() {
		 
		// return root.
		return this.root;
	}
	
	// method
	public void skiNextSegment (BinaryTreeNode<SkiSegment> node, ArrayUnorderedList<SkiSegment> sequence) {
		
	}
}
