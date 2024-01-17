package main;

import ngrams.NGramMap;
import ngrams.TimeSeries;

import java.util.*;

public class WordNet {
    private boolean[] marked;
    private HashMap<Integer, Set<String>> idWord;
    private NGramMap map;
    private HashMap<Double, ArrayList<Integer>> desc;
    private TreeMap<Double, Set<String>> counttowords;
    private TreeMap<String, Double> wordstocount;
    private TreeMap<String, Double> rankMap;
    private Graph graph;
    private NGramMap nGramMap;

    public WordNet(String synsetFilename, String hyponymFilename) {
        graph = new Graph(synsetFilename, hyponymFilename);
        idWord = new HashMap<>();

        Set<String> synset = new HashSet<String>();

    }
    public WordNet(NGramMap nGramMap, String synsetFilename, String hyponymFilename) {
        this.nGramMap = nGramMap;
        idWord = new HashMap<>();
        graph = new Graph(synsetFilename, hyponymFilename);
        Set<String> synset = new HashSet<String>();
    }

    public Set<String> hyponyms(String input) {
        Set<Integer> synsetId = new HashSet<>();
        Set<String> temporary = new HashSet<>();
        Set<String> hyponyms = new HashSet<String>();
        HashMap<String, Set<Integer>> idsOfWord = new HashMap<>();
        String[] tokens;

        //        for (Integer id : graph.getIdWord().keySet()) {
        //            temporary = graph.getIdWord().get(id);
        //            if (graph.getIdWord().get(id).contains(input)) {
        //                synsetId.add(id);
        //            }
        //        }
        idsOfWord = graph.getIdsOfWord();
        synsetId = idsOfWord.get(input);

        //        Set<Integer> queue = new HashSet<>(synsetId);
        //        Set<String> words;
        if (synsetId != null) {
            for (Integer id :synsetId) {
                ArrayList<Integer> lst = graph.dfs(id);
                for (Integer i :lst) {
                    Set<String> s = graph.getIdWord().get(i);
                    for (String temp :s) {
                        hyponyms.add(temp);
                    }
                }
            }
        }

        return hyponyms;
    }
    public TreeSet<String> hyponyms(List<String> inputs) {

        Set<String> hyponym = new HashSet<>();
        Set<String> words = new HashSet<>();

        Set<Integer> lst = new HashSet<>();

        Set<Integer> synsetId = new HashSet<>();
        hyponym = hyponyms(inputs.get(0));
        for (String input :inputs) {
            words = hyponyms(input);
            hyponym.retainAll(words);
        }
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(hyponym);

        return treeSet;
    }

    public TreeSet<String> hyponyms(List<String> inputs, int k, int startYear, int endYear) {
        if (k == 0) {
            return hyponyms(inputs);
        }
        int track = 0;
        Set<String> hyponyms = new HashSet<String>();
        Set<String> words = new HashSet<>();
        wordstocount = new TreeMap<String, Double>();
        counttowords = new TreeMap<Double, Set<String>>();
        TimeSeries counts;

        double count = 0;
        Set<String> temp = new HashSet<String>();
        words = hyponyms(inputs);

        for (String word :words) {
            counts = nGramMap.countHistory(word, startYear, endYear);
            if (counts != null && counts.size() != 0) {
                for (int i = startYear; i <= endYear; i++) {
                    count += counts.getOrDefault(i, 0.0);
                }
                wordstocount.put(word, count);
                if (counttowords.containsKey(count)) {
                    counttowords.get(count).add(word);
                } else {
                    temp.add(word);
                    counttowords.put(count, new HashSet<String>(temp));
                }
                temp.clear();
                count = 0;
            }
        }
        TreeSet<Set<String>> treeSet = new TreeSet<>();

        Set<Double> keys = new HashSet<>();
        TreeSet<String> vals = new TreeSet<>();
        Set<String> test;

        for (int i = 0; i < k; i++) {
            if (counttowords != null && !counttowords.isEmpty()) {
                test = counttowords.pollLastEntry().getValue();
                for (String w :test) {
                    if (vals.size() < k) {
                        vals.add(w);
                    }
                }
            }
        }


        return vals;
    }
}

