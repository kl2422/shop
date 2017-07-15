<html>

    <head>
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>UserName</th>
                <th>Gender</th>
            </tr>
            <#list users as user >
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td><#if user.gender == 1>男<#else>女</#if></td>
                </tr>
            </#list>
            <#if paginator.totalPages > 1>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li <#if !paginator.hasPrePage >class="disabled"</#if> >
                            <a href="javascript:goto(${paginator.prePage})" aria-label="Previous" >
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <#list paginator.getSlider() as slider >
                            <li><a href="javascript:goto(${slider})" <#if slider=paginator.page >class="active"</#if> >${slider}</a></li>
                        </#list>

                        <li <#if !paginator.hasNextPage >class="disabled"</#if> >
                            <a href="javascript:goto(${paginator.nextPage})" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </#if>

        </table>
        <script>
            function goto(page) {
                window.location.href = "list?page="
                        + page + "&pageSize=" + ${paginator.limit}
            }

        </script>

    </body>
</html>