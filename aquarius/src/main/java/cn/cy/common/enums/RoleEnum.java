package cn.cy.common.enums;


public enum RoleEnum {
	SYSTEM_ADMIN("管理员",0),
	SYSTEM_SELLER("卖家",1),
	SYSTEM_BUYER("买家",2);
	
	private RoleEnum(String name, Integer value) {
		this.name = name;
		this.value = value;
	}
	private String name;
	private Integer value;
	
	 public static RoleEnum getEnum(Integer value)
	    {
		 RoleEnum resultEnum = null;
		 RoleEnum[] enumArr = RoleEnum.values();
	        // 判断是否为空
	        if (enumArr.length != 0 && enumArr != null)
	        {
	            for (RoleEnum roleEnum : enumArr)
	            {
	                if (roleEnum.getValue() == value)
	                {
	                    resultEnum = roleEnum;
	                    break;
	                }
	            }
	        }
	        return resultEnum;
	    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

	
}
