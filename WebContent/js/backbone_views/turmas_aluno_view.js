window.TurmasAlunoView = Backbone.View.extend({
	
	template:null,
	
	initialize:function(){
		
		var request = $.ajax({
						async:false,
						url:"backbone_templates/turmas_aluno_template.html",
						method:"GET"
			
						});
		
		var that=this;
		request.done(function(data){
			
			that.template = _.template(data);
			
		});
		
		
		
	},
	
	
	render:function(){
		
		$(this.el).html(this.template);
		return this;
		
		
	}
	
	
});