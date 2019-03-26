/**
 Test list features.
 */
public class UserOfList {
    public static void main( String[] args ) {
        List_inChainOfNodes list = new List_inChainOfNodes();

        System.out.println( "number of elements: " + list.size() );
        
        // the spec requests that toString include the size
        System.out.println( "empty list: " + list
                          + System.lineSeparator());

        /* Populate the list with elements.
           Create the test data in an array, for the programming
           convenience of being able to loop through it.
        */
        String[] elements = new String[]{"y","u","t","S",};
            /* convenient syntax      ^^^^^^^^^^^^^^^^^^^^
               for convenient way to init an array of Strings */
        int elemIndex;
        for( String elem : elements ) {
            list.addAsHead( elem);
            System.out.println( "number of elements: " + list.size() + " list: " + list);
        }
        System.out.println( "populated list: " + list
                          + System.lineSeparator());
						  
						  
		// test get(index) 
		System.out.println( "testing get()");
		System.out.println( list);
		System.out.println( "index 0: " + list.get(0));
		System.out.println( "index 2: " + list.get(2));
		System.out.println();

		// test add(index, val) 
		System.out.println( "testing add(index, val)");
		System.out.println( list);
		System.out.println( "result of adding to index 1: ");
		list.add(1, "testing");
		System.out.println( list);
		System.out.println( "result of adding to end ");
		list.add(5, 2019);
		System.out.println( list);
		System.out.println( "result of adding to beginning ");
		list.add(0, "classOf");
		System.out.println( list + System.lineSeparator());

		// test set(index, val) 
		System.out.println( "testing set(index)");
		System.out.println( list);
		System.out.println( "result of setting index2 to true ");
		list.set(2, true);
		System.out.println( list);
		System.out.println( "result of setting beginning to 10000 ");
		list.set(0, 10000);
		System.out.println( list);
		System.out.println( "result of setting end to STUY ");
		list.set(6, "STUY");
		System.out.println( list + System.lineSeparator());

		// test remove(index) 
		System.out.println( "testing remove(index)");
		System.out.println( list);
		System.out.println( "result of removing index 3: ");
		list.remove(3);
		System.out.println( list);
		System.out.println( "result of removing end ");
		list.remove(5);
		System.out.println( list);
		System.out.println( "result of removing beginning ");
		list.remove(0);
		System.out.println( list + System.lineSeparator());
    }
}
