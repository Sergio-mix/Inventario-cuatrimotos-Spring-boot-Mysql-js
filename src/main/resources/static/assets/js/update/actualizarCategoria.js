const id = sessionStorage.getItem('idActualizarCateria');
obtener();

async function obtener() {
    const categoria = await obtenerObjetoPorId(id);

    document.getElementById('txtNombre').value = categoria.name;
    document.getElementById('txtDescription').innerHTML = categoria.description;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(CategoryId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

async function actualizarCategoria() {
    let nombre = document.getElementById('txtNombre').value;
    let descripcion = document.getElementById('txtDescription').value;

    if (nombre !== "" && descripcion !== "") {
        await fetch(CategoryUpdate, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                name: nombre,
                description: descripcion
            })
        });
        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}