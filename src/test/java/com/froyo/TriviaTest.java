package com.froyo;


import org.junit.Test;

import static org.junit.Assert.*;


public class TriviaTest {

	@Test
	public void createRockQuestion() {
		Trivia trivia = new Trivia();
		assertEquals("Rock Question 5", trivia.createRockQuestion(9));
	}

	@Test
	public void isPlayable() {
		Trivia trivia = new Trivia();
		assertTrue(trivia.add("isPlayable1"));
		assertFalse(trivia.isPlayable());
		assertTrue(trivia.add("isPlayable2"));
		assertTrue(trivia.isPlayable());
		assertTrue(trivia.add("isPlayable3"));
		assertTrue(trivia.isPlayable());
	}

	@Test
	public void add() {
		Trivia trivia = new Trivia();
		assertTrue(trivia.add("add"));
	}

	@Test
	public void howManyPlayers() {
		Trivia trivia = new Trivia();
		assertTrue(trivia.add("howManyPlayers1"));
		assertTrue(trivia.add("howManyPlayers2"));
		assertTrue(trivia.add("howManyPlayers3"));
		assertEquals(3, trivia.howManyPlayers());
	}

	@Test
	public void roll() {
		Trivia trivia = new Trivia();
		trivia.add("user");
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		assertFalse(trivia.isGettingOutOfPenaltyBox);
		trivia.wrongAnswer();
		trivia.roll(1);
		assertTrue(trivia.isGettingOutOfPenaltyBox);
		trivia.roll(2);
		assertFalse(trivia.isGettingOutOfPenaltyBox);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		trivia.roll(1);
		assertTrue(trivia.isGettingOutOfPenaltyBox);
	}

	@Test
	public void wasCorrectlyAnswered() {
		Trivia trivia = new Trivia();
		trivia.add("WasCorrectlyAnswered");
		assertTrue(trivia.wasCorrectlyAnswered());
		trivia.wrongAnswer();
		assertTrue(trivia.wasCorrectlyAnswered());
	}

	@Test
	public void wrongAnswer() {
		Trivia trivia = new Trivia();
		trivia.add("wrongAnswer");
		trivia.wrongAnswer();
		assertEquals(0, trivia.currentPlayer);
		trivia.add("wrongAnswerBis");
		trivia.wrongAnswer();
		assertEquals(1, trivia.currentPlayer);
	}

}
