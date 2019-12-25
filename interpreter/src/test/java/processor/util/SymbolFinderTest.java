package processor.util;

import com.kanasuki.nadbank.interpreter.processor.util.SymbolFinder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SymbolFinderTest {

    @Test
    public void shouldFindFirstNonSpaceSymbolWhenItIsInTheBeginning() {
        String text = "a  ";

        int index = SymbolFinder.nextNonSpaceSymbol(text);

        assertEquals(0, index);
    }

    @Test
    public void shouldFindFirstNonSpaceSymbolWhenItIsInTheEnd() {
        String text = "   a";

        int index = SymbolFinder.nextNonSpaceSymbol(text);

        assertEquals(3, index);
    }

    @Test
    public void shouldFindFirstNonSpaceSymbolWhenNextLineAppear() {
        String text = "  \n a";

        int index = SymbolFinder.nextNonSpaceSymbol(text);

        assertEquals(4, index);
    }
}
