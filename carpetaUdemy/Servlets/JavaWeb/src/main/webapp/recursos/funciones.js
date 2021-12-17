function validarForm(forma) {
    var usuario = forma.usuario;
    var password = forma.password;
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    var generos = forma.genero;
    var radioSeleccionado = false;
    var ocupacion = forma.ocupacion;

    if (usuario.value === "" || usuario.value === "Escribir usuario") {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    if (password.value === "" || password.value.length < 3) {
        alert("Debe proporcionar una contraseña al menos de 3 caracteres");
        password.focus();
        password.select();
        return false;
    }

    for (var i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkSeleccionado = true;
        }
    }

    if (!checkSeleccionado) {
        alert("Debe seleccionar una tecnología")
        return false;
    }

    for (var i = 0; i < generos.length; i++) {
        if (generos[i].checked) {
            radioSeleccionado = true;
        }
    }
    
    if (!radioSeleccionado) {
        alert("Dede seleccionar un genero");
        return false;
    }
    
    if(ocupacion.value === ""){
        alert("Debe seleccionar una ocupación");
        return false;
    }
    //Hasta este punto es un formulario valido
    alert("Formulario valido, enviado datos al servidor");
    return true;
}

