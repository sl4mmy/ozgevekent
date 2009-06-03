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

package ozgevekent.services;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import ozgevekent.domain.Account;
import ozgevekent.domain.Role;
import ozgevekent.persistence.DAO;

import java.util.List;

/**
 * Understands Google's single sign-on mechanism.
 */
public class UserService {

        private static final com.google.appengine.api.users.UserService GOOGLE_SERVICE = UserServiceFactory
            .getUserService();

        private User user;

        public Account associateUserWith(final Account account) {
                account.associateWith(getUser(), getRole());
                return account;
        }

        public Account findOrCreateAccountAssociatedWithUser() {
                if (not(isLoggedIn())) {
                        return new Account();
                }

                final List<Account> accounts = accountsForUser();
                return findOrCreateFirstMatch(accounts);
        }

        public boolean isUserAssociatedWith(final Account account) {
                return account != null && account.hasUser() && account.isAssociatedWith(getUser());
        }

        public String loginURLFor(final String requestURL) {
                return GOOGLE_SERVICE.createLoginURL(requestURL);
        }

        public String logoutURLFor(final String requestURL) {
                return GOOGLE_SERVICE.createLogoutURL(requestURL);
        }

        public String nickname() {
                if (not(isLoggedIn())) {
                        return null;
                }

                return getUser().getNickname();
        }

        private List<Account> accountsForUser() {
                final DAO<Account> dao = new DAO<Account>();
                return dao.findBy("select from Account where user == userParam parameters User userParam", getUser());
        }

        private Account findOrCreateFirstMatch(final List<Account> accounts) {
                if (accounts == null) {
                        return associateUserWith(new Account());
                }

                for (Account account : accounts) {
                        if (isUserAssociatedWith(account)) {
                                return account;
                        }
                }

                return associateUserWith(new Account());
        }

        private boolean isAdmin() {
                return isLoggedIn() && GOOGLE_SERVICE.isUserAdmin();
        }

        private boolean isLoggedIn() {
                return GOOGLE_SERVICE.isUserLoggedIn();
        }

        private Role getRole() {
                if (isAdmin()) {
                        return Role.superuser();
                }

                if (isLoggedIn()) {
                        return Role.normal();
                }

                return Role.anonymous();
        }

        private User getUser() {
                if (user == null) {
                        user = GOOGLE_SERVICE.getCurrentUser();
                }

                return user;
        }

        private boolean not(final boolean expression) {
                return !expression;
        }
}
