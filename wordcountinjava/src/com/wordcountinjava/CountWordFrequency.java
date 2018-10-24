package com.wordcountinjava;

/*
 *  =============================================================
 *  CountWordFrequency: Read a stream of words from the keyboard.
 
*  Use a hashmap to record the frequency of each word. Then use
 *  a treemap to order the words.
 *  =============================================================
 */

import java.util.*;

public class CountWordFrequency {

	public static void main(String args[]) {

		Map map = new HashMap();

		Integer ONE = new Integer(1);

		// Read stream of input from keyboard ..

		for (int i = 0, n = args.length; i < n; i++) {

			String key = args[i];

			Integer frequency = (Integer) map.get(key);

			if (frequency == null) {

				frequency = ONE;

			} else {

				int value = frequency.intValue();

				frequency = new Integer(value + 1);
			}

			map.put(key, frequency);
		}

		// Print (unordered) contents of map ..

		System.out.println("HashMap of [ word, frequency ] usage");

		System.out.println("====================================");

		System.out.println(map);

		// Create and print an ordered treemap...

		System.out.println("TreeMap of [ word, frequency ] usage");
		System.out.println("====================================");

		Map sortedMap = new TreeMap(map);
		System.out.println(sortedMap);

		System.out.println("====================================");
	}
}
