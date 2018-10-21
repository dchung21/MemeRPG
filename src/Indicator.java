public class Indicator {

    private int x, y,i;

    Indicator(){
        x = 200;
        y = 675;
        i = 1;
    }
    public void select(CombatMap c){
        c.getEnemy().damage(c.getCp().getMyMeme().getAttack(x/200).getPower());
    }

    public void right(){
        x += 200;
    }

    public void left(){
        x -= 200;
    }

    public int getX(){
        return(x);
    }

    public int getY(){
        return(y);
    }

}
