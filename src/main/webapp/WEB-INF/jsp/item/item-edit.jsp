<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-render name="/WEB-INF/jsp/layout/layout-definition.jsp">
    <s:layout-component name="script">

    </s:layout-component>

    <s:layout-component name="content">
        <s:form beanclass="com.stripes.workshop.action.ItemAction" class="form-horizontal">
            <div class="form-group form-group">
                <s:label for="item.name" class="col-xs-2 control-label"/>
                <div class="col-xs-10">
                    <sd:text name="item.name" class="form-control" maxlength="30"/>
                </div>
            </div>
            <div class="form-group form-group">
                <s:label for="item.price" class="col-xs-2 control-label"/>
                <div class="col-xs-10">
                    <sd:text name="item.price" class="form-control" maxlength="20"/>
                </div>
            </div>
            <div class="form-group form-group">
                <s:label for="item.user" class="col-xs-2 control-label"/>
                <div class="col-xs-10">
                    <s:select name="item.user.id">  
                        <s:option value=""></s:option> 
                        <s:options-collection collection="${actionBean.userList}" label="name" value="id"/>  
                    </s:select>
                </div>
            </div>
            <s:hidden name="item.id"/>
            <div class="btn-group pull-right">
                <s:link href="/item" event="view" class="btn btn-primary">
                    Cancel
                </s:link>
                <button class="btn btn-primary" type="submit" name="update">Save changes</button>
            </div>
        </s:form>
    </s:layout-component>
</s:layout-render>