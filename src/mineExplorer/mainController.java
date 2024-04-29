package mineExplorer;

public class mainController {

	public static void main(String[] args) {
        int rows = 5;
        int columns = 7;

        String[][] board = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = " ";
            }
        }

        displayBoard(board);
    }
	
	public static void displayBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            // Ligne horizontale
            for (int j = 0; j < board[0].length; j++) {
            	if (i == 0) {
                    System.out.print("====");
            	} else if (j == 0){
            		System.out.print("¶---");            		
            	} else {
            		System.out.print("+---");            		
            	}
            }
            if (i == 0) {
        		System.out.println("=");            		
            } else {
            	System.out.println("¶");
            }
            
            // Contenu de la ligne
            for (int j = 0; j < board[0].length; j++) {
            	if (j == 0) {
                    System.out.print("¶ " + board[i][j] + " ");
            	} else {
            		System.out.print("| " + board[i][j] + " ");            		
            	}
            }
            System.out.println("¶");
        }
        
        // Dernière ligne horizontale
        for (int j = 0; j < board[0].length; j++) {
            System.out.print("====");
        }
        System.out.println("=");
    }

}
