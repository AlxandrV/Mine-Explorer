package mineExplorer;

public class Game {


  public static void main(String[] args) {
    Board board = new Board();
    board.setMatrice(new String[5][7]);
    Game game = new Game();
    game.launch(board);
  }

  public Board launch(Board board) {

    String[][] matrice = board.getMatrice();
    int row = matrice.length / 2;
    int column = matrice[0].length / 2;
    matrice[row][column] = "*";
    board.setMatrice(matrice);
    return board;
  }

  // public static void print(Board board) {
  // for (int i = 0; i < board.getRows(); i++) {
  // // Ligne horizontale
  // for (int j = 0; j < board.getColumns(); j++) {
  // if (i == 0) {
  // System.out.print("====");
  // } else if (j == 0) {
  // System.out.print("¶---");
  // } else {
  // System.out.print("+---");
  // }
  // }
  // if (i == 0) {
  // System.out.println("=");
  // } else {
  // System.out.println("¶");
  // }
  //
  // // Contenu de la ligne
  // for (int j = 0; j < board.getColumns(); j++) {
  // if (j == 0) {
  // System.out.print("¶ " + " ");
  // } else {
  // System.out.print("| " + " ");
  // }
  // }
  // System.out.println("¶");
  // }
  //
  // // Dernière ligne horizontale
  // for (int j = 0; j < board.getColumns(); j++) {
  // System.out.print("====");
  // }
  // System.out.println("=");
  // }
}
