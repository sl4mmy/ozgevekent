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

package ozgevekent.actions.person;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Understands how information about an individual human being is represented in an HTTP GET request.
 */
public class PersonParameters extends ActionSupport {

        private String name;

        private String emailAddress;

        private List<String> street;

        private String city;

        private String state;

        private String postalCode;

        private String country;

        public String getName() {
                return name;
        }

        public void setName(final String name) {
                this.name = name;
        }

        public String getEmailAddress() {
                return emailAddress;
        }

        public void setEmailAddress(final String emailAddress) {
                this.emailAddress = emailAddress;
        }

        public List<String> getStreet() {
                return street;
        }

        public void setStreet(final List<String> street) {
                this.street = street;
        }

        public String getCity() {
                return city;
        }

        public void setCity(final String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(final String state) {
                this.state = state;
        }

        public String getPostalCode() {
                return postalCode;
        }

        public void setPostalCode(final String postalCode) {
                this.postalCode = postalCode;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(final String country) {
                this.country = country;
        }
}
