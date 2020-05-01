<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        body{
            background: url("https://storge.pic2.me/upload/782/5948f0a59523b.jpg");
        }
        .center {
            margin: auto;
        }
        h1, h2, h3, h4, h5, h6 {
            font-family: 'Montserrat', Arial, sans-serif;
            font-weight:700;
        }
        .subpage-head {
            background-color:#f9f1e6;
            padding-top: 80px;
            padding-bottom: 20px;
        }
        .subpage-head h3 {
            color:#53504c;
        }
        @media (min-width:992px) {
            .subpage-head {
                padding-top: 110px;
            }
        }
    </style>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Roboto+Mono:300,400,500">
</head>
<body>
<div class="subpage-head has-margin-bottom">
    <div class="container">
        <div class="row">
            <div class="col-4">
                <h1 align="center">${elem.name}</h1>
            </div>
            <div class="col-4 offset-4">
                <div class="right">
                    <div id="weather"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<div class="center">

    <div class="container" align="center" >
        <div class="row" ">
            <div class=" col-sm-12 col-md-10 col-lg-8" style="background: wheat" >
                <h2>Description:</h2>
                <p class="mb-0">${elem.about}</p>
                <br>
                <h2>Author:</h2>
                <h2 class="h5 text-black">${elem.author.login}</h2>
                <br>
                <h2>Country:</h2>
                <h2 class="h5 text-black">${elem.country.countryName}</h2>
                <br>
                <h2>Tags:</h2>
                <#list elem.tags as tag>
                <h2 class="h5 text-black">${tag.name}</h2>
                </#list>
            </div>
        </div>
    </div>



<form action="/vol" method="get">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="text-center mt-4" >
        <button type="submit" class="btn btn-primary btn-lg" style="background-color: wheat">Назад</button>
        <span class="help-block loading"></span>
    </div>
</form>
<script>
    $(document).ready(function () {
        $.get(
                "http://api.openweathermap.org/data/2.5/weather",
                {
                    "q":"Kazan",
                    "appid":"56fc6c6cb76c0864b4cd055080568268",
                },

                function (data) {
                    let out = '';
                    out +='Kazan '+'<p style="text-align:center"><img src="https://openweathermap.org/img/w/'+data.weather[0].icon + '.png"></p>';
                    out += 'Погода: <b>'+data.weather[0].main+'</b><br>';
                    out += 'Температура: <b>'+Math.round(data.main.temp-273) + 'C</b><br>';
                    out += 'Влажность: <b>'+data.main.humidity+'%</b><br>';
                    out += 'Видимость: <b>' + (data.visibility/1000)+'км</b><br>';
                    console.log(data.main);
                    $('#weather').html(out);

                }
        );
    })
</script>
</body>
</html>