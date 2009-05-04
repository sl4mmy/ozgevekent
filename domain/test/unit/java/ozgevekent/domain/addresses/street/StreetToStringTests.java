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

package ozgevekent.domain.addresses.street;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ozgevekent.domain.addresses.Street;

public class StreetToStringTests {

        @Test
        public void shouldBeEmptyStringWhenComponentsAreNull() throws Exception {
                final Street street = new Street(null);

                assertEquals("", street.toString());
        }

        @Test
        public void shouldBeEmptyStringWhenComponentsAreEmpty() throws Exception {
                final Street street = new Street();

                assertEquals("", street.toString());
        }

        @Test
        public void shouldBeComponentValuesWhenComponentsIsValued() throws Exception {
                final Street street = new Street("STREET");

                assertEquals("STREET", street.toString());
        }

        @Test
        public void shouldJoinComponentValuesWithNewlinesWhenComponentsIsValued() throws Exception {
                final Street street = new Street("DOES", "NOT", "MATTER");

                assertEquals("DOES\nNOT\nMATTER", street.toString());
        }

        @Test
        public void shouldUseEmptyStringForIndividualComponentValuesThatAreNull() throws Exception {
                final Street street = new Street("DOES", null, "NOT", null, "MATTER", null);

                assertEquals("DOES\n\nNOT\n\nMATTER\n", street.toString());
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(StreetToStringTests.class);
        }
}
