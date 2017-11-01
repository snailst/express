/**
 * @author: zhuzhongpei
 * @date: 2017/11/1 下午3:10
 * @description:
 * @version:
 * @change:
 */
var CreatedOKLodop7766=null;

//====判断是否需要安装CLodop云打印服务器:====
function needCLodop(){
    try{
        var ua=navigator.userAgent;
        if (ua.match(/Windows\sPhone/i) !=null) return true;
        if (ua.match(/iPhone|iPod/i) != null) return true;
        if (ua.match(/Android/i) != null) return true;
        if (ua.match(/Edge\D?\d+/i) != null) return true;
        if (ua.match(/QQBrowser/i) != null) return false;
        var verTrident=ua.match(/Trident\D?\d+/i);
        var verIE=ua.match(/MSIE\D?\d+/i);
        var verOPR=ua.match(/OPR\D?\d+/i);
        var verFF=ua.match(/Firefox\D?\d+/i);
        var x64=ua.match(/x64/i);
        if ((verTrident==null)&&(verIE==null)&&(x64!==null))
            return true; else
        if ( verFF !== null) {
            verFF = verFF[0].match(/\d+/);
            if ( verFF[0] >= 42 ) return true;
        } else
        if ( verOPR !== null) {
            verOPR = verOPR[0].match(/\d+/);
            if ( verOPR[0] >= 32 ) return true;
        } else
        if ((verTrident==null)&&(verIE==null)) {
            var verChrome=ua.match(/Chrome\D?\d+/i);
            if ( verChrome !== null ) {
                verChrome = verChrome[0].match(/\d+/);
                if (verChrome[0]>=42) return true;
            };
        };
        return false;
    } catch(err) {return true;};
};

//====页面引用CLodop云打印必须的JS文件：====
if (needCLodop()) {
    var head = document.head || document.getElementsByTagName("head")[0] || document.documentElement;
    oscript = document.createElement("script");
    oscript.src ="http://localhost:8000/CLodopfuncs.js?priority=1";
    head.insertBefore( oscript,head.firstChild );
};

//====获取LODOP对象的主过程：====
function getLodop(oOBJECT,oEMBED){
    var strHtmInstall="<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
    var strHtmUpdate="<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行升级</a>,升级后请重新进入。</font>";
    var strHtm64_Install="<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
    var strHtm64_Update="<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行升级</a>,升级后请重新进入。</font>";
    var strHtmFireFox="<br><br><font color='#FF00FF'>（注意：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它）点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行安装</a></font>";
    var strHtmChrome="<br><br><font color='#FF00FF'>(如果此前正常，仅因浏览器升级或重安装而出问题，需重新执行以上安装）点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip'>执行安装</a></font>";
    var strCLodopInstall="<br><font color='#FF00FF'>CLodop云打印服务(localhost本地)未安装启动!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip'>执行安装</a>,安装后请刷新页面。</font>";
    var strCLodopUpdate="<br><font color='#FF00FF'>CLodop云打印服务需升级!点击这里<a href='http://www.lodop.net/demolist/CLodopPrint_Setup_for_Win32NT.zip' target='_self'>执行升级</a>,升级后请刷新页面。</font>";
    var LODOP;
    try{
        var isIE = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
        if (needCLodop()) {
            try{ LODOP=getCLodop();} catch(err) {};
            if (!LODOP && document.readyState!=="complete") {alert("C-Lodop没准备好，请稍后再试！"); return;};
            if (!LODOP) {
                if (isIE) document.write(strCLodopInstall); else
                    document.documentElement.innerHTML=strCLodopInstall+document.documentElement.innerHTML;
                return;
            } else {

                if (CLODOP.CVERSION<"2.0.4.7") {
                    if (isIE) document.write(strCLodopUpdate); else
                        document.documentElement.innerHTML=strCLodopUpdate+document.documentElement.innerHTML;
                };
                if (oEMBED && oEMBED.parentNode) oEMBED.parentNode.removeChild(oEMBED);
                if (oOBJECT && oOBJECT.parentNode) oOBJECT.parentNode.removeChild(oOBJECT);
            };
        } else {
            var is64IE  = isIE && (navigator.userAgent.indexOf('x64')>=0);
            //=====如果页面有Lodop就直接使用，没有则新建:==========
            if (oOBJECT!=undefined || oEMBED!=undefined) {
                if (isIE) LODOP=oOBJECT; else  LODOP=oEMBED;
            } else if (CreatedOKLodop7766==null){
                LODOP=document.createElement("object");
                LODOP.setAttribute("width",0);
                LODOP.setAttribute("height",0);
                LODOP.setAttribute("style","position:absolute;left:0px;top:-100px;width:0px;height:0px;");
                if (isIE) LODOP.setAttribute("classid","clsid:2105C259-1E0C-4534-8141-A753534CB4CA");
                else LODOP.setAttribute("type","application/x-print-lodop");
                document.documentElement.appendChild(LODOP);
                CreatedOKLodop7766=LODOP;
            } else LODOP=CreatedOKLodop7766;
            //=====Lodop插件未安装时提示下载地址:==========
            if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
                if (navigator.userAgent.indexOf('Chrome')>=0)
                    document.documentElement.innerHTML=strHtmChrome+document.documentElement.innerHTML;
                if (navigator.userAgent.indexOf('Firefox')>=0)
                    document.documentElement.innerHTML=strHtmFireFox+document.documentElement.innerHTML;
                if (is64IE) document.write(strHtm64_Install); else
                if (isIE)   document.write(strHtmInstall);    else
                    document.documentElement.innerHTML=strHtmInstall+document.documentElement.innerHTML;
                return LODOP;
            };
        };
        if (LODOP.VERSION<"6.2.0.3") {
            if (needCLodop())
                document.documentElement.innerHTML=strCLodopUpdate+document.documentElement.innerHTML; else
            if (is64IE) document.write(strHtm64_Update); else
            if (isIE) document.write(strHtmUpdate); else
                document.documentElement.innerHTML=strHtmUpdate+document.documentElement.innerHTML;
            return LODOP;
        };
        //===如下空白位置适合调用统一功能(如注册语句、语言选择等):===

        //===========================================================
        return LODOP;
    } catch(err) {alert("getLodop出错:"+err);};
};
/**
 * 圆通快递单模板
 * @param o
 */
