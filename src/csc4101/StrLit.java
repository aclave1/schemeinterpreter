package csc4101;

import java.io.*;
class StrLit extends Node {
  private String strVal;

  public StrLit(String s) { strVal = s; }

  public void print(int n) {
    System.out.printf("\"%s\"",strVal);
  }
}
