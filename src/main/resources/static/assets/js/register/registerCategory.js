async function registrarCategoria() {
    let name = document.getElementById('txtNombre').value;
    let descripcion = document.getElementById('txtDescription').value;

    if (name !== "" && descripcion !== "") {
        await fetch(CategorySave, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: name,
                description: descripcion,
            })
        })

        doOpen("../../index.html");
    } else {
        alert('Hay campos vacíos');
    }
}
