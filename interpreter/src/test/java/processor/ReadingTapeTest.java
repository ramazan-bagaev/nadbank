package processor;

import com.kanasuki.nadbank.interpreter.processor.ReadingTape;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReadingTapeTest {

    @Test
    public void shouldRemoveFirstSymbolWhenNextCalled() {
        ReadingTape readingTape = new ReadingTape("word");

        readingTape.next();

        assertEquals("ord", readingTape.getRemain());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowWhenNoSymbolsToRead() {
        ReadingTape readingTape = new ReadingTape("");

        readingTape.next();
    }

    @Test
    public void shouldReturnFalseWhenNoSymbolsLeft() {
        ReadingTape readingTape = new ReadingTape("");

        assertFalse(readingTape.hasNext());
    }
}
