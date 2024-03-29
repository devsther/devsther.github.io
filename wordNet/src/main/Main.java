package main;

import browser.NgordnetServer;
import ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        NgordnetServer hns = new NgordnetServer();

        String wordFile = "./data/ngrams/top_14377_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";
        String hyponymFile = "./data/wordnet/hyponyms11.txt";
        String synsetFile = "./data/wordnet/synsets11.txt";

        NGramMap ngm = new NGramMap(wordFile, countFile);
        WordNet wrd = new WordNet(synsetFile, hyponymFile);



        hns.startUp();
        hns.register("history", new DummyHistoryHandler());
        hns.register("historytext", new DummyHistoryTextHandler());
        hns.register("hyponyms", new HyponymsHandler(ngm, wrd));

        System.out.println("Finished server startup! Visit http://localhost:4567/ngordnet.html");
    }
}
