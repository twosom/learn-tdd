package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private Game g;

    @BeforeEach
    void setup() {
        this.g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        rollMany(2, 5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    void allOnes() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    void oneSpare() {
        rollSpare();
        g.roll(7);
        rollMany(17, 0);
        assertEquals(24, g.score());
    }
    @Test
    void oneStrike() {
        rollStrike();
        g.roll(2);
        g.roll(3);
        rollMany(16, 0);
        assertEquals(20, g.score());
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
