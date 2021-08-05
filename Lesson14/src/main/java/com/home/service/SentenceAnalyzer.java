package com.home.service;

import java.util.List;
import java.util.Set;

public interface SentenceAnalyzer {

    List<String> getMatchingWordsList(List<String> words, String text);

    Set<String> getSentencesForEditing(String text, List<String> matchingWords);
}
