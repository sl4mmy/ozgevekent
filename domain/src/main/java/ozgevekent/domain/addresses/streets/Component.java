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

package ozgevekent.domain.addresses.streets;

import com.google.appengine.api.datastore.Key;
import ozgevekent.domain.addresses.Street;
import ozgevekent.utilities.equalitators.StringEqualitator;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Understands individual elements in a street address.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Component implements Serializable {

        private static final int DEFAULT_HASHCODE = 42;

        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        private Key key;

        @Persistent
        private String component;

        @Persistent
        private Street street;

        protected Component() {
        }

        public Component(final String component) {
                this.component = component;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof Component) {
                        final Component otherComponent = (Component) other;

                        return new StringEqualitator().areEqual(component, otherComponent.component);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(component)) {
                        return DEFAULT_HASHCODE;
                }

                return component.hashCode();
        }

        @Override
        public String toString() {
                if (isNullOrEmpty(component)) {
                        return "";
                }

                return component;
        }

        private boolean isNullOrEmpty(final String value) {
                return value == null || "".equals(value);
        }
}
