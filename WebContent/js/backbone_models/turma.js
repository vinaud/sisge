window.Turma = Backbone.Model.extend({
	
	urlRoot:"services/turmas",
	idAttribute:"id",
	
	defaults:{
		
		nome:null,
		codigo:null,
		capacidade:1,
		professor:null
		
	},
	
	validate:function(attr){
		
		var camposInvalidos=[];
		
		if(attr.capacidade <= 0){
			
			camposInvalidos.push("capacidade");
		}
		
		if(attr.nome==null || attr.nome==""){
			
		camposInvalidos.push("nome");
		}
		
		if(!attr.professor || attr.professor==null){
			
			camposInvalidos.push("vinculo");
		}
		
		if(camposInvalidos.length > 0){
			
			return camposInvalidos;
		}
	}
	
	

		
		
	
	
	
	
	
});