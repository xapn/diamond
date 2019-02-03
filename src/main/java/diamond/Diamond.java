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
    private final int startCode;

    private Diamond(String letter) {
        this.letter = letter;
        if (letter == null) {
            throw new IllegalArgumentException("Argument value missing!");
        } else if (letter.isEmpty()) {
            throw new IllegalArgumentException("Letter missing!");
        } else if (letter.length() > 1) {
            throw new IllegalArgumentException("A single letter expected!");
        } else if (!letter.matches("[a-zA-Z]")) {
            throw new IllegalArgumentException("Letter expected!");
        } else {
            letterCode = letter.codePointAt(0);
            if (letter.matches("[A-Z]")) {
                startCode = (int) 'A';
            } else {
                startCode = (int) 'a';
            }
        }
    }

    public static String of(String letter) {
        return new Diamond(letter).create();
    }

    private String create() {
        if ("A".equals(letter.toUpperCase())) {
            return letter;
        } else {
            List<String> atFirst = rangeClosed(startCode, letterCode)
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
        String letter = letterOf((char) code);
        return indentLine(code) + (code == startCode ? letter : letter + separateLetters(code) + letter);
    }

    private String indentLine(int code) {
        return repeatSpaceNTimes(letterCode - code);
    }

    private String separateLetters(int code) {
        return repeatSpaceNTimes((code - startCode - 1) * 2 + 1);
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
