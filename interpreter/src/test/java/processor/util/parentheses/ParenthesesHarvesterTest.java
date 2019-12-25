package processor.util.parentheses;

import com.kanasuki.nadbank.interpreter.exception.UtilException;
import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesHarvester;
import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesesHarvesterTest {

    @Test
    public void shouldSplitParenthesesBlockWhenOneAppear() throws UtilException {
        String text = "before(parenthesesBlock) rest";

        String[] splits = ParenthesesHarvester.splitParenthesesBlock(text, ParenthesesType.Round);

        assertEquals(new String[]{"before", "parenthesesBlock", " rest"}, splits);
    }

    @Test
    public void shouldSplitParenthesesBlockWhenParenthesisInside() throws UtilException {
        String text = "before(parenthesesBlock()) rest";

        String[] splits = ParenthesesHarvester.splitParenthesesBlock(text, ParenthesesType.Round);

        assertEquals(new String[]{"before", "parenthesesBlock()", " rest"}, splits);
    }
}
