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

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import ozgevekent.AccountAware;
import ozgevekent.PersonAware;
import ozgevekent.domain.Account;
import ozgevekent.domain.Person;
import ozgevekent.domain.Role;
import ozgevekent.persistence.DAO;
import ozgevekent.services.MailService;

/**
 * Understands how to create personal information for an individual human being.
 */
public class NewAction extends PersonParameters implements AccountAware, PersonAware {

        private Person person;

        private Account account;

        @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "name",
                        message = "Please enter your name"),
                    @RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "emailAddress",
                        message = "Please enter your email address")
                },
            emails = {
                    @EmailValidator(type = ValidatorType.FIELD, fieldName = "emailAddress",
                        message = "Please enter a valid email address")
                }
        )
        public String execute() throws Exception {
                final Role role = suitableRoleFor(account);
                account.registerTo(person, role);

                final DAO<Account> dao = new DAO<Account>();
                account = dao.save(account);

                final MailService mailService = new MailService();
                mailService.sendNewPersonMail(person);

                return "success";
        }

        public void setAccount(final Account account) {
                this.account = account;
        }

        public Person getPerson() {
                return person;
        }

        public void setPerson(final Person person) {
                this.person = person;
        }

        private Role suitableRoleFor(final Account account) {
                if (account.isSuperuser()) {
                        return Role.superuser();
                }

                return Role.normal();
        }
}
