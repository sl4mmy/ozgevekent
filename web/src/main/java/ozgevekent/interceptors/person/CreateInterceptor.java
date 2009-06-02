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

package ozgevekent.interceptors.person;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import ozgevekent.PersonAware;
import ozgevekent.actions.person.PersonParameters;
import ozgevekent.domain.Address;
import ozgevekent.domain.EmailAddress;
import ozgevekent.domain.Name;
import ozgevekent.domain.Person;
import ozgevekent.domain.addresses.City;
import ozgevekent.domain.addresses.Country;
import ozgevekent.domain.addresses.PostalCode;
import ozgevekent.domain.addresses.State;
import ozgevekent.domain.addresses.Street;
import ozgevekent.utilities.ActionInvocationSelectFilter;

import java.util.List;

/**
 * Understands how people are represented as request parameters.
 */
public class CreateInterceptor extends AbstractInterceptor {

        public String intercept(final ActionInvocation invocation) throws Exception {
                if (not(invocation.getAction() instanceof PersonAware)) {
                        return invocation.invoke();
                }

                final List<PersonAware> components =
                    new ActionInvocationSelectFilter(invocation).select(PersonAware.class);

                final PersonParameters personParameters = getPersonParameters(invocation.getAction());
                final Person person = parsePerson(personParameters);

                for (PersonAware component : components) {
                        component.setPerson(person);
                }

                return invocation.invoke();
        }

        private PersonParameters getPersonParameters(final Object action) {
                return (PersonParameters) action;
        }

        private Person parsePerson(final PersonParameters parameters) {
                final Name name = new Name(parameters.getName());
                final EmailAddress emailAddress = new EmailAddress(parameters.getEmailAddress());

                final Street street = parseStreet(parameters.getStreet());
                final City city = new City(parameters.getCity());
                final State state = new State(parameters.getState());
                final PostalCode postalCode = new PostalCode(parameters.getPostalCode());
                final Country country = new Country(parameters.getCountry());

                final Address address = new Address(postalCode, country, state, city, street);

                return new Person(name, emailAddress, address);
        }

        private Street parseStreet(final List<String> street) {
                final int length = street.size();
                final String[] storage = new String[length];
                return new Street(street.toArray(storage));
        }

        private boolean not(final boolean expression) {
                return !expression;
        }
}
