package cn.cy.common.utils;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * 分页工具类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月4日 下午12:59:00
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int total;
	//每页记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> rows;
	
	public PageUtils() {
		
	}
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<?> rows, int total, int pageSize, int currPage) {
		this.rows = rows;
		this.total = total;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)total/pageSize);
	}

	/**
	 * 分页
	 */
	public PageUtils(Page<?> page) {
		this.rows = page.getRecords();
		this.total = page.getTotal();
		this.pageSize = page.getSize();
		this.currPage = page.getCurrent();
		this.totalPage = page.getPages();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
