package boardchess;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
	public Piece Piece(int row, int column) {
		if (!PositionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
		
	}
	
	public Piece piece(Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
		
	}
	
	public void PlacePiece(Piece piece, Position position) {
		if (TherelsAPiece(position)) {
			throw new BoardException("There is already a piece on position" + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean PositionExists(int row, int column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
	}
	
	public boolean PositionExists(Position position) {
		return PositionExists(position.getRow(), position.getColumn());
		
	}
	
	public boolean TherelsAPiece(Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
		
	}
	
	public Piece removePiece(Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		
	}
	
}




