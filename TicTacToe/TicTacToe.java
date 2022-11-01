package TicTacToe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class TicTacToe {

  public void play(int m, int n, int k){
    char[][] arr = new char[m][n];

    HashSet<String> hSet = new HashSet<>();
    initialize(hSet,m,n);
    while(true){
      System.out.println("Going to play for player 1");
      char statusP1 = playGame(hSet,'x',arr,k);
      printGameStatus('x',statusP1);
      display(arr);
      if(statusP1 != 'p')
        break;
      System.out.println("Going to play for player 2");
      char statusP2 = playGame(hSet,'o',arr,k);
      printGameStatus('o',statusP2);
      display(arr);
      if(statusP2 != 'p')
        break;
    }
  }

  public void initialize(HashSet<String> hSet, int m, int n){
    for (int i=0;i<m;i++)
      for(int j=0;j<n;j++){
        hSet.add(i + "," + j);
      }
  }

  public void printGameStatus(char player, char status){
    System.out.println("Status of game after player " + player + " entry - " + status);
  }

  public void display(char[][] grid){
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  public char playGame(HashSet<String> hSet, char player, char[][] grid, int k){
    if(hSet.size()==0)
      return 'e';
    Random random = new Random();
    int index = random.nextInt(hSet.size());
    Iterator<String> iterator = hSet.iterator();
    for(int i=0;i<index;i++)
      iterator.next();
    String currentGrid = iterator.next();
    System.out.println("Current Random grid chosen " + currentGrid);
    String[] point = currentGrid.split(",");
    hSet.remove(currentGrid);
    int row = Integer.parseInt(point[0]);
    int col = Integer.parseInt(point[1]);
    grid[row][col]=player;
    return checkGameStatus(row,col,player,k, grid);
  }

  public char checkGameStatus(int row, int col, char player, int k, char[][] grid){
    int consecutives = 1, m=grid.length, n=grid[0].length;

    //travel horizontally right
    int i=row, j=col+1;
    while(j<n && grid[i][j]==player){
      consecutives++;
      j++;
      if(consecutives>=k)
        return player;
    }
    //travel horizontally left
    j=col-1;
    while(j>=0 && grid[i][j]==player){
      consecutives++;
      j--;
      if(consecutives>=k)
        return player;
    }

    //travel vertically down
    consecutives = 1;
    i=row+1;
    j=col;
    while(i<m && grid[i][j]==player){
      consecutives++;
      i++;
      if(consecutives>=k)
        return player;
    }
    //travel vertically up
    i=row-1;
    while(i>=0 && grid[i][j]==player){
      consecutives++;
      i--;
      if(consecutives>=k)
        return player;
    }

    //travel diagonal bottom - left
    consecutives = 1;
    i=row+1;
    j=col-1;
    while(i<m && j>=0 && grid[i][j]==player){
      consecutives++;
      i++;
      j--;
      if(consecutives>=k)
        return player;
    }
    //travel diagonal up - right
    i=row-1;
    j=col+1;
    while(i>=0 && j<n && grid[i][j]==player){
      consecutives++;
      i--;
      j++;
      if(consecutives>=k)
        return player;
    }

    //travel diagonal top - left
    consecutives = 1;
    i=row-1;
    j=col-1;
    while(i>=0 && j>=0 && grid[i][j]==player){
      consecutives++;
      i--;
      j--;
      if(consecutives>=k)
        return player;
    }
    //travel diagonal bottom - right
    i=row+1;
    j=col+1;
    while(i<m && j<n && grid[i][j]==player){
      consecutives++;
      i++;
      j++;
      if(consecutives>=k)
        return player;
    }

    return 'p';
  }

}
