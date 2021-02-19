package com.example.Yatzy;

import com.example.Yatzy.rules.Yatzy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class YatzyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testChance() {
		int expected = 7;
		int actual = new Yatzy().chance(1,1,3,1,1);
		assertEquals(expected, actual);
	}

	@Test public void testYatzy() {
		int expected = 50;
		int actual = new Yatzy().yatzy(1,1,1,1,1);
		assertEquals(expected, actual);
		assertEquals(50, new Yatzy().yatzy(1,1,1,1,1));
		assertEquals(0, new Yatzy().yatzy(1,1,1,1,3));
	}

	@Test public void testOnes() {
		assertTrue(new Yatzy().ones(1,2,3,4,5) == 1);
		assertEquals(2, new Yatzy().ones(1,2,1,4,5));
		assertEquals(0, new Yatzy().ones(6,2,2,4,5));
	}

	@Test
	public void testTwos() {
		assertEquals(4, new Yatzy().twos(1,2,3,2,6));
		assertEquals(10, new Yatzy().twos(2,2,2,2,2));
	}

	@Test
	public void testThrees() {
		assertEquals(6, new Yatzy().threes(1,2,3,2,3));
		assertEquals(12, new Yatzy().threes(2,3,3,3,3));
	}

	@Test
	public void testFours()
	{
		assertEquals(12, new Yatzy().fours(4,4,4,5,5));
		assertEquals(8, new Yatzy().fours(4,4,5,5,5));
		assertEquals(4, new Yatzy().fours(4,5,5,5,5));
	}

	@Test
	public void testFives() {
		assertEquals(10, new Yatzy().fives(4,4,4,5,5));
		assertEquals(15, new Yatzy().fives(4,4,5,5,5));
		assertEquals(20, new Yatzy().fives(4,5,5,5,5));
	}

	@Test
	public void testSixes() {
		assertEquals(0, new Yatzy().sixes(4,4,4,5,5));
		assertEquals(6, new Yatzy().sixes(4,4,6,5,5));
		assertEquals(18, new Yatzy().sixes(6,5,6,6,5));
	}

	@Test
	public void testOnePair() {
		assertEquals(6, new Yatzy().score_pair(3,4,3,5,6));
		assertEquals(10, new Yatzy().score_pair(5,3,3,3,5));
	}

	@Test
	public void testTwoPair() {
		assertEquals(16, new Yatzy().two_pair(3,3,5,4,5));
		assertEquals(16, new Yatzy().two_pair(3,3,5,5,5));
	}

	@Test
	public void testThreeOfAKind()
	{
		assertEquals(9, new Yatzy().three_of_a_kind(3,3,3,4,5));
		assertEquals(15, new Yatzy().three_of_a_kind(5,3,5,4,5));
		assertEquals(9, new Yatzy().three_of_a_kind(3,3,3,3,5));
	}

	@Test
	public void testFourOfAKind() {
		assertEquals(12, new Yatzy().four_Of_AKind(3,3,3,3,5));
		assertEquals(20, new Yatzy().four_Of_AKind(5,5,5,4,5));
		assertEquals(12, new Yatzy().four_Of_AKind(3,3,3,3,3));
	}

	@Test
	public void testSmallStraight() {
		assertEquals(15, new Yatzy().smallStraight(1,2,3,4,5));
		assertEquals(0, new Yatzy().smallStraight(2,3,4,5,1));
		assertEquals(0, new Yatzy().smallStraight(1,2,2,4,5));
	}

	@Test
	public void testLargeStraight() {
		assertEquals(0, new Yatzy().largeStraight(6,3,4,2,5));
		assertEquals(20, new Yatzy().largeStraight(2,3,4,5,6));

	}

	@Test
	public void testFullHouse() {
		assertEquals(12, new Yatzy().fullHouse(3,3,2,2,2));
		assertEquals(0, new Yatzy().fullHouse(2,3,4,5,6));

	}

}
