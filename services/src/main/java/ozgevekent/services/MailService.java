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

import ozgevekent.domain.Person;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Understands how to notify the administrators of significant site activity.
 */
public class MailService {

        private static final String ADMIN_EMAIL = System.getProperty("admin.email");

        public void sendNewPersonMail(final Person person) {
                final Properties props = new Properties();
                final Session session = Session.getDefaultInstance(props, null);

                final String msgBody =
                    "Merhaba!\n\nLook who else just created their profile:\n\n" + person + "\n\nLove,\nKent";

                try {
                        Message msg = new MimeMessage(session);
                        msg.setFrom(new InternetAddress(ADMIN_EMAIL));
                        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(ADMIN_EMAIL));
                        msg.setSubject("Somebody created a profile");
                        msg.setText(msgBody);
                        Transport.send(msg);
                } catch (AddressException e) {
                        e.printStackTrace();
                } catch (MessagingException e) {
                        e.printStackTrace();
                }
        }
}
