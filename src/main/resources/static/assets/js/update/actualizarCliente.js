const id = sessionStorage.getItem('idActualizarCliente');
obtener();

async function obtener() {
    const cliente = await obtenerObjetoPorId(id);

    document.getElementById('txtNombre').value = cliente.name;
    document.getElementById('txtCorreo').value = cliente.email;
    document.getElementById('txtPassword').value = cliente.password;
    document.getElementById('txtEdad').value = cliente.age;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(ClientId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

async function actualizarCliente() {
    let nombre = document.getElementById('txtNombre').value;
    let correo = document.getElementById('txtCorreo').value;
    let clave = document.getElementById('txtPassword').value;
    let edad = document.getElementById('txtEdad').value;

    if (id !== ""
        && nombre !== ""
        && correo !== ""
        && clave !== ""
        && edad !== "") {
        await fetch(ClientUpdate, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                idClient: id,
                name: nombre,
                email: correo,
                password: clave,
                age: +edad
            })
        });
        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}