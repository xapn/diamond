package diamond;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;

class DiamondTest {

    private static String diamondOf(String letter) {
        if (letter == null) {
            throw new IllegalArgumentException("Argument value missing!");
        } else if (letter.isEmpty() || "A".equals(letter)) {
            return letter;
        } else {
            List<String> atFirst = rangeClosed((int) 'A', letter.codePointAt(0))
                    .mapToObj(code -> code == 65 ? "A" : valueOf((char) code) + valueOf((char) code))
                    .collect(toList());
            List<String> atLast = new ArrayList<>(atFirst.subList(0, atFirst.size() - 1));
            reverse(atLast);
            return Stream
                    .of(atFirst, atLast)
                    .flatMap(List::stream)
                    .collect(joining("\n"));
        }
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

    @Test
    void should_return_AnBBnA_given_B() {
        resultOf(() -> diamondOf("B")).isEqualTo("A\nBB\nA");
    }

    @Test
    void should_return_AnBBnCCnBBnA_given_C() {
        resultOf(() -> diamondOf("C")).isEqualTo("A\nBB\nCC\nBB\nA");
    }
}