function getYuantongTpl(o){
    LODOP.NewPage();
    // 快递单号
    LODOP.ADD_PRINT_TEXT(0.5*32, 1.5*32, 10*32, 0.5*32, o.express_code);
    // 寄件人姓名
    LODOP.ADD_PRINT_TEXT(2.8*32,3*32,3*32,0.5*32, o.agent_name);
    // 始发地
    LODOP.ADD_PRINT_TEXT(2.8*32,6.8*32,4*32,0.5*32,"单县龙王庙镇");
    // 寄件人地址
    LODOP.ADD_PRINT_TEXT(4*32,3*32,7*32,1.5*32,"山东省菏泽市单县龙王庙镇");
    // 电话
    LODOP.ADD_PRINT_TEXT(5.7*32,4*32,4*32,0.5*32, o.agent_mobile_number);
    // 内件品名
    LODOP.ADD_PRINT_TEXT(7.1*35,2.8*32,5*32,1*32,""+(o.goods_name)+"("+ o.goods_num+")");
    // 备注
    LODOP.ADD_PRINT_TEXT(8.5*32, 2.8*32, 10*35, 4*32,"("+ o.remarks+")");
    // 收件人姓名
    LODOP.ADD_PRINT_TEXT(3*32,12.5*35,5*32,0.5*32,""+(o.customer_name)+"");
    // 电话
    LODOP.ADD_PRINT_TEXT(5.7*32,13.7*35,4*32,0.5*32,""+(o.mobile_number)+"");
    // 收件人地址
    LODOP.ADD_PRINT_TEXT(4.1*32, 12.5*35, 10*32, 2*32,""+o.address+"");
}
/**
 * 中通快递单模板
 * @param o
 */
function getZhongtongTpl(o){
    LODOP.NewPage();
    // 快递单号
    LODOP.ADD_PRINT_TEXT(0.5*32, 1.5*32, 10*32, 0.5*32, o.express_code);
    /** 寄件人信息 **/
    // 寄件人姓名
    LODOP.ADD_PRINT_TEXT(3*32,3.3*32,3*32,0.5*32, o.agent_name);
    // 始发地
    LODOP.ADD_PRINT_TEXT(3*32,7.3*32,4*32,0.5*32, '单县龙王庙镇');
    // 寄件人地址
    LODOP.ADD_PRINT_TEXT(3.8*32,3.4*32,7.5*32,1.5*32, '山东省菏泽市单县龙王庙镇');
    // 寄件人电话
    LODOP.ADD_PRINT_TEXT(6*32,3.3*32,7*32,0.5*32, o.agent_mobile_number);
    // 内件品名
    LODOP.ADD_PRINT_TEXT(6.7*35,2.2*32,4*32,1*32, ""+(o.goods_name)+"("+ o.goods_num+")");

    /** 收件人信息 **/
    // 收件人姓名
    LODOP.ADD_PRINT_TEXT(3*32,12.5*35,3*32,0.5*32, ""+(o.customer_name)+"");
    // 收件人电话
    LODOP.ADD_PRINT_TEXT(6*32,12.6*35,7*32,0.5*32, ""+(o.mobile_number)+"");
    // 收件人地址
    LODOP.ADD_PRINT_TEXT(3.8*32, 12.5*35, 7.5*32, 1.5*32, ""+(o.address)+"");
}
/**
 * 邮政快递单模板
 * @param o
 */
function getYouzhengTpl(o){
    LODOP.NewPage();
    // 快递单号
    LODOP.ADD_PRINT_TEXT(0.5*32, 1.5*34, 10*34, 0.5*34, o.express_code);
    LODOP.ADD_PRINT_TEXT(1*32, 1.5*34, 10*34, 0.5*34, o.create_at);
    // 寄件人姓名
    LODOP.ADD_PRINT_TEXT(2.6*34, 3*34, 3*34, 0.5*34, o.agent_name);
    // 电话
    LODOP.ADD_PRINT_TEXT(2.6*34, 7.1*34, 4*34, 0.5*34, o.agent_mobile_number);
    // 寄件人地址
    LODOP.ADD_PRINT_TEXT(3.9*34, 3*34, 9*34, 0.5*34, "山东省菏泽市单县龙王庙镇");
    // 内件品名
    LODOP.ADD_PRINT_TEXT(10.5*33, 2*34, 10*34, 0.5*34, ""+(o.goods_name)+"("+ o.goods_num+")");
    // 备注
    LODOP.ADD_PRINT_TEXT(11*33, 2*34, 10*34, 3*34,"("+ o.remarks+")");
    // 收件人姓名
    LODOP.ADD_PRINT_TEXT(5.8*34, 3*34, 3*34, 0.5*34, ""+(o.customer_name)+"");
    // 电话
    LODOP.ADD_PRINT_TEXT(5.5*34, 7.1*34, 4.5*34, 0.5*34,""+(o.mobile_number)+"");
    // 收件人地址
    LODOP.ADD_PRINT_TEXT(6.8*34, 3*34, 9*34, 1*34   ,""+(o.address)+"");
}