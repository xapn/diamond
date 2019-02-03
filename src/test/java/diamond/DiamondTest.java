package diamond;

import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;

class DiamondTest {

    private static String diamondOf(String letter) {
        if (letter == null) {
            throw new IllegalArgumentException("Argument value missing!");
        }
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

    @Test
    void should_fail_to_create_a_diamond_given_nil() {
        whenOutsideOperatingConditions(() -> diamondOf(null))
                .thenItFails()
                .becauseOf(IllegalArgumentException.class)
                .withMessage("Argument value missing!");
    }
}
