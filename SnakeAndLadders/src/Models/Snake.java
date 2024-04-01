package Models;

public class Snake {
	private int startPos,endPos;

	public Snake(int start,int end){
		this.startPos = start;
		this.endPos = start;
	}

	public int getStartPosition(){
		return this.startPos;
	}

	public int getEndPosition(){
		return this.endPos;
	}
}
