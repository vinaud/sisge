window.TelaUsuarioView =  Backbone.View.extend({
	
	model:window.Usuario,
	template:null,
	
	initialize:function(){
		
		var request = $.ajax({
			
			url:"backbone_templates/tela_usuario_template.html",
			async:false
		});
		var that=this;
		request.done(function(data){
			that.template = data;
		});
		
		request = $.ajax({
			
			
			
			
		});
		
		request = $.ajax({
			
			url:"http://localhost:8080/SISGE/services/usuario/logado",
			async:false,
			method:"get"
			
		});
		
		request.done(function(data){
			
			window.usuario = new window.Usuario(JSON.parse(data));
			
		});
		
		this.render();
		
		
		
		
		
	},
	
	events:{
		
		"click #btn_novo_vinculo":"mostrarModalNovoVinculo",
		"click #salvar_vinculo":"salvarVinculo"
		
		
	},
	
	
	render:function(){
		

		
		$(this.el).html(_.template(this.template,{usuario:/*JSON.stringify*/(window.usuario)}));
		var turmasView = new window.TurmasAlunoView();
		$(this.el).find("#turmas").html(turmasView.render().el);
		
		
		return this;
		
		
	},
	
	
	mostrarModalNovoVinculo:function(){		
		
		$(this.el).find('#modal_novo_vinculo').modal('show');
		
		
	},
	
	salvarVinculo:function(){
		
		var nomeVinculo = $(this.el).find('#modal_nome_vinculo').val();
		
		if($(this.el).find('#modal_radio_aluno').is(':checked')){
			
			
			var request = $.ajax({
				
				url:"http://localhost:8080/SISGE/services/usuario/logado",
				method:"GET",
				async:false
			});
			var usuario = null;
			request.done(function(data){
				
				usuario = new window.Usuario((JSON.parse(data)));
				var vinculo = new window.Aluno({
					
					nome: nomeVinculo,
					usuario:usuario

				});
				vinculo.save();

			});
			
			request.fail(function(xhr,erro){
				
				alert("Falha ao salvar o vínculo");
				
				
			});

			
		}else{
			
			var request = $.ajax({
				
				url:"http://localhost:8080/SISGE/services/usuario/logado",
				method:"GET",
				async:false
			});
			var usuario = null;
			request.done(function(data){
				
				usuario = new window.Usuario((JSON.parse(data)));
				var vinculo = new window.Professor({
					
					nome: nomeVinculo,
					usuario:usuario

				});
				
				vinculo.save({},{success:function(model,response){
					
					console.log("vinculo salvo com sucesso");
					
				},error:function(model,error){
					
					alert("não foi possível salvar o vínculo");
					
				}});

				

			});
			
			request.fail(function(xhr,erro){
				
				alert("Falha ao salvar o vínculo");
			});
			
			
			
			
		}
		$(this.el).find('#modal_novo_vinculo').modal('hide');
		
		
		
	}
	
	
	
	
	
});