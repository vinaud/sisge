
window.Roteador = Backbone.Router.extend({
	
	
	initialize:function(){
		
		
	},
	
	
	routes:{
		
		"login":"login",
		"cadastrar":"cadastrar",
		"usuario":"mostrarTelaUsuario",
		
		
		
		
		
	},
	
	login:function(){
		
		$.get("/SISGE/inicio.html",function(data){
			
			$('#principal').html(data);
			if(!window.viewLogin){
				window.viewLogin = new window.LoginView({el:'#formulario_login'});
			}else{
			}
			
			
		});
		
		
	},
	
	
	
	
	
	
	cadastrar:function(){
		
		
		
	},
	
	
	mostrarTelaUsuario:function(){
		if(!window.viewTelaUsuario){
			
			window.viewTelaUsuario = new window.TelaUsuarioView();
			$('#principal').html(viewTelaUsuario.render().el);
			
		}else{
			$('#principal').html(viewTelaUsuario.render().el);
		}
		
		
	}
	
	
});


window.roteador = new Roteador();

Backbone.history.start();

