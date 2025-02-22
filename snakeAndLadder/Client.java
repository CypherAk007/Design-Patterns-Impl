package snakeAndLadder;


import snakeAndLadder.Exceptions.DuplicateSymbolException;
import snakeAndLadder.Exceptions.MoreThanOneBotException;
import snakeAndLadder.Exceptions.ObstacleOutOfBoundsException;
import snakeAndLadder.Exceptions.PlayersAndDimensionsMismatchException;
import snakeAndLadder.Strategies.WinningStrategy;
import snakeAndLadder.controllers.GameController;
import snakeAndLadder.models.*;


import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, ObstacleOutOfBoundsException, MoreThanOneBotException {

        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        int sizeOfBoard = 4;

        List<Player> players = List.of(
                new Player(1L,"Ak",new Symbol('A'), PlayerType.HUMAN),
//                new Player(1L,"Zk",new Symbol('Z'), PlayerType.HUMAN),
//                new Player(1L,"Yk",new Symbol('Y'), PlayerType.HUMAN),
                new Bot(2L,"GPT",new Symbol('X'), BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of();
//        List<Obstacles> ladderLocations = List.of(new Obstacles(2,15),
//                new Obstacles(6,13)
//        );
//        List<Obstacles> snakeLocations = List.of(new Obstacles(14,1),
//                new Obstacles(5,2)
//        );
        List<Obstacles> ladderLocations = List.of(
        );
        List<Obstacles> snakeLocations = List.of(
        );

        Game game = gameController.startGame(sizeOfBoard,players,winningStrategies,ladderLocations,snakeLocations);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        gameController.displayBoard(game);
//        for(int i=1;i<=16;i++){
//        int[] val = game.getBoard().findRowAndColGivenCellNumber(i);
//        System.out.println("row: "+val[0]+"col: "+val[1]);

//        }

//        if(gameController.getGameState(game).equals(GameState.DRAW)){
//            System.out.println("Game has been drawn!!");
//        }else{
//            System.out.println("The winner is:- "+gameController.getWinner(game));
//        }


    }
}
