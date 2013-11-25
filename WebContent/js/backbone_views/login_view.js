window.login_view_template=null;

window.LoginView = Backbone.View.extend({
	
	
	
	initialize:function(){
		
		if(window.login_view_template){
			this.template = window.login_view_template;
			this.render();
			
		}else{
			
			this.baixarTemplate();
			
		}
		
	},
	
	
	render:function(){
		
		
		var pagina = _.template(this.template);
		$(this.el).html(pagina);
		var cadastroUsuarioView = new window.CadastroUsuarioView({el:$(this.el).find('#conteudo_modal')});
		$(this.el).find('#conteudo_modal').html($(cadastroUsuarioView.render.el).html());
		
		
	},
	
	
	events:{
		"click .btn-primary ":"efetuarLogin",
		"click #se_cadastrar":"mostrarModal"
			
		
		
	},
	
	baixarTemplate:function(){
		var that=this;
		$.get("backbone_templates/login_view_template.html",function(data){
			
			window.login_view_template = data;
			that.template = window.login_view_template;
			that.render();
			
		});
		
	},
	
	efetuarLogin:function(){
		
		var nomeUsuario = $(this.el).find('#nomeUsuario').val();
		var senha = $(this.el).find('#senha').val();
		
		var query="http://localhost:8080/SISGE/services/login/usuario/"+
							nomeUsuario+"/senha/"+senha;

		var request = $.ajax({
			type:"GET",
			url : query,
			async:false
			
		});
		
		request.done(function(data){
			
			window.usuario = new window.Usuario(JSON.parse(data));
			roteador.navigate("usuario",{trigger:true});
			
			
		});
		
		request.fail(function(erro,data){
			
			switch(erro.status){
				case 401:
					alert("Usuario e/ou senha não conferem");
					break;
				default:
					alert("Falha de login: "+erro.status);
			
			}
		});
		

		
		
		
		
		
	},
	
	mostrarModal:function(){
		
		
		$('#modalcadastro').modal('show');
	}
	
	
	
});