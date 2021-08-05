package com.home.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SentenceAnalyzerImpl implements SentenceAnalyzer {
    private final TextFormatter textFormatter;

    public SentenceAnalyzerImpl(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    @Override
    public List<String> getMatchingWordsList(List<String> words, String text) {
        String textLowerCase = text.toLowerCase();
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (textLowerCase.contains(word.toLowerCase())) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    @Override
    public Set<String> getSentencesForEditing(String text, List<String> matchingWords) {
        List<String> sentences = textFormatter.getSplitedSentences(text);
        return getSentencesForEditingByWordList(matchingWords, sentences);

    }

    private Set<String> getSentencesForEditingByWordList(List<String> matchingWords, List<String> sentences) {
        Set<String> sentencesForEditing = new HashSet<>();
        for (String word : matchingWords) {
            sentencesForEditing.addAll(getSentencesForEditingByWord(sentences, word));
        }
        return sentencesForEditing;
    }

    private Set<String> getSentencesForEditingByWord(List<String> sentences, String word) {
        return sentences.stream()
                .filter(x -> x.toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toSet());
    }
}
