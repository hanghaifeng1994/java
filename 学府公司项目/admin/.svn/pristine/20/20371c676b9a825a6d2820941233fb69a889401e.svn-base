function getCookie(name) {
    var reg = RegExp(name + '=([^;]+)');
    var arr = document.cookie.match(reg);
    if (arr) {
        return arr[1];
    } else {
        return '';
    }
};

function delCookie(name) {
    this.setCookie(name, null, -1);
}
function checkLogin(){
    //请求前验证是否登录，后台都要登录才能操作，所以就放这里了
    let isLogin = false;
    let userc = getCookie('ahll_m_user');
    if (userc) {
        isLogin=true;
    }
    if(!isLogin) {
        window.clearInterval(loginCheckI);
        if (confirm("您登录已超时或尚未登录，请重新登录")){
            window.location.href = './login.html';
        }else{
            window.setInterval(checkLogin, 3000);
        }
    }
}
var loginCheckI = window.setInterval(checkLogin, 3000);