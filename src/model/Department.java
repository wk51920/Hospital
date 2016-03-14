package model;

/**
 * Created by wk_51920 on 2014/11/15.
 */
public interface Department {
    public void setTomorrow(boolean order);
    public void setAffterTomorrow(boolean order);
    public boolean getTomorrow();
    public boolean getAfterTomorrow();
    public String getDepartmentName();
}
