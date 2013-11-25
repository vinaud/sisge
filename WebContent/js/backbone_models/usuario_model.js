var Usuario = Backbone.Model.extend({
	
	urlRoot:"/SISGE/services/usuario/novo",
	
	defaults:{
		
		
		nome:null,
		senha:null,
		dadosPessoais:null,
		vinculos:null
		
		
	},
	
	initialize:function(){
		
		/*if(param){
			
			this.urlRoot = param.urlRoot;
			this.nome=param.nome;
			this.senha=param.senha;
		}*/
		
		
		

	},
	
	validate:function(attrs){
		
		var erros=[];
		var numErros=-1;
		
		if(attrs.nome==null || attrs.nome==""){
			erros.push("Este campo é obrigatório");
			numErros++;
			
		}
		if(attrs.dadosPessoais ==null || attrs.dadosPessoais.nome==""){
			erros.push("este campo é obrigatório");
			numErros++;	
		}
		
		if(!attrs.nomeUsuario || attrs.nomeUsuario!=""){
			
			erros.push("este campo é obrigatório");
		}
		
		
		
		
		
		if(numErros != -1){
			alert(numErros);
			return erros;
			
		}
		
		
		
		
	}



	
	
	
});