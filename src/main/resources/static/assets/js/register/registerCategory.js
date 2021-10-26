async function registrarCategoria() {
    let name = document.getElementById('txtNombre').value;
    let descripcion = document.getElementById('txtDescription').value;

    if (name !== "" && descripcion !== "") {
        const CategoryName = await validarName(name);
        if (CategoryName.validation === false) {
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
            alert("El nombre ya se encuentra registrado intente con otro nombre")
        }
    } else {
        alert('Hay campos vacíos');
    }
}

function validarName(name) {
    return new Promise(resolve => {
        return resolve(
            fetch(CategoryValid + name, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json()).then(json => {
                return json;
            })
        );
    });
}
