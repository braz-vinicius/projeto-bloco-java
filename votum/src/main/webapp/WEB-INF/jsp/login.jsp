<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>

<custom:mainLayout title="Usuário">
    <h3>Login</h3>
        <form action="/login_validate" method="post">
            <div class="form-group">
                <label for="nome">E-mail:</label>
                <input type="text" class="form-control" name="username" id="nome">
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" name="password" id="senha">
            </div>
            <button type="submit" class="btn btn-default">Entrar</button>
        </form>


    <c:if test="${param.error}" >
        <div class="alert alert-danger">
            <strong>Erro!</strong> O usuário e/ou senha fornecidos estão incorretos.
        </div>
    </c:if>
</custom:mainLayout>