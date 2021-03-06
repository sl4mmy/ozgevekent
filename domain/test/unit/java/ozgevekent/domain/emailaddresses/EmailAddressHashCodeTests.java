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
import org.junit.Test;
import ozgevekent.domain.EmailAddress;

public class EmailAddressHashCodeTests {

        @Test
        public void shouldBeFortyTwoWhenEmailAddressValueIsNull() throws Exception {
                final EmailAddress emailAddress = new EmailAddress(null);

                assertEquals(42, emailAddress.hashCode());
        }

        @Test
        public void shouldBeFortyTwoWhenEmailAddressValueIsEmpty() throws Exception {
                final EmailAddress emailAddress = new EmailAddress("");

                assertEquals(42, emailAddress.hashCode());
        }

        @Test
        public void shouldBeEmailAddressValueHashCodeWhenEmailAddressValueIsNotNullOrEmpty() throws Exception {
                final String value = "DOES NOT MATTER";

                final EmailAddress emailAddress = new EmailAddress(value);

                assertEquals(value.hashCode(), emailAddress.hashCode());
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(EmailAddressHashCodeTests.class);
        }
}
