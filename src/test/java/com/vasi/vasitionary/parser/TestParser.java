package com.vasi.vasitionary.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vasi.vasitionary.parser.json.JSONDictionaryParser;

import junit.framework.Assert;

public class TestParser {
	private Logger logger = LoggerFactory.getLogger(TestParser.class);
	public String getResourceContent(String path) {
		String content = null;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);		
		try {
			content = IOUtils.toString(inputStream, "UTF-8");			
			logger.info("Content of the file " + path + " read successfully");
			logger.info(content);
		} catch (IOException e) {
			logger.error("Unable to get the content of the file " + path, e);
		}
		return content;
	}
	
	public File getResourceFile(String path) {		
		File file = new File(getClass().getClassLoader().getResource(path).getFile());		
		return file;
	}
	
	@Test
	public void testParser() throws IOException {
		String[] expected = {"அ", "அஆ", "அஃகம்", "அஃகரம்", "அஃகல்", "அஃகாமை"};
		final List<String> actual = new ArrayList<>();
		IDictionaryParser parser = new JSONDictionaryParser();
		parser.parse(getResourceFile("dictionary-sample.json"), "word", new ICallback() {
			
			@Override
			public void notify(String word) {
				actual.add(word);
				
			}
		});
		
		// Assert
		for (String s : expected) {
			Assert.assertTrue("Failed to get the word from parser" + s, actual.contains(s));
		}
	}
}
