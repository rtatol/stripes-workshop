<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-render name="/WEB-INF/jsp/layout/layout-definition.jsp">
    <s:layout-component name="script">
        <script type="text/javascript">
            $(document).ready(function() {
                if (typeof console !== "undefined" && typeof console.log !== "undefined") {
                    console.log('dev');
                }
            });
        </script>
    </s:layout-component>

    <s:layout-component name="content">
        <p>dev</p>
        <div class="row">
            <div class="col-xs-4"> 
                <button class="btn btn-warning">test</button>  
            </div>
        </div>
    </s:layout-component>
</s:layout-render>