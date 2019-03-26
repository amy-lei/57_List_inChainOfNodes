/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes(){
    } 
    
    /** 
      Construct a list given a headReference
     */
    public List_inChainOfNodes(Node headReference){
        this.headReference = headReference;
    }

    /**
      @return the number of elements in this list
     */
    public int size() {
        // base case: empty list
        if (headReference == null)
            return 0; // size is 0
        
        // recursive case
        else{
            // add 1 to the size of the list without the headreference
            return 1 + new List_inChainOfNodes( headReference.getReferenceToNextNode()).size();
        }
    }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
    public String toString() {
        String result = "[";
        Node curNode = headReference;
        for( int el = 0; el < size(); el++){
            result += curNode.getCargoReference() + ",";
            curNode = curNode.getReferenceToNextNode();
        }
        return result += "]";
    }
    
    
    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        // store former headRef
        Node formerHead = headReference;
        
        // set new headRef to the param and set its nextRef to the former
        headReference = new Node( val, formerHead);
       
        return true;
     }
	 
	/**
	 @return value corresponding to the given index
	 */
	 public Object get(int index){
		 return getNode(index).getCargoReference();
		 
	 }

	/**
	 Helper function for add and remove
	 @return Node corresponding to the given index
	 */
	 private Node getNode(int index){
		 Node curNode = headReference;
		 for( int el = 0; ; el++){
			 if (el == index) return curNode;
			 curNode = curNode.getReferenceToNextNode();
			
		 }
		 
	 }
	 
	/**
	  Append @value to the list at the given index. 
	  
	  @return true, in keeping with conventions. 
	  
	 */
	public boolean add(int index, Object val){
	
		// if index == 0 use addAsHead
		if(index==0) addAsHead( val);
		
		else{ 
			// store former element at index 
			Node nodeBefore = getNode(index -1);
			Node nodeToBeShifted = nodeBefore.getReferenceToNextNode();
		
		
			// create a Node using given value and set to it as next Node of nodeBefore
			Node addition = new Node( val, nodeToBeShifted);
			nodeBefore.setReferenceToNextNode( addition);
		}
		return true;
	}
	
	/**
	  Sets @value at given index
	  
	  @return old value, in keeping with conventions
	 */
	public Node set( int index, Object val){
		// store value of succeeding node and replaced node
        	Node replacedNode = getNode(index);
        	Node succeedingNode = replacedNode.getReferenceToNextNode();
        
        	// create new Node using succeedingNode as nextRef
       		 Node addition = new Node( val, succeedingNode);
        
        	// if setting @index 0, make this new node the headref
       		 if (index == 0) headReference = addition;
        	// otherwise have it be the nextRef of the proceeding node
        	else { getNode(index-1).setReferenceToNextNode( addition);}
	
        
        //return old value by convention
		return replacedNode;
		
	}
    
    /** 
      Removes @value at given index
      
      @return value removed, in keeping with conventions
     */
     
    public Node remove( int index){
        // save old succeeding Node
        Node removedNode = getNode(index);
        Node succeedingNode = removedNode.getReferenceToNextNode();
        
        // if removing from the head, set succeeding as new headRef
        if (index==0) headReference = succeedingNode;
        else {
            // set the nextRef of the preceeding node to the succeedingNode
            getNode(index-1).setReferenceToNextNode( succeedingNode);
        }
        
        return removedNode;
    }
}
