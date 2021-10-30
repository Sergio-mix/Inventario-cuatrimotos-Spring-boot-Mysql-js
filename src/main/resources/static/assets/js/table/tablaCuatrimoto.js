llenarTabla();

async function llenarTabla() {
    const request = await fetch(QuadbikeAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const cuatrimotos = await request.json();


    let listHtml = '';
    for (let cuatrimoto of cuatrimotos) {
        let category = cuatrimoto.category;

        if (category === null) {
            category = 'No asignado';
        }else {
            category = cuatrimoto.category.name;
        }
        let fila =
            "<tr></tr><td> " + cuatrimoto.brand + "</td>" +
            "<td>" + cuatrimoto.year + "</td>" +
            "<td> " + category + " </td>" +
            "<td> " + cuatrimoto.name + " </td>" +
            "<td><button style=\"color: #6e51cb\" class=\"btn btn-sm btn-neutral\" onclick='verCuatrimoto(" + cuatrimoto.id + ")'>Info</button>" +
            "<button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarCuatrimoto(" + cuatrimoto.id + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarCuatrimoto(" + cuatrimoto.id + ",this" + ")'>Eliminar</button></td>" +
            "</tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableCuatrimoto tbody').outerHTML = listHtml;
}

async function verCuatrimoto(codigo) {
    sessionStorage.setItem('idInfoCuatrimoto', codigo);
    doOpen("html/info/infoCuatrimoto.html");
}


async function actualizarCuatrimoto(codigo) {
    sessionStorage.setItem('idActualizarCuatrimoto', codigo)
    doOpen("html/update/actualizarCuatrimoto.html");
}

function eliminarCuatrimoto(codigo, btn) {
    fetch(QuadbikeRemove + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: +codigo,
        })
    });

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}