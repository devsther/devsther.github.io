package main;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import ngrams.NGramMap;

import java.util.List;
import java.util.TreeSet;

public class HyponymsHandler extends NgordnetQueryHandler {
    NGramMap map;
    WordNet wordNet;
    public HyponymsHandler(NGramMap map, WordNet wordNet) {
        this.map = map;
        this.wordNet = wordNet;
    }
    public HyponymsHandler(WordNet wordNet) {
        this.wordNet = wordNet;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();
        String s = "";

        TreeSet<String> output = wordNet.hyponyms(words, k, startYear, endYear);
        return output.toString();
    }
}

