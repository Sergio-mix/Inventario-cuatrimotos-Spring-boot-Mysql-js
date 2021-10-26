async function registrarCliente() {
    let nombre = document.getElementById('txtNombre').value;
    let correo = document.getElementById('txtCorreo').value;
    let clave = document.getElementById('txtPassword').value;
    let edad = document.getElementById('txtEdad').value;

    if (nombre !== "" && correo !== "" && clave !== "" && edad !== "") {
        await fetch(ClientSave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: nombre,
                email: correo,
                password: clave,
                age: +edad
            })
        })

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}

