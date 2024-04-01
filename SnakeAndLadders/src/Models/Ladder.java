package Models;

public class Ladder {
    private int startPos,endPos;

    public Ladder(int start,int end){
        this.startPos = start;
        this.endPos = end;
    }

    public int getStartPosition(){
        return this.startPos;
    }

    public int getEndPosition(){
        return this.endPos;
    }
}
