import static org.junit.Assert.assertEquals;

public class Iterative {

	public static BitList complement( BitList in ) {
		
		 BitList out;
		 out = new BitList();

	        Iterator itr = in.iterator();
	        Iterator itra = out.iterator();

	        if ( ! itr.hasNext() ) {

	            itra.add( BitList.ONE );

	        }

	            while ( itr.hasNext() ) {
	                int valeur = itr.next();

	                if ( valeur == BitList.ZERO ) {
	                    itra.add( BitList.ONE );
	                } else if (valeur==BitList.ONE) {
	                    itra.add( BitList.ZERO );
	                }
	            }

	        

	        return out;
	}

	public static BitList or( BitList a, BitList b ) {
		
		BitList out;
		out=new BitList();
		Iterator fin= out.iterator();
		Iterator itra=a.iterator();
		Iterator itrb=b.iterator();
		 if ( ! itrb.hasNext() ) {
             throw new IllegalArgumentException( "a est vide " );
        }
        if ( ! itra.hasNext() ) {
             throw new IllegalArgumentException( "b est vide " );
        }
		while(itra.hasNext()) {
			if(!itrb.hasNext()) {
				 throw new IllegalArgumentException( "not the same length" );
				
			}
			int valeur=itra.next();
			int val=itrb.next();
			if (valeur==BitList.ONE && val==BitList.ZERO) {
				fin.add(BitList.ONE);
			}else if (valeur==BitList.ZERO && val==BitList.ONE) {
				fin.add(BitList.ONE);}
			else if (valeur==BitList.ZERO && val==BitList.ZERO) {
				fin.add(BitList.ZERO);}
			else if (valeur==BitList.ONE && val==BitList.ONE) {
				fin.add(BitList.ONE);}
			
			
			
		}if (  itrb.hasNext() ) {
            throw new IllegalArgumentException( "b est vide " );
       }


		return out;
		// Your code here
	}

	public static BitList and( BitList a, BitList b ) {

		BitList out;
		out=new BitList();
		Iterator fin= out.iterator();
		Iterator itra=a.iterator();
		Iterator itrb=b.iterator();
		int comp=0;
		int compt=0;
		
		 if ( ! itrb.hasNext() ) {
             throw new IllegalArgumentException( "a est vide " );
        }
        if ( ! itra.hasNext() ) {
             throw new IllegalArgumentException( "b est vide " );
        }
		while(itra.hasNext() && itrb.hasNext()) {
			if(!itrb.hasNext()) {
				 throw new IllegalArgumentException( "not the same length" );
				
			}
			int valeur=itra.next();
			int val=itrb.next();
			if (valeur==BitList.ONE && val==BitList.ZERO) {
				fin.add(BitList.ZERO);
			}else if (valeur==BitList.ZERO && val==BitList.ONE) {
				fin.add(BitList.ZERO);}
			else if (valeur==BitList.ZERO && val==BitList.ZERO) {
				fin.add(BitList.ZERO);}
			else if (valeur==BitList.ONE && val==BitList.ONE) {
				fin.add(BitList.ONE);}
			
			
			
		}if (  itrb.hasNext() ) {
            throw new IllegalArgumentException( "b est vide " );
       }

		return out;
		// Your code here
	}
	

	public static BitList xor( BitList a, BitList b ) {

		BitList out;
		out=new BitList();
		Iterator fin= out.iterator();
		Iterator itra=a.iterator();
		Iterator itrb=b.iterator();
		 if ( ! itrb.hasNext() ) {
             throw new IllegalArgumentException( "a est vide " );
        }
        if ( ! itra.hasNext() ) {
             throw new IllegalArgumentException( "b est vide " );
        }
		while(itra.hasNext()) {
			if(!itrb.hasNext()) {
				 throw new IllegalArgumentException( "not the same length" );
				
			}
			int valeur=itra.next();
			int val=itrb.next();
			if (valeur==BitList.ONE && val==BitList.ZERO) {
				fin.add(BitList.ONE);
			}else if (valeur==BitList.ZERO && val==BitList.ONE) {
				fin.add(BitList.ONE);}
			else if (valeur==BitList.ZERO && val==BitList.ZERO) {
				fin.add(BitList.ZERO);}
			else if (valeur==BitList.ONE && val==BitList.ONE) {
				fin.add(BitList.ZERO);}
			
			
			
		}if (  itrb.hasNext() ) {
            throw new IllegalArgumentException( "b est vide " );
       }


		return out;
	}public static void main (String [] args ) {
		
	            BitList list = new BitList("01");
	            Iterative it = new Iterative();
	            BitList listComp = it.complement(list);
	            int bit = listComp.removeFirst();
	           System.out.println(0 + bit);
	           
	}
}