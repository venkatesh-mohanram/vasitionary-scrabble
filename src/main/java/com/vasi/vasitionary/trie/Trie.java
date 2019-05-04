package com.vasi.vasitionary.trie;

import java.io.Serializable;

public class Trie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode currentNode = root;
		for (int i=0; i<word.length();i++) {
			Character c = word.charAt(i);
			if (currentNode.getChildren().containsKey(c)) {
				currentNode = currentNode.getChildren().get(c);
			} else {
				TrieNode newNode = new TrieNode();
				currentNode.getChildren().put(c, newNode);
				currentNode = newNode;
			}
		}
		currentNode.setEndOfWord(true);
	}
	
	public boolean search(String word) {
		boolean found = true;
		TrieNode currentNode = root;
		for (int i=0;i<word.length();i++) {
			Character c = word.charAt(i);
			if (currentNode.getChildren().containsKey(c)) {
				currentNode = currentNode.getChildren().get(c); 
			} else {
				found = false;
				break;
			}
		}
		if (!currentNode.isEndOfWord) {
			found = false;
		}
		return found;
	}
}
