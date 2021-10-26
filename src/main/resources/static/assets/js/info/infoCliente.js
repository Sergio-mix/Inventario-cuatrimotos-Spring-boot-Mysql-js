const id = sessionStorage.getItem('idInfoCliente');
obtener();

async function obtener() {
    const cliente = await obtenerObjetoPorId(id);

    document.getElementById('txtNameHome').innerText = cliente.name;

    document.getElementById('txtNombre').value = cliente.name;
    document.getElementById('txtEmail').value = cliente.email;
    document.getElementById('txtEdad').value = cliente.age;

    return cliente;
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