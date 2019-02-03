package diamond;

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
}
