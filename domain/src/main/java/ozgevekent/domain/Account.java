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
import com.google.appengine.api.users.User;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Understands individual users.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Account implements Serializable {

        private static final int RANDOM_PRIME = 31;

        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        private Key key;

        @Persistent
        private Person person;

        @Persistent
        @Embedded
        private Role role;

        @Persistent
        private User user;

        public Account() {
        }

        public Account(final Person person, final Role role) {
                registerTo(person, role);
        }

        public Account(final User user, final Role role) {
                associateWith(user, role);
        }

        public boolean isAnonymous() {
                return role.isAnonymous();
        }

        public boolean isNormal() {
                return role.isNormal();
        }

        public boolean isSuperuser() {
                return role.isSuperuser();
        }

        public void registerTo(final Person person, final Role role) {
                this.person = person;
                this.role = role;
        }

        public boolean hasPerson() {
                return person != null;
        }

        public boolean isRegisteredTo(final Person other) {
                return hasPerson() && person.equals(other);
        }

        public void associateWith(final User user, final Role role) {
                this.user = user;
                this.role = role;
        }

        public boolean hasUser() {
                return user != null;
        }

        public boolean isAssociatedWith(final User other) {
                return hasUser() && user.equals(other);
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }
                if (!(other instanceof Account)) {
                        return false;
                }

                final Account account = (Account) other;

                if (person != null ? !person.equals(account.person) : account.person != null) {
                        return false;
                }
                if (user != null ? !user.equals(account.user) : account.user != null) {
                        return false;
                }

                return true;
        }

        @Override
        public int hashCode() {
                int result;
                result = (person != null ? person.hashCode() : 0);
                result = RANDOM_PRIME * result + (user != null ? user.hashCode() : 0);
                return result;
        }

        @Override
        public String toString() {
                return (person == null) ? "" : person.toString();
        }
}
