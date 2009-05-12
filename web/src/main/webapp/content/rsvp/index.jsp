<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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

<html>
<head>
        <title>Your Contact Information</title>
</head>
<body>
<s:form action="create" namespace="/rsvp" method="post">
        <s:textfield name="name" label="Name" size="32"/>
        <s:textfield name="emailAddress" label="Email Address" size="32"/>
        <s:textfield name="street" label="Street" size="32"/>
        <s:textfield name="city" label="City" size="32"/>
        <s:textfield name="state" label="State" size="32"/>
        <s:textfield name="postalCode" label="Postal Code" size="32"/>
        <s:textfield name="country" label="Country" size="32"/>
        <s:submit value="Save"/>
</s:form>
</body>
</html>
