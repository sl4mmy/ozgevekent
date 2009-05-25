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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html>
<head>
        <title>| Your Contact Information</title>
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript" src="/scripts/person.js"></script>
</head>
<body>
<form id="new_person" name="new_person" action="/person/new" method="post">
        <fieldset>
                <legend><span>/Contact Information</span></legend>
                <ol>
                        <li>
                                <label for="name">Adim <em>()</em>/Name <em>(required)</em></label>
                                <input id="name" name="name" class="text" type="text" size="64"/>
                        </li>
                        <li>
                                <label for="emailAddress"><em>()</em>/Email Address <em>(required)</em></label>
                                <input id="emailAddress" name="emailAddress" class="text" type="text" size="64"/>
                        </li>
                </ol>
        </fieldset>
        <fieldset>
                <legend><span>/Mailing Address</span></legend>
                <ol>
                        <li>
                                <label for="street">Sokak <em>()</em>/Street <em>(required)</em></label>
                                <input id="street" name="street[0]" class="text" type="text" size="64"/>
                                <a href="#street" onclick="add_street(); return false;">/Add another line</a>
                        </li>
                        <li>
                                <label for="city">Kent <em>()</em>/City <em>(required)</em></label>
                                <input id="city" name="city" class="text" type="text" size="64"/>
                        </li>
                        <li>
                                <label for="state"><em>()</em>/State <em>(required)</em></label>
                                <input id="state" name="state" class="text" type="text" size="64"/>
                        </li>
                        <li>
                                <label for="postalCode"><em>()</em>/Postal Code <em>(required)</em></label>
                                <input id="postalCode" name="postalCode" class="text" type="text" size="64"/>
                        </li>
                        <li>
                                <label for="country"><em>()</em>/Country <em>(required)</em></label>
                                <input id="country" name="country" class="text" type="text" size="64"/>
                        </li>
                </ol>
        </fieldset>
        <fieldset class="submit">
                <input class="submit" type="submit" value="/Save"/>
        </fieldset>
</form>
</body>
</html>
