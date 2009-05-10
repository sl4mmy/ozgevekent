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

package ozgevekent.utilities.equalitators;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringEqualitatorTests {

        @Test
        public void shouldBeTrueWhenLeftAndRightAreSame() throws Exception {
                final String value = "DOES NOT MATTER";

                assertEquals(true, equalitator().areEqual(value, value));
        }

        @Test
        public void shouldBeTrueWhenLeftAndRightAreEqual() throws Exception {
                assertEquals(true, equalitator().areEqual("DOES NOT MATTER", "DOES NOT MATTER"));
        }

        @Test
        public void shouldBeTrueWhenLeftAndRightAreBothNull() throws Exception {
                assertEquals(true, equalitator().areEqual(null, null));
        }

        @Test
        public void shouldBeTrueWhenLeftAndRightAreBothEmpty() throws Exception {
                assertEquals(true, equalitator().areEqual("", ""));
        }

        @Test
        public void shouldBeTrueWhenLeftIsNullAndRightIsEmpty() throws Exception {
                assertEquals(true, equalitator().areEqual(null, ""));
        }

        @Test
        public void shouldBeTrueWhenLeftIsEmptyAndRightIsNull() throws Exception {
                assertEquals(true, equalitator().areEqual("", null));
        }

        @Test
        public void shouldNotBeTrueWhenLeftAndRightAreNotEqual() throws Exception {
                assertEquals(false, equalitator().areEqual("LEFT", "RIGHT"));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNullAndRightIsNotNullOrEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual(null, "DOES NOT MATTER"));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsEmptyAndRightIsNotNullOrEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual("", "DOES NOT MATTER"));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNotNullOrEmptyAndRightIsNull() throws Exception {
                assertEquals(false, equalitator().areEqual("DOES NOT MATTER", null));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNotNullOrEmptyAndRightIsEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual("DOES NOT MATTER", ""));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(StringEqualitatorTests.class);
        }

        private Equalitator<String> equalitator() {
                return new StringEqualitator();
        }
}
