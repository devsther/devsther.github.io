import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import main.AutograderBuddy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/** Tests the case where the list of words is length greater than 1, but k is still zero. */
public class TestMultiWordK0Hyponyms {
    // this case doesn't use the NGrams dataset at all, so the choice of files is irrelevant
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String HUGE_WORDS_FILE = "data/ngrams/top_49887_words.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";
    public static final String LARGE_SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String LARGE_HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    /** This is an example from the spec.*/
    @Test
    public void testOccurrenceAndChangeK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("occurrence", "change");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[alteration, change, increase, jump, leap, modification, saltation, transition]";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testOccurrenceAndChangeK5() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                HUGE_WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("food", "cake");

        NgordnetQuery nq = new NgordnetQuery(words, 1950, 1990, 5);
        String actual = studentHandler.handle(nq);
        String expected = "[biscuit, cake, kiss, snap, wafer]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testCatAndog() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                HUGE_WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("cat", "dog");

        NgordnetQuery nq = new NgordnetQuery(words, 1470   , 2019, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[Maltese]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testCat() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                HUGE_WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("paddy,movement,set,press,lead,effect,shape,center,right");

        NgordnetQuery nq = new NgordnetQuery(words, 1920   , 1980, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[]";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testInWords() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("occurrence", "change");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2000, 4);
        String actual = studentHandler.handle(nq);
        String expected = "[]";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testWithNoHyponyms() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("variation", "mutation");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2000, 4);
        String actual = studentHandler.handle(nq);
        String expected = "[]";
        assertThat(actual).isEqualTo(expected);
    }

}
