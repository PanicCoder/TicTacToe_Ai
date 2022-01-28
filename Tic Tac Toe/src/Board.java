public class Board {
    
    private Stone board[][];

    public Board(){
        board = new Stone[3][3];
        ZEICHENFENSTER.gibFenster().setzeTitel("Tic Tac Toe");
    }

    public void draw_board() {
        for(int i =0; i < ZEICHENFENSTER.gibFenster().get_breite();i+=100) {
            for(int k =0; k < ZEICHENFENSTER.gibFenster().get_hoehe();k+=100){
                if (board[i/100][k/100]==null){
                    ZEICHENFENSTER.gibFenster().zeichneKreis(i+50, k+50, 40);
                }else{
                    board[i/100][k/100].zeichne();
                }
                ZEICHENFENSTER.gibFenster().zeichneRechteck(i, k, 100, 100);
            }
        }
    }

    public void clear(int x,int y){
        board[x][y].clear();
    }

    public void stein_einfuegen(Stone st,int pos_x,int pos_y){
        st.change_shape((pos_x*100)+50,(pos_y*100)+50);
        board[pos_x][pos_y]=st;
    }
    
    public Stone[][] get_Spielfeld(){
        return board;
    }

}
