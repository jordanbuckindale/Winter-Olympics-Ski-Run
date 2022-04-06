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
		root = this.getRoot();
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
		if (right != null && left != null){
			
			// create boolean variables for both nodes that represent if they have jumps.
			boolean rJumpStatus = false;
			boolean lJumpStatus = false;
			
			// sets boolean values to true if ski segment contains jump.
			rJumpStatus = right.getData().getID().contains("jump");
			lJumpStatus = right.getData().getID().contains("jump");
			
			// checks if right has a jump, and left does not have a jump.
			if (rJumpStatus == true && lJumpStatus == false) {
				skiNextSegment(right, sequence);
			}
			
			// checks if left has a jump, and right does not have a jump.
			if (rJumpStatus == false && lJumpStatus == true) {
				skiNextSegment(left, sequence);
			}
			
			// if both contain jumps, find and choose the one with the greater height or go right if equal.
			if (rJumpStatus == true && lJumpStatus == true) {
				
				// create string variables for each node.
				String rightID;
				String leftID;
				
				// create int variables for each node height.
				int rHeight;
				int lHeight;
				
				// get the strings that contain the height of jump.
				rightID = right.getData().getID();
				leftID = left.getData().getID();
				
				// split string at dash line.
				String[] rightStringParts = rightID.split("-", 2);
				String[] leftStringParts = leftID.split("-", 2);
				
				// get the height section of string only.
				rightID = rightStringParts[1];
				leftID = leftStringParts[1];
				
				// get height of nodes from string.
				rHeight = Integer.parseInt(rightID);
				lHeight = Integer.parseInt(leftID);
				
				// check if right node height is the same size or larger than the left node. 
				if (rHeight >= lHeight) {
					
					// call function again on right node.
					skiNextSegment(right, sequence);
				}
				
				// check if left node height is larger than the right node.
				if (rHeight < lHeight) {
					
					// call function again on left node.
					skiNextSegment(left, sequence);
				}
			}
			
			// create boolean variables for both nodes that represent if they have slaloms.
			boolean rSlalomStatus = false;
			boolean lSlalomStatus = false;
			
			// sets boolean value to true if ski segment contains slalom.
			rSlalomStatus = right.getData().getID().contains("slalom");
			lSlalomStatus = right.getData().getID().contains("slalom");
			

			if (rSlalomStatus == true || lSlalomStatus == true) {
				
				// create string variables for each node.
				String rightID;
				String leftID;
				
				// create string variables for each node direction.
				String rDirection;
				String lDirection;
				
				// get the strings that contain the direction of the ski segment.
				rightID = right.getData().getID();
				leftID = left.getData().getID();
				
				// split string at dash line.
				String[] rightStringParts = rightID.split("-", 2);
				String[] leftStringParts = leftID.split("-", 2);
				
				// get the direction section of string only.
				rDirection = rightStringParts[1];
				lDirection = leftStringParts[1];
			
				// check if right segment is slalom and if it is leeward.
				if (rSlalomStatus == true && lSlalomStatus == false) {
					
					// check if path is leeward.
					if( rDirection == "L")
						skiNextSegment(right, sequence);
					
					else {
						skiNextSegment(left, sequence);
					}
				}
						
				// check if left segment is slalom and if it is leeward.
				if (rSlalomStatus == false && lSlalomStatus == true) {
					
					// check if path is leeward.
					if( lDirection == "L")
						skiNextSegment(left, sequence);
					else {
						skiNextSegment(right, sequence);
					}
				}
				
				// check if right and left segment are both slaloms.
				if (rSlalomStatus == true && lSlalomStatus == true) {
					
					// check if right node is leeward. 
					if (rDirection == "L" && lDirection == "W") {
			
						// call function again on right node.
						skiNextSegment(right, sequence);
					}
					
					// check if left node is leeward.
					if (rDirection == "W" && lDirection == "L") {
						
						// call function again on left node.
						skiNextSegment(left, sequence);
					}
				}
			}
			
			else {
				// if not jump or not slalom, chose right 
				skiNextSegment(right, sequence);
			}
			
		}
		
		// if both are null, path is finished.
		else {
			
		
		}
	}
}
