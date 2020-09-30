<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>

<custom:mainLayout title="Pessoa Física">
    <h3>Pessoa Física</h3>
    <form action="/pessoa/fisica" method="post">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" name="nome" id="nome">
        </div>
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" name="numeroCpf" id="cpf">
        </div>
        <button type="submit" class="btn btn-default">Salvar</button>
    </form>
    <custom:dataTable collection="${lista}" headerLabels="Nome, ID">
        <c:forEach var="prop" items="${lista}">
            <tr>
                <td> <c:out value="${prop.nome}"/> </td>
                <td> <c:out value="${prop.id}"/> </td>
            </tr>
        </c:forEach>
    </custom:dataTable>
</custom:mainLayout>
