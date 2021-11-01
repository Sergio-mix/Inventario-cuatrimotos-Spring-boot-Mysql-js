user();

function user() {
    return new Promise(resolve => {
        return resolve(
            fetch(User, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                document.getElementById('imageIcon').src = json.image;
                document.getElementById('userName').innerHTML = json.name;

                if (json.name !== null) {
                    if (localStorage.getItem('session') === null) {
                        localStorage.setItem('session', json.name);
                        location.reload();
                    }
                }
            })
        );
    });
}