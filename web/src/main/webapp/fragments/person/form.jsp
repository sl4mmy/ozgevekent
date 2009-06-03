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

<%@ taglib prefix="s" uri="/struts-tags" %>

<form id="new_person" name="new_person" action="/person/new" method="post">
        <fieldset>
                <legend><span>/Contact Information</span></legend>
                <ol>
                        <li>
                                <label for="name">Adim <em>()</em>/Name <em>(required)</em>
                                        <s:iterator value="fieldErrors['name']">
                                                <s:iterator>
                                                        <strong><s:property/></strong>
                                                </s:iterator>
                                        </s:iterator>
                                </label>
                                <input id="name" name="name" class="text" type="text" size="64"
                                       value="<s:property value="name"/>"/>
                        </li>
                        <li>
                                <label for="emailAddress"><em>()</em>/Email Address <em>(required)</em>
                                        <s:iterator value="fieldErrors['emailAddress']">
                                                <s:iterator>
                                                        <strong><s:property/></strong>
                                                </s:iterator>
                                        </s:iterator>
                                </label>
                                <input id="emailAddress" name="emailAddress" class="text" type="text" size="64"
                                       value="<s:property value="emailAddress"/>"/>
                        </li>
                </ol>
        </fieldset>
        <fieldset>
                <legend><span>/Mailing Address</span></legend>
                <ol>
                        <li>
                                <label for="street_0">Sokak/Street</label>
                                <s:if test="street.size > 0">
                                        <s:iterator value="street" status="current">
                                                <input id="street_<s:property value="#current.index"/>"
                                                       name="street[<s:property value="#current.index"/>]"
                                                       class="text" type="text" size="64" value="<s:property/>"/>
                                                <s:if test="#current.index == 0">
                                                        <a href="#street" onclick="add_street(); return false;">/Add
                                                                another line</a>
                                                </s:if>
                                                <s:else>
                                                        <a href="#street" onclick="remove_line(this); return false;">/Remove
                                                                this line</a>
                                                </s:else>
                                        </s:iterator>
                                </s:if>
                                <s:else>
                                        <input id="street_0" name="street[0]" class="text" type="text" size="64"/>
                                        <a href="#street" onclick="add_street(); return false;">/Add another line</a>
                                </s:else>
                        </li>
                        <li>
                                <label for="city">Kent/City</label>
                                <input id="city" name="city" class="text" type="text" size="64"
                                       value="<s:property value="city"/>"/>
                        </li>
                        <li>
                                <label for="state">/State</label>
                                <input id="state" name="state" class="text" type="text" size="64"
                                       value="<s:property value="state"/>"/>
                        </li>
                        <li>
                                <label for="postalCode">/Postal Code</label>
                                <input id="postalCode" name="postalCode" class="text" type="text" size="64"
                                       value="<s:property value="postalCode"/>"/>
                        </li>
                        <li>
                                <label for="country">/Country</label>
                                <input id="country" name="country" class="text" type="text" size="64"
                                       value="<s:property value="country"/>"/>
                        </li>
                </ol>
        </fieldset>
        <fieldset class="submit">
                <input class="submit" type="submit" value="/Save"/>
        </fieldset>
</form>
