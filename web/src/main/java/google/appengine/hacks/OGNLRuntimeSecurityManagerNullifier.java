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

package google.appengine.hacks;

import ognl.OgnlRuntime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Understands how to work-around shortcomings in Google AppEngine's sandboxed JVM implementation.
 */
public class OGNLRuntimeSecurityManagerNullifier
    implements HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {

        public void attributeAdded(final HttpSessionBindingEvent event) {
        }

        public void attributeRemoved(final HttpSessionBindingEvent event) {
        }

        public void attributeReplaced(final HttpSessionBindingEvent event) {
        }

        public void contextDestroyed(final ServletContextEvent event) {
        }

        public void contextInitialized(final ServletContextEvent event) {
                OgnlRuntime.setSecurityManager(null);
        }

        public void sessionCreated(final HttpSessionEvent event) {
        }

        public void sessionDestroyed(final HttpSessionEvent event) {
        }
}
