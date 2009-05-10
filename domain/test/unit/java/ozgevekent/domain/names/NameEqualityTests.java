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

package ozgevekent.domain.names;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.Name;

public class NameEqualityTests {

        @Test
        public void shouldEqualSelf() throws Exception {
                final Name name = new Name("DOES NOT MATTER");

                assertEquals(true, name.equals(name));
        }

        @Test
        public void shouldNotEqualNull() throws Exception {
                final Name name = new Name("DOES NOT MATTER");

                assertEquals(false, name.equals(null));
        }

        @Test
        public void shouldNotEqualAnyInstanceThatIsNotAName() throws Exception {
                final Name name = new Name("DOES NOT MATTER");

                assertEquals(false, name.equals(new Object()));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothNameValuesAreTheSame() throws Exception {
                final String name = "DOES NOT MATTER";

                final Name left = new Name(name);
                final Name right = new Name(name);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothNameValuesAreEqual() throws Exception {
                final Name left = new Name("DOES NOT MATTER");
                final Name right = new Name("DOES NOT MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothNameValuesAreNull() throws Exception {
                final Name left = new Name(null);
                final Name right = new Name(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothNameValuesAreEmpty() throws Exception {
                final Name left = new Name("");
                final Name right = new Name("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenNameValueIsNullAndOtherNameValueIsEmpty() throws Exception {
                final Name left = new Name(null);
                final Name right = new Name("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenNameValueIsEmptyAndOtherNameValueIsNull() throws Exception {
                final Name left = new Name("");
                final Name right = new Name(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenNameValuesAreNotEqual() throws Exception {
                final Name left = new Name("LEFT");
                final Name right = new Name("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenNameValueIsNullAndOtherNameValueIsNotNullOrEmpty()
            throws Exception {
                final Name left = new Name(null);
                final Name right = new Name("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenNameValueIsEmptyAndOtherNameValueIsNotNullOrEmpty()
            throws Exception {
                final Name left = new Name("");
                final Name right = new Name("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenNameValueIsNotNullOrEmptyAndOtherNameValueIsNull()
            throws Exception {
                final Name left = new Name("DOES NOT MATTER");
                final Name right = new Name(null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenNameValueIsNotNullOrEmptyAndOtherNameValueIsEmpty()
            throws Exception {
                final Name left = new Name("DOES NOT MATTER");
                final Name right = new Name("");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void equalsShouldBeCommutative() throws Exception {
                final Name left = new Name("DOES NOT MATTER");
                final Name right = new Name("DOES NOT MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void equalsShouldBeTransitive() throws Exception {
                final Name left = new Name("DOES NOT MATTER");
                final Name middle = new Name("DOES NOT MATTER");
                final Name right = new Name("DOES NOT MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(NameEqualityTests.class);
        }
}
