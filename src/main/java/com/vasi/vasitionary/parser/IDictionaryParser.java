package com.vasi.vasitionary.parser;

import java.io.File;
import java.io.IOException;

public interface IDictionaryParser {
	public void parse(File sourceFile, String jsonPath, ICallback callback) throws IOException;
}
