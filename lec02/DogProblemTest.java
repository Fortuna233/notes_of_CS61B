import static org.junit.Assert.*;
import org.junit.Test;

public class DogProblemTest {

    @Test
    public void testIsBiggestOfFourMiddle() {
        Dog[] dogs = {
            new Dog(10),
            new Dog(20),
            new Dog(30),
            new Dog(100),
            new Dog(40),
            new Dog(50),
            new Dog(60)
        };

        assertTrue(DogProblem.isBiggestOfFour(dogs, 3));
    }

    @Test
    public void testIsNotBiggestOfFour() {
        Dog[] dogs = {
            new Dog(10),
            new Dog(20),
            new Dog(30),
            new Dog(40),
            new Dog(100),
            new Dog(50),
            new Dog(60)
        };

        assertFalse(DogProblem.isBiggestOfFour(dogs, 3));
    }

    @Test
    public void testIsBiggestAtBeginning() {
        Dog[] dogs = {
            new Dog(100),
            new Dog(20),
            new Dog(30),
            new Dog(40),
            new Dog(50)
        };

        assertTrue(DogProblem.isBiggestOfFour(dogs, 0));
    }

    @Test
    public void testIsBiggestAtEnd() {
        Dog[] dogs = {
            new Dog(10),
            new Dog(20),
            new Dog(30),
            new Dog(40),
            new Dog(100)
        };

        assertTrue(DogProblem.isBiggestOfFour(dogs, 4));
    }

    @Test
    public void testLargerThanFourNeighbors() {
        Dog[] dogs = {
            new Dog(10),
            new Dog(20),
            new Dog(30),
            new Dog(100),
            new Dog(40),
            new Dog(50),
            new Dog(60)
        };

        Dog[] result = DogProblem.largerThanFourNeighbors(dogs);

        assertEquals(100, result[0].weightInPounds);

        for (int i = 1; i < result.length; i++) {
            assertNull(result[i]);
        }
    }

    @Test
    public void testMultipleBigDogs() {
        Dog[] dogs = {
            new Dog(100),
            new Dog(10),
            new Dog(20),
            new Dog(30),
            new Dog(40),
            new Dog(200),
            new Dog(50),
            new Dog(60),
            new Dog(70),
            new Dog(80),
            new Dog(300)
        };

        Dog[] result = DogProblem.largerThanFourNeighbors(dogs);

        assertEquals(100, result[0].weightInPounds);
        assertEquals(200, result[1].weightInPounds);
        assertEquals(300, result[2].weightInPounds);
    }
}