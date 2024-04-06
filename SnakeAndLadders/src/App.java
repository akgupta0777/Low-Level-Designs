import java.util.*;
import Models.*;
import Services.GameService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int countOfSnakes = sc.nextInt();
		HashMap<Integer,Snake> snakes = new HashMap<>();
		HashMap<Integer,Ladder> ladders = new HashMap<>();
        Queue<Player> players = new LinkedList<>();
		for(int i=1;i<=countOfSnakes;++i){
			int startPos = sc.nextInt();
			int endPos = sc.nextInt();
			Snake snake = new Snake(startPos,endPos);
			snakes.put(startPos,snake);
		}
        int countOfLadders = sc.nextInt();
        for(int i=1;i<=countOfLadders;++i){
            int startPos = sc.nextInt();
            int endPos = sc.nextInt();
            Ladder ladder = new Ladder(startPos,endPos);
            ladders.put(endPos,ladder);
        }
        int countOfPlayers = sc.nextInt();
        for(int i=1;i<=countOfPlayers;++i){
            String name = sc.next();
            Player player = new Player(name);
            players.offer(player);
        }
        int boardSize = sc.nextInt();

        GameService snl = new GameService(boardSize);
        snl.setSnakes(snakes);
        snl.setLadders(ladders);
        snl.setPlayers(players);
        snl.setNumberOfDices(2);
        snl.setContinueUntilAllPlayersLeft(true);
        snl.startGame();
		sc.close();
    }
}
