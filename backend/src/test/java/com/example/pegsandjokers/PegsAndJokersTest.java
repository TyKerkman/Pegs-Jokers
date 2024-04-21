package com.example.pegsandjokers;

import com.example.pegsandjokers.api.controller.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PegsAndJokersTest {

	public static final int NUM_PLAYERS = 4;
	public static final int SIZE_OF_HEAVEN = 5;
	public static final int SIZE_OF_BOARD_SEGMENT = 18;
	public Game g = new Game(0);

	@Test
	public void testInitalizeBoardCreatesCorrectSizeLoop(){
		//Setup
		Board b = g.getBoard();
		int expected = NUM_PLAYERS * SIZE_OF_BOARD_SEGMENT;

		//Execute
		int actual = b.getLoop().length;

		//Test
		assertEquals(expected, actual);
	}

	@Test
	public void testInitalizeBoardCreatesCorrectSizeHeavens(){
		//Setup
		Board b = g.getBoard();

        //Execute
		int actual_row = b.getHeavens().length;
		int actual_col = b.getHeavens()[0].length;

		//Test
		assertEquals(NUM_PLAYERS, actual_row);
		assertEquals(SIZE_OF_HEAVEN, actual_col);
	}

	@Test
	public void testGetHoleIndexStart(){
		//Setup
		Board b = g.getBoard();
		int expected = 0;
		Hole h = b.getLoop()[expected];

		//Execute
		int actual = b.getHoleIndex(h.getId());

		//Test
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHoleIndexMiddle(){
		//Setup
		Board b = g.getBoard();
		int expected = 30;
		Hole h = b.getLoop()[expected];

		//Execute
		int actual = b.getHoleIndex(h.getId());

		//Test
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHoleIndexEnd(){
		//Setup
		Board b = g.getBoard();
		int expected = b.getLoop().length - 1;
		Hole h = b.getLoop()[expected];

		//Execute
		int actual = b.getHoleIndex(h.getId());

		//Test
		assertEquals(expected, actual);
	}

	@Test
	public void testDeckInitializesCorrectly(){
		//Setup
		Deck d = new Deck();
		int expected = 54;

		//Execute
		int actual = d.getCards().size();

		//Test
		assertEquals(expected, actual);
	}

	@Test
	public void testMovePegOut(){
		//Setup
		Game g = new Game(0);
	}
}