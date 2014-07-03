<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-definition>
    <!DOCTYPE html>
    <html>
        <head>
            <title>${app}</title>
            <%-- css --%>
            <link rel="stylesheet" href="${contextPath}/static/css/bootstrap.min.css" type="text/css"/>
            <link rel="stylesheet" href="${contextPath}/static/css/bootstrap-theme.min.css" type="text/css"/>
            <link rel="stylesheet" href="${contextPath}/static/css/main.css" type="text/css"/>
            <%-- additional css  --%>
            <s:layout-component name="css"/>
        </head>
        <body>
            <%-- menu --%>
            <jsp:include page="/WEB-INF/jsp/layout/menu.jsp"/> 
            <%-- content --%>
            <div class="container">
                <s:errors/>
                <s:layout-component name="content">
                    no content
                </s:layout-component>
            </div>
            <%-- scripts --%>
            <script src="${contextPath}/static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
            <script src="${contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
            <%-- menu script --%>
            <script type="text/javascript">
                $(document).ready(function() {
                    $('a[href="' + this.location.pathname + '"]').parent().addClass('active');
                });
            </script>
            <%-- additional scripts  --%>
            <s:layout-component name="script"/>
        </body>
    </html>
</s:layout-definition>