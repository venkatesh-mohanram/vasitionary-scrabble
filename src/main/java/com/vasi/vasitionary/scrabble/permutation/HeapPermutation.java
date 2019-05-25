package com.vasi.vasitionary.scrabble.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
 * @author vemohanr
 *
 */
public class HeapPermutation {

	
	public List<String> permute(String[] chars) {
		List<String> permutations = new ArrayList<String>();
		heapPermutation(chars, chars.length, chars.length, permutations);
		return permutations;
	}
	
	//Generating permutation using Heap Algorithm 
    void heapPermutation(String chars[], int size, int n, List<String> permutations) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) 
            addString(chars, permutations); 
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(chars, size-1, n, permutations); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                String temp = chars[0]; 
                chars[0] = chars[size-1]; 
                chars[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
                String temp = chars[i]; 
                chars[i] = chars[size-1]; 
                chars[size-1] = temp; 
            } 
        } 
    }

	private void addString(String[] chars, List<String> permutations) {
		StringBuilder str = new StringBuilder();
		for (String s : chars) {
			str.append(s);
		}
		permutations.add(str.toString());
	} 

}
