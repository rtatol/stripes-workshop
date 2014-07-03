<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>

<s:layout-render name="/WEB-INF/jsp/layout/layout-definition.jsp">
    <s:layout-component name="script">

    </s:layout-component>

    <s:layout-component name="content">
        <div class="row">
            <div class="col-xs-4"> 
                <s:link href="/item" event="add" class="btn btn-primary">
                    Add
                </s:link>
            </div>
        </div>
        <table class="table table-condensed table-hover">
            <thead>
                <tr>
                    <th width="5%"></th>
                    <th width="30%"><s:label for="item.id"/></th>
                    <th width="25%"><s:label for="item.name"/></th>
                    <th width="10%"><s:label for="item.price"/></th>
                    <th width="10%"><s:label for="item.user"/></th>
                    <th width="20%"><s:label for="actions"/></th>
                </tr>
            </thead>
            <c:forEach var="item" items="${actionBean.itemList}" varStatus="status">
                <tr>
                    <td>${status.count}.</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}€</td>
                    <td>${item.user.name}</td>
                    <td>
                        <div class="btn-group">
                            <s:link href="/item" event="edit" class="btn btn-primary btn-xs">
                                <s:param name="item.id" value="${item.id}"/> Edit
                            </s:link>
                            <s:link href="/item" event="delete" class="btn btn-danger btn-xs">
                                <s:param name="item.id" value="${item.id}"/> Delete
                            </s:link>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </s:layout-component>
</s:layout-render>