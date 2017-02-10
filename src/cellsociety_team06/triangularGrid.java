package cellsociety_team06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class triangularGrid extends Grid {
	int[] rowMove;
	int[] colMove;
	double length;
	

	public triangularGrid(int rows, int cols, int length) {
		super(rows, cols);
		rowMove = new int[] {-1, 0, 0, 1};
		colMove = new int[] {0, 1, -1, 0};
		this.length = length;
		fillGrid();
	}

	@Override
	public void fillGrid() {
		for (int i = 0; i < rows(); i++) {
			List<Unit> cols = new ArrayList<>();
			for (int j = 0; j < cols(); j++) {
				Unit u = new Unit();
				setPoly(u, i, j);
				cols.add((Unit) u);
			}
			grid.add(cols);
		}
	}
	
	private void setPoly(Unit u, int row, int col){
		int orientation = 1;
		if((row + col) % 2 != 0){
			orientation = -1;
			setLayoutDown(u, row, col);
		}
		else{
			setLayoutUp(u, row, col);
		}
		u.getPoints().addAll(new Double[]{
				0.0, 0.0,
	            length, 0.0,
	            length/2.0, orientation * Math.pow(3, 0.5) * length/2.0});
		
	}
	
	private void setLayoutDown(Unit u, int row, int col){
		u.setLayoutX(row * length - (row - 1) * length/2);
		u.setLayoutY(col * length + Math.pow(3, 0.5) * length/2);
	}
	
	private void setLayoutUp(Unit u, int row, int col){
		u.setLayoutX(row * length - (row - 1) * length /2);
		u.setLayoutY(col * length);
	}

	
	@Override
	public Map<Integer[], Unit> getNeighbors(int row, int col) {
		Map<Integer[], Unit> map = new HashMap<>();
		Unit u;
		Integer[] place;
		for(int i = 0; i < rowMove.length; i++){
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];
			if(newRow >= 0 && newRow < rows() && newCol >= 0 && newCol < cols()){
				place = new Integer[] {newRow, newCol};
				u = grid.get(newCol).get(newRow);
				map.put(place, u);
			}
		}
		return map;
	}
}
