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

package ozgevekent.domain.addresses.countries;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.addresses.Country;

public class CountryEqualityTests {

        @Test
        public void shouldBeEqualToSelf() throws Exception {
                final Country country = new Country("DOES NOT MATTER");

                assertEquals(true, country.equals(country));
        }

        @Test
        public void shouldNotBeEqualToNull() throws Exception {
                final Country country = new Country("DOES NOT MATTER");

                assertEquals(false, country.equals(null));
        }

        @Test
        public void shouldNotBeEqualToAnyInstanceThatIsNotACountry() throws Exception {
                final Country country = new Country("DOES NOT MATTER");

                assertEquals(false, country.equals(new Object()));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCountryValuesAreTheSame() throws Exception {
                final String country = "DOES NOT MATTER";

                final Country left = new Country(country);
                final Country right = new Country(country);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCountryValuesAreEqual() throws Exception {
                final Country left = new Country("DOES NOT MATTER");
                final Country right = new Country("DOES NOT MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCountryValuesAreNull() throws Exception {
                final Country left = new Country(null);
                final Country right = new Country(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCountryValuesAreEmpty() throws Exception {
                final Country left = new Country("");
                final Country right = new Country("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenCountryValueIsNullAndOtherCountryValueIsEmpty()
            throws Exception {
                final Country left = new Country(null);
                final Country right = new Country("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenCountryValueIsEmptyAndOtherCountryValueIsNull() throws Exception {
                final Country left = new Country("");
                final Country right = new Country(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenBothCountryValuesAreNotEqual() throws Exception {
                final Country left = new Country("LEFT");
                final Country right = new Country("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCountryValueIsNullAndOtherCountryValueIsNotNullOrEmpty()
            throws Exception {
                final Country left = new Country(null);
                final Country right = new Country("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCountryValueIsEmptyAndOtherCountryValueIsNotNullOrEmpty()
            throws Exception {
                final Country left = new Country("");
                final Country right = new Country("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCountryValueIsNotNullOrEmptyAndOtherCountryValueIsNull()
            throws Exception {
                final Country left = new Country("DOES NOT MATTER");
                final Country right = new Country(null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCountryValueIsNotNullOrEmptyAndOtherCountryValueIsEmpty()
            throws Exception {
                final Country left = new Country("DOES NOT MATTER");
                final Country right = new Country("");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldBeCommutative() throws Exception {
                final Country left = new Country("DOES NOT MATTER");
                final Country right = new Country("DOES NOT MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void shouldBeTransitive() throws Exception {
                final Country left = new Country("DOES NOT MATTER");
                final Country middle = new Country("DOES NOT MATTER");
                final Country right = new Country("DOES NOT MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(CountryEqualityTests.class);
        }
}
