package processor;

import com.kanasuki.nadbank.interpreter.processor.ProgramCodeProcessor;
import org.junit.Test;

public class ProgramCodeProcessorTest {

    @Test
    public void shouldWhen() {
        ProgramCodeProcessor processor = new ProgramCodeProcessor();

        processor.process("");
    }
}
