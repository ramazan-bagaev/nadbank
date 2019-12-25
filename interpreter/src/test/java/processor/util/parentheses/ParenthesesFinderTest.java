package processor.util.parentheses;

import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesFinder;
import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesType;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesesFinderTest {

    @Test
    public void shouldFindParenthesesWhenTheyAreInTheBeginning() {
        String text = "() {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(1, index);
    }

    @Test
    public void shouldFindParenthesesWhenTheyAreInTheMiddle() {
        String text = "(condition == 1) {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(15, index);
    }

    @Test
    public void shouldFindParenthesesWhenTheyAreInTheEnd() {
        String text = "(condition == 1)";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(15, index);
    }

    @Test
    public void shouldFindParenthesesWhenThereAreOtherParentheses() {
        String text = "(condition() == 1) {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(17, index);
    }

    @Test
    public void shouldReturnErrorCodeWhenOutOfBoundary() {
        String text = "(condition == 1 {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(ParenthesesFinder.OUT_OF_BOUNDARY, index);
    }

    @Test
    public void shouldFindParenthesesWhenStringAppears() {
        String text = "(condition(\"word\") == 1) {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(23, index);
    }

    @Test
    public void shouldFindParenthesesWhenOtherParenthesesAppearsInString() {
        String text = "(condition(\"))()()()()weird\") == 1) {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(34, index);
    }

    @Test
    public void shouldReturnErrorCodeWhenNoOpenParentheses() {
        String text = "condition == 0 {something}";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(ParenthesesFinder.OUT_OF_BOUNDARY, index);
    }

    @Test
    public void shouldReturnErrorCodeWhenTextIsEmpty() {
        String text = "";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(ParenthesesFinder.OUT_OF_BOUNDARY, index);
    }

    @Ignore
    @Test
    public void testToBreakIt() {
        String text = "(\"\")\")";

        int index = ParenthesesFinder.nextParenthesesPosition(text, ParenthesesType.Round);

        assertEquals(6, index);
    }
}
