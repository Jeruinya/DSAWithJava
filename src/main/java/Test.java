import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Result {
	public static int getRomanNum(char c) {
		if (c == 'I')
			return 1;
		else if (c == 'V')
			return 5;
		else if (c == 'X')
			return 10;
		else if (c == 'L')
			return 50;
		return -1;
	}

	public static int romanToIntConversion(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			int v1 = getRomanNum(str.charAt(i));
			if (i + 1 < str.length()) {
				int v2 = getRomanNum(str.charAt(i + 1));
				if (v1 >= v2)
					number += v1;
				else {
					number += v2 - v1;
					i++;
				}
			} else
				number += v1;
		}
		return number;
	}

	public static List<String> sortRoman(List<String> names) {
		names = names.stream().sorted((o1, o2) -> {
			String[] str1 = o1.split(" ");
			String[] str2 = o2.split(" ");

			Integer val1 = romanToIntConversion(str1[1]);
			Integer val2 = romanToIntConversion(str2[1]);

			if (str1[0].equals(str2[0]))
				return val1.compareTo(val2);
			else
				return str1[0].compareTo(str2[0]);
		}).collect(Collectors.toList());
		return names;
	}

}

 class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int namesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> names = IntStream.range(0, namesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = Result.sortRoman(names);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
