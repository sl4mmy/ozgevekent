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

/**
 * Understands sub-national political entities.
 */
@PersistenceCapable
@EmbeddedOnly
public class State {

        private static final int DEFAULT_HASHCODE = 42;

        @Persistent
        private String state;

        protected State() {
        }

        public State(final String state) {
                this.state = state;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (other instanceof State) {
                        final State otherState = (State) other;

                        return new StringEqualitator().areEqual(state, otherState.state);
                }

                return false;
        }

        @Override
        public int hashCode() {
                if (isNullOrEmpty(state)) {
                        return DEFAULT_HASHCODE;
                }

                return state.hashCode();
        }

        @Override
        public String toString() {
                if (isNullOrEmpty(state)) {
                        return "";
                }

                return state;
        }

        private boolean isNullOrEmpty(final String value) {
                return value == null || "".equals(value);
        }
}
