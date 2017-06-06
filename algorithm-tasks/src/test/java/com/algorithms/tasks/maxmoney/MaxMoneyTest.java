package com.algorithms.tasks.maxmoney;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxMoneyTest {

	private MaxMoney maxMoney = new MaxMoney();

	@Test
	public void testEmptyArray() {
		assertEquals(0, maxMoney.calculateMaxMoney(null));
		int[] array = new int[0];
		assertEquals(0, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testSingleElememt() {
		int[] array = { 5 };
		assertEquals(5, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testTwoElememts() {
		int[] array1 = { 1, 2 };
		assertEquals(2, maxMoney.calculateMaxMoney(array1));
		int[] array2 = { 2, 1 };
		assertEquals(2, maxMoney.calculateMaxMoney(array2));
		int[] array3 = { 1, 1 };
		assertEquals(1, maxMoney.calculateMaxMoney(array3));
	}

	@Test
	public void testThreeElements1() {
		int[] array = { 1, 3, 1 };
		assertEquals(3, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testThreeElements2() {
		int[] array = { 1, 3, 2 };
		assertEquals(3, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testThreeElements3() {
		int[] array = { 1, 2, 3 };
		assertEquals(4, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testThreeElements4() {
		int[] array = { 2, 3, 2 };
		assertEquals(4, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testFourElements1() {
		int[] array = { 2, 3, 2, 3 };
		assertEquals(6, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testFourElements2() {
		int[] array = { 5, 3, 3, 5 };
		assertEquals(10, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testFiveElements1() {
		int[] array = { 2, 3, 2, 3, 2 };
		assertEquals(6, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testFiveElements2() {
		int[] array = { 2, 3, 2, 3, 5 };
		assertEquals(9, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testSixElements() {
		int[] array = { 2, 3, 2, 3, 2, 3 };
		assertEquals(9, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testSevenElements1() {
		int[] array = { 1, 5, 3, 3, 5, 1 };
		assertEquals(10, maxMoney.calculateMaxMoney(array));
	}

	@Test
	public void testSevenElements2() {
		int[] array = { 2, 3, 2, 3, 2, 3, 2 };
		assertEquals(9, maxMoney.calculateMaxMoney(array));
	}
}
