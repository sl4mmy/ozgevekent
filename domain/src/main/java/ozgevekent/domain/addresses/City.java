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

import ozgevekent.utilities.equalitators.StringEqualitator;

/**
 * Understands how to identify municipalities.
 */
public class City {

        private static final int DEFAULT_HASHCODE = 42;

        private final String city;

        public City(final String city) {
                this.city = city;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof City) {
                        final City otherCity = (City) other;

                        return new StringEqualitator().areEqual(city, otherCity.city);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(city)) {
                        return DEFAULT_HASHCODE;
                }

                return city.hashCode();
        }

        @Override
        public String toString() {
                if (isNullOrEmpty(city)) {
                        return "";
                }

                return city;
        }

        private boolean isNullOrEmpty(final String value) {
                return value == null || "".equals(value);
        }
}