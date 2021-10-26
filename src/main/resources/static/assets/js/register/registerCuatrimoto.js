categorias();

async function registrarCuatrimoto() {
    let brand = document.getElementById('txtMarca').value;
    let model = document.getElementById('txtModelo').value;
    let category_id = document.getElementById('txtCategiria').value;
    let name = document.getElementById('txtNombre').value;
    let description = document.getElementById('txtDescripcion').value;

    if (brand !== "" && model !== "" && category_id !== "" && name !== "") {

        const category = {
            id: +category_id
        };

        await fetch(QuadbikeSave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                brand: brand,
                year: +model,
                category: category,
                name: name,
                description: description
            })
        })

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

