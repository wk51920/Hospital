package model;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wk_51920 on 2014/11/16.
 */
public class PhoneNumberCheck {
    private static Map<String, Boolean> tUsersPhoneNumberInternal = new HashMap<String, Boolean>();
    private static Map<String, Boolean> tatUsersPhoneNumberInternal = new HashMap<String, Boolean>();
    private static Map<String, Boolean> tUsersPhoneNumberSurgery = new HashMap<String, Boolean>();
    private static Map<String, Boolean> tatUsersPhoneNumberSurgery = new HashMap<String, Boolean>();


    public Map<String, Boolean> getUserPhoneNumber(String tag) {
        if (tag.equals("TI"))               //明天内科预约手机号
            return this.tUsersPhoneNumberInternal;
        else if (tag.equals("TATI"))        //后天内科预约手机号
            return this.tatUsersPhoneNumberInternal;
        else if (tag.equals("TS"))          //明天外科预约手机号
            return this.tUsersPhoneNumberSurgery;
        else return this.tatUsersPhoneNumberSurgery;  //后天外科预约手机号
    }

    public void addUserPhone(String phoneNumber, Map<String, Boolean> usersPhoneNumber) {
        boolean flag = true;
        for (Map.Entry entry : usersPhoneNumber.entrySet())
            if (entry.getKey() == phoneNumber)
                flag = false;
        if (usersPhoneNumber.isEmpty())
            usersPhoneNumber.put(phoneNumber, true);
        else if (flag) {
            usersPhoneNumber.put(phoneNumber, false);
        }
    }

    public void removeUserPhone(String phoneNumber, Map<String, Boolean> usersPhoneNumber) {
        usersPhoneNumber.remove(phoneNumber);
    }

    public boolean checkUserPhone(String phoneNumber, Map<String, Boolean> usersPhoneNumber) {
        boolean flag = true;     //true表示此号码没有预约过
        for (Map.Entry entry : usersPhoneNumber.entrySet())
            if (entry.getKey().equals(phoneNumber))
                flag = false;   //false表示此号码已经预约了
        return flag;
    }

    public boolean numberLegal(String number) {
        if (number.length() != 11)
            return false;
        else if (number.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
            return true;
        } else return false;
    }

}
