import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import main.WordNet;
import org.junit.jupiter.api.Test;
import main.AutograderBuddy;

import java.util.List;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

/** Tests the most basic case for Hyponyms where the list of words is one word long, and k = 0.*/
public class TestOneWordK0Hyponyms {
    // this case doesn't use the NGrams dataset at all, so the choice of files is irrelevant
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";

    @Test
    public void testActK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("act");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[act, action, change, demotion, human_action, human_activity, variation]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testHyponymsSimple(){
        WordNet wn = new WordNet("./data/wordnet/synsets11.txt","./data/wordnet/hyponyms11.txt");
        wn.hyponyms("antihistamine");
        assertThat(wn.hyponyms("antihistamine")).isEqualTo(Set.of("antihistamine","actifed"));
    }
//    @Test
//    public void testTwoHyponymsSimple(){
//        WordNet wn = new WordNet("./data/wordnet/synsets16.txt","./data/wordnet/hyponyms16.txt");
//        wn.hyponyms("change");
//        assertThat(wn.hyponyms("change")).isEqualTo(Set.of("antihistamine","actifed"));
//    }
    @Test
    public void testMultipleHyponymsSimple(){
        WordNet wn = new WordNet("./data/wordnet/synsets16.txt","./data/wordnet/hyponyms16.txt");
        List<String> words = List.of("change","occurrence");
        wn.hyponyms(words);
        assertThat(wn.hyponyms(words)).isEqualTo(Set.of(
                "alteration", "change", "increase", "jump", "leap", "modification", "saltation", "transition"));
    }

}