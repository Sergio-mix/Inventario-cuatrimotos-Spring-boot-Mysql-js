llenarTabla();

async function llenarTabla() {
    const request = await fetch(API + '/api/Admin/all', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const administradores = await request.json();

    let listHtml = '';
    for (let administrador of administradores) {
        let fila =
            "<tr><td> " + administrador.id + "</td>" +
            "<td>" + administrador.name + "</td>" +
            "<td> " + administrador.email + " </td>" +
            "<td><button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarAdmin(" + administrador.id + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarAdmin(" + administrador.id + ",this" + ")'>Eliminar</button>" +
            "</td></tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableAdmin tbody').outerHTML = listHtml;
}

async function actualizarAdmin(codigo) {
    sessionStorage.setItem('idActualizarAdmin', codigo)
    doOpen("html/update/actualizarAdmin.html");
}

function eliminarAdmin(codigo, btn) {
    fetch(AdminRemove + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}