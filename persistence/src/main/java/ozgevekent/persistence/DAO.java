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

package ozgevekent.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.List;

/**
 * Understands how to interact with persistent datastores.
 *
 * @param <T> type of entities
 */
public class DAO<T> {

        private static final PersistenceManagerFactory PERSISTENCE_MANAGER_FACTORY =
            JDOHelper.getPersistenceManagerFactory("transactions-optional");

        public List<T> findBy(final String jdoql, final Object parameter) {
                final PersistenceManager persistenceManager = PERSISTENCE_MANAGER_FACTORY.getPersistenceManager();
                final Query query = persistenceManager.newQuery(jdoql);
                try {
                        return (List<T>) query.execute(parameter);
                } finally {
                        query.closeAll();
                }
        }

        public T save(final T entity) {
                final PersistenceManager persistenceManager = PERSISTENCE_MANAGER_FACTORY.getPersistenceManager();
                final Transaction transaction = persistenceManager.currentTransaction();

                try {
                        transaction.begin();

                        final T result = persistenceManager.makePersistent(entity);

                        transaction.commit();

                        return result;
                } finally {
                        if (transaction.isActive()) {
                                transaction.rollback();
                        }

                        persistenceManager.close();
                }
        }
}
