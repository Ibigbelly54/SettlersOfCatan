public class Runner {

    private static StartFrame output;
   // private static BuildFrame build;
    public static void main(String[] args)
    {
        GameEngine eng = new GameEngine();

        MapTile[][] board = GameEngine.getBoard();
        for(int r=0; r<5; r++) {
            for(int c=0; c<5; c++) {
                if(board[r][c] != null) {
                    System.out.print(board[r][c].getResource() + " ");
                }

            }
            System.out.println();
        }
        for(int r=0; r<5; r++) {
            for(int c=0; c<5; c++) {
                if(board[r][c] != null) {
                    System.out.print("[" + r + "," + c + "] ");
                }

            }
            System.out.println();
        }
        output = new StartFrame();
      //  BoardPanel pan = new BoardPanel();
        //build= new BuildFrame();

    }
    static StartFrame returnStartFrame(){
        return output;
    }


}
