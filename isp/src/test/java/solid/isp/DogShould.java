package solid.isp;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DogShould {
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private final Dog dog = new Dog();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(consoleContent));
    }


    @Test
    public void run() {
        dog.run();
        assertThat(consoleContent.toString())
                .isEqualTo("Dog is running");
    }

    @Test
    public void bark() {
        dog.bark();
        assertThat(consoleContent.toString())
                .isEqualTo("Dog is barking");
    }
}