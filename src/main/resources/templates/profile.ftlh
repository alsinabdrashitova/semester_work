<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<#--<link rel="stylesheet" type="text/css" href="<@spring.url '/static/church.css'/>"/>-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

    <style>
        body{
            background: url("https://storge.pic2.me/upload/782/5948f0a59523b.jpg");
        }
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

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active" >
                    <a class="nav-link" style="color: midnightblue" href="/profile">Profile
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: midnightblue" href="/vol">Volunteering</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="subpage-head has-margin-bottom">
</div>
<div class="container" align="center">
    <div class="row">
        <h1>Setting up your profile</h1>
        <div class=" col-sm-12 col-md-10 col-lg-8" style="background: wheat">
            <form method="post" action="/profile">
                <div class="form-group">
                    <label>Login</label>
                    <input type="email" class="form-control" name="login" id="login" value="${user.login}">
                </div>
                <div class="form-group">
                    <label>Country</label>
                    <input type="text" class="form-control" name="country" value="${user.country}">
                </div>
                <div class="form-group">
                    <label>Sex</label><br>
                    <input name="sex" type="text" class="form-control" value="${user.sex}">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="text-center mt-4" >
                    <button type="submit" class="btn btn-primary btn-lg">Save</button>
                    <span class="help-block loading"></span>
                </div>
            </form>
        </div>
    </div>

    </div>
    <br>
    <div class="container" align="center">
        <div class="row">
            <h1>You can change your password</h1>
            <div class=" col-sm-12 col-md-10 col-lg-8" style="background: wheat">
                <form method="post" action="/pass">
                    <div class="form-group">
                        <label>Old Password</label>
                        <input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="Old password">
                    </div>
                    <div class="form-group">
                        <label>New Password</label>
                        <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="New password">
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="text-center mt-4" >
                        <button type="submit" class="btn btn-primary btn-lg">Save</button>
                        <span class="help-block loading"></span>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="text-center mt-4" >
            <button type="submit" class="btn btn-primary btn-lg">Exit</button>
            <span class="help-block loading"></span>
        </div>
    </form>
        <form method="post" action="/deleteUser">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="text-center mt-4" >
            <button type="submit" class="btn btn-primary btn-lg">Delete</button>
            <span class="help-block loading"></span>
        </div>
        </form>
        </div>
    </div>
</div>



</body>
</html>
