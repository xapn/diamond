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

class Letter {

    private final String letter;
    private final int code;

    Letter(String letter) {
        this.letter = letter;
        new RightLetterSpecification().check();
        code = letter.codePointAt(0);
    }

    boolean isA() {
        return "A".equals(letter.toUpperCase());
    }

    boolean isUppercase() {
        return letter.matches("[A-Z]");
    }

    String getLetter() {
        return letter;
    }

    int getCode() {
        return code;
    }

    private class RightLetterSpecification {

        private void check() {
            if (letter == null) {
                throw new IllegalArgumentException("Argument value missing!");
            } else if (letter.isEmpty()) {
                throw new IllegalArgumentException("Letter missing!");
            } else if (!isLetter(letter)) {
                throw new IllegalArgumentException("Letter expected!");
            } else if (!isSingleLetter(letter)) {
                throw new IllegalArgumentException("A single letter expected!");
            }
        }

        private boolean isLetter(String letter) {
            return letter.matches("[a-zA-Z]+");
        }

        private boolean isSingleLetter(String letter) {
            return letter.length() == 1;
        }
    }
}
