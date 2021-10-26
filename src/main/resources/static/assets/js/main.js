sessionStorage.clear();

localStorage.getItem('session');
const session = localStorage.getItem('session');

if (session === null) {
    doOpen('html/login/login.html');
}

