package othello;

import java.util.List;

public class RandomPlayer extends OthelloPlayer{
	/*
	 * Implement a RandomPlayer that just chooses moves randomly from a list of available, 
	 * legal moves. This will be a good baseline player to check the efficacy of your other agents.
	 * 
	 */
	
	public OthelloMove getMove(OthelloState state){
		List<OthelloMove> moves;
		moves = state.generateMoves();
		if(moves.size() <= 0){
			return null;
		}
		int rand = (int)(Math.random() * moves.size());
		return moves.get(rand);
	}
}
