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

package ozgevekent.domain.addresses.postalcodes;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.addresses.PostalCode;

public class PostalCodeEqualityTests {

        @Test
        public void shouldBeEqualToSelf() throws Exception {
                final PostalCode postalCode = new PostalCode("DOES NOT MATTER");

                assertEquals(true, postalCode.equals(postalCode));
        }

        @Test
        public void shouldNotBeEqualToNull() throws Exception {
                final PostalCode postalCode = new PostalCode("DOES NOT MATTER");

                assertEquals(false, postalCode.equals(null));
        }

        @Test
        public void shouldNotBeEqualToAnyInstanceThatIsNotAPostalCode() throws Exception {
                final PostalCode postalCode = new PostalCode("DOES NOT MATTER");

                assertEquals(false, postalCode.equals(new Object()));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothPostalCodeValuesAreTheSame() throws Exception {
                final String value = "DOES NOT MATTER";

                final PostalCode left = new PostalCode(value);
                final PostalCode right = new PostalCode(value);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothPostalCodeValuesAreEqual() throws Exception {
                final PostalCode left = new PostalCode("DOES NOT MATTER");
                final PostalCode right = new PostalCode("DOES NOT MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothPostalCodeValuesAreNull() throws Exception {
                final PostalCode left = new PostalCode(null);
                final PostalCode right = new PostalCode(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothPostalCodeValuesAreEmtpy() throws Exception {
                final PostalCode left = new PostalCode("");
                final PostalCode right = new PostalCode("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenPostalCodeValueIsNullAndOtherPostalCodeValueIsEmpty()
            throws Exception {
                final PostalCode left = new PostalCode(null);
                final PostalCode right = new PostalCode("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenPostalCodeValueIsEmptyAndOtherPostalCodeValueIsNull()
            throws Exception {
                final PostalCode left = new PostalCode("");
                final PostalCode right = new PostalCode(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenBothPostalCodeValuesAreNotEqual() throws Exception {
                final PostalCode left = new PostalCode("LEFT");
                final PostalCode right = new PostalCode("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenPostalCodeValueIsNullAndOtherPostalCodeValueIsNotNullOrEmpty()
            throws Exception {
                final PostalCode left = new PostalCode(null);
                final PostalCode right = new PostalCode("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenPostalCodeValueIsEmptyAndOtherPostalCodeValueIsNotNullOrEmpty()
            throws Exception {
                final PostalCode left = new PostalCode("");
                final PostalCode right = new PostalCode("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenPostalCodeValueIsNotNullOrEmptyAndOtherPostalCodeValueIsNull()
            throws Exception {
                final PostalCode left = new PostalCode("DOES NOT MATTER");
                final PostalCode right = new PostalCode(null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenPostalCodeValueIsNotNullOrEmptyAndOtherPostalCodeValueIsEmpty()
            throws Exception {
                final PostalCode left = new PostalCode("DOES NOT MATTER");
                final PostalCode right = new PostalCode("");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void equalsShouldBeCommutative() throws Exception {
                final PostalCode left = new PostalCode("DOES NOT MATTER");
                final PostalCode right = new PostalCode("DOES NOT MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void equalsShouldBeTransitive() throws Exception {
                final PostalCode left = new PostalCode("DOES NOT MATTER");
                final PostalCode middle = new PostalCode("DOES NOT MATTER");
                final PostalCode right = new PostalCode("DOES NOT MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(PostalCodeEqualityTests.class);
        }
}
