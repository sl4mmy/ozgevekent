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

package ozgevekent.domain.addresses.cities;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
import ozgevekent.domain.addresses.City;

public class CityEqualityTests {

        @Test
        public void shouldBeEqualToSelf() throws Exception {
                final City city = new City("DOES NOT MATTER");

                assertEquals(true, city.equals(city));
        }

        @Test
        public void shouldNotBeEqualToNull() throws Exception {
                final City city = new City("DOES NOT MATTER");

                assertEquals(false, city.equals(null));
        }

        @Test
        public void shouldNotBeEqualToAnyInstanceThatIsNotACity() throws Exception {
                final City city = new City("DOES NOT MATTER");

                assertEquals(false, city.equals(new Object()));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCityValuesAreTheSame() throws Exception {
                final String value = "DOES NOT MATTER";

                final City left = new City(value);
                final City right = new City(value);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCityValuesAreEqual() throws Exception {
                final City left = new City("DOES NOT MATTER");
                final City right = new City("DOES NOT MATTER");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCityValuesAreNull() throws Exception {
                final City left = new City(null);
                final City right = new City(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenBothCityValuesAreEmtpy() throws Exception {
                final City left = new City("");
                final City right = new City("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenCityValueIsNullAndOtherCityValueIsEmpty() throws Exception {
                final City left = new City(null);
                final City right = new City("");

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldBeEqualToDifferentInstanceWhenCityValueIsEmptyAndOtherCityValueIsNull() throws Exception {
                final City left = new City("");
                final City right = new City(null);

                assertNotSame(left, right);
                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenBothCityValuesAreNotEqual() throws Exception {
                final City left = new City("LEFT");
                final City right = new City("RIGHT");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCityValueIsNullAndOtherCityValueIsNotNullOrEmpty()
            throws Exception {
                final City left = new City(null);
                final City right = new City("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCityValueIsEmptyAndOtherCityValueIsNotNullOrEmpty()
            throws Exception {
                final City left = new City("");
                final City right = new City("DOES NOT MATTER");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCityValueIsNotNullOrEmptyAndOtherCityValueIsNull()
            throws Exception {
                final City left = new City("DOES NOT MATTER");
                final City right = new City(null);

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstanceWhenCityValueIsNotNullOrEmptyAndOtherCityValueIsEmpty()
            throws Exception {
                final City left = new City("DOES NOT MATTER");
                final City right = new City("");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void equalsShouldBeCommutative() throws Exception {
                final City left = new City("DOES NOT MATTER");
                final City right = new City("DOES NOT MATTER");

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void equalsShouldBeTransitive() throws Exception {
                final City left = new City("DOES NOT MATTER");
                final City middle = new City("DOES NOT MATTER");
                final City right = new City("DOES NOT MATTER");

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() {
                return new JUnit4TestAdapter(CityEqualityTests.class);
        }
}
