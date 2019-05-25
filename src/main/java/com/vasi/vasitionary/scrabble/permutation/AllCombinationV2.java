package com.vasi.vasitionary.scrabble.permutation;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationV2 {
	public List<String> getAllCombinations(String[] chars) {
		List<String> allCombinations = new ArrayList<>();
		Combination combinationGenerator = new Combination();
		List<String> combinations = combinationGenerator.getCombinations(chars);
		// Get all the permutations of all the combinations
		HeapPermutation perumationGenerator = new HeapPermutation();
		for (String combination : combinations) {
			List<String> permute = perumationGenerator.permute(toStringArray(combination));
			allCombinations.addAll(permute);
		}
		return allCombinations;
	}
	
	public String[] toStringArray(String str) {
		List<String> strArray = new ArrayList<>();
		for (int i=0;i<str.length();i++) {
			int endIndex = (i==str.length())?0:i+1;
			strArray.add(str.substring(i, endIndex));
		}
		String[] a = new String[strArray.size()];
		return strArray.toArray(a);
	}
}
