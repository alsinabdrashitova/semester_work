<#import "/spring.ftl" as spring/>
<html>

<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Roboto+Mono:300,400,500">
    <style>
        body {
            padding-top: 50px;
            padding-bottom: 50px;
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="/add">
        <h2 class="form-signin-heading">Добавление волонтерства</h2>

        <label for="name" class="sr-only">Название</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Name" required autofocus>
        <br>
        <label for="about" class="sr-only">Описание</label>
        <input type="text" id="about" name="about" class="form-control" placeholder="Description"  required autofocus>
        <br>
        <div id="checkboxes">
        <#list tags as tag>
            <label>
                <input type="checkbox" name="tag" value="${tag.name}"/>${tag.name}</label>
        </#list>
        </div>

        <div id="rad"
             <#list countries  as country>
            <label>
                <input type="radio" name="countryName" value="${country.countryName}"/>${country.countryName}</label>
             </#list>
         </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button class="btn btn-lg btn-primary btn-block"  type="submit" style="background-color: wheat">Добавить</button>
    </form>
    <br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <form method="get" action="/vol">
        <button class="btn btn-lg btn-primary btn-block"  type="submit" style="background-color: wheat">Назад</button>
    </form>

</div>
</body>
</html>