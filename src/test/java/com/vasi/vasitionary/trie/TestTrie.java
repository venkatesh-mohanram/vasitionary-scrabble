package com.vasi.vasitionary.trie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTrie {
	private static Trie trieEnglish;
	private static Trie trieTamil;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		trieEnglish = new Trie();
		// Insert few words
		trieEnglish.insert("Hello");
		trieEnglish.insert("Hai");
		trieEnglish.insert("Heaven");
		
		trieTamil = new Trie();
		// Insert few tamil words
		trieTamil.insert("அஃகுல்லி");
		trieTamil.insert("அஃதான்று");
		trieTamil.insert("கலபி");
	}

	@Test
	public void testFullWord() {
		boolean result = trieEnglish.search("Heaven");
		Assert.assertTrue("Search is failing", result);		
	}
	
	@Test
	public void testFullWordTamil() {
		boolean result = trieTamil.search("அஃதான்று");
		Assert.assertTrue("Search is failing", result);		
	}
	
	@Test
	public void testPartWord() {
		boolean result = trieEnglish.search("Ha");
		Assert.assertFalse("Search is failing", result);
	}
	
	@Test
	public void testPartWordTamil() {
		boolean result = trieTamil.search("அஃ");
		Assert.assertFalse("Search is failing", result);
	}
	
	@Test
	public void testUnknownWord() {
		boolean result = trieEnglish.search("Apple");
		Assert.assertFalse("Search is failing", result);
	}
	
	@Test
	public void testUnknownWordTamil() {
		boolean result = trieTamil.search("கலம்பகம்");
		Assert.assertFalse("Search is failing", result);
	}
	
	//@Test
	public void testSerialization() {
        try {
        	 FileOutputStream fos = new FileOutputStream("test.ser");
        	 ObjectOutputStream oos = new ObjectOutputStream(fos);
        	 oos.writeObject(trieTamil);
        	 oos.close();
        	 fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testDeserialization() {
		try
        {
            FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Trie tamilTrie = (Trie)ois.readObject();
            tamilTrie.insert("கலம்பகம");
            Assert.assertTrue(tamilTrie.search("கலம்பகம்"));
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
            
        }
	}

}
