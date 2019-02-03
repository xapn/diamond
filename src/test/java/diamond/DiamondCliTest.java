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

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.when;

class DiamondCliTest {

    @Test
    void should_print_a_diamond() {
        when(() -> DiamondCli.main(new String[]{"D"})).thenStandardOutput(
                stdout -> assertThat(stdout).hasContent("   A\n" //
                        + "  B B\n" //
                        + " C   C\n" //
                        + "D     D\n" //
                        + " C   C\n" //
                        + "  B B\n" //
                        + "   A"));
    }

    @Nested
    class Given_invalid_arguments {

        @Test
        void should_print_an_error_message_given_nil() {
            when(() -> DiamondCli.main(null)).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("Argument value missing!"));
        }

        @Test
        void should_print_an_error_message_given_several_letters() {
            when(() -> DiamondCli.main(new String[]{"A", "B"})).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("A single letter expected!"));
        }
    }
}
