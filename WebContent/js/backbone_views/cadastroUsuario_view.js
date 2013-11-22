window.CadastroUsuarioView =  Backbone.View.extend({
	
	
	initialize:function(){
		
		
		this.render();
	},
	
	
	render:function(){
		
		var that = this;
		
		if(!window.templateCadastroUsuarioView){
			
			
			$.get('backbone_templates/template_cadastroUsuarioView.html',function(data){
				
				that.template = data;
				
				$(that.el).html(_.template(that.template));
				return that;
				
				
			});

		}else{
			
			that.template = data;
			
			$(that.el).html(_.template(that.template));
			return that;
			
		} 

	},
	
	
	events:{
		
		"click #enviarCadastro":"cadastrar"
		
		
		
	},
	
	
	cadastrar:function(){
		
		var nome = $(this.el).find('#nome').val();
		var dtNascimento = $(this.el).find('#dtNascimento').val();
		var rua = $(this.el).find('#rua').val();
		var numero = $(this.el).find('#numero').val();
		var bairro = $(this.el).find('#bairro').val();
		var complemento = $(this.el).find('#complemento').val();
		var estado = $(this.el).find('#estado').val();
		var cidade = $(this.el).find('#cidade').val();
		var nomeUsuario = $(this.el).find('#nomeUsuario').val();
		var senha = $(this.el).find('#senha').val();
		var confirmacaoSenha= $(this.el).find("#confirmacaoSenha").val();
		alert(bairro);
		
		
		var endereco = new window.Endereco({
			rua:rua,
			numero:numero,
			bairro:bairro,
			complemento:complemento,
			estado:estado,
			cidade:cidade
		});
		
		var dadosPessoais = new window.DadosPessoais({
			
			nome:nome,
			dtNascimento:dtNascimento,
			endereco:endereco
			
		});
		
		
		var usuario = new window.Usuario({
			
			nome:nomeUsuario,
			senha:senha,
			dadosPessoais: dadosPessoais
			
		});
		
		usuario.on("invalid",function(model){
			
			alert("senhas diferem");
			
			
		});
		
		if(senha==confirmacaoSenha){
			
			usuario.save({},{success:function(model,response){
				
				$('#modalcadastro').modal('hide');
				
			},error:function(model,error){
				alert("erro:"+error.error);
				
				
			}});
			
		}else{
			
			alert("erro na validação");
		}
		
		
		
		

	},
	
	limparValores:function(){
		
		
	}
	

	
	
	
});