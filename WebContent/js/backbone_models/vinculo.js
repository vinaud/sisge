window.Aluno = Backbone.Model.extend({
	
	
	urlRoot:"services/vinculos/aluno",
	
	validate:function(attr){
		return (attr.nome==null || attr.nome=="");
		
	}
	
	
});


window.Professor = Backbone.Model.extend({
	
	
	urlRoot:"services/vinculos/professor",
	
	validate:function(attr){
		if(attr.nome==null || attr.nome==""){
			
			return "erro: O nome não pode estar vazio";
		};
		
	}
	
	
});