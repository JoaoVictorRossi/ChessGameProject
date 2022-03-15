package chess.pieces;

import boardchess.Board;
import boardchess.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// NW moves
		p.setValues(position.getRow() -1, position.getColumn() -1);
		while (getBoard().PositionExists(p) && !getBoard().TherelsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);;
		}
		if (getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		// NE moves
		p.setValues(position.getRow() -1, position.getColumn() +1);
		while (getBoard().PositionExists(p) && !getBoard().TherelsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() -1, p.getColumn() +1);
		}
		if (getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		// SE moves
		p.setValues(position.getRow() +1, position.getColumn() +1);
		while (getBoard().PositionExists(p) && !getBoard().TherelsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		// above moves
		p.setValues(position.getRow() +1, position.getColumn() -1);
		while (getBoard().PositionExists(p) && !getBoard().TherelsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().PositionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "B";
	}
	
	
	
	

}
