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

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.io.Serializable;

/**
 * Understands how pieces of mail are automatically sorted.
 */
@PersistenceCapable
@EmbeddedOnly
public class PostalCode implements Serializable {

        private static final int DEFAULT_HASHCODE = 42;

        @Persistent
        private String postalCode;

        protected PostalCode() {
        }

        public PostalCode(final String postalCode) {
                this.postalCode = postalCode;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof PostalCode) {
                        final PostalCode otherPostalCode = (PostalCode) other;

                        return new StringEqualitator().areEqual(postalCode, otherPostalCode.postalCode);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(postalCode)) {
                        return DEFAULT_HASHCODE;
                }

                return postalCode.hashCode();
        }

        @Override
        public String toString() {
                if (isNullOrEmpty(postalCode)) {
                        return "";
                }

                return postalCode;
        }

        private boolean isNullOrEmpty(final String value) {
                return value == null || "".equals(value);
        }
}
