
window.Roteador = Backbone.Router.extend({
	
	
	initialize:function(){
		
		
	},
	
	
	routes:{
		
		"login":"login",
		"cadastrar":"cadastrar",
		"usuario":"mostrarTelaUsuario"
		
		
		
		
		
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
		
		
		
	}
	
	
});


window.roteador = new Roteador();

Backbone.history.start();

