package com.vasi.vasitionary;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vasi.vasitionary.scrabble.AllCombinationPermutation;
import com.vasi.vasitionary.scrabble.HeapPermutation;
import com.vasi.vasitionary.scrabble.Permutation;

import junit.framework.Assert;

public class TestPermutation {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws UnsupportedEncodingException {		
		String[] chars = {"றி", "ம", "சு"};
		//char[] charArray = str.toCharArray();
		Permutation permutationHelper = new AllCombinationPermutation();
		List<String> allCombinations = permutationHelper.getAllCombinations(chars);
		for (int i=0;i<allCombinations.size();i++) {
			System.out.println(allCombinations.get(i));
		}
		Assert.assertEquals(36, allCombinations.size());
	}

}
