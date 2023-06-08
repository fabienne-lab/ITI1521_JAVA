
public class nombre {
	static int[]array;
	int value;
	public static int [] methode  (String[] tableau) {
		 // Creating array of string length 
		array = new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
       
  
       
		for(int ii =0; ii<tableau.length ; ii++) {
			 
			for (int ei=0; ei<tableau[ii].length(); ei++ ){
				char[] ch = new char[tableau[ii].length()]; 
				String se=tableau[ii];
				ch[ei] = se.charAt(ei); 
				int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,x,y,z=0;
				for(int re =0;re< ch.length; re++) {
					if(ch[re]=='a'){
					System.out.println("dfghjkl;kjhgfdsfghj");
					array[0]+=1;
				}if(ch[re]=='a'){
					
					array[1]+=1;}
				if(ch[re]=='b'){
					
					array[2]+=1;}
				if(ch[re]=='c'){
				
					array[3]+=1;}
				if(ch[re]=='d'){
				
					array[4]+=1;}
				if(ch[re]=='e'){
					
					array[5]+=1;}
				if(ch[re]=='f'){
					
					array[6]+=1;}
				if(ch[re]=='g'){
				
					array[7]+=1;}
				if(ch[re]=='h'){
					
				array[8]+=1;}
				if(ch[re]=='i'){
					
					array[9]+=1;}
				if(ch[re]=='j'){
				
					array[0]+=1;}
				if(ch[re]=='k'){
					
					array[10]+=1;}
				if(ch[re]=='l'){
				
					array[11]+=1;}
				
			}
		}
		
	}
		return array;

}public static int max (int []arr) {
	int maxi=0;
	for (int i=0; i<array.length-1;i++) {
		int temp = array[i];
		if (temp>maxi) {
			maxi=temp;
			temp=array[i++];
		}
		
	}return maxi;
	
}public static void main(String []args ) {
	String [] re= new String []{"apple", "bandage"};

	int [] arr=methode(re);
	int a = max(arr);
	System.out.println(a);
	System.out.println("sdfghjkl;");
}
}