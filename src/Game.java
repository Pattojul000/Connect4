import java.util.Scanner;

public class Game {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private boolean isComplete = false;

    public Game() {
        gameBoard = new GameBoard();
        player1 = new Player(Space.RED, 1);
        player2 = new Player(Space.YELLOW, 2);
    }

    public void Play() {

        Scanner myScan = new Scanner(System.in);
        SpaceStatus();
        gameBoard.Draw();

        while (true) {

            System.out.println("Player 1 (.R):  Enter a location number.");
            int location = myScan.nextInt();

                if (this.gameBoard.spaces[location] == Space.RED || this.gameBoard.spaces[location] == Space.YELLOW || this.gameBoard.spaces[location] == Space.UNDEFINED) {

                    System.out.println("You cannot place in an already marked or undefined zone, please try again.");

                    System.out.println("Player 1 (.R):  Enter a location number.");
                    location = myScan.nextInt();

                }

            gameBoard.PlaceOnBoard(player1.getPiece(), location);

            boolean ifWon = CheckForWin();

            if (ifWon) {
                System.out.println("Player 1 Wins");
                gameBoard.Draw();
                return;
            }

            if (IsFilled()) {
                System.out.println("Draw:  All Spaces Filled");
                gameBoard.Draw();
                return;
            }

            SpaceStatus();
            gameBoard.Draw();

            System.out.println("Player 2 (.Y):  Enter a location number.");
            location = myScan.nextInt();

            if(this.gameBoard.spaces[location] == Space.RED || this.gameBoard.spaces[location] == Space.YELLOW || this.gameBoard.spaces[location] == Space.UNDEFINED){

                System.out.println("You cannot place in an already marked or undefined zone, please try again.");

                System.out.println("Player 2 (.Y):  Enter a location number.");
                location = myScan.nextInt();

            }

            gameBoard.PlaceOnBoard(player2.getPiece(), location);

            ifWon = CheckForWin();

            if (ifWon) {
                System.out.println("Player 2 Wins");
                gameBoard.Draw();
                return;
            }

            if (IsFilled()) {
                System.out.println("Draw:  All Spaces Filled");
                gameBoard.Draw();
                return;
            }

            SpaceStatus();
            gameBoard.Draw();

        }

    }

    private boolean SpaceStatus(){

        for(int i = 7; i < this.gameBoard.spaces.length; i++){

            //Spaces being marked EMPTY or UNDEFINED

            if(this.gameBoard.spaces[i] == Space.EMPTY){
                this.gameBoard.spaces[i-7] = Space.UNDEFINED;
            } else if(this.gameBoard.spaces[i] == Space.RED || this.gameBoard.spaces[i] == Space.YELLOW){
                this.gameBoard.spaces[i-7] = Space.EMPTY;
            }

        }

        for(int j = 0; j < this.gameBoard.spaces.length; j++){

            //Spaces being marked as red/yellow

            if(this.gameBoard.spacesText[j] == ".R"){
                this.gameBoard.spaces[j] = Space.RED;
            } else if(this.gameBoard.spacesText[j] == ".Y"){
                this.gameBoard.spaces[j] = Space.YELLOW;
            }

        }

        return false;

    }

