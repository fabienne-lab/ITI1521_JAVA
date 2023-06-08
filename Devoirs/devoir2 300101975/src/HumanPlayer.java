/**HumanPlayer est une classe qui r�alise l�interface Player. 
Dans son impl�mentation de la m�thode play, elle v�rifie d�abord que le jeu est effectivement jouable (et renvoie faux si ce n'est pas),
puis demande � l�utilisateur une entr�e valide (similaire � celui du devoir 1).
Une fois qu�une telle entr�e a �t� fournie, il joue le jeu et donne le contr�le � l�autre joueur et renvoie vrai.*/
public class HumanPlayer implements Player {

	public  boolean play(TicTacToe game) {
     
		if(game.getNumRounds() == game.numRows*game.numColumns){
			System.out.println("le jeux est deja fini");
			
			return false;
		}

		boolean tour  = true;

		while(tour) {
        	
        	
        String g=	game.toString()
            + "\n\n"
            + game.nextPlayer() + " to play: ";
        	System.out.print(g);
        	String answer = Utils.readLine();
        	
        	int valeur;
        	
            valeur = Integer.parseInt(answer);
           
             if(valeur < 0 || valeur> (game.numColumns*game.numColumns)){
               	System.out.println("la valeur entree doit etre entre 1 et "  + (game.numColumns*game.numRows));
               } 
             else if(game.valueAt(valeur) != CellValue.EMPTY) {
                	System.out.println("cette cellule a deja ete jouer avec " + game.valueAt(valeur));
                } 
                else {
            	game.play(valeur);
            	 game.currentPlayer=game.valueAt(game.lastPlayedPosition);
            	tour = false;
            	
            	
            }}
		tour=false;
        
		
		return true;

	}

}
