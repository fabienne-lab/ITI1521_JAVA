import java.util.NoSuchElementException;

public class BinarySearchTree< E extends Comparable<E> > {

    // A static nested class used to store the elements of this tree

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;
        private Node( E value ) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;
    
    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add( E obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        // special case:

        if ( root == null ) {
            root = new Node<E>( obj );
            return true;
        }

        // general case:

        return add( obj, root );
    }

    private boolean add( E obj, Node<E> current ) {

        boolean result;
        int test = obj.compareTo( current.value );

        if ( test == 0 ) {
            result = false;
        } else if ( test < 0 ) {
            if ( current.left == null ) {
                current.left = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.left );
            }
        } else {
            if ( current.right == null ) {
                current.right = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.right );
            }
        }
        return result;
    }

    /**
     * Looks up for obj in this BinarySearchTree, returns true
     * if obj is found and false otherwise.
     *
     * @param obj value to look for
     * @return true if the object has been found and false otherwise
     */

    public boolean contains( E obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        return contains( obj, root );
    }

    private boolean contains( E obj, Node<E> current ) {

        boolean result;

        if ( current == null ) {

            result = false;

        } else {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {

                result = true;

            } else if ( test < 0 ) {

                result = contains( obj, current.left );

            } else {

                result = contains( obj, current.right );

            }
        }
        return result;
    }

    public E max() {

        if ( root == null ) {
            throw new NoSuchElementException();
        }
        return max( root );
    }

    private E max( Node<E> current ) {

        if ( current.right == null ) {
            return current.value;
        } else {
            return max( current.right );
        }

    }

    public E min() {

        if ( root == null ) {
            throw new NoSuchElementException();
        }
        return min( root );
    }

    private E min( Node<E> current ) {

        if ( current.left == null ) {
            return current.value;
        } else {
            return min( current.left );
        }

    }

    public boolean isTwoTree() {

        return isTwoTree( root );
    }

    private boolean isTwoTree( Node<E> current ) {

        boolean answer;

        if ( current == null ) {

            answer = true;

        } else {

            if ( current.left == null || current.right == null ) {

        	   answer = current.left == null && current.right == null;

            } else {

        	   answer = isTwoTree( current.left ) && isTwoTree( current.right );

            }

        }

        return answer;
    }

    public int depth() {
        return depth( root );
    }

    private int depth( Node<E> current ) {

        if ( current == null ) {

            return -1;

        } else {

            int dleft, dright;

            dleft = depth( current.left ); 
            dright = depth( current.right ); 

            return Math.max( dleft, dright ) + 1;
        }

    }

    private static String NL = System.getProperty( "line.separator" );
        
    public String toString() {
        return toString( root, "" );
    }

    private String toString( Node<E> current, String padding ) {

        String result;

        if ( current == null ) {
            
            result = padding + "null" + NL;

        } else {

            result = toString( current.right, padding + "  " );
            result += padding + current.value + NL;
            result += toString( current.left, padding + "  " );
        }

        return result;
    }

}