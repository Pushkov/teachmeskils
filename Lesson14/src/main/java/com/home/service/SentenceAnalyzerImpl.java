package com.home.service;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

@AllArgsConstructor
public class SentenceAnalyzerImpl implements SentenceAnalyzer {
    private final TextFormatter textFormatter;

    @Override
    public List<String> getMatchingWordsList(List<String> words, String text) {
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (containsIgnoreCase(text, word)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    @Override
    public Set<String> getSentencesForEditing(String text, List<String> matchingWords) {
        List<String> sentences = textFormatter.getSplittedSentences(text);
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
                .filter(x -> containsIgnoreCase(x, word))
                .collect(Collectors.toSet());
    }
}