    private boolean CheckForWin() {

        //HORIZONTAL
        if(this.gameBoard.spaces[0] == this.gameBoard.spaces[1] && this.gameBoard.spaces[1] == this.gameBoard.spaces[2]
                && this.gameBoard.spaces[2] == this.gameBoard.spaces[3] && this.gameBoard.spaces[0] != Space.EMPTY
                && this.gameBoard.spaces[0] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[1] == this.gameBoard.spaces[2] && this.gameBoard.spaces[2] == this.gameBoard.spaces[3]
                && this.gameBoard.spaces[3] == this.gameBoard.spaces[4] && this.gameBoard.spaces[1] != Space.EMPTY
                && this.gameBoard.spaces[1] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[2] == this.gameBoard.spaces[3] && this.gameBoard.spaces[3] == this.gameBoard.spaces[4]
                && this.gameBoard.spaces[4] == this.gameBoard.spaces[5] && this.gameBoard.spaces[2] != Space.EMPTY
                && this.gameBoard.spaces[2] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[3] == this.gameBoard.spaces[4] && this.gameBoard.spaces[4] == this.gameBoard.spaces[5]
                && this.gameBoard.spaces[5] == this.gameBoard.spaces[6] && this.gameBoard.spaces[3] != Space.EMPTY
                && this.gameBoard.spaces[3] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[7] == this.gameBoard.spaces[8] && this.gameBoard.spaces[8] == this.gameBoard.spaces[9]
                && this.gameBoard.spaces[9] == this.gameBoard.spaces[10] && this.gameBoard.spaces[7] != Space.EMPTY
                && this.gameBoard.spaces[7] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[8] == this.gameBoard.spaces[9] && this.gameBoard.spaces[9] == this.gameBoard.spaces[10]
                && this.gameBoard.spaces[10] == this.gameBoard.spaces[11] && this.gameBoard.spaces[8] != Space.EMPTY
                && this.gameBoard.spaces[8] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[9] == this.gameBoard.spaces[10] && this.gameBoard.spaces[10] == this.gameBoard.spaces[11]
                && this.gameBoard.spaces[11] == this.gameBoard.spaces[12] && this.gameBoard.spaces[9] != Space.EMPTY
                && this.gameBoard.spaces[9] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[10] == this.gameBoard.spaces[11] && this.gameBoard.spaces[11] == this.gameBoard.spaces[12]
                && this.gameBoard.spaces[12] == this.gameBoard.spaces[13] && this.gameBoard.spaces[10] != Space.EMPTY
                && this.gameBoard.spaces[10] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[14] == this.gameBoard.spaces[15] && this.gameBoard.spaces[15] == this.gameBoard.spaces[16]
                && this.gameBoard.spaces[16] == this.gameBoard.spaces[17] && this.gameBoard.spaces[14] != Space.EMPTY
                && this.gameBoard.spaces[14] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[15] == this.gameBoard.spaces[16] && this.gameBoard.spaces[16] == this.gameBoard.spaces[17]
                && this.gameBoard.spaces[17] == this.gameBoard.spaces[18] && this.gameBoard.spaces[15] != Space.EMPTY
                && this.gameBoard.spaces[15] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[16] == this.gameBoard.spaces[17] && this.gameBoard.spaces[17] == this.gameBoard.spaces[18]
                && this.gameBoard.spaces[18] == this.gameBoard.spaces[19] && this.gameBoard.spaces[16] != Space.EMPTY
                && this.gameBoard.spaces[16] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[17] == this.gameBoard.spaces[18] && this.gameBoard.spaces[18] == this.gameBoard.spaces[19]
                && this.gameBoard.spaces[19] == this.gameBoard.spaces[20] && this.gameBoard.spaces[17] != Space.EMPTY
                && this.gameBoard.spaces[17] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[21] == this.gameBoard.spaces[22] && this.gameBoard.spaces[22] == this.gameBoard.spaces[23]
                && this.gameBoard.spaces[23] == this.gameBoard.spaces[24] && this.gameBoard.spaces[21] != Space.EMPTY
                && this.gameBoard.spaces[21] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[22] == this.gameBoard.spaces[23] && this.gameBoard.spaces[23] == this.gameBoard.spaces[24]
                && this.gameBoard.spaces[24] == this.gameBoard.spaces[25] && this.gameBoard.spaces[22] != Space.EMPTY
                && this.gameBoard.spaces[22] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[23] == this.gameBoard.spaces[24] && this.gameBoard.spaces[24] == this.gameBoard.spaces[25]
                && this.gameBoard.spaces[25] == this.gameBoard.spaces[26] && this.gameBoard.spaces[23] != Space.EMPTY
                && this.gameBoard.spaces[23] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[24] == this.gameBoard.spaces[25] && this.gameBoard.spaces[25] == this.gameBoard.spaces[26]
                && this.gameBoard.spaces[26] == this.gameBoard.spaces[27] && this.gameBoard.spaces[24] != Space.EMPTY
                && this.gameBoard.spaces[24] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[28] == this.gameBoard.spaces[29] && this.gameBoard.spaces[29] == this.gameBoard.spaces[30]
                && this.gameBoard.spaces[30] == this.gameBoard.spaces[31] && this.gameBoard.spaces[28] != Space.EMPTY
                && this.gameBoard.spaces[28] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[29] == this.gameBoard.spaces[30] && this.gameBoard.spaces[30] == this.gameBoard.spaces[31]
                && this.gameBoard.spaces[31] == this.gameBoard.spaces[32] && this.gameBoard.spaces[29] != Space.EMPTY
                && this.gameBoard.spaces[29] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[30] == this.gameBoard.spaces[31] && this.gameBoard.spaces[31] == this.gameBoard.spaces[32]
                && this.gameBoard.spaces[32] == this.gameBoard.spaces[33] && this.gameBoard.spaces[30] != Space.EMPTY
                && this.gameBoard.spaces[30] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[31] == this.gameBoard.spaces[32] && this.gameBoard.spaces[32] == this.gameBoard.spaces[33]
                && this.gameBoard.spaces[33] == this.gameBoard.spaces[34] && this.gameBoard.spaces[31] != Space.EMPTY
                && this.gameBoard.spaces[31] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[35] == this.gameBoard.spaces[36] && this.gameBoard.spaces[36] == this.gameBoard.spaces[37]
                && this.gameBoard.spaces[37] == this.gameBoard.spaces[38] && this.gameBoard.spaces[35] != Space.EMPTY
                && this.gameBoard.spaces[35] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[36] == this.gameBoard.spaces[37] && this.gameBoard.spaces[37] == this.gameBoard.spaces[38]
                && this.gameBoard.spaces[38] == this.gameBoard.spaces[39] && this.gameBoard.spaces[36] != Space.EMPTY
                && this.gameBoard.spaces[36] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[37] == this.gameBoard.spaces[38] && this.gameBoard.spaces[38] == this.gameBoard.spaces[39]
                && this.gameBoard.spaces[39] == this.gameBoard.spaces[40] && this.gameBoard.spaces[37] != Space.EMPTY
                && this.gameBoard.spaces[37] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[38] == this.gameBoard.spaces[39] && this.gameBoard.spaces[39] == this.gameBoard.spaces[40]
                && this.gameBoard.spaces[40] == this.gameBoard.spaces[41] && this.gameBoard.spaces[38] != Space.EMPTY
                && this.gameBoard.spaces[38] != Space.UNDEFINED){
            return true;
        }
        //VERTICAL
        else if(this.gameBoard.spaces[35] == this.gameBoard.spaces[28] && this.gameBoard.spaces[28] == this.gameBoard.spaces[21]
                && this.gameBoard.spaces[21] == this.gameBoard.spaces[14] && this.gameBoard.spaces[35] != Space.EMPTY
                && this.gameBoard.spaces[35] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[28] == this.gameBoard.spaces[21] && this.gameBoard.spaces[21] == this.gameBoard.spaces[14]
                && this.gameBoard.spaces[14] == this.gameBoard.spaces[7] && this.gameBoard.spaces[28] != Space.EMPTY
                && this.gameBoard.spaces[28] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[21] == this.gameBoard.spaces[14] && this.gameBoard.spaces[14] == this.gameBoard.spaces[7]
                && this.gameBoard.spaces[7] == this.gameBoard.spaces[0] && this.gameBoard.spaces[21] != Space.EMPTY
                && this.gameBoard.spaces[21] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[36] == this.gameBoard.spaces[29] && this.gameBoard.spaces[29] == this.gameBoard.spaces[22]
                && this.gameBoard.spaces[22] == this.gameBoard.spaces[15] && this.gameBoard.spaces[36] != Space.EMPTY
                && this.gameBoard.spaces[36] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[29] == this.gameBoard.spaces[22] && this.gameBoard.spaces[22] == this.gameBoard.spaces[15]
                && this.gameBoard.spaces[15] == this.gameBoard.spaces[8] && this.gameBoard.spaces[29] != Space.EMPTY
                && this.gameBoard.spaces[29] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[22] == this.gameBoard.spaces[15] && this.gameBoard.spaces[15] == this.gameBoard.spaces[8]
                && this.gameBoard.spaces[8] == this.gameBoard.spaces[1] && this.gameBoard.spaces[22] != Space.EMPTY
                && this.gameBoard.spaces[22] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[37] == this.gameBoard.spaces[30] && this.gameBoard.spaces[30] == this.gameBoard.spaces[23]
                && this.gameBoard.spaces[23] == this.gameBoard.spaces[16] && this.gameBoard.spaces[37] != Space.EMPTY
                && this.gameBoard.spaces[37] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[30] == this.gameBoard.spaces[23] && this.gameBoard.spaces[23] == this.gameBoard.spaces[16]
                && this.gameBoard.spaces[16] == this.gameBoard.spaces[9] && this.gameBoard.spaces[30] != Space.EMPTY
                && this.gameBoard.spaces[30] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[23] == this.gameBoard.spaces[16] && this.gameBoard.spaces[16] == this.gameBoard.spaces[9]
                && this.gameBoard.spaces[9] == this.gameBoard.spaces[2] && this.gameBoard.spaces[23] != Space.EMPTY
                && this.gameBoard.spaces[23] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[38] == this.gameBoard.spaces[31] && this.gameBoard.spaces[31] == this.gameBoard.spaces[24]
                && this.gameBoard.spaces[24] == this.gameBoard.spaces[17] && this.gameBoard.spaces[38] != Space.EMPTY
                && this.gameBoard.spaces[38] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[31] == this.gameBoard.spaces[24] && this.gameBoard.spaces[24] == this.gameBoard.spaces[17]
                && this.gameBoard.spaces[17] == this.gameBoard.spaces[10] && this.gameBoard.spaces[31] != Space.EMPTY
                && this.gameBoard.spaces[31] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[24] == this.gameBoard.spaces[17] && this.gameBoard.spaces[17] == this.gameBoard.spaces[10]
                && this.gameBoard.spaces[10] == this.gameBoard.spaces[3] && this.gameBoard.spaces[24] != Space.EMPTY
                && this.gameBoard.spaces[24] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[39] == this.gameBoard.spaces[32] && this.gameBoard.spaces[32] == this.gameBoard.spaces[25]
                && this.gameBoard.spaces[25] == this.gameBoard.spaces[18] && this.gameBoard.spaces[39] != Space.EMPTY
                && this.gameBoard.spaces[39] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[32] == this.gameBoard.spaces[25] && this.gameBoard.spaces[25] == this.gameBoard.spaces[18]
                && this.gameBoard.spaces[18] == this.gameBoard.spaces[11] && this.gameBoard.spaces[32] != Space.EMPTY
                && this.gameBoard.spaces[32] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[25] == this.gameBoard.spaces[18] && this.gameBoard.spaces[18] == this.gameBoard.spaces[11]
                && this.gameBoard.spaces[11] == this.gameBoard.spaces[4] && this.gameBoard.spaces[25] != Space.EMPTY
                && this.gameBoard.spaces[25] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[40] == this.gameBoard.spaces[33] && this.gameBoard.spaces[33] == this.gameBoard.spaces[26]
                && this.gameBoard.spaces[26] == this.gameBoard.spaces[19] && this.gameBoard.spaces[40] != Space.EMPTY
                && this.gameBoard.spaces[40] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[33] == this.gameBoard.spaces[26] && this.gameBoard.spaces[26] == this.gameBoard.spaces[19]
                && this.gameBoard.spaces[19] == this.gameBoard.spaces[12] && this.gameBoard.spaces[33] != Space.EMPTY
                && this.gameBoard.spaces[33] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[26] == this.gameBoard.spaces[19] && this.gameBoard.spaces[19] == this.gameBoard.spaces[12]
                && this.gameBoard.spaces[12] == this.gameBoard.spaces[5] && this.gameBoard.spaces[26] != Space.EMPTY
                && this.gameBoard.spaces[26] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[41] == this.gameBoard.spaces[34] && this.gameBoard.spaces[34] == this.gameBoard.spaces[27]
                && this.gameBoard.spaces[27] == this.gameBoard.spaces[20] && this.gameBoard.spaces[41] != Space.EMPTY
                && this.gameBoard.spaces[41] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[34] == this.gameBoard.spaces[27] && this.gameBoard.spaces[27] == this.gameBoard.spaces[20]
                && this.gameBoard.spaces[20] == this.gameBoard.spaces[13] && this.gameBoard.spaces[34] != Space.EMPTY
                && this.gameBoard.spaces[34] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[27] == this.gameBoard.spaces[20] && this.gameBoard.spaces[20] == this.gameBoard.spaces[13]
                && this.gameBoard.spaces[13] == this.gameBoard.spaces[6] && this.gameBoard.spaces[27] != Space.EMPTY
                && this.gameBoard.spaces[27] != Space.UNDEFINED){
            return true;
        }
        //DIAGONAL
        else if(this.gameBoard.spaces[0] == this.gameBoard.spaces[8] && this.gameBoard.spaces[8] == this.gameBoard.spaces[16]
                && this.gameBoard.spaces[16] == this.gameBoard.spaces[24] && this.gameBoard.spaces[0] != Space.EMPTY
                && this.gameBoard.spaces[0] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[1] == this.gameBoard.spaces[9] && this.gameBoard.spaces[9] == this.gameBoard.spaces[17]
                && this.gameBoard.spaces[17] == this.gameBoard.spaces[25] && this.gameBoard.spaces[1] != Space.EMPTY
                && this.gameBoard.spaces[1] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[2] == this.gameBoard.spaces[10] && this.gameBoard.spaces[10] == this.gameBoard.spaces[18]
                && this.gameBoard.spaces[18] == this.gameBoard.spaces[26] && this.gameBoard.spaces[2] != Space.EMPTY
                && this.gameBoard.spaces[2] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[3] == this.gameBoard.spaces[9] && this.gameBoard.spaces[9] == this.gameBoard.spaces[15]
                && this.gameBoard.spaces[15] == this.gameBoard.spaces[21] && this.gameBoard.spaces[3] != Space.EMPTY
                && this.gameBoard.spaces[3] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[3] == this.gameBoard.spaces[11] && this.gameBoard.spaces[11] == this.gameBoard.spaces[19]
                && this.gameBoard.spaces[19] == this.gameBoard.spaces[27] && this.gameBoard.spaces[3] != Space.EMPTY
                && this.gameBoard.spaces[3] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[4] == this.gameBoard.spaces[10] && this.gameBoard.spaces[10] == this.gameBoard.spaces[16]
                && this.gameBoard.spaces[16] == this.gameBoard.spaces[22] && this.gameBoard.spaces[4] != Space.EMPTY
                && this.gameBoard.spaces[4] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[5] == this.gameBoard.spaces[11] && this.gameBoard.spaces[11] == this.gameBoard.spaces[17]
                && this.gameBoard.spaces[17] == this.gameBoard.spaces[23] && this.gameBoard.spaces[5] != Space.EMPTY
                && this.gameBoard.spaces[5] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[6] == this.gameBoard.spaces[12] && this.gameBoard.spaces[12] == this.gameBoard.spaces[18]
                && this.gameBoard.spaces[18] == this.gameBoard.spaces[24] && this.gameBoard.spaces[6] != Space.EMPTY
                && this.gameBoard.spaces[6] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[7] == this.gameBoard.spaces[15] && this.gameBoard.spaces[15] == this.gameBoard.spaces[23]
                && this.gameBoard.spaces[23] == this.gameBoard.spaces[31] && this.gameBoard.spaces[7] != Space.EMPTY
                && this.gameBoard.spaces[7] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[8] == this.gameBoard.spaces[16] && this.gameBoard.spaces[16] == this.gameBoard.spaces[24]
                && this.gameBoard.spaces[24] == this.gameBoard.spaces[32] && this.gameBoard.spaces[8] != Space.EMPTY
                && this.gameBoard.spaces[8] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[9] == this.gameBoard.spaces[17] && this.gameBoard.spaces[17] == this.gameBoard.spaces[25]
                && this.gameBoard.spaces[25] == this.gameBoard.spaces[33] && this.gameBoard.spaces[9] != Space.EMPTY
                && this.gameBoard.spaces[9] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[10] == this.gameBoard.spaces[18] && this.gameBoard.spaces[18] == this.gameBoard.spaces[26]
                && this.gameBoard.spaces[26] == this.gameBoard.spaces[34] && this.gameBoard.spaces[10] != Space.EMPTY
                && this.gameBoard.spaces[10] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[10] == this.gameBoard.spaces[16] && this.gameBoard.spaces[16] == this.gameBoard.spaces[22]
                && this.gameBoard.spaces[22] == this.gameBoard.spaces[28] && this.gameBoard.spaces[10] != Space.EMPTY
                && this.gameBoard.spaces[10] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[11] == this.gameBoard.spaces[17] && this.gameBoard.spaces[17] == this.gameBoard.spaces[23]
                && this.gameBoard.spaces[23] == this.gameBoard.spaces[29] && this.gameBoard.spaces[11] != Space.EMPTY
                && this.gameBoard.spaces[11] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[12] == this.gameBoard.spaces[18] && this.gameBoard.spaces[18] == this.gameBoard.spaces[24]
                && this.gameBoard.spaces[30] == this.gameBoard.spaces[36] && this.gameBoard.spaces[12] != Space.EMPTY
                && this.gameBoard.spaces[12] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[13] == this.gameBoard.spaces[19] && this.gameBoard.spaces[19] == this.gameBoard.spaces[25]
                && this.gameBoard.spaces[25] == this.gameBoard.spaces[31] && this.gameBoard.spaces[13] != Space.EMPTY
                && this.gameBoard.spaces[13] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[14] == this.gameBoard.spaces[22] && this.gameBoard.spaces[22] == this.gameBoard.spaces[30]
                && this.gameBoard.spaces[30] == this.gameBoard.spaces[38] && this.gameBoard.spaces[14] != Space.EMPTY
                && this.gameBoard.spaces[14] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[15] == this.gameBoard.spaces[23] && this.gameBoard.spaces[23] == this.gameBoard.spaces[31]
                && this.gameBoard.spaces[31] == this.gameBoard.spaces[39] && this.gameBoard.spaces[15] != Space.EMPTY
                && this.gameBoard.spaces[15] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[16] == this.gameBoard.spaces[24] && this.gameBoard.spaces[24] == this.gameBoard.spaces[32]
                && this.gameBoard.spaces[32] == this.gameBoard.spaces[40] && this.gameBoard.spaces[16] != Space.EMPTY
                && this.gameBoard.spaces[16] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[17] == this.gameBoard.spaces[25] && this.gameBoard.spaces[25] == this.gameBoard.spaces[33]
                && this.gameBoard.spaces[33] == this.gameBoard.spaces[41] && this.gameBoard.spaces[17] != Space.EMPTY
                && this.gameBoard.spaces[17] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[17] == this.gameBoard.spaces[23] && this.gameBoard.spaces[23] == this.gameBoard.spaces[29]
                && this.gameBoard.spaces[29] == this.gameBoard.spaces[35] && this.gameBoard.spaces[17] != Space.EMPTY
                && this.gameBoard.spaces[17] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[18] == this.gameBoard.spaces[24] && this.gameBoard.spaces[24] == this.gameBoard.spaces[30]
                && this.gameBoard.spaces[30] == this.gameBoard.spaces[36] && this.gameBoard.spaces[18] != Space.EMPTY
                && this.gameBoard.spaces[18] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[19] == this.gameBoard.spaces[25] && this.gameBoard.spaces[25] == this.gameBoard.spaces[31]
                && this.gameBoard.spaces[31] == this.gameBoard.spaces[37] && this.gameBoard.spaces[19] != Space.EMPTY
                && this.gameBoard.spaces[19] != Space.UNDEFINED){
            return true;
        }
        else if(this.gameBoard.spaces[20] == this.gameBoard.spaces[26] && this.gameBoard.spaces[26] == this.gameBoard.spaces[32]
                && this.gameBoard.spaces[32] == this.gameBoard.spaces[38] && this.gameBoard.spaces[20] != Space.EMPTY
                && this.gameBoard.spaces[20] != Space.UNDEFINED){
            return true;
        }

       return false;

    }

