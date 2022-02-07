/**
 * Validação de formulário
 #author
 */

function validar() {

	let nome = frmContato.nome.value;
	let idade = frmContato.idade.value;
	let genero = frmContato.genero.value;
	let telefone = frmContato.telefone.value;
	let email = frmContato.email.value;
	let cpf = frmContato.cpf.value;

	if(nome === ""){
		window.alert("Preencha o campo Nome")
		frmContato.nome.focus()
		return false
	}else if(idade === "") {
		window.alert("Preencha o campo Idade")
		frmContato.idade.focus()
		return false
	}else if(genero === "") {
		window.alert("Preencha o campo Gênero")
		frmContato.genero.focus()
		return false
	}else if(telefone === "") {
		window.alert("Preencha o campo Telefone")
		frmContato.telefone.focus()
		return false
	}else if(email === "") {
		window.alert("Preencha o campo Email")
		frmContato.email.focus()
		return false
	}else if(cpf === "") {
		window.alert("Preencha o campo CPF")
		frmContato.cpf.focus()
		return false
	}else{
		document.forms["frmContato"].submit()
	}

}