/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes_recursive{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes_recursive(){
    } 
    
    /** 
      Construct a list given a headReference
     */
    public List_inChainOfNodes_recursive(Node headReference){
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
            return 1 + new List_inChainOfNodes_recursive( headReference.getReferenceToNextNode()).size();
        }
    }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
    public String toString() {
        return   "["
               + toStringHelper() 
               + "]"
               ;
    }
     /**
       Helper function 
       @return string representation of this list without brackets
       format: 
           element0,element1,element2
      */
    private String toStringHelper(){
        //base case
        if (size() == 0) return "";
        //recursive case
        else { return  headReference.getCargoReference()
                     + ","
                     + new List_inChainOfNodes_recursive(headReference.getReferenceToNextNode()).toStringHelper()
                     ;
        }
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
}
