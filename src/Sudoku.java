/**
 * @author 5767275
 * Title: Sudoku Checker
 * Semester: COP 3804 - Fall 2022
 * Professor: Cristy Charters
 */
public class Sudoku {


    public String[][] makeSudoku(String s) {
        int SIZE = 9;
        int k = 0;
        String[][] x = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x[i][j] = s.substring(k, k + 1);
                k++;
            }
        }
        return x;
    }

    public String getPrintableSudoku(String[][] x) {
        int SIZE = 9;
        String temp = "";
        for (int i = 0; i < SIZE; i++) {
            if ((i == 3) || (i == 6)) {
                temp = temp + "=================\n";
            }
            for (int j = 0; j < SIZE; j++) {
                if ((j == 3) || (j == 6)) {
                    temp = temp + " || ";
                }
                temp = temp + x[i][j];
            }
            temp = temp + "\n";
        }
        return temp;
    }

    public boolean isValidSudoku(String[][] x) {
        return rowsAreLatin(x) && colsAreLatin(x) && goodSubsquares(x);
    }

    public boolean rowsAreLatin(String[][] x) {
        boolean test = true;
        for (int i = 0; i < x.length; i++) {
            test = test && rowIsLatin(x,i);
        }
        return test;
    }
    
    /*
    For rowIsLatin, colIsLatin, and goodSubsquare we are running all of them
    through a boolean array set to 9. The logic behind this is that the code will 
    check each number changing each number from false to true. Before we can do
    that we need to parse it because they are currently set as an object and not
    an int which is what we need for this to work this process is the same for the
    rest of the code in colIsLatin and goodSubsquare. IN the event that the 
    number is repeated it return the whole puzzle as invalid without having to 
    check the rest.
    */    
    public boolean rowIsLatin(String[][] x, int i) {
        boolean found[] = new boolean[9];
        int n;
        for(n=0;n<found.length;n++)
            found[n] = false;
        for(int j=0;j<x[i].length;j++)
        {
            n = Integer.parseInt(x[i][j]);
            found[n-1]=true;
        }      
        for( n=0;n<found.length;n++)
            if(!found[n])
                return false;
        return true;
    }

    /*
    For colsAreLatin were basically doing the same thing that we find for
    rowsAreLatin
    */
    public boolean colsAreLatin(String[][] x) {
        boolean test = true;
        for (int j = 0; j < x.length; j++) {
            test = test && colIsLatin(x,j);
        }
        return test;
    }

     public boolean colIsLatin(String[][] x, int j) {
        boolean found[] = new boolean[9];
        int n;
        for(n=0;n<found.length;n++)
            found[n] = false;
        for(int i=0;i<x.length;i++)
        {
            n = Integer.parseInt(x[i][j]);
            found[n-1]=true;
        }      
         for( n=0;n<found.length;n++)
            if(!found[n])
                return false;
        return true;
    }
     
     /*
     goodSubsqaures is nearly identical to rowsAreLatin and colsAreLatin however
     this one increments are set to +3 instead of +1. 
     */

    public boolean goodSubsquares(String[][] x) {
        boolean test = true;
        for (int i = 0; i < x.length;i=i+3) {
            for(int j=0;j<x[i].length;j=j+3)
                test = test && goodSubsquare(x,i,j);
        }
        return test;
    }

    public boolean goodSubsquare(String[][] x, int i, int j) {
        boolean found[] = new boolean[9];
        int n;
        for(n=0;n<found.length;n++)
            found[n] = false;
        for(int row=i;row<(i+3);row++)
            for(int col=j;col<(j+3);col++)
            {
                n = Integer.parseInt(x[row][col]);
                found[n-1]=true;
            }
        for( n=0;n<found.length;n++)
            if(!found[n])
                return false;
       return true;
    }
}