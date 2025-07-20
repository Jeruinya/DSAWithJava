package com.java.features.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//Given a list of sentences, find the longest sentence based on word count.
public class FindLongestSentence {
    public static void main(String[] args) {
        List<String> sentenceList = Arrays.asList("This is a short sentence.",
                "Here is another sentence with more words.",
                "This is the longest sentence among them all, with the most words.");

        String longestSentence = sentenceList.stream().
                max(Comparator.comparingInt(sentence -> sentence.split(" ").length)).orElse("");

        Optional<String> longestSentence1 = sentenceList.stream().
                max(Comparator.comparingInt(String::length));

        System.out.println(longestSentence);
        System.out.println(longestSentence1.get());
    }
}
