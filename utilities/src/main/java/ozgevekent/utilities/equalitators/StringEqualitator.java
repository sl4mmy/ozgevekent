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
 * Understands how to determine when character sequences are equivalent.
 */
public class StringEqualitator implements Equalitator<String> {

        public boolean areEqual(final String left, final String right) {
                if (left == right) {
                        return true;
                }

                if (bothAreNullOrEmpty(left, right)) {
                        return true;
                }

                if (left == null) {
                        return false;
                }

                return left.equals(right);
        }

        private boolean bothAreNullOrEmpty(final String left, final String right) {
                return isNullOrEmpty(left) && isNullOrEmpty(right);
        }

        private boolean isNullOrEmpty(final String value) {
                return value == null || "".equals(value);
        }
}
