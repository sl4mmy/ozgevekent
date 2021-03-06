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

import com.google.appengine.api.datastore.Key;
import ozgevekent.domain.addresses.City;
import ozgevekent.domain.addresses.Country;
import ozgevekent.domain.addresses.PostalCode;
import ozgevekent.domain.addresses.State;
import ozgevekent.domain.addresses.Street;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Understands how to uniquely identify physical locations.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Address implements Serializable {

        private static final int PRIME = 31;

        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        private Key key;

        @Persistent
        @Embedded
        private City city;

        @Persistent
        @Embedded
        private Country country;

        @Persistent(mappedBy = "address")
        private Person person;

        @Persistent
        @Embedded
        private PostalCode postalCode;

        @Persistent
        private Street street;

        @Persistent
        @Embedded
        private State state;

        protected Address() {
        }

        public Address(final PostalCode postalCode, final Country country, final State state, final City city,
            final Street street) {
                this.postalCode = postalCode;
                this.country = country;
                this.state = state;
                this.city = city;
                this.street = street;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (!(other instanceof Address)) {
                        return false;
                }

                final Address address = (Address) other;

                if (!city.equals(address.city)) {
                        return false;
                }

                if (!country.equals(address.country)) {
                        return false;
                }

                if (!postalCode.equals(address.postalCode)) {
                        return false;
                }

                if (state != null ? !state.equals(address.state) : address.state != null) {
                        return false;
                }

                if (!street.equals(address.street)) {
                        return false;
                }

                return true;
        }

        @Override
        public int hashCode() {
                int result = city.hashCode();
                result = PRIME * result + country.hashCode();
                result = PRIME * result + postalCode.hashCode();
                result = PRIME * result + street.hashCode();
                result = PRIME * result + (state != null ? state.hashCode() : 0);
                return result;
        }

        @Override
        public String toString() {
                final StringBuilder temp = new StringBuilder();
                temp.append(street).append("\n");
                temp.append(city).append(", ");
                temp.append(state != null ? state : "").append(" ");
                temp.append(postalCode).append("\n");
                temp.append(country);
                return temp.toString();
        }
}
