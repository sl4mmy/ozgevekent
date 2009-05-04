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

/**
 * Understands how to distinguish a particular building within a neighborhood.
 */
public class Street {

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

                        if (components == otherComponents) {
                                return true;
                        }

                        if (components == null || otherComponents == null) {
                                return false;
                        }

                        return areComponentsEqual(components, otherComponents);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(components)) {
                        return 42;
                }

                return components.hashCode();
        }

        public String toString() {
                if (isNullOrEmpty(components)) {
                        return "";
                }

                return join(components, "\n");
        }

        private boolean areComponentsEqual(final String[] left, final String[] right) {
                if (left.length != right.length) {
                        return false;
                }

                for (int index = 0; index < left.length; index++) {
                        final String component = left[index];
                        final String otherComponent = right[index];

                        if (component == otherComponent) {
                                continue;
                        }

                        if (component == null || not(component.equals(otherComponent))) {
                                return false;
                        }
                }

                return true;
        }

        private String emptyStringIfNull(final String value) {
                if (value == null) {
                        return "";
                }

                return value;
        }

        private boolean isLast(final int current, final int total) {
                return current == total - 1;
        }

        private boolean isNullOrEmpty(final String[] values) {
                return values == null || values.length == 0;
        }

        private String join(final String[] values, final String separator) {
                final int length = values.length;

                final StringBuilder temp = new StringBuilder();
                for (int index = 0; index < length; index++) {
                        final String component = components[index];

                        temp.append(emptyStringIfNull(component));

                        if (not(isLast(index, length))) {
                                temp.append(separator);
                        }
                }

                return temp.toString();
        }

        private boolean not(final boolean expression) {
                return !expression;
        }
}
