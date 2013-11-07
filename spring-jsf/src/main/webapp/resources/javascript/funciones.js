
var esCerrarSession=false;
$(document).ready(function () {
	$(document).ajaxComplete(function(event, xhr, settings) {
/*		  console.log('settings:'+settings.url );
		  console.log('settings:'+settings.url );
		  console.log('accepts:'+settings.accepts );
		  console.log('async:'+settings.async );
		  console.log('beforeSend:'+settings.beforeSend );
		  console.log('contentType :'+settings.contentType );
		  console.log('data:'+settings.data);
		 
		 
		  
		 
		  console.log('isLocal :'+settings.isLocal);

		  
		  console.log('eventname:'+event.name);
		  console.log('esCerrarSession:'+esCerrarSession);
		*/
		  var identificarView=settings.data.substring(settings.data.lastIndexOf('%')+3,settings.data.length);
		//  console.log('identificador:'+identificarView);
		  //console.log('index coincidnecia:'+xhr.responseText.lastIndexOf(identificarView));
		  if(xhr.responseText.lastIndexOf(identificarView)==-1 && !esCerrarSession){
			  sessionTimeOutDialog.show();
		  }
		  
	});

	$(document).keydown(function(e) {
		var element = e.target.nodeName.toLowerCase();
		if ((element != 'input' && element != 'textarea') || $(e.target).attr("readonly")) {
		    if (e.keyCode === 8) {
		        return false;
		    }
		}
	});
	
});

$(document).ready(function () {
	var ventana_alto = $(window).height();
	$("#content").css({'min-height':ventana_alto - 135});
	var content_alto = $("#todito").height();
	$("#barra-separacion").css({'height':content_alto + 9});
	
	$(window).resize(function() {
	    var ventana_alto = $(window).height();
	    $("#content").css({'min-height':ventana_alto - 135});
	    var content_alto = $("#todito").height();
	    $("#barra-separacion").css({'height':content_alto + 9});
	});
	
	$("#boton-mostrar").css({'display': 'none'});
	$("#boton-ocultar").css({'display': 'block'});
});