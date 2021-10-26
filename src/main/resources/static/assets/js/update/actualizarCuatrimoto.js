const id = sessionStorage.getItem('idActualizarCuatrimoto');
categorias();
obtener();

async function obtener() {
    const cuatrimoto = await obtenerObjetoPorId(id);

    document.getElementById('txtMarca').value = cuatrimoto.brand;
    document.getElementById('txtModelo').value = cuatrimoto.year;
    document.getElementById('txtCategiria').selected = cuatrimoto.category;
    document.getElementById('txtNombre').value = cuatrimoto.name;
    document.getElementById('txtDescripcion').value = cuatrimoto.description;

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

async function actualizarCuatrimoto() {
    let brand = document.getElementById('txtMarca').value;
    let model = document.getElementById('txtModelo').value;
    let category_id = document.getElementById('txtCategiria').value;
    let name = document.getElementById('txtNombre').value;
    let description = document.getElementById('txtDescripcion').value;

    if (brand !== ""
        && model !== ""
        && category_id !== ""
        && name !== "") {

        const category = {
            id: category_id
        }

        await fetch(QuadBikeUpdate, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: +id,
                brand: brand,
                year: +model,
                category: category,
                name: name,
                description: description
            })
        });
        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}

async function categorias() {
    const request = await fetch(CategoryAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const categorias = await request.json();

    for (let categoria of categorias) {
        document.getElementById('txtCategiria').innerHTML +=
            "<option value='" + categoria.id + "'>" + categoria.name + "</option>";
    }
}