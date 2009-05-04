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
 * Understands geopolitical state boundaries.
 */
public class Country {

        private final String country;

        public Country(final String country) {
                this.country = country;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof Country) {
                        final Country otherCountry = (Country) other;

                        if (country == otherCountry.country) {
                                return true;
                        }

                        if (country == null) {
                                return false;
                        }

                        return country.equals(otherCountry.country);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (country == null) {
                        return 42;
                }

                return country.hashCode();
        }

        @Override
        public String toString() {
                if (country == null) {
                        return "";
                }

                return country;
        }
}
