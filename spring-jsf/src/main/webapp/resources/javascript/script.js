
function validarNombreAplicacion(e) { 
	tecla = (document.all) ? e.keyCode : e.which; 
    if (tecla==8) return true; 
    patron = /[A-Za-zñÑ\s]/; 
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
} 


function cambioColorInText(e) { 
	document.getElementById('itNombreAplicacion').style.borderColor = '#D5D8D9';
}


