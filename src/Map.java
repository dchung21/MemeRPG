public class Map {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static int[][] MAP = new int[WIDTH][HEIGHT];

    Map(){
        generateMap();
    }

    private void generateMap(){
        for(int i = 0; i < MAP.length; i++){
            for(int j = 0; j < MAP.length; j++){
                if(Math.random() > 0.7){
                    MAP[i][j] = 0;
                }

                else{
                    MAP[i][j] = 1;
                }
            }
        }
    }

    public int[][] getMap(){
        return this.MAP;
    }

}
