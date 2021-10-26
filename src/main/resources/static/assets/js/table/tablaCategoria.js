llenarTabla();

async function llenarTabla() {
    const request = await fetch(CategoryAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const categorias = await request.json();


    let listHtml = '';
    for (let categoria of categorias) {
        let fila =
            "<tr><td> " + categoria.name + "</td>" +
            "<td>" + categoria.description + "</td>" +
            "<td> <button style=\"color: #343434\" class=\"btn btn-sm btn-neutral\" onclick='cuatrimotosPorCategoria(" + categoria.id + ")'>Cuatrimotos</button>" +
            "<button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarCategoria(" + categoria.id + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarCategoria(" + categoria.id + ",this" + ")'>Eliminar</button></td>" +
            "</tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableCategoria tbody').outerHTML = listHtml;
}


async function cuatrimotosPorCategoria(codigo) {
    sessionStorage.setItem('idInfoCategoria', codigo);
    doOpen("html/info/listaCuatrimotosCategoria.html");
}


async function actualizarCategoria(codigo) {
    sessionStorage.setItem('idActualizarCateria', codigo)
    doOpen("html/update/ActualizarCategoria.html");
}

function eliminarCategoria(codigo, btn) {
    fetch(CategoryRemove + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}