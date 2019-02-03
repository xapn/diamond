package diamond;

import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;

class DiamondTest {

    private static String diamondOf(String letter) {
        return letter;
    }

    @Test
    void should_create_nothing_given_no_letter() {
        resultOf(() -> diamondOf("")).isEqualTo("");
    }

    @Test
    void should_create_a_diamond_given_A() {
        resultOf(() -> diamondOf("A")).isEqualTo("A");
    }
}
