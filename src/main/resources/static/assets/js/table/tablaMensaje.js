llenarTabla();

async function llenarTabla() {
    const request = await fetch(MessageAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const mensajes = await request.json();

    let listHtml = '';
    for (let mensaje of mensajes) {
        let fila =
            "<tr><td> " + mensaje.messageText + "</td>" +
            "<td>" +
            "<button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarMensaje(" + mensaje.idMessage + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarMensaje(" + mensaje.idMessage + ",this" + ")'>Eliminar</button>" +
            "</td></tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableMensaje tbody').outerHTML = listHtml;
}

async function actualizarMensaje(codigo) {
    sessionStorage.setItem('idActualizarMensaje', codigo)
    doOpen("html/update/actualizarMensaje.html");
}

function eliminarMensaje(codigo, btn) {
    fetch(MessageRemove + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}