package csc4101;

import java.io.*;
class IntLit extends Node {
  private int intVal;

  public IntLit(int i) { intVal = i; }

  public void print(int n) {
    System.out.printf("%d",intVal);
  }
}
