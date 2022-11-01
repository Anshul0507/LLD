package TicTacToe;

import java.util.Scanner;


public class Test {

  public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    System.out.println("Enter m,n,k line separated");
    int m = sn.nextInt();
    int n = sn.nextInt();
    int k = sn.nextInt();

    TicTacToe obj = new TicTacToe();
    obj.play(m,n,k);
  }


}
