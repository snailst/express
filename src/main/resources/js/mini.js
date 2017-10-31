/**
 * @author: zhuzhongpei
 * @date: 2017/10/31 上午10:21
 * @description:
 * @version:
 * @change:
 */
(function () {
    var gAjax;
    $(function(){
        $("#query").delegate("input", "focus", function(){
            if($(this).val() == $(this).attr("placeholder")){
                $(this).val("");
            }
        }).delegate("input", "blur", function(){
            if($(this).val() == ""){
                $(this).val($(this).attr("placeholder"));
            }
        });
        $("#query").find("input").each(function(){
            $(this).val($(this).attr("placeholder"));
        });
        $("#queryBtn").click(function(){
            if ($("#kuaidiNum").val() != "" && $("#kuaidiNum").val() != $("#kuaidiNum").attr("placeholder")) {
                $("#query").addClass("result-box");
                auto();
            }else{
                $("#kuaidiNum").addClass("error").focus();
            }
        });
        $("#selectComBtn").click(function(){
            $("#query").addClass("result-box");
            $("#comList").toggle();
        });
        $("#comList").delegate("a", "click", function(){
            $("#comList").hide();
            var companyCode = $(this).attr("data-code");
            if(companyCode != null && companyCode != ""){
                selectCompany($(this).attr("data-code"));
                query();
            }
        });
    });
    function selectCompany(com) {
        $("#kuaidiCom").val(com);
        for (var i in jsoncom.company) {
            if (jsoncom.company[i].code == com) {
                $("#selectComBtn").html(jsoncom.company[i].companyname).show();
                break;
            }
        }
    }

    function auto() {
        $("#resultBox").html("<span class=\"tips\">正在查询，请稍候...</span>").show();
        if(gAjax){
            gAjax.abort();
        }
        gAjax = $.ajax({
            type:"post",
            url:"/autonumber/auto?num=" + $("#kuaidiNum").val(),
            dataType:"json",
            success:function (resultJson) {
                if (resultJson.length > 0) {
                    $("#suggestList").empty();
                    $("#suggestList").append("<span class=\"li-title\">推荐</span>");
                    for(i = 0; i < resultJson.length; i ++){
                        var comCode = resultJson[i].comCode;
                        for(var j in jsoncom.company){
                            if(comCode == jsoncom.company[j].code){
                                $("#suggestList").append("<a data-code=\"" + comCode + "\">" + jsoncom.company[j].shortname + "</a>");
                            }
                        }
                    }
                    selectCompany(resultJson[0].comCode);
                    query();
                } else {
                    $("#resultBox").html("<span class=\"tips\">抱歉，该单号无法识别。</span>").show();
                }
            }
        });
    }

    function query() {
        $("#query").addClass("result-box");
        $("#inputBox").hide();
        $("#resultBox").html("<span class=\"tips\">正在查询，请稍候...</span>").show();
        if(gAjax){
            gAjax.abort();
        }
        code = $("#kuaidiCom").val();
        if(code == "other"){
            $("#selectCom").show();
            $("#selectComBtn").click();
            return false;
        }
        gAjax = $.ajax({
            type:"get",
            url:"/query?type=" + $("#kuaidiCom").val() + "&postid=" + $("#kuaidiNum").val() + "&id=1&valicode=&temp=" + Math.random(),
            dataType:"json",
            success:function (resultJson) {
                if (resultJson.status == 200) {
                    var html = "<ul class=\"result-list\">";
                    var total = resultJson.data.length;
                    var isCheck = resultJson.ischeck;
                    //顺序
                    for (var i = 0; i < total; i ++) {
                        var className = "";
                        var col2 = "";
                        if (i == (total - 1)) {
                            className += "first";
                            col2 = '<span class="col1"><span class="step"><span class="line1">&nbsp;</span><span class="point">&nbsp;</span></span></span>';
                        }else if (i == 0 && isCheck == 0) {
                            className += "last";
                            col2 = '<span class="col1"><span class="step"><span class="line2">&nbsp;</span><span class="point">&nbsp;</span></span></span>';
                        }else if (i == 0 && isCheck == 1) {
                            className += "last finish";
                            col2 = '<span class="col1"><span class="step"><span class="line2">&nbsp;</span><span class="point">&nbsp;</span></span></span>';
                        }else{
                            col2 = '<span class="col1"><span class="step"><span class="line1">&nbsp;</span><span class="line2">&nbsp;</span><span class="point">&nbsp;</span></span></span>';
                        }
                        var context = resultJson.data[i].context;
                        var ftime = resultJson.data[i].ftime;
                        context = getJumpNetContext(context, $("#kuaidiCom").val(), "fonter1");

                        html += '<li class="' + className + '">' + col2 + '<span class="col2"><span>' + ftime + '</span><span>' + context + '</span></span></li>';
                    }
                    html += "</ul>";
                    $("#resultBox").html(html).show();
                } else {
                    $("#resultBox").html("<span class=\"tips\">抱歉，该单号暂无记录，请稍后再试</span>").show();
                }
            }
        });
    }

    //跳转网点处理
    function getJumpNetContext(context, com, flag) {
        var beforeKeyword = "(?:(?!的|员|型|是).|^)";
        var keyword = ".?到达.?|.?问题.?|.?派件.?|.?签收.?|.?疑难.?|.?扫描.?|.?装袋.?|.?装包.?|.?妥投.?|.?操作员.?|.?审核.?|.?备注.?|.?客服.?|.?网点经理.?|.?员工.?|.?门卫.?|.?本人.?|.?草签.?|.?图片.?|.?分拨中心.?";
        var companyNetworkCodes = {
            "shentong": "5",
            "huitongkuaidi": "6",
            "huiqiangkuaidi": "27",
            "tiantian": "7",
            "zhaijisong": "12",
            "quanfengkuaidi": "23",
            "longbanwuliu": "24",
            "guotongkuaidi": "20",
            "kuaijiesudi": "18",
            "debangwuliu": "1",
            "zhongtong": "3",
            "yunda": "2"
        }
        switch (com) {
            case ("shentong"):
            case ("huitongkuaidi"):
            case ("huiqiangkuaidi"):
            case ("tiantian"):
            case ("quanfengkuaidi"):
            case ("longbanwuliu"):
            case ("guotongkuaidi"):
            case ("kuaijiesudi"):
            {
                var pattern = beforeKeyword + "【((?:(?!" + keyword + ")[^\\s\\d【]){2,})】";
                var reg = new RegExp(pattern, "gi");
                context = context.replace(reg, function ($0, $1, $2) {
                    return "【<a href=\"//www.kuaidi100.com/network.jsp?from=" + flag + "&searchText=" + encodeURIComponent($1) + "&company=" + companyNetworkCodes[com] + "\" target=\"_blank\">" + $1 + "</a>】";
                });
                break;
            }
            case ("debangwuliu"):
            case ("zhaijisong"):
            case ("zhongtong"):
            {
                var pattern = beforeKeyword + "\\[((?:(?!" + keyword + ")[^\\s\\d【]){2,})\\]";
                var reg = new RegExp(pattern, "gi");
                context = context.replace(reg, function ($0, $1, $2) {
                    return "[<a href=\"//www.kuaidi100.com/network.jsp?from=" + flag + "&searchText=" + encodeURIComponent($1) + "&company=" + companyNetworkCodes[com] + "\" target=\"_blank\">" + $1 + "</a>]";
                });
                break;
            }
            case ("yunda"):
            {
                var pattern = "((?:(?!" + keyword + ")\\S){2,}):";
                var reg = new RegExp(pattern, "gi");
                context = context.replace(reg, function ($0, $1, $2) {
                    return "<a href=\"//www.kuaidi100.com/network.jsp?from=" + flag + "&searchText=" + encodeURIComponent($1) + "&company=" + companyNetworkCodes[com] + "\" target=\"_blank\">" + $1 + "</a>:";
                });
                break;
            }
        }
        return context;
    }

    function getKeyword(){
        var num = $("#kuaidiNum").val().replace(/\s/g, "");
        gLastNum = num;
        if(gAjaxObject){
            gAjaxObject.abort();
        }
        gAjaxObject = $.ajax({
            type: "post",
            url: "/autonumber/autoComNum?text=" + num,
            dataType:"json",
            success:function(resultJson) {
                gSelectKeywordIndex = -1;
                if(resultJson.auto && resultJson.auto.length > 0){
                    $("#inputBox").show();
                }else{
                    $("#inputBox").hide();
                }
                addSuggestion(resultJson);
            }
        });
    }

    //智能查询建议
    function addSuggestion(resultJson){
        $("#suggestList").empty();
        $("#inputBox").empty();
        var i = 0;
        var num = resultJson.num;
        if(resultJson.auto && resultJson.auto.length > 0){
            $("#suggestList").append("<span class=\"li-title\">推荐</span>");
            for(i = 0; i < resultJson.auto.length; i ++){
                var comCode = resultJson.auto[i].comCode;
                for(var j in jsoncom.company){
                    if(comCode == jsoncom.company[j].code){
                        $("#suggestList").append("<a data-code=\"" + comCode + "\" data-num=\"" + num + "\">" + jsoncom.company[j].shortname + "</a>");
                        if(i <= 2){
                            $("#inputBox").append("<li class=\"selection selection" + i + "\" data-index=\"" + i + "\" data-code=\"" + comCode + "\" data-num=\"" + num + "\">" + num + "&emsp;<b>" + jsoncom.company[j].companyname + "</b></li>");
                        }
                    }
                }
            }
            if(i > 2) i = 3;
        }
        $("#inputBox").append("<li class=\"selection selection" + i + "\" data-index=\"" + i + "\" data-code=\"other\">" + num + "&emsp;<b>其他快递</b></li>");
        $("#inputBox").append("<li class=\"tips_bottom\">由快递100猜测</li>");
    }

    var gAjaxObject;
    var gAjaxTime;
    var gLastNum = "";
    var postid = $("#kuaidiNum");
    var gSelectKeywordIndex = -1;
    var reg = new RegExp("[0-9a-zA-Z]{4,}");
    postid.keyup(function(e) {
        var keycode = e.keyCode ? e.keyCode: e.which;
        //回车查询
        if(keycode != 13){
            var keyword = postid.val();
            if(keyword != ""){
                if(keyword != gLastNum){
                    clearTimeout(gAjaxTime);
                    gAjaxTime = setTimeout(getKeyword, 200);
                }
            }else{
                clearTimeout(gAjaxTime);
                $("#inputBox").hide();
                gSelectKeywordIndex = -1;
            }
        }
    }).keydown(function(e){
        var keycode = e.keyCode ? e.keyCode: e.which;
        var keyword = postid.val();
        //上下选择建议
        if(keycode == 40 && keyword != "" && reg.test(keyword)){
            if($("#inputBox").is(":hidden")){
                $("#inputBox").show();
                $("#inputBox li.selection").removeClass("hover");
            }else{
                if(gSelectKeywordIndex == -1){
                    gSelectKeywordIndex = 0;
                }else if(gSelectKeywordIndex == $("#inputBox li.selection:last").attr("data-index")){
                    gSelectKeywordIndex = 0;
                }else{
                    gSelectKeywordIndex ++;
                }
                $("#inputBox li.selection").removeClass("hover");
                $("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").addClass("hover");
                $("#kuaidiCom").val($("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").attr("data-code"));
                $("#selectComBtn").html($("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").find("b").text()).show();
            }
        }else if(keycode == 38 && keyword != "" && reg.test(keyword)){
            if($("#inputBox").is(":hidden")){
                $("#inputBox").show();
                $("#inputBox li.selection").removeClass("hover");
            }else{
                if(gSelectKeywordIndex == -1){
                    gSelectKeywordIndex = $("#inputBox li.selection:last").attr("data-index");
                }else if(gSelectKeywordIndex == 0){
                    gSelectKeywordIndex = $("#inputBox li.selection:last").attr("data-index");
                }else {
                    gSelectKeywordIndex --;
                }
                $("#inputBox li.selection").removeClass("hover");
                $("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").addClass("hover");
                $("#kuaidiCom").val($("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").attr("data-code"));
                $("#selectComBtn").html($("#inputBox li.selection:eq(" + gSelectKeywordIndex + ")").find("b").text()).show();
            }
        }else if(keycode == 13 && keyword != "" && reg.test(keyword)){
            query();
        }
    }).click(function(e){
        e.stopPropagation();
        var keyword = postid.val();
        if(keyword != "" && reg.test(keyword)){
            $("#inputBox").show();
        }
    });

    $(document).click(function () {
        if (!$("#inputBox").is(":hidden")) {
            $("#inputBox").hide();
        }
    });

    $("#inputBox").delegate("li.selection","mouseenter",function(){
        $("#inputBox li").removeClass("hover");
        $(this).addClass("hover");
        gSelectKeywordIndex = $(this).attr("data-index");
        $("#kuaidiCom").val($(this).attr("data-code"));
        $("#selectComBtn").html($(this).find("b").text()).show();
    }).delegate("li.selection","click",function(){
        query();
    });


})();