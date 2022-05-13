public class GameBoard {

    // 00 | 01 | 02 | 03 | 04 | 05 | 06
    //--- --- --- --- --- --- --- --- ---
    // 07 | 08 | 09 | 10 | 11 | 12 | 13
    //--- --- --- --- --- --- --- --- ---
    // 14 | 15 | 16 | 17 | 18 | 19 | 20
    //--- --- --- --- --- --- --- --- ---
    // 21 | 22 | 23 | 24 | 25 | 26 | 27
    //--- --- --- --- --- --- --- --- ---
    // 28 | 29 | 30 | 31 | 32 | 33 | 34
    //--- --- --- --- --- --- --- --- ---
    // 35 | 36 | 37 | 38 | 39 | 40 | 41

    /*
    WINNING CONDITIONS (HORIZONTAL) - 24
    0,1,2,3 | 1,2,3,4 | 2,3,4,5 | 3,4,5,6
    7,8,9,10 | 8,9,10,11 | 9,10,11,12 | 10,11,12,13
    14,15,16,17 | 15,16,17,18 | 16,17,18,19 | 17,18,19,20
    21,22,23,24 | 22,23,24,25 | 23,24,25,26 | 24,25,26,27
    28,29,30,31 | 29,30,31,32 | 30,31,32,33 | 31,32,33,34
    35,36,37,38 | 36,37,38,39 | 37,38,39,40 | 38,39,40,41

    WINNING CONDITIONS (VERTICAL) - 21
    35,28,21,14 | 28,21,14,7 | 21,14,7,0
    36,29,22,15 | 29,22,15,8 | 22,15,8,1
    37,30,23,16 | 30,23,16,9 | 23,16,9,2
    38,31,24,17 | 31,24,17,10 | 24,17,10,3
    39,32,25,18 | 32,25,18,11 | 25,18,11,4
    40,33,26,19 | 33,26,19,12 | 26,19,12,5
    41,34,27,20 | 34,27,20,13 | 27,20,13,6

    WINNING CONDITIONS (DIAGONAL) - 24
    0,8,16,24 | 1,9,17,25 | 2,10,18,26 | 3,9,15,21 | 3,11,19,27 | 4,10,16,22 | 5,11,17,23 | 6,12,18,24
    7,15,23,31 | 8,16,24,32 | 9,17,25,33 | 10,18,26,34 | 10,16,22,28 | 11,17,23,29 | 12,18,24,30 | 13,19,25,31
    14,22,30,38 | 15,23,31,39 | 16,24,32,40 | 17,25,33,41 | 17,23,29,35 | 18,24,30,36 | 19,25,31,37 | 20,26,32,38

    */

    Space spaces[];
    String spacesText[];

    public GameBoard(){
        spaces = new Space[42];


        for(int i = 0; i < spaces.length; i++){
            spaces[i] = Space.EMPTY;
        }

        spacesText = new String[42];

        for(int i = 0; i < spacesText.length; i++){
            spacesText[0] = "00";
            spacesText[1] = "01";
            spacesText[2] = "02";
            spacesText[3] = "03";
            spacesText[4] = "04";
            spacesText[5] = "05";
            spacesText[6] = "06";
            spacesText[7] = "07";
            spacesText[8] = "08";
            spacesText[9] = "09";
            spacesText[10] = "10";
            spacesText[11] = "11";
            spacesText[12] = "12";
            spacesText[13] = "13";
            spacesText[14] = "14";
            spacesText[15] = "15";
            spacesText[16] = "16";
            spacesText[17] = "17";
            spacesText[18] = "18";
            spacesText[19] = "19";
            spacesText[20] = "20";
            spacesText[21] = "21";
            spacesText[22] = "22";
            spacesText[23] = "23";
            spacesText[24] = "24";
            spacesText[25] = "25";
            spacesText[26] = "26";
            spacesText[27] = "27";
            spacesText[28] = "28";
            spacesText[29] = "29";
            spacesText[30] = "30";
            spacesText[31] = "31";
            spacesText[32] = "32";
            spacesText[33] = "33";
            spacesText[34] = "34";
            spacesText[35] = "35";
            spacesText[36] = "36";
            spacesText[37] = "37";
            spacesText[38] = "38";
            spacesText[39] = "39";
            spacesText[40] = "40";
            spacesText[41] = "41";
        }

    }

    public void PlaceOnBoard(Space pieceToPlace, int locationToPlace){

        if(spaces[locationToPlace] == Space.EMPTY){
            spaces[locationToPlace] = pieceToPlace;
            if(pieceToPlace == Space.RED){
                spacesText[locationToPlace] = ".R";
            }
            else{
                spacesText[locationToPlace] = ".Y";
            }

        }
    }

    public void Draw(){
        System.out.println("");
        System.out.println(" " + spacesText[0] + " | " + spacesText[1] + " | " + spacesText[2] + " | " + spacesText[3] + " | " + spacesText[4] + " | " + spacesText[5] + " | " + spacesText[6]);
        System.out.println("----|----|----|----|----|----|----");
        System.out.println(" " + spacesText[7] + " | " + spacesText[8] + " | " + spacesText[9] + " | " + spacesText[10] + " | " + spacesText[11] + " | " + spacesText[12] + " | " + spacesText[13]);
        System.out.println("----|----|----|----|----|----|----");
        System.out.println(" " + spacesText[14] + " | " + spacesText[15] + " | " + spacesText[16] + " | " + spacesText[17] + " | " + spacesText[18] + " | " + spacesText[19] + " | " + spacesText[20]);
        System.out.println("----|----|----|----|----|----|----");
        System.out.println(" " + spacesText[21] + " | " + spacesText[22] + " | " + spacesText[23] + " | " + spacesText[24] + " | " + spacesText[25] + " | " + spacesText[26] + " | " + spacesText[27]);
        System.out.println("----|----|----|----|----|----|----");
        System.out.println(" " + spacesText[28] + " | " + spacesText[29] + " | " + spacesText[30] + " | " + spacesText[31] + " | " + spacesText[32] + " | " + spacesText[33] + " | " + spacesText[34]);
        System.out.println("----|----|----|----|----|----|----");
        System.out.println(" " + spacesText[35] + " | " + spacesText[36] + " | " + spacesText[37] + " | " + spacesText[38] + " | " + spacesText[39] + " | " + spacesText[40] + " | " + spacesText[41]);
        System.out.println("");
    }
}