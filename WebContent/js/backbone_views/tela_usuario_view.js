window.TelaUsuarioView =  Backbone.View.extend({
	
	model:window.Usuario,
	vinculos:null,
	template:null,
	vinculoSelecionado:null,
	
	
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
		"click #salvar_vinculo":"salvarVinculo",
		"change input[type=radio]":"redesenharVinculos",
		"change #vinculos":"renderizarTurmas",
		"click #btn_criar_turma":"mostrarModalCadastroTurma"
			
			
			
		
		
	},
	
	
	render:function(){
		

		$(this.el).html(_.template(this.template,{usuario:(window.usuario),vinculos:(window.vinculos)}));
		var turmasView = new window.TurmasAlunoView();
		$(this.el).find("#turmas").html(turmasView.render().el);
		this.redesenharVinculos();

		return this; 
		
		
	},
	
	
	mostrarModalNovoVinculo:function(){		
		
		$(this.el).find('#modal_novo_vinculo').modal('show');
		
		
	},
	
	mostrarModalCadastroTurma:function(){
		
		var i = $(this.el).find('#vinculos').prop('selectedIndex');
		this.vinculoSelecionado = this.vinculos.at(i);
		if(this.vinculoSelecionado){
			var cadastroView = new window.CadastroTurmaView({vinculo:this.vinculoSelecionado});
			$(this.el).find('#conteudo_modal_cadastro_turma').html(cadastroView.el);
			$(this.el).find("#modal_criar_turma").modal('show');
		}else{
			
			alert("Ops, você ainda não tem nenhum vínculo, crie um primeiro");
		}
		
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
		
		
		
	},
	
	redesenharVinculos:function(){
		var that=this;
		if($(this.el).find('#radio_aluno').is(':checked')){
			
			that.vinculos = new window.AlunoCollection();
			that.vinculos.fetch({success:function(collection,response){
				
				var str = "";
				collection.each(function(model){
					str+= "<option>";
					str+= model.get('nome') + "</option>";
					
				});
				
				$(that.el).find('#vinculos').html(str);
				var i = $(that.el).find('#vinculos').prop('selectedIndex');
				that.vinculoSelecionado = that.vinculos.at(i);
				
				
				
			},error:function(model,error){
				
				alert("erro");
				
				
			}});

		}else{
			that.vinculos = new window.ProfessorCollection();
			that.vinculos.fetch({success:function(collection,response){
				var str = "";
				collection.each(function(model){
					str+= "<option>";
					str+= model.get('nome') + "</option>";
					
				});
				
				$(that.el).find('#vinculos').html(str);
				
				if(that.vinculos.length>0){
					var i = $(that.el).find('#vinculos').prop('selectedIndex');
					that.vinculoSelecionado = that.vinculos.at(i);
					
				}
				
				
			},error:function(model,error){
				
				alert("erro");
				
				
			}});
			
		}
		
		
	},
	
	renderizarTurmas:function(){
		
		
		alert("renderizando turmas não implementado ainda");
	}
	
	
	
	
	
	
	
	
	
	
	
	
});