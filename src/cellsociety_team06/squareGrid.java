package cellsociety_team06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class squareGrid extends Grid {
	int[] rowMove;
	int[] colMove;
	double rectWidth, rectHeight;
	

	public squareGrid(int rows, int cols, int heightSquare, int widthSquare) {
		super(rows, cols);
		rowMove = new int[] {-1, 0, 0, 1};
		colMove = new int[] {0, 1, -1, 0};
		rectWidth = widthSquare;
		rectHeight = heightSquare;
		fillGrid();
	}

	@Override
	public void fillGrid() {
		for (int i = 0; i < rows(); i++) {
			List<Unit> cols = new ArrayList<>();
			for (int j = 0; j < cols(); j++) {
				Unit u = new Unit();
				u.getPoints().addAll(new Double[]{
						0.0, 0.0,
			            rectHeight, 0.0,
			            rectHeight, rectWidth,
			            0.0, rectWidth});
				u.setLayoutX(i * rectHeight);
				u.setLayoutY(j * rectWidth);
				cols.add((Unit) u);
			}
			grid.add(cols);
		}
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
