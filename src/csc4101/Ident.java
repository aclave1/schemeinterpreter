package csc4101;

import java.io.*;
class Ident extends Node {
  private String name;

  public Ident(String n) { name = n; }

    public String getName(){
        return name;
    }
  public void print(int n) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");

    System.out.printf("%s ",name);
  }
}
