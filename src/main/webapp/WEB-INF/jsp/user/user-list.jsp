<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-render name="/WEB-INF/jsp/layout/layout-definition.jsp">
    <s:layout-component name="script">

    </s:layout-component>

    <s:layout-component name="content">
        <div class="row">
            <div class="col-xs-4"> 
                <s:link href="/user" event="add" class="btn btn-primary">
                    Add
                </s:link>
            </div>
        </div>
        <table class="table table-condensed table-hover">
            <thead>
                <tr>
                    <th width="5%"></th>
                    <th width="30%"><s:label for="user.id"/></th>
                    <th width="35%"><s:label for="user.name"/></th>
                    <th width="10%"><s:label for="user.dead"/></th>
                    <th width="20%"><s:label for="actions"/></th>
                </tr>
            </thead>
            <c:forEach var="user" items="${actionBean.userList}" varStatus="status">
                <tr>
                    <td>${status.count}.</td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.dead}</td>
                    <td>
                        <div class="btn-group">
                            <s:link href="/user" event="edit" class="btn btn-primary btn-xs">
                                <s:param name="user.id" value="${user.id}"/> Edit
                            </s:link>
                            <s:link href="/user" event="delete" class="btn btn-danger btn-xs">
                                <s:param name="user.id" value="${user.id}"/> Delete
                            </s:link>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </s:layout-component>
</s:layout-render>