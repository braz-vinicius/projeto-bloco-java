<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>

<custom:mainLayout title="Proposição">
    <h3>Proposição</h3>
        <form action="/proposicao" method="post">
            <div class="form-group">
                <label for="proposicao">Proposição:</label>
                <input type="text" class="form-control" name="nomeProposicao" id="proposicao">
            </div>
            <div class="form-group">
                <label for="tema">Tema:</label>
                <input type="text" class="form-control" name="tema" id="tema">
            </div>
            <button type="submit" class="btn btn-default">Salvar</button>
        </form>
        <custom:dataTable collection="${lista}" headerLabels="Tema, Proposição">
            <c:forEach var="prop" items="${lista}">
                <tr>
                    <td> <c:out value="${prop.tema}"/> </td>
                    <td> <c:out value="${prop.nomeProposicao}"/> </td>
                </tr>
            </c:forEach>
        </custom:dataTable>
</custom:mainLayout>