    private boolean IsFilled(){

        if((this.gameBoard.spaces[0] != Space.EMPTY) &&
                (this.gameBoard.spaces[1] != Space.EMPTY) &&
                (this.gameBoard.spaces[2] != Space.EMPTY) &&
                (this.gameBoard.spaces[3] != Space.EMPTY) &&
                (this.gameBoard.spaces[4] != Space.EMPTY) &&
                (this.gameBoard.spaces[5] != Space.EMPTY) &&
                (this.gameBoard.spaces[6] != Space.EMPTY) &&
                (this.gameBoard.spaces[7] != Space.EMPTY) &&
                (this.gameBoard.spaces[8] != Space.EMPTY) &&
                (this.gameBoard.spaces[9] != Space.EMPTY) &&
                (this.gameBoard.spaces[10] != Space.EMPTY) &&
                (this.gameBoard.spaces[11] != Space.EMPTY) &&
                (this.gameBoard.spaces[12] != Space.EMPTY) &&
                (this.gameBoard.spaces[13] != Space.EMPTY) &&
                (this.gameBoard.spaces[14] != Space.EMPTY) &&
                (this.gameBoard.spaces[15] != Space.EMPTY) &&
                (this.gameBoard.spaces[16] != Space.EMPTY) &&
                (this.gameBoard.spaces[17] != Space.EMPTY) &&
                (this.gameBoard.spaces[18] != Space.EMPTY) &&
                (this.gameBoard.spaces[19] != Space.EMPTY) &&
                (this.gameBoard.spaces[20] != Space.EMPTY) &&
                (this.gameBoard.spaces[21] != Space.EMPTY) &&
                (this.gameBoard.spaces[22] != Space.EMPTY) &&
                (this.gameBoard.spaces[23] != Space.EMPTY) &&
                (this.gameBoard.spaces[24] != Space.EMPTY) &&
                (this.gameBoard.spaces[25] != Space.EMPTY) &&
                (this.gameBoard.spaces[26] != Space.EMPTY) &&
                (this.gameBoard.spaces[27] != Space.EMPTY) &&
                (this.gameBoard.spaces[28] != Space.EMPTY) &&
                (this.gameBoard.spaces[29] != Space.EMPTY) &&
                (this.gameBoard.spaces[30] != Space.EMPTY) &&
                (this.gameBoard.spaces[31] != Space.EMPTY) &&
                (this.gameBoard.spaces[32] != Space.EMPTY) &&
                (this.gameBoard.spaces[33] != Space.EMPTY) &&
                (this.gameBoard.spaces[34] != Space.EMPTY) &&
                (this.gameBoard.spaces[35] != Space.EMPTY) &&
                (this.gameBoard.spaces[36] != Space.EMPTY) &&
                (this.gameBoard.spaces[37] != Space.EMPTY) &&
                (this.gameBoard.spaces[38] != Space.EMPTY) &&
                (this.gameBoard.spaces[39] != Space.EMPTY) &&
                (this.gameBoard.spaces[40] != Space.EMPTY) &&
                (this.gameBoard.spaces[41] != Space.EMPTY)){
            return true;
        }

        return false;

    }

}