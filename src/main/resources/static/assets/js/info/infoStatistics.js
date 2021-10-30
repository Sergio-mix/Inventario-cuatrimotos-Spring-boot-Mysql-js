ini();

async function ini() {
    const json = await obtenerReport_status();
    document.getElementById('tReserasCompletadas').innerHTML = json.completed;
    document.getElementById('tReserasNoCompletadas').innerHTML = json.cancelled;
    topClientes();
}

async function statusDate() {
    let date1 = document.getElementById('txtFechaInicial').value;
    let date2 = document.getElementById('txtFechaFinal').value;

    const reportDate = await obtenerReport_dates(date1, date2);

    document.getElementById('numR').innerHTML = 'Cantidad: ' + reportDate.length;

    if (reportDate.length > 0) {
        let listHtml = '';
        for (let reporte of reportDate) {
            let fila =
                "<tr><td> " + reporte.idReservation + "</td>" +
                "<td>" + reporte.client.idClient + "</td>" +
                "<td> " + reporte.client.name + " </td>" +
                "<td> " + reporte.client.email + " </td>" +
                "</td></tr>";

            listHtml += fila;
        }

        document.querySelector('#tabla-reportes-fecha tbody').outerHTML = listHtml;
    } else {
        document.querySelector('#tabla-reportes-fecha tbody').innerHTML = "";
        document.getElementById('numR').innerHTML = 'No Hay registros en el rango de fechas';
    }
}

async function topClientes() {
    const top = await obtenerReport_clients();
    const numMax = document.getElementById('txtNum').value;

    let aux = 0;
    let listHtml = '';
    for (let client of top) {
        if (aux < numMax) {
            let fila =
                "<tr><td> " + client.client.email + "</td>" +
                "<td>" + client.total + "</td>" +
                "</td></tr>";

            listHtml += fila;
            aux++;
        } else {
            break;
        }
    }

    document.querySelector('#tablaTopClientes tbody').outerHTML = listHtml;
}


function obtenerReport_dates(date1, date2) {
    return new Promise(resolve => {
        return resolve(
            fetch(ReservationReport_dates + date1 + '/' + date2, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

function obtenerReport_status() {
    return new Promise(resolve => {
        return resolve(
            fetch(ReservationReport_status, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

function obtenerReport_clients() {
    return new Promise(resolve => {
        return resolve(
            fetch(ReservationReport_clients, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}