sessionStorage.clear();

if(localStorage.getItem('session') === null){
    localStorage.clear();
    doOpen("../../html/login/login.html");
}