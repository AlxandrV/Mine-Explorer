package com.project;

public class Player {
  private final String symbol = "♛♛";

  private Coordinate coordinate;
  private Board board;

  public void setBoard(Board board) {
    this.board = board;
  }

  public void setCoordinate(Coordinate coordinate) {
    if (this.coordinate != null)
      board.getMatrice()[this.coordinate.getY()][this.coordinate.getX()].playerLeaveRoom();

    this.coordinate = coordinate;
    board.getMatrice()[coordinate.getY()][coordinate.getX()].playerEnterRoom(this);
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void moveToDirection(String direction) {
    switch (direction) {
      case "z":
        setCoordinate(new Coordinate(coordinate.getX(), coordinate.getY() - 1));
        break;
      case "q":
        setCoordinate(new Coordinate(coordinate.getX() - 1, coordinate.getY()));
        break;
      case "s":
        setCoordinate(new Coordinate(coordinate.getX(), coordinate.getY() + 1));
        break;
      case "d":
        setCoordinate(new Coordinate(coordinate.getX() + 1, coordinate.getY()));
        break;
      default:
        break;
    }
  }

  @Override
  public String toString() {
    return symbol;
  }
}
