package chess;

import chess.models.Board;

import java.util.ArrayList;

public class ChessApplication {
    public static void main(String[] args) {
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
