package model;

import javax.swing.event.DocumentEvent;

/**
 * Created by wk_51920 on 2014/11/15.
 */
public class InternalMedicine implements Department {
    private static boolean tomorrow = true;
    private static boolean afterTomorrow = true;
    private final String departmentName = "InternalMedicine";

    @Override
    public void setTomorrow(boolean order) {
        this.tomorrow = order;
    }

    @Override
    public void setAffterTomorrow(boolean order) {
        this.afterTomorrow = order;
    }

    @Override
    public boolean getTomorrow() {
        return this.tomorrow;
    }

    @Override
    public boolean getAfterTomorrow() {
        return this.afterTomorrow;
    }

    @Override
    public String getDepartmentName() {
        return this.departmentName;
    }
}
