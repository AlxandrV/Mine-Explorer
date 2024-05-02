package main.java;

public class Board {

  private String[][] matrice;
  private int nbRow;
  private int nbColumn;

  public Board(int nbRow, int nbColumn) {
    this.nbRow = nbRow;
    this.nbColumn = nbColumn;

    initMatrice();
  }

  private void initMatrice() {
    matrice = new String[nbRow][nbColumn];
    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        matrice[i][j] = "*";
      }
    }
  }

  public String[][] getMatrice() {
    return matrice;
  }

  public void setMatrice(String[][] matrice) {
    this.matrice = matrice;
  }

  @Override
  public String toString() {
    String display = "";

    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        display += matrice[i][j];
      }
      if (i < nbRow - 1) {
        display += "\n";
      }
    }

    return display;
  }
}
