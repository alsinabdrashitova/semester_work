<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        h1, h2, h3, h4, h5, h6 {
            font-family: 'Montserrat', Arial, sans-serif;
            font-weight:700;
        }
        .btn {
            font-family: 'Montserrat', Arial, sans-serif;
            font-weight:700;
            text-transform:uppercase;
        }
        .btn-primary {
            color: #483f34;
            background-color: #ffc55f;
            border-color: #e7ad47;
        }
        .btn-primary:hover, .btn-primary:focus, .btn-primary:active, .btn-primary.active, .open>.dropdown-toggle.btn-primary {
            color: #483f34;
            background-color: #fdbf51;
            border-color: #e7ad47;
        }
        .navbar-nav {
            margin: 25px 0;
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
<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item" >
                    <a class="nav-link" style="color: midnightblue" href="/profile">Profile
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" style="color: midnightblue" href="/vol">Vol</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="subpage-head has-margin-bottom">
    <div class="container">
        <h3>Available events</h3>
    </div>
</div>
<br>
<form method="post" action="/vol">
    <div class="site-section">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="post-entry bg-white">
                        <div class="text p-4">
                            <h2 class="h5 text-black"><a href="#">Морские черепахи в Коста-Рике</a></h2>
                            <span class="text-uppercase date d-block mb-3"><small> &bullet; 25 декабря 2019</small></span>
                            <p class="mb-0">Морские черепахи находятся на грани вымирания. Вам предстоит защищать их от хищников, помогать маленьким черепашатам добираться до воды и охранять пляж. В свободное время можно заняться серфингом, посмотреть на водопады, наесться местных фруктов.</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="post-entry bg-white">
                        <div class="text p-4">
                            <h2 class="h5 text-black"><a href="#">Name.</a></h2>
                            <span class="text-uppercase date d-block mb-3"><small> &bullet; 31 декабря 2019</small></span>
                            <p class="mb-0">Волонтерский проект EVS.(European Volunteer Service)</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="post-entry bg-white">
                        <div class="text p-4">
                            <h2 class="h5 text-black"><a href="#">Черепашкииииииииииииии</a></h2>
                            <span class="text-uppercase date d-block mb-3"><small>&bullet; 30 декабря 2019</small></span>
                            <p class="mb-0">bee bee bumblebee</p>
                        </div>
                    </div>
                </div>

                <#list vol as v>
                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="post-entry bg-white">
                        <div class="text p-4">
                          <a href="/vol/${v.id}" > <h2 class="h5 text-black">${v.name}</h2></a>
                            <#--<span class="text-uppercase date d-block mb-3"><small>&bullet; 30 декабря 2019</small></span>-->
                            <p class="mb-0">${v.about}</p>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <form method="post" action="/delete">
                    <div class="text-center">
                        <button type="submit">Delete</button>
                    </div>
                    </form>
                </div>
                </#list>
            <#--<button class="btn btn-primary text-center" >Добавить волонтерство</button>-->
            </div>
        </div>
    </div>
</form>
<div class="container">
    <div class="row">
        <form action="/add" method="get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="text-center mt-4" >
                <button type="submit" class="btn btn-primary btn-lg">Add an event </button>
                <span class="help-block loading"></span>
            </div>
        </form>
    </div>
</div>
</body>
</html>