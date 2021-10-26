const id = sessionStorage.getItem('idInfoCuatrimoto');
obtener();

async function obtener() {
    const cuatrimoto = await obtenerObjetoPorId(id);

    document.getElementById('txtNameHome').innerText = cuatrimoto.name;
    document.getElementById('txtMarca').value = cuatrimoto.brand;
    document.getElementById('txtModelo').value = cuatrimoto.year;
    document.getElementById('txtCategory').value = cuatrimoto.category.name;
    document.getElementById('txtNombre').value = cuatrimoto.name;

    return cuatrimoto;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(QuadbikeId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}