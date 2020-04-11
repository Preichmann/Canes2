$(document).ready(function(){
	$("#cep").on("change", function(){
		if(this.value){
			$.ajax({
				url: 'http://api.postmon.com.br/v1/cep/'+this.value,
				dateType: "json",
				crossDomain: true,
					statusCode:{
						200: function(data){
							//console.log(data);

							$("#cep").addClass("is-valid");
							$("#logradouro").val(data.logradouro);
							$("#bairro").val(data.bairro);
							$("#cidade").val(data.cidade);
							$("#estado").val(data.estado);
						},
						400: function(msg){
							console.log(msg); //Request error
						},
						404: function(msg){
							console.log(msg); //Cep inválido
						}
					}
			})
		}
	});
});