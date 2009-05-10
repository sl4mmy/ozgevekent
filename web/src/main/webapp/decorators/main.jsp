<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="application/xhtml+xml;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html version="-//W3C//DTD XHTML 1.1//EN"
      xmlns="http://www.w3.org/1999/xhtml" xml:lang="en"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/1999/xhtml
                          http://www.w3.org/MarkUp/SCHEMA/xhtml11.xsd"
    >
<head>
        <link rel="stylesheet" type="text/css" href="/styles/main.css"/>
        <title><decorator:title default="Ozge ve Kent"/></title>
        <decorator:head/>
</head>
<body>
<div class="wrapper">
        <div class="content">
                <decorator:body/>
        </div>

        <div class="push"></div>
</div>
<div class="footer">
        <p class="copyright">Copyright (c) 2009</p>
</div>
</body>
</html>