window.CadastroTurmaView = Backbone.View.extend({
	
	vinculo:null,
	
	
	initialize:function(vinculo){
		this.vinculo = vinculo.vinculo;
		if(!window.cadastroTurmaTemplate){
			var request=null;
			request = $.ajax({
				
				url:"backbone_templates/cadastro_turma_template.html",
				async:false
			});
			
			request.done(function(data){
				
				window.cadastroTurmaTemplate = data;
				
			});
			
			request.fail(function(xhr,error){
				
				alert("impossível de carregar o template");
				
			});
		}
		
		
		
		this.render();
		
		
	},
	
	events:{
		
		"click #btnCadastrarTurma":"cadastrarTurma"
		
	},
	
	cadastrarTurma:function(){
		
		
		var nome = $(this.el).find("#nomeTurma").val();
		var codigo = $(this.el).find("#codigoTurma").val();
		var capacidade = $(this.el).find("#capacidadeTurma").val();
		this.turma = new window.Turma({
			nome:nome,
			codigo:codigo,
			capacidade:capacidade,
			vinculo:this.vinculo
		});
		
		this.turma.on('invalid',function(model,erro){
			
				alert("Há erros nos campos");
			
		});
		
		this.turma.save();
		
		
		
			
	},
	

	render:function(){
		
		
		var template = _.template(window.cadastroTurmaTemplate,{vinculo:this.vinculo});
		$(this.el).html(template);
		
		
	}
	
	
	
});