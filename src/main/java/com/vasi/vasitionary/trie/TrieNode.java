package com.vasi.vasitionary.trie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TrieNode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Map<Character, TrieNode> children;
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
	
	public boolean isEndOfWord() {
		return isEndOfWord;
	}
	public void setEndOfWord(boolean isEndOfWord) {
		this.isEndOfWord = isEndOfWord;
	}
	public Map<Character, TrieNode> getChildren() {
		return children;
	}		
}
