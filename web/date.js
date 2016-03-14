/**
 *日期构建函数
 */
function rebuildDay() {
    var year = Number(document.getElementById("yearSelect").value);//计算选择的年
    var month = Number(document.getElementById("monthSelect").value);//计算选择的月份
    var day = 31;
    if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
        day = day - 1;
    }
    if (month == 2) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )) {
            day = 29;
        } else {
            day = 28;
        }
    }
    document.getElementById("daySelect").innerHTML = buildHtml(day);
}
function buildHtml(day) {
    var html;
    for (var i = 1; i <= day; i++) {
        if (i < 10)
            html += "<option value='" +"0"+ i + "'>" + i + "</option>";
        else
            html += "<option value='" + i + "'>" + i + "</option>";
    }
    return html;
}