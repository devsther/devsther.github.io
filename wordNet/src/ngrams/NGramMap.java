package ngrams;
import edu.berkeley.eecs.inst.cs61b.ngrams.StaffNGramMap;
import edu.princeton.cs.algs4.In;

/**
 * A placeholder implementation of NGramMap.
 */
public class NGramMap {
    private final StaffNGramMap staffSolution;
    private TimeSeries totCount;

    public NGramMap(String wordsFilename, String countsFilename) {
        String[] token2;
        In in2 = new In(countsFilename);
        totCount = new TimeSeries();

        while (in2.hasNextLine()) {
            token2 = in2.readLine().split(",");
            totCount.put(Integer.parseInt(token2[0]), Double.parseDouble(token2[1]));
        }

        this.staffSolution = new StaffNGramMap(wordsFilename, countsFilename);
    }

    public TimeSeries countHistory(String word, int startYear, int endYear) {
        TimeSeries h = new TimeSeries();
        h.putAll(staffSolution.countHistory(word, startYear, endYear));
        return h;
    }

    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        throw new UnsupportedOperationException();
    }
    public NGramMap getNGramMap(String wordsFilename, String countsFilename) {
        return new NGramMap(wordsFilename, countsFilename);
    }

}
