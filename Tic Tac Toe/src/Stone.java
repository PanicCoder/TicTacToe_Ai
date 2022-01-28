public class Stone{

    private int stone[];

    public Stone(int xPos, int yPos, int radius,int farbnr){
        stone = new int[]{xPos,yPos,radius,farbnr};
    }

    public int[] get_Stein(){
        return stone;
    }
    public void zeichne(){
        ZEICHENFENSTER.gibFenster().fuelleKreis(stone[0], stone[1], stone[2], stone[3]);
    }
    public void change_shape(int x_pos,int y_pos){
        stone[0]=x_pos;
        stone[1]=y_pos;
    }

    public void clear(){
        ZEICHENFENSTER.gibFenster().loescheKreis(stone[0], stone[1], stone[2]);
    }
     
}