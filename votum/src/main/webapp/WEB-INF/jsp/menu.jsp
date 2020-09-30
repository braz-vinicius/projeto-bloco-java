<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="nav navbar-nav">
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pessoa
            <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="/pessoa?tipoPessoa=pessoaFisica">Pessoa Física</a></li>
            <li><a href="/pessoa?tipoPessoa=pessoaJuridica">Pessoa Jurídica</a></li>
            <li><a href="/pessoa?tipoPessoa=pessoaPolitica">Pessoa Política</a></li>
        </ul>
    </li>
    <li><a href="/proposicao">Proposição</a></li>
    <li><a href="/usuario">Usuário</a></li>
    <li><a href="/voto">Voto</a></li>
</ul>