const id = sessionStorage.getItem('idActualizarReservacion');

obtener();

async function obtener() {
    const reserva = await obtenerObjetoPorId(id);

    document.getElementById('txtFechaDeInicio').value = reserva.startDate.split('T', 1);
    document.getElementById('txtFechaFinal').value = reserva.devolutionDate.split('T', 1);
    document.getElementById('txtScore').value = reserva.score;
    document.getElementById('txtStatus').value = reserva.status;

    return reserva;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(ReservaId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

async function actualizarReserva() {
    let fechaInicio = document.getElementById('txtFechaDeInicio').value;
    let fechaFin = document.getElementById('txtFechaFinal').value;
    let score = document.getElementById('txtScore').value;
    let status = document.getElementById('txtStatus').value;

    if (score === 'null') {
        score = null;
    }

    if (status === 'null') {
        status = null;
    }
    
    if (fechaInicio !== "" && fechaFin !== "") {
        const reserva = await obtenerObjetoPorId(id);

        const quadbike = {
            id: reserva.quadbike.id
        }

        const client = {
            idClient: reserva.client.idClient
        }

        await fetch(ReservationUpdate, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                idReservation: id,
                startDate: fechaInicio,
                devolutionDate: fechaFin,
                client: client,
                score: score,
                status: status,
                quadbike: quadbike
            })
        });

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}