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

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.io.Serializable;

/**
 * Understands authorization levels for users.
 */
@PersistenceCapable
@EmbeddedOnly
public class Role implements Serializable {

        @Persistent
        private String role;

        private Role(final String role) {
                this.role = role;
        }

        protected Role() {
        }

        public boolean isAnonymous() {
                return "ANONYMOUS".equals(role);
        }

        public boolean isNormal() {
                return "NORMAL".equals(role);
        }

        public boolean isSuperuser() {
                return "SUPERUSER".equals(role);
        }

        @Override
        public boolean equals(final Object other) {
                if (other instanceof Role) {
                        final Role otherRole = (Role) other;

                        return role.equals(otherRole.role);
                }

                return false;
        }

        @Override
        public int hashCode() {
                return role.hashCode();
        }

        @Override
        public String toString() {
                return role;
        }

        public static Role anonymous() {
                return new Role("ANONYMOUS");
        }

        public static Role normal() {
                return new Role("NORMAL");
        }

        public static Role superuser() {
                return new Role("SUPERUSER");
        }
}
