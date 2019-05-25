package com.vasi.vasitionary;

import java.util.List;

import org.junit.Test;

import com.vasi.vasitionary.scrabble.permutation.Combination;

import junit.framework.Assert;

public class TestCombination {
	@Test
	public void test1() {
		Combination combination = new Combination();
		List<String> combinations = combination.getCombinations(new String[] {"A", "B", "C"});
		for (String comb : combinations) {
			System.out.println(comb);
		}
		Assert.assertEquals(7, combinations.size());
	}
}
