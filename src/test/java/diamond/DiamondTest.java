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

    @Test
    void should_fail_to_create_a_diamond_given_no_letter() {
        whenOutsideOperatingConditions(() -> Diamond.of(""))
                .thenItFails()
                .becauseOf(IllegalArgumentException.class)
                .withMessage("Letter missing!");
    }

    @Test
    void should_create_a_diamond_given_A() {
        resultOf(() -> Diamond.of("A")).isEqualTo("A");
    }

    @Test
    void should_fail_to_create_a_diamond_given_nil() {
        whenOutsideOperatingConditions(() -> Diamond.of(null))
                .thenItFails()
                .becauseOf(IllegalArgumentException.class)
                .withMessage("Argument value missing!");
    }

    @Test
    void should_return_AnBBnA_given_B() {
        resultOf(() -> Diamond.of("B")).isEqualTo(" A\nBB\n A");
    }

    @Test
    void should_return_AnBBnCCnBBnA_given_C() {
        resultOf(() -> Diamond.of("C")).isEqualTo("  A\n BB\nCC\n BB\n  A");
    }

    static class Diamond {

        private final String letter;
        private final int letterCode;

        private Diamond(String letter) {
            this.letter = letter;
            if (letter == null) {
                throw new IllegalArgumentException("Argument value missing!");
            } else if (letter.isEmpty()) {
                throw new IllegalArgumentException("Letter missing!");
            } else {
                letterCode = letter.codePointAt(0);
            }
        }

        static String of(String letter) {
            return new Diamond(letter).create();
        }

        private String create() {
            if ( "A".equals(letter)) {
                return letter;
            } else {
                List<String> atFirst = rangeClosed((int) 'A', letterCode)
                        .mapToObj(code -> Stream
                                .generate(() -> " ")
                                .limit(letterCode - code)
                                .collect(joining()) + (code == 65 ? "A" : letterOf((char) code) + letterOf(
                                (char) code)))
                        .collect(toList());
                List<String> atLast = new ArrayList<>(atFirst.subList(0, atFirst.size() - 1));
                reverse(atLast);
                return Stream
                        .of(atFirst, atLast)
                        .flatMap(List::stream)
                        .collect(joining("\n"));
            }
        }

        private String letterOf(char code) {
            return valueOf(code);
        }
    }
}
