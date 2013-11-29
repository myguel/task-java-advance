/** file para validaciones del cliente */

 function ocultarDialogSiOperacionEsCorrecta(xhr, status, args, widgetVar) {
       if (args.ocurrioError || args.validationFailed) {
               widgetVar.show();
       } else {
               widgetVar.hide();
       }
}
 