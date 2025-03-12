package chess;

import chess.controllers.GameController;
import chess.exceptions.*;
import chess.models.*;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersMismatchException, DuplicateChessColorPieceException, MoreThanOneBotException, OutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        List<Player> players = List.of(
                new Player(1L,new Symbol('A'),"AK", PlayerType.HUMAN, ChessPieceColor.WHITE),
                new Player(1L,new Symbol('B'),"BK", PlayerType.HUMAN, ChessPieceColor.BLACK)

        );

        List<WinningStrategy> winningStrategies = List.of();
        List<SpecialCaseStrategy> specialCaseStrategies = List.of();

        Game game = gameController.startGame(players,winningStrategies,specialCaseStrategies);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.getGameState(game).equals(GameState.WIN)){
            System.out.println("Winner is : "+gameController.getWinner(game).getName());
        }else{
            System.out.println("Game has been Drawn!!!");
        }



        //        Play
        Board board = new Board(new ArrayList<>());
        board.display();

//        System.out.println("♗"+"♛\uD83C\uDFF0"+"♔"+"♔");
//
//        System.out.println("\n" +
//                "\uD83D\uDC19\uD83E\uDD90\uD83E\uDD91\u200D\uD83E\uDD9E\uD83E\uDD80\uD83E\uDD91\u200D\uD83E\uDD90\uD83D\uDC19\n" +
//                "\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\uD83C\uDF64\n" +
//                "⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A\n" +
//                "\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\n" +
//                "⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A\n" +
//                "\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\uD83C\uDF0A⛰\n" +
//                "\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\uD83D\uDC6E\n" +
//                "\uD83C\uDFF0\uD83C\uDFC7\u200D\uD83E\uDD3A\uD83D\uDC78\uD83E\uDD34\u200D\uD83E\uDD3A\uD83C\uDFC7\uD83C\uDFF0\n");
//
//        System.out.println("╔═╤═╤═╤═╤═╤═╤═╤═╗╮\n" +
//                "║│♞│♝│♛│♚│♝│♞│♜║8\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║♟│♟│♟│♟│♟│♟│♟│♟║7\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║ │░│ │░│ │░│ │░║6\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║░│ │░│ │░│ │░│ ║5\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║ │░│ │░│ │░│ │░║4\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║░│ │░│ │░│ │░│ ║3\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║♙│♙│♙│♙│♙│♙│♙│♙║2\n" +
//                "╟─┼─┼─┼─┼─┼─┼─┼─╢┊\n" +
//                "║♖│♘│♗│♕│♔│♗│♘│♖║1\n" +
//                "╚═╧═╧═╧═╧═╧═╧═╧═╝┊\n" +
//                "╰a┈b┈c┈d┈e┈f┈g┈h┈╯");
//
//        System.out.println("╔════════╗\n" +
//                "║♜♞♝♛♚♝♞♜║\n" +
//                "║♟♟♟♟♟♟♟♟║\n" +
//                "║▒█▒█▒█▒█║\n" +
//                "║█▒█▒█▒█▒║\n" +
//                "║▒█▒█▒█▒█║\n" +
//                "║█▒█▒█▒█▒║\n" +
//                "║♙♙♙♙♙♙♙♙║\n" +
//                "║♖♘♗♕♔♗♘♖║\n" +
//                "╚════════╝");
    }
}
