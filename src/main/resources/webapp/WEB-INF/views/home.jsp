<%@page import="com.jaeverba.jv.controller.Idioma" %>

<%@
        page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<%//@page import="models.Pages" %>

<%@include file="/webapp/constants.jsp" %>

<%!
String cab = "", idioma;
    //Pages page = new Pages("JV - Inicio");
    String idioma_page_title;
%>

<%
    idioma = Idioma.getLang(request, response);
    switch (idioma) {
        case "es":
            idioma_page_title = "JV - Inicio";
            break;

        case "en":
            idioma_page_title = "JV - Home";
            break;
    }
%>



<!DOCTYPE html>

<html id='html' lang="<%=idioma %>" translate="no">
<head>
    <title><%= idioma_page_title %></title>

    <!-- TODO: Metadata -->
    <%//@ include file="WEB-INF/templates/meta.jsp" %>

    <!-- TODO: Favicon -->
    <%//@ include file="WEB-INF/templates/favicon.jsp" %>

    <!-- TODO: Styles -->
    <link rel="stylesheet" href="https://use.typekit.net/yym2vzw.css">
    <link rel="stylesheet" href="<%=cab %>styles.jsp?tipo=general&style=normal">
    <link rel="stylesheet" href="<%=raiz %>/mods/material-components-web/material-components-web.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <script>
        (function(d, w, c) {
            w.SibConversationsID = '6311a0506ffbb956d14e63fa';
            w[c] = w[c] || function() {
                (w[c].q = w[c].q || []).push(arguments);
            };
            var s = d.createElement('script');
            s.async = true;
            s.src = 'https://conversations-widget.sendinblue.com/sib-conversations.js';
            if (d.head) d.head.appendChild(s);
        })(document, window, 'SibConversations');
    </script>
</head>

<body id="body">
<div id="contenedor_principal">
    <div id="contenedor"></div>
</div>


<% //TODO: Scripts %>
<!-- TODO: Scripts -->
<!-- script type="text/javascript" src="<%=raiz %>/node_modules/jquery/dist/jquery.js"></script-->

<script type="importmap">
		{
			"imports": {
				"engine": "<%=raiz %>/src/js/engine.js",
				"jquery": "<%=raiz %>/mods/jquery/dist/jquery.js",
				"vue": "<%=raiz %>/mods/vue/dist/vue.esm-browser.js",
				"MCU": "<%=raiz %>/mods/@material/material-color-utilities/dist/index.js",
				"lottie": "<%=raiz %>/mods/lottie-web/build/player/lottie.js",
				"vue-lottie": "<%=raiz %>/mods/vue-lottie/dist/build.js"
			}
		}
		</script>


<script defer type="module" src="scripts.jsp?app=main"></script>
<script defer nomodule src="no_module.js"></script>
</body>
</html>