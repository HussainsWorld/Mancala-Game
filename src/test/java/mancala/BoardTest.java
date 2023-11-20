package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class BoardTest {
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.initializeBoard();
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        board.registerPlayers(player1, player2);

    }
    private int getPitValue(int pit){
        return board.getPits().get(pit-1).getStoneCount();
    }

    private int getStoreValue(int store){
        return board.getStores().get(store-1).getTotalStones();
    }

    @Test
    public void testCaptureStonesUnderValidPitNum() {
        assertThrows(PitNotFoundException.class, () -> board.captureStones(0));
    }

    @Test
    public void testCaptureStonesOverValidPitNum() {
        assertThrows(PitNotFoundException.class, () -> board.captureStones(14));
    }

    @Test
    public void testCaptureStonesInvalidCapturePit() throws PitNotFoundException {
        assertEquals(0, board.captureStones(2));
    }

    @Test
    public void testCaptureStonesValidCapturePit() throws PitNotFoundException {
        board.getPits().get(5-1).removeStones();
        board.getPits().get(5-1).addStone();
        int capturedStones = board.captureStones(5);

        assertEquals(5, capturedStones);
    }

    @Test
    public void testDistributeStonesUnderValidPitNum() {
        assertThrows(PitNotFoundException.class, () -> board.distributeStones(0));
    }

    @Test
    public void testDistributeStonesOverValidPitNum() {
        assertThrows(PitNotFoundException.class, () -> board.distributeStones(14));
    }

    @Test
    public void testDistributeStonesWorking() throws PitNotFoundException{
        int startPit = 5;
        board.distributeStones(startPit);
        assertEquals(1, getStoreValue(1));
        assertEquals(5, getPitValue(7));
    }

    @Test
    public void testDistributeStonesSkipStore() throws PitNotFoundException{
        // Assuming you have a valid move (e.g., startPit = 1)
        int startPit = 6;
        for (int i = 0; i < 4; i++) {
            board.getPits().get(6-1).addStone();
        }
        //pit 6 should have 8 stones now
        //check if the stores have the values they should
        //check if after skipping store it adds to own pit

        // Perform the move
        board.distributeStones(startPit);
        assertEquals(1, getStoreValue(1));
        assertEquals(0, getStoreValue(2));
        assertEquals(5, getPitValue(1));
    }

    @Test
    public void testGetNumStonesInvalidPit() {
        assertThrows(PitNotFoundException.class, () -> board.getNumStones(14));
    }

    @Test
    public void testGetNumStonesValidPit() throws PitNotFoundException{
        assertEquals(4,board.getNumStones(3));
    }


    @Test
    public void testIsSideEmptyUnderValidPitNum() {
        assertThrows(PitNotFoundException.class, () -> board.isSideEmpty(0));
    }

    @Test
    public void testIsSideNotEmpty() throws PitNotFoundException{
        assertFalse(board.isSideEmpty(1));
    }
    @Test
    public void testIsSideEmpty() throws PitNotFoundException{
        for (int i = 0; i < 6; i++) {
            board.getPits().get(i).removeStones();
        }
        assertTrue(board.isSideEmpty(1));
    }


    @Test
    public void testResetBoard() {
        board.getPits().get(3).removeStones();
        
        board.resetBoard();
        for (int i = 1; i < 12; i++) {
            assertEquals(4, board.getPits().get(i).getStoneCount());
        }
    }

    @Test
    public void testRegisterPlayers() {
        assertEquals(player1, board.getStores().get(0).getOwner());
        assertEquals(player2, board.getStores().get(1).getOwner());
        assertEquals(board.getStores().get(0), player1.getStore());
        assertEquals(board.getStores().get(1), player2.getStore());
    }

}
