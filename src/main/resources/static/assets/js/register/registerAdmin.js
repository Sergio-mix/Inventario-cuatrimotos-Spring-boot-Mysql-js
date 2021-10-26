async function registrarAdmin() {
    let nombre = document.getElementById('txtNombre').value;
    let correo = document.getElementById('txtCorreo').value;
    let clave = document.getElementById('txtPassword').value;

    if (nombre !== "" && correo !== "" && clave !== "") {
        await fetch(AdminSave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: nombre,
                email: correo,
                password: clave
            })
        })

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}
