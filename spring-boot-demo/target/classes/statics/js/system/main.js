var vm = new Vue({
	el:'#root',
	data:{
		menuList:{}
	},
	methods: {
		getMenuList: function (event) {
			$.getJSON("sysMenu/getMenu",function(r){
				vm.menuList = r.menuList;
				console.log(vm.menuList);
			});
		},
		getUser: function(){
			$.getJSON("sys/user/info/?_"+$.now(), function(r){
				vm.user = r.user;
			});
		},
		updatePassword: function(){
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "修改密码",
				area: ['550px', '270px'],
				shadeClose: false,
				content: jQuery("#passwordLayer"),
				btn: ['修改','取消'],
				btn1: function (index) {
					var data = "password="+vm.password+"&newPassword="+vm.newPassword;
					$.ajax({
						type: "POST",
					    url: "sys/user/password",
					    data: data,
					    dataType: "json",
					    success: function(result){
							if(result.code == 0){
								layer.close(index);
								layer.alert('修改成功', function(index){
									location.reload();
								});
							}else{
								layer.alert(result.msg);
							}
						}
					});
	            }
			});
		},
		add: function(){
			console.log("add");
		}
	},
	created: function(){
		this.getMenuList();
	}
});
