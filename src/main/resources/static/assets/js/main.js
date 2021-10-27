sessionStorage.clear();

localStorage.getItem('session');
const session = localStorage.getItem('session');

if (session === null) {
    doOpen('html/login/login.html');
}

async function salir() {
    await fetch(API + "/logout", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
}
