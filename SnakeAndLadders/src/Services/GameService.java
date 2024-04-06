package Services;

import Models.*;
import java.util.*;

public class GameService {
    private Board gameBoard;
    private int boardSize;
    private int numberOfPlayers;
    private int numberOfDices;
    private boolean continueUntilPlayersLeft;
    private Queue<Player> players;
    private HashMap<String,Integer> position;
    private static final int DEFAULT_SIZE = 100;
    private static final int DEFAULT_NO_OF_DICES = 1;

    public GameService(){
        this(DEFAULT_SIZE);
    }

    public GameService(int boardSize){
        this.boardSize = boardSize;
        this.gameBoard  = new Board(this.boardSize);
        this.numberOfDices = DEFAULT_NO_OF_DICES;
        this.position = new HashMap<>();
    }

    public void setSnakes(HashMap<Integer,Snake> snakes){
        this.gameBoard.setSnakes(snakes);
    }

    public void setLadders(HashMap<Integer,Ladder> ladders){
        this.gameBoard.setLadders(ladders);
    }

    public void setPlayers(Queue<Player> players){
        this.players = players;
        this.numberOfPlayers = players.size();
        for(Player current : players){
            this.position.put(current.getID(), 0);
        }
    }

    public void setNumberOfDices(int dices){
        this.numberOfDices = dices;
    }

    public void setContinueUntilAllPlayersLeft(boolean value){
        this.continueUntilPlayersLeft = value;
    }

    public boolean isGameCompleted(){
        if(continueUntilPlayersLeft){
            return players.size()<=1;
        }
        return players.size()<numberOfPlayers;
    }

    public void movePlayer(Player currentPlayer,int diceValue){
        int currentPosition = position.get(currentPlayer.getID());
        int newPosition = currentPosition+diceValue;

        if(newPosition > boardSize){
            System.out.println(currentPlayer.getName()+" rolled a "+diceValue+" and cannot move further.");
            return ;
        }
        if(gameBoard.checkForSnake(newPosition)){
            Snake snake = gameBoard.getSnake(newPosition);
            newPosition = snake.getEndPosition();
        }else if(gameBoard.checkForLadder(newPosition)){
            Ladder ladder = gameBoard.getLadder(newPosition);
            newPosition = ladder.getEndPosition();
        }
        System.out.println(currentPlayer.getName()+" rolled a "+diceValue+" and moved from "+currentPosition+" to "+newPosition);
        position.put(currentPlayer.getID(),newPosition);
    }

    public boolean hasWon(Player currentPlayer){
        return position.get(currentPlayer.getID()) == boardSize;
    }

    public void startGame(){
        DiceService dice = new DiceService(numberOfDices);
        while(!isGameCompleted()){
            int diceValue=0;
            int diceFace=0;
            int numberOfrolls = 0;
            do{
                if(numberOfrolls>=3) break;
                numberOfrolls++;
                diceFace = dice.rollDice();
                diceValue += diceFace;
            }while(diceValue==6);
            if(numberOfrolls>=3) diceValue = 0;
            Player currentPlayer = players.poll();
            if(currentPlayer == null) continue;
            movePlayer(currentPlayer,diceValue);
            if(hasWon(currentPlayer)){
                System.out.println(currentPlayer.getName()+" wins the game");
            }else{
                players.offer(currentPlayer);
            }
        }
    }
}
