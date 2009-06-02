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

package ozgevekent.utilities;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.LinkedList;
import java.util.List;

/**
 * Understands how to match components which are instances of the same type.
 *
 * @param <T> the type of components to select
 */
public class ActionInvocationSelectFilter<T> {

        private final Object action;

        private final List<InterceptorMapping> interceptors;

        public ActionInvocationSelectFilter(final ActionInvocation invocation) {
                this.action = invocation.getAction();
                this.interceptors = invocation.getProxy().getConfig().getInterceptors();
        }

        public List<T> select(final Class<T> type) {
                final List<T> components = new LinkedList<T>();
                if (type.isAssignableFrom(action.getClass())) {
                        components.add((T) action);
                }
                for (InterceptorMapping interceptorMapping : interceptors) {
                        final Interceptor interceptor = interceptorMapping.getInterceptor();
                        if (type.isAssignableFrom(interceptor.getClass())) {
                                components.add((T) interceptor);
                        }
                }
                return components;
        }
}
