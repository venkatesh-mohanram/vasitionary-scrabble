package com.vasi.vasitionary.scrabble.permutation;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public List<String> getCombinations(String[] chars) {
		return combine(chars);
	}
	
	private List<String> combine(String[] chars) {
		StringBuilder output = new StringBuilder();
		List<String> combination = new ArrayList<>();
		combine(chars, 0, output, combination);
		return combination;
	}
	
	private void combine(String[] inputstring, int start, StringBuilder output, List<String> combination) {
		for( int i = start; i < inputstring.length; ++i ){
            output.append( inputstring[i] );
            combination.add(output.toString());
            if ( i < inputstring.length )
            combine(inputstring, i + 1, output, combination);
            output.setLength( output.length() - 1 );
        }
	}	
}
