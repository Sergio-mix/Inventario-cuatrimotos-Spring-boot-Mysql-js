const id = sessionStorage.getItem('idInfoCliente');
cuatrimotos();

async function registrarMensaje() {
    let cuatrimoto = document.getElementById('txtCuatrimoto').value;
    let mensage = document.getElementById('txtMensaje').value;

    if (mensage !== "") {

        const client = {
            idClient: +id
        };

        const quadbike = {
            id: +cuatrimoto
        };

        await fetch(MessageSave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                messageText: mensage,
                client: client,
                quadbike: quadbike,

            })
        })

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}

async function cuatrimotos() {
    const request = await fetch(QuadbikeAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const cuatrimotos = await request.json();

    for (let cuatrimoto of cuatrimotos) {
        document.getElementById('txtCuatrimoto').innerHTML +=
            "<option value='" + cuatrimoto.id + "'>" + cuatrimoto.name + "</option>";

    }
}

