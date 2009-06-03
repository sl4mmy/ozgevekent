<%--
  Copyright (c) 2009, Kent R. Spillner <kspillner@acm.org>

  Permission to use, copy, modify, and/or distribute this software for any
  purpose with or without fee is hereby granted, provided that the above
  copyright notice and this permission notice appear in all copies.

  THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
  WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
  MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
  ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
  WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
  ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
  OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
--%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<s:if test="loggedIn">
        Merhaba, <s:property value="nickname"/>! | <a href="/person">Edit profile</a> |
        <a href="<s:property value="logoutURL"/>">Logout</a>
</s:if>
<s:else>
        <a href="<s:property value="loginURL"/>">Login</a> | <a href="/person">Create profile</a>
</s:else>