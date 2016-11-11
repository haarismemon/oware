package functionality;

import java.util.Random;

/**
 * This class represents a basic computer player in the single player mode.
 *
 * @author Aqib Rashid
 * @author Haaris Memon
 */

public class BasicComputerPlayer extends Player {

	private Board board;
	private int randomPosition;

	/**
	 * Creates a new Player with name Computer
	 */
	public BasicComputerPlayer() {
		super("Computer");
	}

	/**
	 * Set the board that the computer player is playing on
	 *
	 * @param board that player is playing on
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Returns the board that the computer player is playing on
	 *
	 * @return board computer player playing on
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Generate and store the random integer position
	 * @return
	 */
	public int generateAndStoreRandomPosition() {
		randomPosition = new Random().nextInt(6);
		return randomPosition;
	}

	/**
	 * Makes move to sow at random position generated previously
	 * @return the random house clicked on the first row
	 */
	public void makeMove() {
        generateAndStoreRandomPosition();
        while (getBoard().getHouseOnBoard(0, randomPosition).getCount() == 0 || !getBoard().canSow(0, randomPosition) || !getBoard().checkMove(0, randomPosition)) {
            generateAndStoreRandomPosition();
        }

		// Assuming the computer will always be row 0
		board.sow(0, randomPosition);
	}

}