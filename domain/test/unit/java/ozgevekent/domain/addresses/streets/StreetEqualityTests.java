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

package ozgevekent.domain.addresses.streets;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.addresses.Street;

public class StreetEqualityTests {

        @Test
        public void shouldEqualSelf() throws Exception {
                final Street street = new Street();

                assertEquals(true, street.equals(street));
        }

        @Test
        public void shouldNotEqualNull() throws Exception {
                final Street street = new Street();

                assertEquals(false, street.equals(null));
        }

        @Test
        public void shouldNotEqualAnyInstanceThatIsNotAStreet() throws Exception {
                final Street street = new Street("DOES", "NOT", "MATTER");

                assertEquals(false, street.equals(new Object()));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentsAreTheSame() throws Exception {
                final String[] components = new String[] { "DOES", "NOT", "MATTER" };

                final Street left = new Street(components);
                final Street right = new Street(components);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentValuesAreTheSame() throws Exception {
                final String first = "FIRST";
                final String second = "SECOND";
                final String third = "THIRD";

                final String[] leftComponents = new String[] { first, second, third };
                final String[] rightComponents = new String[] { first, second, third };

                final Street left = new Street(leftComponents);
                final Street right = new Street(rightComponents);

                assertNotSame(leftComponents, rightComponents);
                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentsAreEqual() throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentsAreEmpty() throws Exception {
                final Street left = new Street();
                final Street right = new Street();

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentsAreNull() throws Exception {
                final Street left = new Street((String[]) null);
                final Street right = new Street((String[]) null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenComponentsAreNullAndOtherComponentsAreEmpty() throws Exception {
                final Street left = new Street((String[]) null);
                final Street right = new Street();

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenComponentsAreEmptyAndOtherComponentsAreNull() throws Exception {
                final Street left = new Street();
                final Street right = new Street((String[]) null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentValuesAreNull() throws Exception {
                final Street left = new Street(null, null, null);
                final Street right = new Street(null, null, null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenBothComponentValuesAreEmpty() throws Exception {
                final Street left = new Street("", "", "");
                final Street right = new Street("", "", "");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenNullComponentValuesCorrespondToEmptyComponentValuesInOtherInstance()
            throws Exception {
                final Street left = new Street(null, null, null);
                final Street right = new Street("", "", "");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldEqualDifferentInstanceWhenEmptyComponentValuesCorrespondToNullComponentValuesInOtherInstance()
            throws Exception {
                final Street left = new Street("", "", "");
                final Street right = new Street(null, null, null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenBothComponentsAreNotEqual() throws Exception {
                final Street left = new Street("LEFT");
                final Street right = new Street("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenBothComponentValuesAreNotEqual() throws Exception {
                final Street left = new Street("SAME", "SAME", "DIFFERENT", "SAME");
                final Street right = new Street("SAME", "SAME", "SOMETHING ELSE", "SAME");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentsAreNullAndOtherComponentsAreNotNullOrEmpty()
            throws Exception {
                final Street left = new Street((String[]) null);
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentsAreEmptyAndOtherComponentsAreNotNullOrEmpty()
            throws Exception {
                final Street left = new Street();
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentValuesAreNullAndOtherComponentValuesAreNotNullOrEmpty()
            throws Exception {
                final Street left = new Street(null, null, null);
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentValuesAreEmptyAndOtherComponentValuesAreNotNullOrEmpty()
            throws Exception {
                final Street left = new Street("", "", "");
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentsAreNotNullOrEmptyAndOtherComponentsAreNull()
            throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street((String[]) null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentsAreNotNullOrEmptyAndOtherComponentsAreEmpty()
            throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street();

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWheComponentValuesAreNotNullOrEmptyAndOtherComponentsValuesAreNull()
            throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street(null, null, null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenComponentValuesAreNotNullOrEmptyAndOtherComponentValuesAreEmpty()
            throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street("", "", "");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotEqualDifferentInstanceWhenBothComponentsAreNotTheSameLength() throws Exception {
                final Street left = new Street("ONLY", "THREE", "COMPONENTS");
                final Street right = new Street("THIS", "HAS", "FOUR", "COMPONENTS");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void equalsShouldBeCommutative() throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void equalsShouldBeTransitive() throws Exception {
                final Street left = new Street("DOES", "NOT", "MATTER");
                final Street middle = new Street("DOES", "NOT", "MATTER");
                final Street right = new Street("DOES", "NOT", "MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(StreetEqualityTests.class);
        }
}
