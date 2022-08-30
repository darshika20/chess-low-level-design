package application;

import commons.ChessUtils;
import factory.AllPiecesFactory;
import model.*;
import service.BoardService;
import service.PieceService;

import java.util.*;

public class ChessApplication {

    public static void main(String[] args) {

        List<Piece> pieceList = AllPiecesFactory.getAllDefaultPieces();
        Map<PieceType, List<Piece>> whitePieceTypeListMap = getPieceMapForColor(pieceList, Color.WHITE);
        Map<PieceType, List<Piece>> blackPieceTypeListMap = getPieceMapForColor(pieceList, Color.BLACK);


        Board board = ChessUtils.getBoard();
        BoardService boardService = new BoardService(board);
        boardService.initializeBoard(whitePieceTypeListMap, blackPieceTypeListMap);

        boardService.displayBoard();

        System.out.println("Get all moves for white pawn");
        PieceService pieceService = new PieceService();
        Piece firstWhitePawn = whitePieceTypeListMap.get(PieceType.PAWN).get(0);
        Set<Cell> moves = pieceService.getAllValidMoves(firstWhitePawn);
        Cell cellToMove = null;
        for (Cell cell : moves) {
            if (cell.getRow() == 3 && cell.getCol() == 0) {
                cellToMove = cell;
            }
            System.out.println(cell.getRow() + " " + cell.getCol());
        }
        System.out.println("Moving White Pawn to 2 steps");
        pieceService.move(cellToMove, firstWhitePawn);
        boardService.displayBoard();
    }

    private static Map<PieceType, List<Piece>> getPieceMapForColor(List<Piece> pieceList, Color color) {
        Map<PieceType, List<Piece>> pieceTypeListMap = new HashMap<>();
        for (Piece piece : pieceList) {
            if (piece.getColor() == color) {
                if (!pieceTypeListMap.containsKey(piece.getName())) {
                    pieceTypeListMap.put(piece.getName(), new ArrayList<>());
                }
                pieceTypeListMap.get(piece.getName()).add(piece);
            }
        }
        return pieceTypeListMap;
    }
}
