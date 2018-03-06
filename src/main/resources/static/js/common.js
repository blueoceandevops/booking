//点击后异步加载标题、内容和时间
function showDetail(id) {
    $.get("/summary/text/id/" + id, function (data) {
            $("#title").text(data.title);
            $("#content").html(data.content);
            $("#id").text(data.id);
        }
    )
}

$(document).ready(
    function () {
        var id = $("tbody tr:first").attr("id");
        showDetail(id);
    }
)


function filter(currentUrl, field, value) {
    //var currentUrl = location.href
    var urlLength = currentUrl.length
    var questionIndex = currentUrl.indexOf("?")
    var poundIndex = currentUrl.indexOf("#")
    var fieldIndex = currentUrl.indexOf(field)

    var newUrl
    var newFilter = field + "=" + value

    //条件不存在时
    if (fieldIndex == -1) {
        //无条件
        if (questionIndex == -1) {
            //无锚点时
            if (poundIndex == -1) {
                newUrl = currentUrl + "?" + newFilter
            }
            //有锚点时
            else {
                newUrl = currentUrl.substring(0, poundIndex) + "?" + newFilter + currentUrl.substring(poundIndex)
            }
        }
        //有条件时
        else {
            newUrl = currentUrl.substring(0, questionIndex + 1) + newFilter + "&" + currentUrl.substring(questionIndex + 1)
        }
    }
    //条件存在时
    else {
        var startIndex = currentUrl.indexOf("=", fieldIndex) + 1
        var andIndex = currentUrl.indexOf("&", fieldIndex)
        var endIndex

        //有后续条件
        if (andIndex != -1) {
            endIndex = andIndex
        }
        //无后续条件
        else {
            //无锚点
            if (poundIndex == -1) {
                endIndex = urlLength
            }
            //有锚点
            else {
                endIndex = poundIndex
            }
        }

        newUrl = currentUrl.substring(0, startIndex) + value + currentUrl.substring(endIndex)
    }

    return newUrl
    //location.href = newUrl;
}