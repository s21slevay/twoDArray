package com.yavel;

public class Main
{
  public static int Rows = 5;
  public static int Cols = 10;
  int [][] b;
  public static void initializeBoard(Main b)
  {
    for(int r = 0 ; r < Rows; r++)
    {
        for(int c = 0; c < Cols; c++)
        {
            int Value = (int) (Math.random() * 3);
            if (Value == 0)
            {
                b.set(r,c,1);
            }
        }
    }
  }
  // next need to display board
   public static void displayBoard(Main b)
   {
     for (int r = 0; r< Rows; r++)
     {
         for( int c = 0; c< Cols; c++)
         {
             if(b.get(r,c) == 0)
             {
                 System.out.print("-");
             }
             else if(b.get(r,c) == 1)
             {
                 System.out.print("1");
             }
         }
         System.out.println();
     }
   }
   //next need to find the next generation by looking at the cells around the main cell
    public static void nextGeneration(Main b, Main nextGen)
    {
        for(int r = 0; r< Rows; r++)
        {
            for(int c= 0; c< Cols; c++)
            {
                if(b.get(r,c) == 1 && countNeighbors(r, c,b) < 2) //countNeighbors is going to be implemented later as a method
                {
                    nextGen.set(r,c,0);//underpopulation and dies
                }
                else if(b.get(r,c) == 1 && countNeighbors(r,c,b) < 4)
                {
                    nextGen.set(r,c,1);//perfect population and lives
                }
                else if(b.get(r,c) == 1 && countNeighbors(r,c,b) > 3)
                {
                    nextGen.set(r,c,0);//overpopulation and dies
                }
                else if(b.get(r,c) == 0 && countNeighbors(r,c,b) == 3)
                {
                    nextGen.set(r,c,1);//migration from other cells and becomes alive
                }
            }
        }
    }
    // time to implement countNeighbors method which will return a value and is a static method
    public static int countNeighbors ( int row, int col, Main b)
    {
       int count = 0;
       for(int r = row -1; row<= row+1; r++)
       {
            for (int c = col - 1; c<= col + 1; c++)
            {
                if(r >= 0 && r < Rows && c >= 0 && c < Cols && !(r== row && c == col) && b.get(r,c) == 1)
                {
                    count++;
                }
            }
       }
       return count;
    }
   // now I need to transfer the previous board and transfer it to the current board with changes.
   public static void transferNextBoard(Main board, Main transferBoard)
   {
       for(int r = 0; r < Rows; r++ )
       {
           for(int c = 0; c< Cols; c++)
           {
             board.set(r, c, transferBoard.get(r,c));
           }
       }
   }
  //to get the size of the board
  public Main (int rows, int cols)
  {
      b = new int[rows] [cols];
  }
  // get the value that is in each of the rows and cols
  public int get( int row, int col)
  {
      return b[row][col];
  }
  // setting a value to each row and col
  public void set(int row, int col, int value)
  {
      b[row][col] = value;
  }
  // to find the height of the grid
    public int getRows()
    {
        return b.length;
    }
    public int getCols()
    {
        return b[0].length;
    }
    public String toString()
    {
        String result ="";
        for(int r = 0; r < getRows(); r++)
        {
            for(int c = 0; c < getCols(); c++)
            {
                result += String.valueOf(b[r][c]);
            }
            result += "\n";
        }
        return result;
    }




    public static void main(String[] args)
    {
        Main board = new Main(Rows, Cols);
        Main transferBoard = new Main(Rows, Cols);
        initializeBoard(board);
        displayBoard(board);
        for ( int i = 0 ; i< 10 ; i++)
        {
            displayBoard(board);
            nextGeneration(board , transferBoard);
            transferNextBoard(board , transferBoard);
        }
    }
}
