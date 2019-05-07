package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by xuyang on 17/8/28.
 */
import java.io.Serializable;
import java.util.List;

/**
 * 定义一个分页对象
 * @author acer
 *
 */
public class Pager<T> implements Serializable {

    private static final long serialVersionUID = 6709051158579269845L;
    private int page;//当前页码
    private int pageTotal;//总页码
    private int rowsTotal;//总条数
    private int rows;//每页显示条数
    private List<T> list;//返回的数据集合


    public Pager() {
        super();
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageTotal() {
        return pageTotal;
    }
    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
    public int getRowsTotal() {
        return rowsTotal;
    }
    public void setRowsTotal(int rowsTotal) {
        this.rowsTotal = rowsTotal;
        if(rows >0) {
            pageTotal = rowsTotal % rows == 0 ? rowsTotal / rows : rowsTotal / rows + 1;
        }
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "Pager [list=" + list + ", page=" + page + ", pageTotal="
                + pageTotal + ", rows=" + rows + ", rowsTotal=" + rowsTotal
                + "]";
    }


}
