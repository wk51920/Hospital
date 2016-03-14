package model;

/**
 * Created by wk_51920 on 2014/11/15.
 */
public class OrderControl {
    private GetDate date = new GetDate();
    private Department internal = new InternalMedicine();
    private Department surgery = new Surgery();

    public int haveOrder(String time, String department) {
        if (time.equals(date.getDate("T")) && internal.getDepartmentName().equals(department)) {
            if (internal.getTomorrow())
                return 1;            //内科明天有号
            else return 2;           //内科明天没号
        }else if(time.equals(date.getDate("T")) && surgery.getDepartmentName().equals(department))
        {
            if (surgery.getTomorrow())
                return 3;            //外科明天有号
            else return 4;           //外科明天没号
        }else if(time.equals(date.getDate("TAT")) && internal.getDepartmentName().equals(department))
        {
            if (internal.getAfterTomorrow())
                return 5;            //内科后天有号
            else return 6;           //内科后天没号
        }else if(time.equals(date.getDate("TAT")) && surgery.getDepartmentName().equals(department))
        {
            if (surgery.getAfterTomorrow())
                return 7;           //外科后天有号
            else return 8;          //外科后天没号
        }else return 9;             //日期不在明后两天范围内
    }
}
