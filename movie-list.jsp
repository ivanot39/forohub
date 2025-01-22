<!DOCTYPE html>
<html>
<head>
    <title>Lista de Películas</title>
</head>
<body>
    <h1>Lista de Películas</h1>
    <ul>
        <c:forEach items="${movies}" var="movie">
            <li><a href="/movies/${movie.id}">${movie.title}</a></li>
        </c:forEach>
    </ul>

    <form action="/movies/add" method="post">
        <input type="text" name="title" placeholder="Título">
        <input type="text" name="director" placeholder="Director">
        <input type="number" name="year" placeholder="Año">
        <button type="submit">Añadir Película</button>
    </form>
</body>
</html>
