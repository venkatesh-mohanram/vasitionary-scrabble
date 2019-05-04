package com.vasi.vasitionary;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;

import com.vasi.vasitionary.parser.ICallback;
import com.vasi.vasitionary.parser.IDictionaryParser;
import com.vasi.vasitionary.parser.json.JSONDictionaryParser;
import com.vasi.vasitionary.scrabble.ScrabbleManager;
import com.vasi.vasitionary.trie.Trie;

import junit.framework.Assert;

public class TestEnd2End {
	Logger logger = org.slf4j.LoggerFactory.getLogger(TestEnd2End.class);
	private Trie trieTamil = new Trie();
	private File getResourceFile(String path) {		
		File file = new File(getClass().getClassLoader().getResource(path).getFile());		
		return file;
	}	

	//@Test
	public void testLoadTime() throws IOException {
		long startTime = System.currentTimeMillis();
		File file = getResourceFile("v_word_list.json");
		IDictionaryParser parser = new JSONDictionaryParser();
		parser.parse(file, "word", new ICallback() {
			
			@Override
			public void notify(String word) {
				trieTamil.insert(word);				
			}
		});
		long endTime = System.currentTimeMillis();
		logger.debug("Total time taken to load in ms " + (endTime - startTime));
	}
	
	@Test
	public void testSearch() throws IOException {
		testLoadTime();
		Assert.assertTrue("Not found in the dictionary", trieTamil.search("அகக்களி"));
	}
	
	@Test
	public void testScrabble() {		
		ScrabbleManager sm = new ScrabbleManager();
		//List<String> validWords = sm.getAllValidWords(new String[] {"அ", "து", "றி", "ம", "சோ", "ன", "ஆ"});
		List<String> validWords = sm.getAllValidWords(new String[] {"அ", "ன", "ஆ"});
		logger.debug("Total valid words is:" + validWords.size());
		for (int i=0;i<validWords.size();i++) {
			logger.debug(validWords.get(i));
		}
	}

}
