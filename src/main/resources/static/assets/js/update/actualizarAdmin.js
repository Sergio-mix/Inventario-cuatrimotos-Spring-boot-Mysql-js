const id = sessionStorage.getItem('idActualizarAdmin');
obtener();

async function obtener() {
    const admin = await obtenerObjetoPorId(id);

    document.getElementById('txtNombre').value = admin.name;
    document.getElementById('txtCorreo').value = admin.email;
    document.getElementById('txtPassword').value = admin.password;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(AdminId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

async function actualizarAdmin() {
    let nombre = document.getElementById('txtNombre').value;
    let correo = document.getElementById('txtCorreo').value;
    let clave = document.getElementById('txtPassword').value;

    if (nombre !== "" && correo !== "" && clave !== "") {
        await fetch(Admin, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                name: nombre,
                email: correo,
                password: clave
            })
        });
        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}