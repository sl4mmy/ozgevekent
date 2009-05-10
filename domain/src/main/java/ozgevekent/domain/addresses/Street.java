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

package ozgevekent.domain.addresses;

import ozgevekent.utilities.equalitators.ArrayEqualitator;
import ozgevekent.utilities.equalitators.StringEqualitator;
import ozgevekent.utilities.prettyprinters.ArrayPrettyPrinter;

/**
 * Understands how to distinguish a particular building within a neighborhood.
 */
public class Street {

        private static final int DEFAULT_HASHCODE = 42;

        private final String[] components;

        public Street(final String... components) {
                this.components = components;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof Street) {
                        final Street otherStreet = (Street) other;
                        final String[] otherComponents = otherStreet.components;

                        final StringEqualitator elementEqualitator = new StringEqualitator();

                        return new ArrayEqualitator<String>(elementEqualitator).areEqual(components, otherComponents);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(components)) {
                        return DEFAULT_HASHCODE;
                }

                return components.hashCode();
        }

        @Override
        public String toString() {
                return new ArrayPrettyPrinter<String>().prettify(components);
        }

        private boolean isNullOrEmpty(final String[] values) {
                return values == null || values.length == 0;
        }
}
