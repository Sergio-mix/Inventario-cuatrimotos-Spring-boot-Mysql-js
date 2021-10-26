const id = sessionStorage.getItem('idInfoCategoria');
obtener();

async function obtener() {
    const categoria = await obtenerObjetoPorId(id);

    document.getElementById('txt').innerText = categoria.name;


    let listHtml = '';
    for (let cuatrimotoCategoria of categoria.quadbikes) {
        let fila =
            "<tr><td> " + cuatrimotoCategoria.brand + "</td>" +
            "<td>" + cuatrimotoCategoria.year + "</td>" +
            "<td>" + cuatrimotoCategoria.name + "</td>" +
            "</tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableCategoriaCuatrimoto tbody').outerHTML = listHtml;
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