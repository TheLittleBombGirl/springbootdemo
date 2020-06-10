/**
 * @author yinzhf
 * extends: https://github.com/wenzhixin/bootstrap-table
 */
(function($){
	var ops = {
	    container: 'body',
	    template: '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',
		animation: true,
		delay: 0,
		html: false,
		placement: 'top',
		selector: false,
		trigger: 'hover focus'
	}
	$.fn.bootstrapTable.Constructor.prototype.tooltip = function(option){
		var ths = this;
		ths.ops = $.extend({}, ops, option);
		ths.$el.find('>tbody>tr[data-index]>td').each(function(i){
			var $this = $(this);
			$this.tooltip({
				container: ths.ops.container,
				template: ths.ops.template,
				html: ths.ops.html,
				animation: ths.ops.animation,
				delay: ths.ops.delay,
				placement: ths.ops.placement,
				selector: ths.ops.selector,
				trigger: ths.ops.trigger,
				title: $this.text()
			});
		});
	};
	$.fn.bootstrapTable.methods.push('tooltip');
})(jQuery);