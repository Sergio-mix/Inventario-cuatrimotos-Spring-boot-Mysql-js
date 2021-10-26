llenarTabla();

async function llenarTabla() {
    const request = await fetch(ClientAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const clientes = await request.json();

    let listHtml = '';
    for (let cliente of clientes) {
        let fila =
            "<tr><td> " + cliente.name + "</td>" +
            "<td>" + cliente.email + "</td>" +
            "<td> " + cliente.age + " </td>" +
            "<td><button style=\"color: #6e51cb\" class=\"btn btn-sm btn-neutral\" onclick='verCliente(" + cliente.idClient + ")'>Info</button>" +
            "<button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarCliente(" + cliente.idClient + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarCliente(" + cliente.idClient + ",this" + ")'>Eliminar</button>" +
            "</td></tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableCliente tbody').outerHTML = listHtml;
}

async function verCliente(codigo) {
    sessionStorage.setItem('idInfoCliente', codigo);
    doOpen("html/info/infoCliente.html");
}

async function actualizarCliente(codigo) {
    sessionStorage.setItem('idActualizarCliente', codigo)
    doOpen("html/update/actualizarCliente.html");
}

function eliminarCliente(codigo, btn) {
    fetch(ClientRemove + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}