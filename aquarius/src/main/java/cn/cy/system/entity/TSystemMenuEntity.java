package cn.cy.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_system_menu")
public class TSystemMenuEntity {
	
	@TableId
	private String ListId;
	private String menuName;
	private String menuParentId;
	private String permission;
	private String type;
	private String isDelete;
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getListId() {
		return ListId;
	}
	public void setListId(String listId) {
		ListId = listId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(String menuParentId) {
		this.menuParentId = menuParentId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
