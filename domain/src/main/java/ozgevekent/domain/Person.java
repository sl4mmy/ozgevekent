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

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Understands individual human beings.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person {

        private static final int PRIME = 31;

        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        private Key key;

        @Persistent
        private Address address;

        @Persistent
        @Embedded
        private EmailAddress emailAddress;

        @Persistent
        @Embedded
        private Name name;

        protected Person() {
        }

        public Person(final Name name, final EmailAddress emailAddress, final Address address) {
                this.name = name;
                this.emailAddress = emailAddress;
                this.address = address;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (!(other instanceof Person)) {
                        return false;
                }

                final Person person = (Person) other;

                if (!address.equals(person.address)) {
                        return false;
                }

                if (!emailAddress.equals(person.emailAddress)) {
                        return false;
                }

                if (!name.equals(person.name)) {
                        return false;
                }

                return true;
        }

        @Override
        public int hashCode() {
                int result = address.hashCode();
                result = PRIME * result + emailAddress.hashCode();
                result = PRIME * result + name.hashCode();
                return result;
        }

        @Override
        public String toString() {
                final StringBuilder temp = new StringBuilder();
                temp.append(name).append(" <");
                temp.append(emailAddress).append(">\n");
                temp.append(address);
                return temp.toString();
        }
}
