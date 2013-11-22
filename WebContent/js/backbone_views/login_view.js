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
		var query="http://localhost:8080/SISGE/services/usuario/login/usuario/"+
							nomeUsuario+"/senha/"+senha
		$.get(query,function(data){
			
			alert(data);
		});

		
		
		
		
		
	},
	
	mostrarModal:function(){
		
		
		$('#modalcadastro').modal('show');
	}
	
	
	
});