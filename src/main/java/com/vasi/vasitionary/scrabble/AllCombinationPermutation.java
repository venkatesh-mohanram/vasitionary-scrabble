package com.vasi.vasitionary.scrabble;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationPermutation implements Permutation {	

	public List<String> getAllCombinations(String[] chars) {
		List<String> allCombinations = new ArrayList<>();
		for (int i = chars.length;i > 1 ;i--) {
			AllCombinationPermutation permutation = new AllCombinationPermutation();
			List<String> kCombinations = new ArrayList<>();			
			permutation.getAllKLength(chars, i, kCombinations);
			allCombinations.addAll(kCombinations);
		}
		return allCombinations;
	}
	
	// The method that prints all
	// possible strings of length k.
	// It is mainly a wrapper over
	// recursive function printAllKLengthRec()
	private void getAllKLength(String[] set, int k, List<String> combinations) {
		int n = set.length;
		getAllKLengthRec(set, "", n, k, combinations);
	}

	// The main recursive method
	// to print all possible
	// strings of length k
	private static void getAllKLengthRec(String[] set, String prefix, int n, int k, List<String> combinations) {

		// Base case: k is 0,
		// print prefix
		if (k == 0) {
			combinations.add(prefix);
			return;
		}

		// One by one add all characters
		// from set and recursively
		// call for k equals to k-1
		for (int i = 0; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + set[i];

			// k is decreased, because
			// we have added a new character
			getAllKLengthRec(set, newPrefix, n, k - 1, combinations);
		}
	}

}