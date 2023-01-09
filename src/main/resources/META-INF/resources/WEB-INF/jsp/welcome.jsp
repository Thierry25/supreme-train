<!DOCTYPE html>
<html lang="en">

<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <h3>Welcome ${name}</h3>
        <p>Your password <strike>${password}</strike> is not really secured though</p>
        <a href="/list-todos">Manage your todos</a>
    </div>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src=" webjars/jquery/3.6.1/jquery.min.js"></script>
</body>

</html>