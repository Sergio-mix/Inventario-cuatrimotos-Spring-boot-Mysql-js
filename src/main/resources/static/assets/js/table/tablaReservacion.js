llenarTabla();

async function llenarTabla() {
    const request = await fetch(ReservationAll, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const reservations = await request.json();

    let listHtml = '';
    for (let reservation of reservations) {
        let score = reservation.score;

        if (score === null) {
            score = 'No asignado';
        }
        let fila =
            "<tr><td> " + reservation.idReservation + "</td>" +
            "<td>" + reservation.client.idClient + "</td>" +
            "<td> " + reservation.client.name + " </td>" +
            "<td> " + reservation.client.email + " </td>" +
            "<td> " + score + " </td>" +
            "<td> <button style=\"color: #ffd025\" class=\"btn btn-sm btn-neutral\" onclick='actualizarReservacion(" + reservation.idReservation + ")'>Actualizar</button>" +
            "<button style=\"color: #dc4d5c\" class=\"btn btn-sm btn-neutral\" " +
            "onclick='eliminarReservacion(" + reservation.idReservation + ",this" + ")'>Eliminar</button>" +
            "</td></tr>";

        listHtml += fila;
    }

    document.querySelector('#dataTableReservacion tbody').outerHTML = listHtml;
}


async function actualizarReservacion(codigo) {
    sessionStorage.setItem('idActualizarReservacion', codigo)
    doOpen("html/update/ActualizarReservacion.html");
}

function eliminarReservacion(codigo, btn) {
    fetch(Reservation + codigo, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

