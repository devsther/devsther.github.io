package main;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class Graph {

    private HashMap<Integer, Node> graph;
    private HashMap<Integer, ArrayList<Integer>> desc;
    private HashMap<String, Set<Integer>> idsOfWord;
    private HashMap<Integer, Set<String>> idWord;
    private Set<Integer> list;
    private HashMap<Integer, Boolean> marked;
    private int[] edgeTo;
    private int s;
    private ArrayList<Integer> descendents;


    public class Node {
        private int id;
        private String[] word;
        private ArrayList<Integer> descendents;

        public Node(int id, String[] word) {
            this.id = id;
            this.word = word;
        }
    }
    public void insert(int id, String[] word) {
        Node node = new Node(id, word);
        graph.put(id, node);
    }

    public Graph(String synsetFilename, String hyponymFilename) {
        idWord = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        String s;
        String[] tokens;
        String[] wordTokens;
        Integer id;
        In ln1 = new In(synsetFilename);
        In in2 = new In(hyponymFilename);
        Set<String> synset;
        desc = new HashMap<>();
        idsOfWord = new HashMap<>();
        list = new HashSet<>();


        while (ln1.hasNextLine()) {
            s = ln1.readLine();
            s = s.substring(0, s.indexOf(",", s.indexOf(",") + 1));
            tokens = s.split(",");
            id = Integer.parseInt(tokens[0]);
            wordTokens = tokens[1].split(" ");

            synset = new HashSet<>();
            for (String str :wordTokens) {
                synset.add(str);
                if (idsOfWord.containsKey(str)) {
                    idsOfWord.get(str).add(id);
                } else {
                    list.add(id);
                    idsOfWord.put(str, list);
                }
                list = new HashSet<>();
            }
            idWord.put(id, synset);
        }


        while (in2.hasNextLine()) {
            s = in2.readLine();
            tokens = s.split("[,]");
            for (id = 1; id < tokens.length; id++) {
                temp.add(Integer.parseInt(tokens[id]));
            }
            desc.put(Integer.parseInt(tokens[0]), temp);
            temp = new ArrayList<Integer>();
        }


    }

    public HashMap<Integer, Set<String>> getIdWord() {
        return idWord;
    }
    public HashMap<String, Set<Integer>> getIdsOfWord() {
        return idsOfWord;
    }

    public ArrayList<Integer> dfs(int v) {
        marked = new HashMap<>();
        ArrayList<Integer> descendents = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.empty()) {
            // Pop a vertex from the stack
            v = stack.pop();
            descendents.add(v);

            if (visited.contains(v)) {
                continue;
            }
            // we will reach here if the popped vertex `v` is not discovered yet;
            // print `v` and process its undiscovered adjacent nodes into the stack
            visited.add(v);

            // do for every edge (v, u)
            ArrayList<Integer> adjList = desc.get(v);
            if (adjList != null) {
                for (int i = adjList.size() - 1; i >= 0; i--) {
                    int u = adjList.get(i);

                    descendents.add(u);
                    stack.push(u);

                }
            }
        }
        return descendents;
    }


}


