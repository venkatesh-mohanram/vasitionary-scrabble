package com.vasi.vasitionary;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.vasi.vasitionary.scrabble.permutation.AllCombinationV2;

public class TestAllCombinationV2 {
	
	@Test
	public void test() {
		AllCombinationV2 combinationGenerator = new AllCombinationV2();
		List<String> allCombinations = combinationGenerator.getAllCombinations(new String[] {"A", "B", "C"});
		for (String s : allCombinations) {
			System.out.println(s);
		}
		Assert.assertEquals(15, allCombinations.size());
	}
}
