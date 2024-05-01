package mineExplorer;

public class Game {


  public static void main(String[] args) {
    Board board = new Board();
    board.setMatrice(new String[5][7]);
    Game game = new Game();
    game.launch(board);
  }

  public Board launch(Board board) {
    // Place le joueur au centre de la map
    String[][] matrice = board.getMatrice();
    int row = matrice.length / 2;
    int column = matrice[0].length / 2;
    matrice[row][column] = "*";
    board.setMatrice(matrice);

    return board;
  }
}
