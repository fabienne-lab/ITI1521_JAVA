public class BinarySearchTreeTest {

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void main( String[] args ) {

        displayStudentInfo();

        BinarySearchTree<String> t;
        t = new BinarySearchTree<String>();

        String[] animals = { "Lion", "Fox", "Rat", "Cat", "Pig", "Dog", "Tiger" };

        for ( int i=0; i<animals.length; i++ ) {
            System.out.println( "Adding " + animals[ i ] );
            if ( t.add( animals[ i ] ) ) {

        	System.out.println( t );
        	System.out.println( "t.min() -> " + t.min() );
        	System.out.println( "t.max() -> " + t.max() );
        	System.out.println( "t.depth() -> " + t.depth() );
        	System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

            } else {

        	System.out.println( "failure" );

            }
        }

        for ( int i=0; i<animals.length; i++ ) {
            System.out.println( "Adding " + animals[ i ] );
            if ( t.add( animals[ i ] ) ) {

        	System.out.println( t );
        	System.out.println( "t.min() -> " + t.min() );
        	System.out.println( "t.max() -> " + t.max() );
        	System.out.println( "t.depth() -> " + t.depth() );
        	System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

            } else {

        	System.out.println( "failure" );

            }
        }

        String[] pets = { "Lion", "Wolf", "Rat", "Chimp", "Pig", "Horse", "Tiger" };

        for ( int i=0; i<pets.length; i++ ) {
            System.out.println( "t.contains( " + pets[ i ] + ") is " + t.contains( pets[ i ] ) );
        }

        for ( int i=0; i<pets.length; i++ ) {
            System.out.println( "Adding " + pets[ i ] );
            if ( t.add( pets[ i ] ) ) {

        	System.out.println( t );
        	System.out.println( "t.min() -> " + t.min() );
        	System.out.println( "t.max() -> " + t.max() );
        	System.out.println( "t.depth() -> " + t.depth() );
        	System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

            } else {

        	System.out.println( "failure" );

            }
        }



    }
}

