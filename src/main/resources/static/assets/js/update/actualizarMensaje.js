const id = sessionStorage.getItem('idActualizarMensaje');
obtener();

async function obtener() {
    const mensaje = await obtenerObjetoPorId(id);

    document.getElementById('txtMensaje').innerText = mensaje.messageText;
}

function obtenerObjetoPorId(id) {
    return new Promise(resolve => {
        return resolve(
            fetch(MessageId + id, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}

async function actualizarMensaje() {
    let mensaje = document.getElementById('txtMensaje').value;

    if (mensaje !== "") {
        const mensajeOb = await obtenerObjetoPorId(id);

        const quadbike = {
            id: mensajeOb.quadbike.id
        }

        const client = {
            idClient: mensajeOb.client.idClient
        }

        await fetch(MessageUpdate, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                idMessage: id,
                quadbike: quadbike,
                client: client,
                messageText: mensaje
            })
        });

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}