public class Rules {
    
    private Board f;
    private Stone[] win_safe; 
    private int win_player;
    public Rules(Board feld)
    {
        this.f=feld;
        win_safe=new Stone[2];
        win_player=0;
    }
    
    public int win_player(){
        return win_player;
    }

    public int[] format_move(int pos_x,int pos_y){
        int[] count =  new int[2];
        for(int k = 100; k < ZEICHENFENSTER.gibFenster().get_hoehe();k+=100){
            if(pos_y > k - 100 && pos_y < k){
                break;
            }else{
                count[1]++;
            }
        }
        for(int i =100; i <ZEICHENFENSTER.gibFenster().get_breite();i+=100){
            if(pos_x > i - 100 && pos_x < i){
                break;
            }else{
                count[0]++;
            }
        }
        return count;
    }

    public boolean already_occupied(int pos_x,int pos_y){
        if(f.get_Spielfeld()[pos_x][pos_y] == null){
            return false;          
        }
        return true;
    }

    public void draw_win_line(Stone[] pos){
        ZEICHENFENSTER.gibFenster().zeichneStrecke(pos[0].get_Stein()[0], pos[0].get_Stein()[1], pos[1].get_Stein()[0], pos[1].get_Stein()[1]);
    }

    public Stone[] get_win_stone(){
        return win_safe;
    }

    public boolean game_won(Stone[][] my_board){
        if(check_vertikal(my_board)|| check_horizontal(my_board) || check_diagonal_right_to_left(my_board)|| check_diagonal_left_to_right(my_board)){
            return true;
        }
         return false;
    }

    public boolean tie(Stone [][] board){
        for(int i =0;i < board.length;i++){
            for(int k =0;k < board[i].length;k++){
                if(board[i][k]==null){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check_horizontal(Stone[][] board){
        for(int k =0;k < 3;k++){
            if(board[0][k]==null || board[1][k]==null || board[2][k]==null){
                continue;
            }
            if(board[0][k].get_Stein()[3] == board[1][k].get_Stein()[3] && board[2][k].get_Stein()[3] == board[0][k].get_Stein()[3]){
                win_safe[0] = board[0][k];
                win_safe[1] = board[2][k];
                win_player=board[0][k].get_Stein()[3];
                return true;
            } 
        }
        return false;
    }

    private boolean check_vertikal(Stone[][] board){
        for(int i =0;i < board.length;i++){
            if(board[i][0]==null || board[i][1]==null || board[i][2]==null){
               continue;
            }
            if(board[i][0].get_Stein()[3] == board[i][1].get_Stein()[3] && board[i][2].get_Stein()[3] == board[i][0].get_Stein()[3]){
                win_safe[0] = board[i][0];
                win_safe[1] = board[i][2];
                win_player=board[i][0].get_Stein()[3];
                return true;
                }            
            }
        return false;
    }

    private boolean check_diagonal_right_to_left(Stone[][] board){
        if(board[0][0]==null || board[1][1]==null || board[2][2]==null){
            return false;
        }
        if(board[0][0].get_Stein()[3] == board[1][1].get_Stein()[3] && board[0][0].get_Stein()[3] == board[2][2].get_Stein()[3]){
            win_safe[0] = board[0][0];
            win_safe[1] = board[2][2];
            win_player=board[0][0].get_Stein()[3];
            return true;
        }
        return false;
    }

    private boolean check_diagonal_left_to_right(Stone[][] board){
        if(board[0][2]==null || board[1][1]==null || board[2][0]==null){
            return false;
        }
        if(board[0][2].get_Stein()[3] == board[1][1].get_Stein()[3] && board[0][2].get_Stein()[3] == board[2][0].get_Stein()[3]){
            win_safe[0] = board[0][2];
            win_safe[1] = board[2][0];
            win_player=board[0][2].get_Stein()[3];
            return true;
        }
        return false;
      }

}
