import java.io.*;
import java.util.*;

class Position {
  int x,y;
  public Position(int x,int y) {
    this.x=x;
    this.y=y;
  }
}

public class SurroundingRegions {
  boolean isValidPosition(Position p, int rows, int cols) {
    if(p.x>=rows || p.x<0 || p.y>=cols || p.y<0)return false;
    return true;
  }

  boolean isBoundary(Position p, int rows, int cols) {
    if(p.x==rows-1 || p.x==0 || p.y==cols-1 || p.y==0)return true;
    return false;
  }

  boolean testPosition(Position p1,int rows, int cols,boolean[][] visited, char[][] board, Queue<Position> q) {
    if(!isValidPosition(p1,rows,cols)) return false;
    boolean alive=false;
    if(!visited[p1.x][p1.y] && board[p1.x][p1.y]=='O') {
      if(isBoundary(p1,rows,cols)) alive=true;
      visited[p1.x][p1.y]=true;
      q.add(p1);
    }
    return alive;
  }

  boolean bfs2(char[][] board, int i, int j, boolean[][] visited, ArrayList<Position> ar) {
    int rows = board.length;
    int cols = board[0].length;
    Queue<Position> q = new LinkedList<Position>();
    q.add(new Position(i,j));
    boolean alive=false;
    while(!q.isEmpty()) {
      Position p = q.remove();
      ar.add(p);
      if(isBoundary(p,rows,cols)) alive=true;
      if(testPosition(new Position(p.x-1,p.y),rows,cols,visited,board,q))alive=true;
      if(testPosition(new Position(p.x,p.y-1),rows,cols,visited,board,q))alive=true;
      if(testPosition(new Position(p.x,p.y+1),rows,cols,visited,board,q))alive=true;
      if(testPosition(new Position(p.x+1,p.y),rows,cols,visited,board,q))alive=true;
    }
    return alive;
  }

  void addPosition(Queue<Position> q, Position p,boolean[][] visited,int rows, int cols) {
    if(!isValidPosition(p,rows,cols)) return;
    if(visited[p.x][p.y])return;
    q.add(p);
    visited[p.x][p.y]=true;
  }

  boolean bfs(char[][] board, int i, int j, boolean[][] visited, ArrayList<Position> ar) {
    int rows = board.length;
    int cols = board[0].length;
    Queue<Position> q = new LinkedList<Position>();
    q.add(new Position(i,j));
    boolean alive=false;
    while(!q.isEmpty()) {
      Position p = q.remove();
      if(board[p.x][p.y]=='X') continue;
      if(isBoundary(p,rows,cols)) alive=true;
      ar.add(p);
      addPosition(q,new Position(p.x-1,p.y),visited,rows,cols);
      addPosition(q,new Position(p.x,p.y-1),visited,rows,cols);
      addPosition(q,new Position(p.x,p.y+1),visited,rows,cols);
      addPosition(q,new Position(p.x+1,p.y),visited,rows,cols);
    }
    return alive;
  }

  void foo(char[][] board) {
    int rows = board.length;
    if(rows==0)return;
    int cols = board[0].length;
    boolean[][] v = new boolean[rows][cols];
    for(int i=0;i<rows;++i) {
      for(int j=0;j<cols;++j) {
        if(board[i][j]=='O' && !v[i][j]) {
          v[i][j]=true;
          ArrayList<Position> ar = new ArrayList<Position>();
          if(!bfs(board,i,j,v,ar)) {
            for(Position p:ar) {
              board[p.x][p.y]='X';
            }
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    //char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    char[][] board=new char[][]{"XOX".toCharArray(),"XOX".toCharArray(),"XOX".toCharArray()};
    //char[][] board=new char[][]{};
    new SurroundingRegions().foo(board);
    int rows = board.length;
    if(rows==0)return;
    int cols = board[0].length;
    boolean[][] v = new boolean[rows][cols];
    for(int i=0;i<rows;++i) {
      for(int j=0;j<cols;++j) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }
}
