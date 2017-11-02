package othello;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int user = 1;

		MinimaxPlayer p1 = new MinimaxPlayer();
		GreedyPlayer p2 = new GreedyPlayer();
		
		while(user == 1){
			OthelloState start = new OthelloState(8);
			int numMoves = 0;
			
			while(!start.gameOver()){
				if(numMoves % 2 == 0){
					System.out.println("Player One");
					System.out.println(start);
					OthelloMove nextmove = p1.getMove(start);
					start = start.applyMoveCloning(nextmove);
					numMoves++;
				} else {
					System.out.println("Player Two");
					System.out.println(start);
					OthelloMove nextmove = p2.getMove(start);
					start = start.applyMoveCloning(nextmove);
					numMoves++;
				}
			}
			System.out.println("Game Over! Try again? 1 for yes, any other number for no");
			user = scan.nextInt();
		}
		System.out.println("Thank you for playing!");
		
	}

}
