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

package ozgevekent.domain;

/**
 * Understands how people are officially called.
 */
public class Name {

        private final String name;

        public Name(final String name) {
                this.name = name;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof Name) {
                        final Name otherName = (Name) other;

                        if (name == otherName.name) {
                                return true;
                        }

                        if (name == null) {
                                return false;
                        }

                        return name.equals(otherName.name);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (name == null) {
                        return 42;
                }

                return name.hashCode();
        }

        @Override
        public String toString() {
                if (name == null) {
                        return "";
                }

                return name;
        }
}
