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

package ozgevekent.domain.emailaddresses;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.EmailAddress;

public class EmailAddressEqualityTests {

        @Test
        public void shouldBeEqualToSelf() throws Exception {
                final EmailAddress emailAddress = new EmailAddress("DOES NOT MATTER");

                assertEquals(true, emailAddress.equals(emailAddress));
        }

        @Test
        public void shouldNotBeEqualToNull() throws Exception {
                final EmailAddress emailAddress = new EmailAddress("DOES NOT MATTER");

                assertEquals(false, emailAddress.equals(null));
        }

        @Test
        public void shouldNotBeEqualToAnyInstanceThatIsNotAEmailAddress() throws Exception {
                final EmailAddress emailAddress = new EmailAddress("DOES NOT MATTER");

                assertEquals(false, emailAddress.equals(new Object()));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothEmailAddressValuesAreTheSame() throws Exception {
                final String value = "DOES NOT MATTER";

                final EmailAddress left = new EmailAddress(value);
                final EmailAddress right = new EmailAddress(value);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothEmailAddressValuesAreEqual() throws Exception {
                final EmailAddress left = new EmailAddress("DOES NOT MATTER");
                final EmailAddress right = new EmailAddress("DOES NOT MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothEmailAddressValuesAreNull() throws Exception {
                final EmailAddress left = new EmailAddress(null);
                final EmailAddress right = new EmailAddress(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothEmailAddressValuesAreEmtpy() throws Exception {
                final EmailAddress left = new EmailAddress("");
                final EmailAddress right = new EmailAddress("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenEmailAddressValueIsNullAndOtherEmailAddressValueIsEmpty()
            throws Exception {
                final EmailAddress left = new EmailAddress(null);
                final EmailAddress right = new EmailAddress("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenEmailAddressValueIsEmptyAndOtherEmailAddressValueIsNull()
            throws Exception {
                final EmailAddress left = new EmailAddress("");
                final EmailAddress right = new EmailAddress(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenBothEmailAddressValuesAreNotEqual() throws Exception {
                final EmailAddress left = new EmailAddress("LEFT");
                final EmailAddress right = new EmailAddress("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenEmailAddressValueIsNullAndOtherEmailAddressValueIsNotNullOrEmpty()
            throws Exception {
                final EmailAddress left = new EmailAddress(null);
                final EmailAddress right = new EmailAddress("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenEmailAddressValueIsEmptyAndOtherEmailAddressValueIsNotNullOrEmpty()
            throws Exception {
                final EmailAddress left = new EmailAddress("");
                final EmailAddress right = new EmailAddress("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenEmailAddressValueIsNotNullOrEmptyAndOtherEmailAddressValueIsNull()
            throws Exception {
                final EmailAddress left = new EmailAddress("DOES NOT MATTER");
                final EmailAddress right = new EmailAddress(null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenEmailAddressValueIsNotNullOrEmptyAndOtherEmailAddressValueIsEmpty()
            throws Exception {
                final EmailAddress left = new EmailAddress("DOES NOT MATTER");
                final EmailAddress right = new EmailAddress("");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void equalsShouldBeCommutative() throws Exception {
                final EmailAddress left = new EmailAddress("DOES NOT MATTER");
                final EmailAddress right = new EmailAddress("DOES NOT MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void equalsShouldBeTransitive() throws Exception {
                final EmailAddress left = new EmailAddress("DOES NOT MATTER");
                final EmailAddress middle = new EmailAddress("DOES NOT MATTER");
                final EmailAddress right = new EmailAddress("DOES NOT MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(EmailAddressEqualityTests.class);
        }
}
