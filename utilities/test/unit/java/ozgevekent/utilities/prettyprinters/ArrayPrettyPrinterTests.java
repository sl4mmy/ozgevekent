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

package ozgevekent.utilities.prettyprinters;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayPrettyPrinterTests {

        @Test
        public void shouldBeEmptyStringWhenNull() throws Exception {
                assertEquals("", prettyPrinter().prettify(null));
        }

        @Test
        public void shouldBeEmptyStringWhenEmpty() throws Exception {
                assertEquals("", prettyPrinter().prettify(new String[] { }));
        }

        @Test
        public void shouldBeFormatValuesWhenNotNullOrEmpty() throws Exception {
                assertEquals("DOES NOT MATTER", prettyPrinter().prettify(new String[] { "DOES NOT MATTER" }));
        }

        @Test
        public void shouldJoinElementsWithNewlinesWhenValuesAreNotNullOrEmpty() throws Exception {
                assertEquals("DOES\nNOT\nMATTER", prettyPrinter().prettify(new String[] { "DOES", "NOT", "MATTER" }));
        }

        @Test
        public void shouldUseEmptyStringForIndividualElementsThatAreNullOrEmpty() throws Exception {
                assertEquals("DOES\n\nNOT\n\nMATTER\n",
                    prettyPrinter().prettify(new String[] { "DOES", null, "NOT", null, "MATTER", null }));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(ArrayPrettyPrinterTests.class);
        }

        private ArrayPrettyPrinter<String> prettyPrinter() {
                return new ArrayPrettyPrinter<String>();
        }
}
