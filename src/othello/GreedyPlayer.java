package othello;

import java.util.List;

public class GreedyPlayer {
	/*
	 * Implement a GreedyPlayer that chooses the move guaranteed to provide the 
	 * best score based solely on that move. In other words, it should choose 
	 * the move that provides the best immediate payoff.  In the event of two or 
	 * more moves of equal value, choose one at random.
	 */
	
	public OthelloMove getMove(OthelloState state){
		OthelloState clone;
		int max = 0, index = 0, i = 0;
		List<OthelloMove> moves;
		moves = state.generateMoves();		//makes a list of moves
		if(moves.size() <= 0){				//if size is 0 or less, return null
			return null;
		}
		for(OthelloMove move : moves){					//for every move
			clone = state.applyMoveCloning(move);		//set clone equal to after applying the move
			if(max < clone.getCount()){					//if clone's count of opponent pieces turned is greater than min
				max = clone.getCount();					//then set min equal to the getCount of clone
				index = i;								//and set index equal to i, which adds one to itself every loop of the for each
			}
			i++;										//the adding
		}
		return moves.get(index);						//returning the move
	}
}
