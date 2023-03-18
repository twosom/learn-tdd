package prime;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsTest {

    @Test
    void factors() {
        assertThat(factorsOf(1)).isEmpty();
        assertThat(factorsOf(2)).containsExactly(2);
        assertThat(factorsOf(3)).containsExactly(3);
        assertThat(factorsOf(4)).containsExactly(2, 2);
        assertThat(factorsOf(5)).containsExactly(5);
        assertThat(factorsOf(6)).containsExactly(2, 3);
        assertThat(factorsOf(7)).containsExactly(7);
        assertThat(factorsOf(8)).containsExactly(2, 2, 2);
        assertThat(factorsOf(9)).containsExactly(3, 3);
    }

    private List<Integer> factorsOf(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; n > 1; divisor++)
            for (; n % divisor == 0; n /= divisor)
                factors.add(divisor);
        return factors;
    }

}
