package diamond;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class Diamond {

    private final String letter;
    private final int letterCode;

    private Diamond(String letter) {
        this.letter = letter;
        if (letter == null) {
            throw new IllegalArgumentException("Argument value missing!");
        } else if (letter.isEmpty()) {
            throw new IllegalArgumentException("Letter missing!");
        } else if (!letter.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Letter expected!");
        } else {
            letterCode = letter.codePointAt(0);
        }
    }

    public static String of(String letter) {
        return new Diamond(letter).create();
    }

    private String create() {
        if ("A".equals(letter)) {
            return letter;
        } else {
            List<String> atFirst = rangeClosed((int) 'A', letterCode)
                    .mapToObj(this::lineForCode)
                    .collect(toList());
            List<String> atLast = new ArrayList<>(atFirst.subList(0, atFirst.size() - 1));
            reverse(atLast);
            return Stream
                    .of(atFirst, atLast)
                    .flatMap(List::stream)
                    .collect(joining("\n"));
        }
    }

    private String lineForCode(int code) {
        return indentLine(code) + (code == 65 ? "A" : letterOf((char) code) + separateLetters(code) + letterOf(
                (char) code));
    }

    private String indentLine(int code) {
        return repeatSpaceNTimes(letterCode - code);
    }

    private String separateLetters(int code) {
        return repeatSpaceNTimes((code - 66) * 2 + 1);
    }

    private String letterOf(char code) {
        return valueOf(code);
    }

    private String repeatSpaceNTimes(int times) {
        return Stream
                .generate(() -> " ")
                .limit(times)
                .collect(joining());
    }
}
