var ID_PERFIL_ADMINISTRADOR = 1;
var ID_PERFIL_TELEMARKETING = 2;
var ID_PERFIL_CONSULTA = 3;

function limpiarFormulario(panel) {
	$('#' + panel + ' input').attr('value', '');
	$('#' + panel + ' textarea').attr('value', '');
	$('#' + panel + ' select :selected').removeAttr('selected');
	$('#' + panel + ' select option').filter(function() {
		return $(this).text() == 'Seleccione';
	}).attr('selected', true);
	$('#' + panel + ' .ui-selectonemenu label').text('Seleccione');
}
function limpiarFormularioSoloInput(panel) {
	$('#' + panel + ' input').attr('value', '');
}

function ocultarDialogSiOperacionEsCorrecta(xhr, status, args, widgetVar) {
	if (args.ocurrioError || args.validationFailed) {
		widgetVar.show();
	} else {
		widgetVar.hide();
	}
}

function consultarOperacionCorrecta(xhr, status, args, widgetVarDl, widgetVarTb) {
	if (typeof args.ocurrioError != 'undefined') {
		if (!args.ocurrioError) {
			widgetVarDl.hide();
			widgetVarTb.getPaginator().setPage(0);
		} 
	}
}

function mostrarDialogExisteCita(xhr, status, args, widgetVar) {
	if (args.existeCita) {
		widgetVar.show();
	}
}


function mostrarDialogHorarioAsesor(xhr, status, args, widgetVarHoAsesor, widgetVarMensaje ) {
	if (args.mostrarHoAsesor) {
		widgetVarHoAsesor.show();
	} 
//	else {
//		widgetVarMensaje.show();
//	}
}

function mostrarDialogHorarioAsesorCita(xhr, status, args, widgetVarHoAsesor, widgetVarMensaje ) {
	if (args.mostrarHoAsesor) {
		widgetVarHoAsesor.show();
	} 
}

function ocultarListados(xhr, status, args, idPanelAdministrador,
		idPanelTlemarketing, idPanelUsuariosConsulta) {
	if (args.idPerfil == ID_PERFIL_ADMINISTRADOR) {
		$('#' + idPanelAdministrador).css('display', 'block');
		$('#' + idPanelTlemarketing).css('display', 'none');
		$('#' + idPanelUsuariosConsulta).css('display', 'none');
	} else {
		if (args.idPerfil == ID_PERFIL_TELEMARKETING) {
			$('#' + idPanelAdministrador).css('display', 'none');
			$('#' + idPanelTlemarketing).css('display', 'block');
			$('#' + idPanelUsuariosConsulta).css('display', 'none');
		} else {
			$('#' + idPanelUsuariosConsulta).css('display', 'block');
			$('#' + idPanelAdministrador).css('display', 'none');
			$('#' + idPanelTlemarketing).css('display', 'none');
		}
	}

}

function validarFechasDisponibles(id, date){
	var result = false;
	var diaSemana = date.getDay();
	var diaMes = date.getDate();
	var mes = (date.getMonth() + 1);
	var anio = date.getFullYear();

	var domingo = 0;
	var sabado = 6;
	var fechaCalendarioEval = ((diaMes < 10) ? "0" + diaMes : diaMes) + "/"
			+ ((mes < 10) ? "0" + mes : mes) + "/" + anio;

	var arrayFechasDisponibles = (document
			.getElementById(id).value)
			.split(",");

	for ( var i = 0; i < arrayFechasDisponibles.length - 1; i++) {

		var fechaDisponible = arrayFechasDisponibles[i];
		if (fechaCalendarioEval == fechaDisponible) {
			result = true;
			break;
		}
	}
	return [ (diaSemana != domingo && diaSemana != sabado && result == true),
			'' ];
}

function mostrarFechasDisponibles(date) {
	var disponible = validarFechasDisponibles('fechasCalendarioDisponibleCitaNueva', date);
	return disponible;
}

function mostrarFechasDisponiblesEditar(date) {
	var disponible = validarFechasDisponibles('fechasCalendarioDisponibleCitaEditar', date);
	return disponible;
}

function cambiarAlturaPopUp(elemento, alturaIdeal) {
	var ventana_alto = $(window).height();

	var ancho_elemento = $("#" + elemento).width();

	if (alturaIdeal >= ventana_alto) {

		$("#" + elemento).css({
			'height' : ventana_alto - 10,
			'overflow' : "scroll"
		});

	} else {

		$("#" + elemento).css({
			'height' : alturaIdeal,
			'overflow' : "scroll"
		});

	}

	$("#" + elemento).css({
		'width' : ancho_elemento + 10
	});

}

function redireccionarSiRegistroCorrecto(args) {
	console.log("Entro al metodo redireccionarSiRegistroCorrecto");
	if (args.registroCorrecto) {
		setTimeout(function() {
			location.href = "http://www.divemotor.com";
		}, 5000);
	}
}

function getCookie(c_name) {
	var i, x, y, ARRcookies = document.cookie.split(";");
	for (i = 0; i < ARRcookies.length; i++) {
		x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
		y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
		x = x.replace(/^\s+|\s+$/g, "");
		if (x == c_name) {
			return unescape(y);
		}
	}
}

function ocultarMenu() {
	$("#cajaPrincipal").css({
		'margin-left' : 0
	});

	$("#menu").css({
		'display' : 'none'
	});
	$("#boton-mostrar").css({
		'display' : 'block'
	});
	$("#boton-ocultar").css({
		'display' : 'none'
	});

}

function mostrarMenu() {
	$("#cajaPrincipal").css({
		'margin-left' : 180
	});

	$("#menu").css({
		'display' : 'block'
	});
	$("#boton-mostrar").css({
		'display' : 'none'
	});
	$("#boton-ocultar").css({
		'display' : 'block'
	});
}

function mostrarDialogSiRegistroCorrecto(args, widgetVar) {
	if (args.registroCorrecto) {
		widgetVar.show();
	}
}

function redireccionarPaginaCompania() {
	// document.getElementById('formGestionCitas').reset();
	location.href = "http://www.divemotor.com";
}

function mostrarDialogConsultaPlaca(xhr, status, args, widgetVar) {
	if (args.placaNoExiste) {
		widgetVar.show();
	}
}

function deseleccionarRadioButtonCita(radio, formulario) {
	var form = document.getElementById(formulario);
    var l = form.elements.length;
    for (i=0; i<l; i++) {
        var type = form.elements[i].type;
        if (type=="radio") {
        	form.elements[i].checked = false;
        }
    } 
    radio.checked = true;
}

function deseleccionarTodosRadioButtonCita(formulario) {
	var form = document.getElementById(formulario);
    var l = form.elements.length;
    for (i=0; i<l; i++) {
        var type = form.elements[i].type;
        if (type=="radio") {
        	form.elements[i].checked = false;
        }
    } 
}


