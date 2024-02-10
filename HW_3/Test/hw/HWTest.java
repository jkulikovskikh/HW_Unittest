package hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HWTest {

    MainHW mainHw;
    @BeforeEach
    void setUp() {
        mainHw = new MainHW();
    }

    @Test
    void numberIsEvenNumber() {
        assertTrue(mainHw.evenOddNumber(8));
    }

    @Test
    void numberIsOddNumber() {
        assertFalse(mainHw.evenOddNumber(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 65, 99})
    void numberInIntervalReturnTrue(int n) {
        assertTrue(mainHw.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    void numberInNotIntervalReturnFalse(int n) {
        assertFalse(mainHw.numberInInterval(n));
    }
}
