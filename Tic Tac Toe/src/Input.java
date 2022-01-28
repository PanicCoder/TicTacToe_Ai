public class Input {
    private int[] pos_mouse;
    private Rules r;
    private Board feld;
    public Input(Board f){
        pos_mouse = new int[2];
        this.feld=f;
        this.r = new Rules(feld);
    }

    public void update_pos(){
        pos_mouse[0]=ZEICHENFENSTER.gibFenster().get_pos_x();
        pos_mouse[1]=ZEICHENFENSTER.gibFenster().get_pos_y();
    }

    public boolean add_Stone(int player){
        update_pos();
        int pos[] = r.format_move(pos_mouse[0], pos_mouse[1]);
        if(!r.already_occupied(pos[0], pos[1])){
            feld.stein_einfuegen(new Stone(pos[0], pos[1], 40, player), pos[0], pos[1]);
            return true;
        }
        return false;
    }

    public boolean add_Stone_from_ai(int x, int y){
        if(!r.already_occupied(x, y)){
            feld.stein_einfuegen(new Stone(x, y, 40, 1), x, y);
            return true;
        }
        return false;
    }
}
