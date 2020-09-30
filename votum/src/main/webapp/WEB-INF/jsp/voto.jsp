<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>

<custom:mainLayout title="Voto">
    <h3>Voto</h3>
    <form action="/voto" method="post">
        <div class="form-group">
            <label for="proposicao">Proposição:</label>
            <select class="form-control" name="proposicao" id="proposicao">
                <option value="" selected disabled hidden>Selecione</option>
                <c:forEach items="${listaProposicao}" var="item">
                    <option value="${item.id}">${item.nomeProposicao}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="pessoa">Pessoa:</label>
            <select class="form-control" name="pessoa" id="pessoa">
                <option value="" selected disabled hidden>Selecione</option>
                <c:forEach items="${listaPessoa}" var="item">
                    <option value="${item.id}">${item.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="pessoa">Voto:</label>
            <select class="form-control" name="votoValor" id="votoValor">
                <option class="form-control" value="" selected disabled hidden>Selecione</option>
                <c:forEach items="${listaTipoVoto}" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-default">Salvar</button>
    </form>
    <custom:dataTable collection="${lista}" headerLabels="Proposição, Pessoa, Voto">
        <c:forEach var="prop" items="${lista}">
            <tr>
                <td> <c:out value="${prop.proposicao.nomeProposicao}"/> </td>
                <td> <c:out value="${prop.pessoa.nome}"/> </td>
                <td> <c:out value="${prop.votoValor}"/> </td>
            </tr>
        </c:forEach>
    </custom:dataTable>
</custom:mainLayout>
