package com.java8.training7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptInvoker {

	private static List<Character> collect;

	public static void main(String[] args) throws FileNotFoundException {
		// create a script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// create a Nashorn script engine
		ScriptEngine engine = factory.getEngineByName("nashorn");
		// evaluate JavaScript statement
		try {
			//engine.eval("print('Hello, World!');");
			engine.eval(new FileReader("src//main/java//myFun.js"));
		} catch (final ScriptException se) {
			se.printStackTrace();
		}
		
		
		 // creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                                           "GeeksQuiz", "GeeksforGeeks");
  
        collect = words.stream().map(p ->  p.charAt(2)).collect(Collectors.toList());
        
        System.out.println(collect);
        
        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                                   .reduce((word1, word2)
                             -> {
                            	 System.out.println(word1 + "  " + word2);
                            	 return
                            	 word1.length() > word2.length()
                             
                                           ? word1 : word2;});
  
        // Displaying the longest String
        longestString.ifPresent(System.out::println);
    
	}
}
