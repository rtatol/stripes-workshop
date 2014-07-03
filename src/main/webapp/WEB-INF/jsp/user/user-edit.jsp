<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-render name="/WEB-INF/jsp/layout/layout-definition.jsp">
    <s:layout-component name="script">

    </s:layout-component>

    <s:layout-component name="content">
        <s:form beanclass="com.stripes.workshop.action.UserAction" class="form-horizontal">
            <div class="form-group form-group">
                <s:label for="user.name" class="col-xs-2 control-label"/>
                <div class="col-xs-10">
                    <sd:text name="user.name" class="form-control" maxlength="50"/>
                </div>
            </div>
            <div class="form-group form-group">
                <s:label for="user.dead" class="col-xs-2 control-label"/>
                <div class="col-xs-10">
                    <s:checkbox name="user.dead"/>
                </div>
            </div>
            <s:hidden name="user.id"/>
            <div class="btn-group pull-right">
                <s:link href="/user" event="view" class="btn btn-primary">
                    Cancel
                </s:link>
                <button class="btn btn-primary" type="submit" name="update">Save changes</button>
            </div>
        </s:form>
    </s:layout-component>
</s:layout-render>