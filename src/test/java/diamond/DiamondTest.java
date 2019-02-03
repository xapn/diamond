package diamond;

import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;

class DiamondTest {

    @Test
    void should_create_nothing_given_no_letter() {
        resultOf(() -> "").isEqualTo("");
    }
}
