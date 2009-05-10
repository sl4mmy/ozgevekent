/*
 * Copyright (c) 2009, Kent R. Spillner <kspillner@acm.org>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package ozgevekent.utilities.equalitators;

/**
 * Understands how to determine when vectors of Strings are equivalent.
 *
 * @param <T> type of elements
 */
public class ArrayEqualitator<T> implements Equalitator<T[]> {

        private final Equalitator<T> elementEqualitator;

        public ArrayEqualitator(final Equalitator<T> elementEqualitator) {
                this.elementEqualitator = elementEqualitator;
        }

        public boolean areEqual(final T[] left, final T[] right) {
                if (left == right) {
                        return true;
                }

                if (bothAreNullOrEmpty(left, right)) {
                        return true;
                }

                if (isNullOrEmpty(left) || isNullOrEmpty(right)) {
                        return false;
                }

                return areValuesEqual(left, right);
        }

        private boolean areValuesEqual(final T[] left, final T[] right) {
                if (left.length != right.length) {
                        return false;
                }

                for (int index = 0; index < left.length; index++) {
                        final T leftElement = left[index];
                        final T rightElement = right[index];

                        if (not(elementEqualitator.areEqual(leftElement, rightElement))) {
                                return false;
                        }
                }

                return true;
        }

        private boolean bothAreNullOrEmpty(final T[] left, final T[] right) {
                return isNullOrEmpty(left) && isNullOrEmpty(right);
        }

        private boolean isNullOrEmpty(final T[] values) {
                return values == null || values.length == 0;
        }

        private boolean not(final boolean expression) {
                return !expression;
        }
}
