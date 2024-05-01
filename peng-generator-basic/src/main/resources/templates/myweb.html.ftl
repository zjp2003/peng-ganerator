<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome</h1>

<ul>
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
    <footer>
        ${currentYear} hello !!!
    </footer>
</body>
</html>