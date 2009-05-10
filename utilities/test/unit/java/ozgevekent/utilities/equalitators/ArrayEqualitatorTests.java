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
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

public class ArrayEqualitatorTests {

        @Test
        public void shouldBeTrueWhenLeftAndRightAreSame() throws Exception {
                final String[] values = new String[] { "FIRST", "SECOND", "THIRD" };

                assertEquals(true, equalitator().areEqual(values, values));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAndRightValuesAreSame() throws Exception {
                final String first = "FIRST";
                final String second = "SECOND";
                final String third = "THIRD";

                final String[] left = new String[] { first, second, third };
                final String[] right = new String[] { first, second, third };

                assertNotSame(left, right);
                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAndRightValuesAreEqual() throws Exception {
                final String[] left = new String[] { "FIRST", "SECOND", "THIRD" };
                final String[] right = new String[] { "FIRST", "SECOND", "THIRD" };

                assertNotSame(left, right);
                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldBeTrueWhenLeftAndRightAreBothNull() throws Exception {
                assertEquals(true, equalitator().areEqual(null, null));
        }

        @Test
        public void shouldBeTrueWhenLeftAndRightAreBothEmpty() throws Exception {
                assertEquals(true, equalitator().areEqual(new String[] { }, new String[] { }));
        }

        @Test
        public void shouldBeTrueWhenLeftIsNullAndRightIsEmpty() throws Exception {
                assertEquals(true, equalitator().areEqual(null, new String[] { }));
        }

        @Test
        public void shouldBeTrueWhenLeftIsEmptyAndRightIsNull() throws Exception {
                assertEquals(true, equalitator().areEqual(new String[] { }, null));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAndRightValuesAreBothNull() throws Exception {
                final String[] left = new String[] { null, null, null };
                final String[] right = new String[] { null, null, null };

                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAndRightValuesAreBothEmpty() throws Exception {
                final String[] left = new String[] { "", "", "" };
                final String[] right = new String[] { "", "", "" };

                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAreNullAndRightValuesAreEmpty() throws Exception {
                final String[] left = new String[] { null, null, null };
                final String[] right = new String[] { "", "", "" };

                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldBeTrueWhenLeftValuesAreEmptyAndRightValuesAreNull() throws Exception {
                final String[] left = new String[] { "", "", "" };
                final String[] right = new String[] { null, null, null };

                assertEquals(true, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldNotBeTrueWhenLeftValuesAndRightValuesAreNotEqual() throws Exception {
                final String[] left = new String[] { "ONE", "TWO", "THREE" };
                final String[] right = new String[] { "FIRST", "SECOND", "THIRD" };

                assertEquals(false, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldNotBeTrueWhenAnyValuesBetweenLeftAndRightAreDifferent() throws Exception {
                final String[] left = new String[] { "SAME", "SAME", "SAME", "SAME" };
                final String[] right = new String[] { "SAME", "SAME", "DIFFERENT", "SAME" };

                assertEquals(false, equalitator().areEqual(left, right));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNullAndRightIsNotNullOrEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual(null, new String[] { "DOES", "NOT", "MATTER" }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsEmptyAndRightIsNotNullOrEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual(new String[] { }, new String[] { "DOES", "NOT", "MATTER" }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNotNullOrEmptyAndRightIsNull() throws Exception {
                assertEquals(false, equalitator().areEqual(new String[] { "DOES", "NOT", "MATTER" }, null));
        }

        @Test
        public void shouldNotBeTrueWhenLeftIsNotNullOrEmptyAndRightIsEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual(new String[] { "DOES", "NOT", "MATTER" }, new String[] { }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftValuesAreNullAndRightValuesAreNotNullOrEmpty() throws Exception {
                assertEquals(false, equalitator().areEqual(new String[] { null, null, null },
                    new String[] { "DOES", "NOT", "MATTER" }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftValuesAreEmptyAndRightValuesAreNotNullOrEmpty() throws Exception {
                assertEquals(false,
                    equalitator().areEqual(new String[] { "", "", "" }, new String[] { "DOES", "NOT", "MATTER" }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftValuesAreNotNullOrEmptyAndRightValuesAreNull() throws Exception {
                assertEquals(false, equalitator().areEqual(new String[] { "DOES", "NOT", "MATTER" },
                    new String[] { null, null, null }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftValuesAreNotNullOrEmptyAndRightValuesAreEmpty() throws Exception {
                assertEquals(false,
                    equalitator().areEqual(new String[] { "DOES", "NOT", "MATTER" }, new String[] { "", "", "" }));
        }

        @Test
        public void shouldNotBeTrueWhenLeftAndRightHaveDifferentLengths() throws Exception {
                final String[] left = new String[] { "ONE", "TWO", "THREE" };
                final String[] right = new String[] { "ONE", "TWO", "THREE", "FOUR" };

                assertEquals(false, equalitator().areEqual(left, right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(ArrayEqualitatorTests.class);
        }

        private Equalitator<String[]> equalitator() {
                return new ArrayEqualitator<String>(new StringEqualitator());
        }
}
