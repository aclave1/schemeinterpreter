package csc4101;

import java.io.*;
class Nil extends Node {
  public Nil() { }

  public void print(int n)		{ print(n, false); }
  public void print(int n, boolean p) {
    if (p) {
      System.out.printf(")");
    } else {
      System.out.printf("()");
    }
  }
}
