(function ($) {
    'use strict';

    $.extend($.fn.bootstrapTable.defaults, {
        fixedColumns: false,
        fixedNumber: 1,
		leftFixedColumns: false,
        leftFixedNumber: 1,
        rightFixedColumns: false,
        rightFixedNumber: 1
    });

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initHeader = BootstrapTable.prototype.initHeader,
        _initBody = BootstrapTable.prototype.initBody,
        _resetView = BootstrapTable.prototype.resetView;
    
  //重写组件的的初始化表头的方法，加入冻结的表头。
    BootstrapTable.prototype.initHeader = function () {
    	console.log("===initHeader==");
        _initHeader.apply(this, Array.prototype.slice.apply(arguments));

        var that = this, 
		$trs = this.$header.find('tr').clone(),
		$ths = $trs.clone().find('th');
        
        if (!that.options.fixedColumns&&!that.options.leftFixedColumns && !that.options.rightFixedColumns) {
            return;
        }
       
    	this.initFixedColumns();
    	
		if (that.options.fixedColumns) {
			$trs.each(function () {
				$(this).find('th:gt(' + (that.options.fixedNumber - 1) + ')').remove();
			});
			that.$fixedHeaderColumns.html('').append($trs);
		}
		
		if (that.options.leftFixedColumns) {
			$trs.each(function () {
				$(this).find('th:gt(' + (that.options.leftFixedNumber - 1) + ')').remove();
			});
			that.$fixedHeaderColumns.html('').append($trs);
		}
		
		//右边列冻结
        if (that.options.rightFixedColumns) {
			var $tr = document.createElement('tr');
			for (var i = $ths.length - that.options.rightFixedNumber; i < $ths.length; i++) {
				$tr.appendChild($ths[i]);
            }
			that.$rightfixedHeaderColumns.html('').append($tr);
        }
        //控制多选
        if (that.options.fixedColumns) {
	      	this.$selectAll = that.$fixedHeaderColumns.find('[name="btSelectAll"]');
			this.$selectAll.off('click').on('click', function() {
				var checked = $(this).prop('checked');
				that[checked ? 'checkAll' : 'uncheckAll']();
				that.updateSelected();
			});
        }
    };
    
	//当初始化的时候配置了fixedColumns: true时需要执行的冻结列的方法	
    BootstrapTable.prototype.initFixedColumns = function () {
    	console.log("===initFixedColumns==");
    	var that = this, 
 		$trs = this.$header.find('tr').clone(),
 		$ths = $trs.clone().find('th');
    	
		this.timeoutBodyColumns_ = 0;
		this.timeoutBodyColumns_ = 0;
		if (that.options.fixedColumns||that.options.leftFixedColumns) {
			
			that.$fixedHeader = $([
				'<div class="fixed-table-header-columns">',
				'<table>',
				'<thead></thead>',
				'</table>',
				'</div>'].join(''));

			that.timeoutHeaderColumns_ = 0;
			that.$fixedHeader.find('table').attr('class', this.$el.attr('class'));
			that.$fixedHeaderColumns = that.$fixedHeader.find('thead');
			that.$tableHeader.before(that.$fixedHeader);

			that.$fixedBody = $([
				'<div class="fixed-table-body-columns">',
				'<table>',
				'<tbody></tbody>',
				'</table>',
				'</div>'].join(''));

			
			that.$fixedBody.find('table').attr('class', this.$el.attr('class'));
			that.$fixedBodyColumns = that.$fixedBody.find('tbody');
			that.$tableBody.before(that.$fixedBody);
		}
		if (that.options.rightFixedColumns) {
			that.$rightfixedHeader = $([
					'<div class="fixed-table-header-columns" style="position: absolute;right:0px; top: 0px;background-color: #fff; border-right:1px solid #ddd;">',
					'<table>',
					'<thead></thead>',
					'</table>',
					'</div>'].join(''));
	
			that.$rightfixedHeader.find('table').attr('class', this.$el.attr('class'));
			that.$rightfixedHeaderColumns = that.$rightfixedHeader.find('thead');
			that.$tableHeader.before(that.$rightfixedHeader);
			
			that.$rightfixedBody = $([
	                '<div class="fixed-table-body-columns" style="position: absolute;right:15px; top: 0px;background-color: #fff; border-right:1px solid #ddd;">',
	                '<table>',
	                '<tbody></tbody>',
	                '</table>',
	                '</div>'].join(''));
				
			that.$rightfixedBody.find('table').attr('class', this.$el.attr('class'));
			that.$rightfixedBodyColumns = that.$rightfixedBody.find('tbody');
			that.$tableBody.before(that.$rightfixedBody);
		}
    };
	
	//重写组件的初始化表内容的方法，加入冻结的表内容。
    BootstrapTable.prototype.initBody = function () {
    	console.log("===initBody==");
        _initBody.apply(this, Array.prototype.slice.apply(arguments));

        var that = this, 
 		$trs = this.$header.find('tr').clone(),
 		$ths = $trs.clone().find('th'),
 		$bodytrs = this.$body.find('tr').clone();
        
        if (!that.options.fixedColumns&&!that.options.leftFixedColumns && !that.options.rightFixedColumns) {
            return;
        }
		
      if(window.innerWidth<that.$tableBody[0].scrollWidth){		
		if (that.options.fixedColumns) {
			if (that.$fixedBodyColumns) {
				that.$fixedBodyColumns.html('');
			}
			$bodytrs.each(function () {
				var $tr = $(this).clone(),
					$tds = $tr.find('td');
				//$tr.html('');这样存在一个兼容性问题，在IE浏览器里面，清空tr,$tds的值也会被清空。
				//$tr.html('');
				var $newtr = $('<tr></tr>');
				$newtr.attr('data-index', $tr.attr('data-index'));
				$newtr.attr('data-uniqueid', $tr.attr('data-uniqueid'));
				var end = that.options.fixedNumber;
				for (var i = 0; i < end; i++) {
					$newtr.append($tds.eq(i).clone());
				}
				that.$fixedBodyColumns.append($newtr);
			});
		}
		
		if (that.options.leftFixedColumns) {
			if(that.$fixedBodyColumns){
				that.$fixedBodyColumns.html('');
			}
			$bodytrs.each(function () {
				var $tr = $(this).clone(),
					$tds = $tr.find('td');
				//$tr.html('');这样存在一个兼容性问题，在IE浏览器里面，清空tr,$tds的值也会被清空。
				//$tr.html('');
				var $newtr = $('<tr></tr>');
				$newtr.attr('data-index', $tr.attr('data-index'));
				$newtr.attr('data-uniqueid', $tr.attr('data-uniqueid'));
				var end = that.options.leftFixedNumber;
				for (var i = 0; i < end; i++) {
					$newtr.append($tds.eq(i).clone());
				}
				that.$fixedBodyColumns.append($newtr);
			});
		}
		
		
		//右边列冻结
		if (that.options.rightFixedColumns) {
			
				if(that.$rightfixedBodyColumns){
					that.$rightfixedBodyColumns.html('');
				}
	            $bodytrs.each(function () {
	                var $tr = $(this).clone(),
	                    $tds = $tr.clone().find('td');
	                var $newtr = $('<tr></tr>');
					$newtr.attr('data-index', $tr.attr('data-index'));
					$newtr.attr('data-uniqueid', $tr.attr('data-uniqueid'));
					var index = $tds.length-that.options.rightFixedNumber;
					for (var i = index; i < $tds.length; i++) {
	                    $newtr.append($tds.eq(i).clone());
	                }
	                that.$rightfixedBodyColumns.append($newtr);
	            });
			}
        }
    };
	//重写“父类”的resetView方法，通过setTimeout去设置冻结的表头和表体的宽度和高度。
    BootstrapTable.prototype.resetView = function () {
    	console.log("===resetView==");
        _resetView.apply(this, Array.prototype.slice.apply(arguments));

        var that = this;
        if (!that.options.fixedColumns&&!that.options.leftFixedColumns && !that.options.rightFixedColumns) {
            return;
        }

        clearTimeout(this.timeoutHeaderColumns_);
        this.timeoutHeaderColumns_ = setTimeout($.proxy(this.fitHeaderColumns, this), this.$el.is(':hidden') ? 100 : 0);

        clearTimeout(this.timeoutBodyColumns_);
        this.timeoutBodyColumns_ = setTimeout($.proxy(this.fitBodyColumns, this), this.$el.is(':hidden') ? 100 : 0);
    };
	//设置冻结列的表头的宽高。
    BootstrapTable.prototype.fitHeaderColumns = function () {
    	console.log("===fitHeaderColumns==");
    	var that = this, 
 			$trs = this.$header.find('tr').clone(),
 			$ths = $trs.clone().find('th'),
			$tds = this.$body.find('tr:first-child:not(.no-records-found) > *'),
            visibleFields = this.getVisibleFields(),
            headerWidth = 0;	
       if(window.innerWidth<that.$tableBody[0].scrollWidth){	
		if (that.options.fixedColumns) {
			headerWidth = 0;
			$tds.each(function (i) {
				var $this = $(this),
					index = i;

				if (i >= that.options.fixedNumber) {
					return false;
				}

				if (that.options.detailView && !that.options.cardView) {
					index = i - 1;
				}
				
				that.$fixedHeader.find('th[data-field="' + visibleFields[index] + '"]')
					.find('.fht-cell').width($this.innerWidth());
				headerWidth += $this.outerWidth();
			});
			that.$fixedHeader.width(headerWidth).show();
		}
		
		if (that.options.leftFixedColumns) {
			headerWidth = 0;
			$tds.each(function (i) {
				var $this = $(this),
					index = i;

				if (i >= that.options.leftFixedNumber) {
					return false;
				}

				if (that.options.detailView && !that.options.cardView) {
					index = i - 1;
				}
				
				that.$fixedHeader.find('th[data-field="' + visibleFields[index] + '"]').find('.fht-cell').width($this.innerWidth());
				headerWidth += $this.outerWidth();
			});
			that.$fixedHeader.width(headerWidth).show();
		}
		
		if (that.options.rightFixedColumns) {
				headerWidth = 0;
				var index = visibleFields.length-that.options.rightFixedNumber;
				for (var i = index; i < visibleFields.length; i++) {
					var $this = $tds.eq(i).clone();
					that.$rightfixedHeader.find('thead th[data-field="' + visibleFields[i] + '"]').find('.fht-cell').width($this.innerWidth() - 1);
					headerWidth += $this.outerWidth();
				}	
				that.$rightfixedHeader.width(headerWidth - 1).show();
			}
		}
		
    };
	//设置冻结列的表体的宽高，以及滚动条和主体表格的滚动条同步。
    BootstrapTable.prototype.fitBodyColumns = function () {
    	console.log("===fitBodyColumns==");
        var that = this,
        	$trs = this.$header.find('tr').clone(),
			$ths = $trs.clone().find('th'),
            top = -(parseInt(this.$el.css('margin-top'))),
            // the fixed height should reduce the scorll-x height
            height = that.$tableBody.height() - 18;
        if(window.innerWidth<that.$tableBody[0].scrollWidth){
		if (that.options.fixedColumns||that.options.leftFixedColumns) {
			if (!this.$body.find('> tr[data-index]').length) {
				that.$fixedBody.hide();
				return;
			}

			if (!this.options.height) {
				top = that.$fixedHeader.height()- 1;
				height = height - top;
			}

			that.$fixedBody.css({
				width: that.$fixedHeader.width(),
				height: height,
				top: top + 1
			}).show();

			this.$body.find('> tr').each(function (i) {
				that.$fixedBody.find('tr:eq(' + i + ')').height($(this).height() - 0.5);
				var thattds = this;
				
				that.$fixedBody.find('tr:eq(' + i + ')').find('td').each(function (j) {
					$(this).width($($(thattds).find('td')[j]).width());
				});
			});

			// events
			that.$tableBody.on('scroll', function () {
				that.$fixedBody.find('table').css('top', -$(this).scrollTop());
			});
			this.$body.find('> tr[data-index]').off('hover').hover(function () {
				var index = $(this).data('index');
				that.$fixedBody.find('tr[data-index="' + index + '"]').addClass('hover');
			}, function () {
				var index = $(this).data('index');
				that.$fixedBody.find('tr[data-index="' + index + '"]').removeClass('hover');
			});
			this.$fixedBody.find('tr[data-index]').off('hover').hover(function () {
				var index = $(this).data('index');
				that.$body.find('tr[data-index="' + index + '"]').addClass('hover');
			}, function () {
				var index = $(this).data('index');
				that.$body.find('> tr[data-index="' + index + '"]').removeClass('hover');
			});
		}
		
		if (that.options.rightFixedColumns) {
			
	            if (!this.$body.find('> tr[data-index]').length) {
	            	that.$rightfixedBody.hide();
					return;
				}
	
				if (!this.options.height) {
					top = that.$rightfixedHeader.height()- 1;
					height = height - top;
				}
				
				this.$rightfixedHeader.css({
					width: that.$rightfixedHeader.width() + 15,
				}).show();
				
				this.$rightfixedBody.css({
					width: that.$rightfixedHeader.width() - 15,
					height: height,
					top: top + 1
				}).show();
	
				this.$body.find('> tr').each(function (i) {
					that.$rightfixedBody.find('tr:eq(' + i + ')').height($(this).height() - 0.5);
					var thattds = this;
					
					that.$rightfixedBody.find('tr:eq(' + i + ')').find('td').each(function (j) {
						$(this).width($($(thattds).find('td')[j]).width());
					});
				});
	
				// events
				that.$tableBody.on('scroll', function () {
					that.$rightfixedBody.find('table').css('top', -$(this).scrollTop());
				});
				this.$body.find('> tr[data-index]').off('hover').hover(function () {
					var index = $(this).data('index');
					that.$rightfixedBody.find('tr[data-index="' + index + '"]').addClass('hover');
				}, function () {
					var index = $(this).data('index');
					that.$rightfixedBody.find('tr[data-index="' + index + '"]').removeClass('hover');
				});
				that.$rightfixedBody.find('tr[data-index]').off('hover').hover(function () {
					var index = $(this).data('index');
					that.$body.find('tr[data-index="' + index + '"]').addClass('hover');
				}, function () {
					var index = $(this).data('index');
					that.$body.find('> tr[data-index="' + index + '"]').removeClass('hover');
				});
			}
        }
	};

})(jQuery);