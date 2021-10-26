const id = sessionStorage.getItem('idInfoCReservacion');
const idClient = sessionStorage.getItem('idInfoCliente');
cuatrimotos();

async function registrarReserva() {
    let fechaInicio = document.getElementById('txtFechaDeInicio').value;
    let fechaFin = document.getElementById('txtFechaFinal').value;
    let idQuadbike = document.getElementById('txtCuatrimoto').value;

    if (fechaInicio !== "" && fechaFin !== "") {

        const client = {
            idClient: +idClient
        };

        const quadbike = {
            id: +idQuadbike
        };

        await fetch(ReservationSave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                startDate: fechaInicio,
                devolutionDate: fechaFin,
                client: client,
                quadbike: quadbike
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

