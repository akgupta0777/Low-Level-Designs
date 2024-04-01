package Models;

import java.util.HashMap;

public class Board {
    private int size;
    private HashMap<Integer,Snake> snakes;
    private HashMap<Integer,Ladder> ladders;
    

    public Board(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public void setSnakes(HashMap<Integer,Snake> snakes){
        this.snakes = snakes;
    }

    public void setLadders(HashMap<Integer,Ladder> ladders){
        this.ladders = ladders;
    }

    public Snake getSnake(int position){
        return this.snakes.get(position);
    }

    public Ladder getLadder(int position){
        return this.ladders.get(position);
    }

    public boolean checkForSnake(int position){
        return snakes.containsKey(position);
    }

    public boolean checkForLadder(int position){
        return ladders.containsKey(position);
    }
}
