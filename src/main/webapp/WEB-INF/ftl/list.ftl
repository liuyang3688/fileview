<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>upFile/调控中心文件</title>
</head>
<body>
<div align="center" style="font-size:18px">${title}&nbsp;</div>
<div align="right" style="padding-right:20px"><a href="${g.base}">返回导航栏  </a></div>
<table border="0px" width="100%">
    <tr bgcolor="#009481">
        <td align="center" style="color:#FFF">文件名</td>
        <td align="center" style="color:#FFF">修改日期</td>
    </tr>
    <#list fileInfoList as fileInfo>
        <tr bgcolor="#CCE0DF">
            <td>
                <a href="${g.base}${fileInfo['filePath']}">${fileInfo['fileName']}</a>
            </td>
            <td>
                ${fileInfo['lastModified']}
            </td>
        </tr>
    </#list>
</table>
</body>
</html>

