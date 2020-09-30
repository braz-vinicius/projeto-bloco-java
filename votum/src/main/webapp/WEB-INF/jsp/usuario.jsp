<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>

<custom:mainLayout title="Usuário">
    <h3>Usuário</h3>
        <form action="/usuario" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" name="nome" id="nome">
            </div>
            <div class="form-group">
                <label for="nome">Foto:</label>
                <input type="file" class="form-control" name="foto" id="foto">
            </div>

            <div class="form-group">
                <label for="cep">CEP:</label>
                <input type="text" class="form-control" name="cep" id="cep">
            </div>
            <div class="form-group">
                <label for="nome">Endereço:</label>
                <input type="text" class="form-control" name="endereco" id="endereco">
            </div>
            <div class="form-group">
                <label for="nome">Número:</label>
                <input type="text" class="form-control" name="numero" id="numero">
            </div>
            <div class="form-group">
                <label for="nome">Complemento:</label>
                <input type="text" class="form-control" name="complemento" id="complemento">
            </div>
            <div class="form-group">
                <label for="email">Login:</label>
                <input type="text" class="form-control" name="email" id="email">
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" name="senha" id="senha">
            </div>
            <button type="submit" class="btn btn-default">Salvar</button>
        </form>
        <custom:dataTable collection="${lista}" headerLabels="Nome, Email">
            <c:forEach var="prop" items="${lista}">
                <tr>
                    <td> <c:out value="${prop.nome}"/> </td>
                    <td> <c:out value="${prop.email}"/> </td>
                </tr>
            </c:forEach>
        </custom:dataTable>
</custom:mainLayout>