/**
  Represent a node that holds...
  o  cargo of interest to the user
  o  reference to the next node in the list
 */

public class Node {
    private Object cargoReference;
    private Node   referenceToNextNode;


    /**
      Construct an instance
     */
    public Node( Object cargoReference) {
		this.cargoReference = cargoReference;
    }
    public Node( Object cargoReference, Node referenceToNextNode) {
        /* For incremental development with the skeleton's UserOfNode,
           postpone writing this constructor until after the accessors.
           Then remove this comment, of course.
         */
	this.cargoReference = cargoReference;
	this.referenceToNextNode = referenceToNextNode;
    }

    /**
      @return a string representation of this instance
     */
    public String toString() {
        String result =
            cargoReference.toString()  // polymorphically use appropriately toString!
          + " id " // include a usually-unique identifier for this node
          + super.toString()
          ;

        // Show rest of chain of nodes
        if( referenceToNextNode == null)
             result += " [no next]";
        else result += " --> " + referenceToNextNode;
        return result;
    }

    // classic accessor and mutator
    public Node getReferenceToNextNode() {
        return referenceToNextNode;
    }
    
    public Object getCargoReference() {
        return cargoReference;
    }

    public void setReferenceToNextNode( Node referenceToNextNode) {
        this.referenceToNextNode = referenceToNextNode;
    }
}
