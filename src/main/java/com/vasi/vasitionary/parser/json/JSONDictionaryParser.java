package com.vasi.vasitionary.parser.json;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vasi.vasitionary.parser.ICallback;
import com.vasi.vasitionary.parser.IDictionaryParser;

public class JSONDictionaryParser implements IDictionaryParser {
	private Logger logger = LoggerFactory.getLogger(JSONDictionaryParser.class);
	
	@Override
	public void parse(File sourceFile, String jsonKeyName, ICallback callback) throws IOException {
		try {
			JsonFactory jsonfactory = new JsonFactory();
			//JsonParser parser = jsonfactory.createJsonParser(IOUtils.toInputStream(sourceFile.getAbsolutePath(), StandardCharsets.UTF_8)); // starting parsing of JSON String
			JsonParser parser = jsonfactory.createJsonParser(sourceFile); // starting parsing of JSON String
			while (parser.nextToken() != null) {
				String token = parser.getCurrentName();				
				if (token!=null && token.equals(jsonKeyName)) {
					parser.nextToken();
					String currentWord = parser.getText();
					logger.trace(currentWord);
					callback.notify(currentWord);
				}
			}
		} catch (IOException e) {
			logger.error("Unable to parse the input file", e);
			throw e;
		}
	}	
}
