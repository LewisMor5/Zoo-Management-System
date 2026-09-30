import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    // Test 1 - test makeSound() returns correct string for Bird
    @Test
    public void testBirdMakeSound() {
        Bird bird = new Bird("Tweety", 3, "yellow", 0.5, 25.0, "Canary");
        String expected = "Tweet! I am Tweety, a 3 year old yellow Canary.";
        String actual = bird.makeSound();
        assertEquals(expected, actual);
    }

    // Test 2 - test getType() returns correct type for Lion
    @Test
    public void testLionGetType() {
        Lion lion = new Lion("Simba", 5, "golden", 180.0, 30.0);
        String expected = "Lion";
        String actual = lion.getType();
        assertEquals(expected, actual);
    }

}