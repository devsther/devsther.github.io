package main;

import browser.NgordnetQueryHandler;
import ngrams.NGramMap;


public class AutograderBuddy {
    /** Returns a HyponymHandler */
    String wordFile = "./data/ngrams/top_14377_words.csv";
    String countFile = "./data/ngrams/total_counts.csv";
    String hyponymFile = "./data/wordnet/hyponyms11.txt";
    String synsetFile = "./data/wordnet/synsets11.txt";


    public static NgordnetQueryHandler getHyponymHandler(
            String wordFile, String countFile,
            String synsetFile, String hyponymFile) {
        NGramMap nGramMap = new NGramMap(wordFile, countFile);
        WordNet wordNet = new WordNet(nGramMap, synsetFile, hyponymFile);
        return new HyponymsHandler(nGramMap, wordNet);
    }
}
