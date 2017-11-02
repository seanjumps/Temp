package othello;

import java.util.LinkedList;
import java.util.List;

public class MinimaxPlayer {
	/*
	 * Implement a MinimaxPlayer that creates a game tree of specified depth and then performs minimax 
	 * search to select the best move. Your evaluation function can simply be to compare the number of 
	 * each players points on the board.  
	 */
	
	private static int end = 3;
	
	public OthelloMove getMove(OthelloState state){
		if (state.nextPlayerToMove == 0){
			return predictMove(0, state, 0);
		} else {
			return predictMove(0, state, 1);
		}	
	}
	
	public OthelloMove predictMove(int depth, OthelloState state, int turn){
		if(depth >= end || state.generateMoves().size() == 0 || state == null){
			return null;
		}
		
		List<OthelloState> clone = new LinkedList<OthelloState>();
		List<OthelloMove> moves = state.generateMoves();
		
		for(OthelloMove move : moves){
			clone.add(state.applyMoveCloning(move));
		}
		
		if(turn % 2 == 0){
			int[] arr = new int[clone.size()];
			
			for(int i = 0; i < clone.size(); i++){
				OthelloMove t = predictMove(depth++, clone.get(i), turn++);
				arr[i] = (clone.get(i)).applyMoveCloning(t).score(); //see if can change to count
			}
			
			int temp = Integer.MIN_VALUE, index = -1;
			
			for(int i = 0; i < arr.length; i++){	//find the biggest score
				if(temp < arr[i]){
					temp = arr[i];
					index = i;
				}
			}
			
			return state.generateMoves().get(index);
		} else {
			int[] arr = new int[clone.size()];
			
			for(int i = 0; i < clone.size(); i++){
				OthelloMove t = predictMove(depth++, clone.get(i), turn++);
				arr[i] = (clone.get(i)).applyMoveCloning(t).score(); //see if can change to count
			}
			
			int temp = Integer.MIN_VALUE, index = 0;
			
			for(int i = 0; i < arr.length; i++){	//find the smallest score
				if(temp > arr[i]){
					temp = arr[i];
					index = i;
				}
			}
			
			return state.generateMoves().get(index);
		}
	}
}