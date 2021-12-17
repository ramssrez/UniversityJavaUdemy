function validarForm(forma){
    var usuario = forma.usuario;
    var password = forma.password;
    var tecnologias = forma.tecnologia;
    var checkSEleccionado = false;
 
    if(usuario.value === "" || usuario.value === "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    if(password.value === "" || password.value.length < 3){
        alert("Debe proporcionar una contraseña al menos de 3 caracteres");
        password.focus();
        password.select();
        return false;
    }

}

