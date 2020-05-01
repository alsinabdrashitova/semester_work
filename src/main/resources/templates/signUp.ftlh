<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sign Up</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <#--<link rel="stylesheet" href="<@spring.url '/static/bootstrap.min.css'/>"/>-->
    <#--<link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/church.css'/>"/>-->
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <#--<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700' rel='stylesheet' type='text/css'>-->
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

    <script type="application/javascript" src="/static/js/req.js"></script>
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
                    <a class="nav-link" style="color: midnightblue" href="/signIn">Sign In
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" style="color: midnightblue" href="/signUp">Sign Up</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="subpage-head has-margin-bottom">
    <div class="container">
        <h3>Sign Up</h3>
        <p class="lead">Your personal data</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6 has-margin-bottom">
            <form action="/signUp" method="post" name="signUp" id="signUp" onsubmit="return validation()">
                <div class="form-group">
                    <label>Login</label>
                    <input type="email" class="form-control" name="login" id="login">
                    <span id="checkLogin" aria-required="true"></span>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" id="password">
                    <span id="checkPassword" aria-required="true"></span>
                </div>
                <div class="form-group">
                    <label>Password repeat</label>
                    <input type="password" class="form-control" name="passwordRepeat" id="passwordRepeat">
                    <span id="checkPasswordRepeat" aria-required="true"></span>
                </div>
                <div class="form-group">
                    <label>Sex</label><br>
                    <input name="sex" type="radio" value="female"> <label>Female</label>
                    <input name="sex"  type="radio" value="male"><label>Male</label>
                    <span id="checkSex" aria-required="true"></span>
                </div>

                <div class="form-group">
                    <label>Country:  </label>
                    <select id="country" name="country">
                        <option id="ru">Russia</option>
                        <option id="ger">Germany</option>
                        <option id="usa">USA</option>
                    </select>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                <div class="text-center mt-4" >
                    <button type="submit" class="btn btn-primary btn-lg">Ok</button>
                    <span class="help-block loading"></span>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>



