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

package ozgevekent.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import ozgevekent.AccountAware;
import ozgevekent.domain.Account;
import ozgevekent.services.AccountService;
import ozgevekent.utilities.ActionInvocationSelectFilter;

import java.util.List;
import java.util.Map;

/**
 * Understands how to determine if users are already authenticated.
 */
public class AccountInterceptor extends AbstractInterceptor {

        public String intercept(final ActionInvocation invocation) throws Exception {
                if (not(invocation.getAction() instanceof AccountAware)) {
                        return invocation.invoke();
                }

                final AccountService service = new AccountService();

                final Map<String, Object> session = invocation.getInvocationContext().getSession();

                final Account account = service.findOrCreateAccount(session);
                session.put("account", account);

                final List<AccountAware> components =
                    new ActionInvocationSelectFilter(invocation).select(AccountAware.class);
                for (AccountAware component : components) {
                        component.setAccount(account);
                }

                return invocation.invoke();
        }

        private boolean not(final boolean expression) {
                return !expression;
        }
}
