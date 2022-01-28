public class Start {
    
    private int player;
    private boolean tie;
    private Board b;
    private Input inp;
    private Rules r;
    private Ai ai;

    public Start(){
        b = new Board();
        inp = new Input(b);
        r = new Rules(b);
        ai = new Ai(inp,b,r);
        player = 1;
        tie = false;
        start();    
    }
    public void start(){
        b.draw_board(); 
        game_loop();
        if(!tie){
            r.draw_win_line(r.get_win_stone());
        }
    }
     public void game_loop(){
        while(!r.game_won(b.get_Spielfeld())){
            if(r.tie(b.get_Spielfeld())){
                System.out.println("draw");
                tie = true;
                return;
            }
            if (player==4){
                if(ZEICHENFENSTER.gibFenster().get_click()){
                    boolean add = inp.add_Stone(player);
                    ZEICHENFENSTER.gibFenster().reset_clicked();
                    if(add){
                        player=1;
                    }
                    b.draw_board();
                }
                continue;
            }
            ZEICHENFENSTER.gibFenster().warte(100);
            ZEICHENFENSTER.gibFenster().warte(100);
            if(ai.ai_move()){
                player = 4;
            }
            b.draw_board();
        }
    }
}
