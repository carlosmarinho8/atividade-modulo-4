/**
 * 
 */
 function confirmar(idcon){
	let resposta = confirm("Confirma exclusão desse contato ?");
	if(resposta === true){
		window.location.href= "delete?idcon=" + idcon;
		//alert(idcon);
	}
}