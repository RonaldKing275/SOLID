package solid.isp;

import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BirdShould {
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private final Bird bird = new Bird();
    private final PrintStream console = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(consoleContent));
    }


    @Test
    public void run() {
        bird.run();
        assertThat(consoleContent.toString())
                .isEqualTo("Bird is running");
        console.print(consoleContent);
    }

    @Test
    public void fly() {
        bird.fly();
        assertThat(consoleContent.toString())
                .isEqualTo("Bird is flying");
        console.print(consoleContent);
    }
}