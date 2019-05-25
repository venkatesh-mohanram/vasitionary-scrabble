package com.vasi.vasitionary.scrabble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vasi.vasitionary.parser.ICallback;
import com.vasi.vasitionary.parser.IDictionaryParser;
import com.vasi.vasitionary.parser.json.JSONDictionaryParser;
import com.vasi.vasitionary.trie.Trie;

public class ScrabbleManager {
	private Trie trie;
	private Logger logger = LoggerFactory.getLogger(ScrabbleManager.class);
	
	public ScrabbleManager(File src, String jsonKey) {
		loadTheDictionary(src, jsonKey);
	}
	
	public ScrabbleManager() {
		File src = getResourceFile("v_word_list.json");
		String jsonKey = "word";
		loadTheDictionary(src, jsonKey);
	}
	
	private File getResourceFile(String path) {		
		File file = new File(getClass().getClassLoader().getResource(path).getFile());		
		return file;
	}
	
	public List<String> getAllValidWords(String[] scrabbleChars) {
		List<String> validWords = new ArrayList<>();
		Permutation permutationHelper = new HeapPermutation();
		List<String> allWords = permutationHelper.getAllCombinations(scrabbleChars);
		logger.debug("Input String size is :" + scrabbleChars.length);
		logger.debug("All possible words size is : " + allWords.size());		
		// Add only the valid words in result
		for (int i=0;i<allWords.size();i++) {
			if (trie.search(allWords.get(i))) {
				validWords.add(allWords.get(i));
			}
		}
		return validWords;
	}
	
	private boolean loadTheDictionary(File src, String jsonKey) {
		boolean success = true;
		trie = new Trie();
		IDictionaryParser parser = new JSONDictionaryParser();
		try {
			parser.parse(src, jsonKey, new ICallback() {
				
				@Override
				public void notify(String word) {
					trie.insert(word);				
				}
			});
		} catch (IOException e) {
			success = false;
			logger.error("Unable to initialize the dictionary: " + e.getMessage(), e);
			
		}
		return success;
	}
}
