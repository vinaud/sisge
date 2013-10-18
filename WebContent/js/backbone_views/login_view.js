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
		
		
	},
	
	
	events:{
		"click .btn-primary ":"efetuarLogin",
			
		
		
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
		
		var nomeUsuario = $('#nomeUsuario').val();
		var senha = $('#senha').val();
		
		
		
	}
	
	
	
});