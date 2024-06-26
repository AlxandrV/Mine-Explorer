package com.project;

import java.util.Scanner;

public class Menu {

  private Scanner scanner;

  public Menu(Scanner scanner) {
    this.scanner = scanner;
  }

  public int getNbRow() {
    System.out.print("Nombre de ligne : ");
    return scanner.nextInt();
  }

  public int getNbColumn() {
    System.out.print("Nombre de colonne : ");
    return scanner.nextInt();
  }

  public int getNbMine() {
    System.out.print("Nombre de mine : ");
    return scanner.nextInt();
  }

  public int doAction() {
    String menu = "----------\n" + "Actions disponibles :\n" + "Quitter[0]\n" + "Se déplacer[1]\n"
        + "----------\n";

    System.out.println(menu);
    int action = scanner.nextInt();

    return action;
  }

  public String moveToDirection() {
    System.out.println("Se déplacer vers :\n" + "Haut : z | Bas : s | Gauche : q | Droite : d");

    return scanner.next().toLowerCase();
  }

  public void actionNotif(PlayerState state) {
    switch (state) {
      case PLAYING:
        System.out.println("Début de la partie");
        break;
      case WON:
        System.out.println("Vous avez gagné");
        break;
      case LOST:
        System.out.println("Vous avez perdu");
        break;
      case EXIT:
        System.out.println("Merci d'avoir joué :)");
        break;

      default:
        break;
    }
  }
}
