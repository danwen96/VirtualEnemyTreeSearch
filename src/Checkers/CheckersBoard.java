package Checkers;

/**
 * Class containing board to a game of checkers and methods that are responsible for operations on this board
 */
public class CheckersBoard {
    private char boardTab[][];

    /**
     * New board creation and filling it with pawns starting posistions using the fillBoardWithStartingPositions()
     */
    CheckersBoard()
    {
        boardTab = new char[8][8];
        fillBoardWithStartingPositions();
    }

    /**
     * Filling the board with standard starting positions of the pawn - 3 lines of pawns for both players
     */
    void fillBoardWithStartingPositions()
    {
        for (int i = 0; i < boardTab.length; i++) {
            for (int j = 0; j < boardTab.length; j++) {
                boardTab[i][j] = '-';
            }
        }
        for (int i = 0; i < boardTab.length; i++) {
            for (int j = (i%2 == 0)? 0:1; j < boardTab.length; j+=2) {
                if(i<=2)
                    boardTab[i][j] = '@';
                else if(i>=5)
                    boardTab[i][j] = '#';
                else
                    boardTab[i][j] = '_';
            }
        }
    }

    /**
     * Showing game board with indexes intended for easier control of the game from command line interface
     */
    void displayGameBoard()
    {
        System.out.println();
        for (int i = 0; i < boardTab.length; i++) {
            for (int j = 0; j < boardTab.length; j++) {
                System.out.print(boardTab[i][j]+" ");
            }
            System.out.print((char)('a'+i));
            System.out.println();
        }
        for (int i = 0; i < boardTab.length; i++) {
            System.out.print((i+1)+" ");
        }
        System.out.println();
    }

    /**
     * Method designed for moving pawns operations
     * @param i index of the pawn that is going to be moved in a form of char index
     * @param j index of the pawn that is going to be moved in a form numeric index
     * @param k index of the field that the pawn intention is to move in a form of char index
     * @param l index of the field that the pawn intention is to move in a form of numeric
     * @return 0 if succeded, 1 if this is a forbidden move, 2 if given arguments are wrong
     */
    int movePawn(char i, int j, char k, int l)
    {
        int indofPawni = (int)i - 'a';
        int indofPawnj = j;

        int indofFieldk = (int)k - 'a';
        int indofFieldl = l;

        char pawn = boardTab[indofPawni][indofPawnj];
        char field = boardTab[indofFieldk][indofFieldl];

        if( pawn != '@' && pawn != '#') {
            System.out.println("Incorrect indexes of the pawn given");
            return 2;
        }

        if( field == '-'){

        }

        int playerMovingDirections;

        if( pawn == '@' )
            playerMovingDirections = 1;
        else if ( pawn == '#' )
            playerMovingDirections = -1;








        return 0;
    }

    public static void main(String[] args) {
        CheckersBoard checkersBoard = new CheckersBoard();
        checkersBoard.displayGameBoard();
    }



}
