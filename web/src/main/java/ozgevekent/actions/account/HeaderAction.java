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

package ozgevekent.actions.account;

import org.apache.struts2.interceptor.RequestAware;
import ozgevekent.AccountAware;
import ozgevekent.domain.Account;
import ozgevekent.services.UserService;

import java.util.Map;

/**
 * Understands how to format account information for display.
 */
public class HeaderAction implements AccountAware, RequestAware {

        private Account account;

        private UserService userService;

        private Map<String, Object> request;

        public HeaderAction() {
                userService = new UserService();
        }

        public String execute() throws Exception {
                return "success";
        }

        public boolean isLoggedIn() {
                return account.isNormal() || account.isSuperuser();
        }

        public String getLoginURL() {
                return userService.loginURLFor((String) request.get("struts.request_uri"));
        }

        public String getLogoutURL() {
                return userService.logoutURLFor((String) request.get("struts.request_uri"));
        }

        public String getNickname() {
                return userService.nickname();
        }

        public boolean isSuperuser() {
                return account.isSuperuser();
        }

        public void setAccount(final Account account) {
                this.account = account;
        }

        public void setRequest(final Map<String, Object> request) {
                this.request = request;
        }
}
