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

import com.google.appengine.api.datastore.Key;
import ozgevekent.domain.Address;
import ozgevekent.domain.addresses.streets.Component;
import ozgevekent.utilities.equalitators.ArrayEqualitator;
import ozgevekent.utilities.equalitators.StringEqualitator;
import ozgevekent.utilities.prettyprinters.ArrayPrettyPrinter;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Understands how to distinguish a particular building within a neighborhood.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Street implements Serializable {

        private static final int DEFAULT_HASHCODE = 42;

        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        private Key key;

        @Persistent(mappedBy = "street")
        private Address address;

        @Persistent(mappedBy = "street")
        private List<Component> components;

        protected Street() {
        }

        public Street(final List<Component> components) {
                if (components == null) {
                        this.components = Collections.EMPTY_LIST;
                } else {
                        this.components = components;
                }
        }

        public Street(final String... components) {
                this(initialize(components));
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof Street) {
                        final Street otherStreet = (Street) other;
                        final String[] otherComponents = toArray(otherStreet.components);

                        final StringEqualitator elementEqualitator = new StringEqualitator();

                        return new ArrayEqualitator<String>(elementEqualitator)
                            .areEqual(toArray(components), otherComponents);
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
                return new ArrayPrettyPrinter<String>().prettify(toArray(components));
        }

        private boolean isNullOrEmpty(final List<Component> values) {
                return values == null || values.size() == 0;
        }

        private String[] toArray(final List<Component> values) {
                if (values == null) {
                        return new String[] {};
                }

                final int length = values.size();
                final String[] temp = new String[length];
                for (int i = 0; i < temp.length; i++) {
                        temp[i] = values.get(i).toString();
                }

                return temp;
        }

        private static List<Component> initialize(final String... components) {
                if (components == null || components.length == 0) {
                        return Collections.EMPTY_LIST;
                }

                final List<Component> temp = new LinkedList<Component>();
                for (String component : components) {
                        temp.add(new Component(component));
                }

                return temp;
        }
}
