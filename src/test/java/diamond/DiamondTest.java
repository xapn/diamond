package diamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;

class DiamondTest {

    @Test
    void should_create_a_diamond_given_A() {
        resultOf(() -> Diamond.of("A")).isEqualTo("A");
    }

    @Test
    void should_create_a_diamond_given_B() {
        resultOf(() -> Diamond.of("B")).isEqualTo(" A\n" //
                + "B B\n" //
                + " A");
    }

    @Test
    void should_create_a_diamond_given_C() {
        resultOf(() -> Diamond.of("C")).isEqualTo("  A\n" //
                + " B B\n" //
                + "C   C\n" //
                + " B B\n" //
                + "  A");
    }

    @Nested
    class Given_an_invalid_argument {

        @Test
        void should_fail_to_create_a_diamond_given_nil() {
            whenOutsideOperatingConditions(() -> Diamond.of(null))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Argument value missing!");
        }

        @Test
        void should_fail_to_create_a_diamond_given_no_letter() {
            whenOutsideOperatingConditions(() -> Diamond.of(""))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Letter missing!");
        }
    }
}
