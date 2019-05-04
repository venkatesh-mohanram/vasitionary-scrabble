# vasitionary-scrabble
Scrabble using Trie data structure

## Getting started

This project is built as a jar file. You can find the jar file inside target\ folder. Add the jar as your dependencies and add below code in your class

```java
		ScrabbleManager sm = new ScrabbleManager(new File("D:\\resources\\v_word_list.json"), "word");
		List<String> validWords = sm.getAllValidWords(new String[] {"அ", "ன", "ஆ"});
		for (int i=0;i<validWords.size();i++) {
			System.out.println(validWords.get(i));
		}
```
