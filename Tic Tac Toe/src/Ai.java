public class Ai {

    private Input input;
    private Board board;
    private Rules rules;

    public Ai(Input i, Board b,  Rules r){
        this.input = i;
        this.board = b;
        this.rules = r;
    }


    public boolean ai_move() {
        return bestMove(board.get_Spielfeld());
    }


    public boolean bestMove(Stone[][] board) {
        double bestScore = Double.NEGATIVE_INFINITY;
        int[] move = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new Stone(0,0,0,1);
                    double score = minimax(board, 0, false);
                    board[i][j] = null;
                    if (score > bestScore){
                        bestScore = score;
                        move = new int[]{i,j};
                    }
                }
          }
        }
        return input.add_Stone_from_ai(move[0], move[1]);
      }
      
      
    public double minimax(Stone[][] board, int depth, boolean isMaximizing) {
        boolean result = rules.game_won(board);
        if (result) {
            if(rules.win_player()==1){
                return 1.0;
            }
            return -1.0;
        }
        if(rules.tie(board)){
            return 0.0;
        }
      
        if(isMaximizing){
          double bestScore = Double.NEGATIVE_INFINITY;
          for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
              if(board[i][j] == null) {
                board[i][j] = new Stone(0,0,0,1);
                double score = minimax(board, depth + 1, false);
                board[i][j] = null;
                bestScore = Math.max(score, bestScore);
              }
            }
          }
          return bestScore;
        }else {
          double bestScore = Double.POSITIVE_INFINITY;
          for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
              if (board[i][j] == null) {
                board[i][j] = new Stone(0,0,0,4);
                double score = minimax(board, depth + 1, true);
                board[i][j] = null;
                bestScore = Math.min(score, bestScore);
              }
            }
          }
          return bestScore;
        }
      }
}
