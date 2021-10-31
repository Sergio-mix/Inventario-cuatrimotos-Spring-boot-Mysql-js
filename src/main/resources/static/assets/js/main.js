sessionStorage.clear();

const session = localStorage.getItem('session');

if (session === null) {
    doOpen('html/login/login.html');
}
