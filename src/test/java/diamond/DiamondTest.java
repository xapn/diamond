/*-
 * #%L
 * Diamond Kata
 * %%
 * Copyright (C) 2019 Xavier Pigeon
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package diamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;

class DiamondTest {

    @Nested
    class Given_an_uppercase_letter {

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
    }

    @Nested
    class Given_a_lowercase_letter {

        @Test
        void should_create_a_diamond_given_a() {
            resultOf(() -> Diamond.of("a")).isEqualTo("a");
        }

        @Test
        void should_create_a_diamond_given_b() {
            resultOf(() -> Diamond.of("b")).isEqualTo(" a\n" //
                    + "b b\n" //
                    + " a");
        }
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

        @Test
        void should_fail_to_create_a_diamond_given_anything_but_a_letter() {
            whenOutsideOperatingConditions(() -> Diamond.of("1"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Letter expected!");
        }

        @Test
        void should_fail_to_create_a_diamond_given_several_letters() {
            whenOutsideOperatingConditions(() -> Diamond.of("AB"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("A single letter expected!");
        }
    }
}
