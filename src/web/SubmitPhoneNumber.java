package web;

import model.Department;
import model.InternalMedicine;
import model.PhoneNumberCheck;
import model.Surgery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by wk_51920 on 2014/11/16.
 */
public class SubmitPhoneNumber extends HttpServlet {
    private PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    private InternalMedicine internalMedicine = new InternalMedicine();
    private Surgery surgery = new Surgery();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String getInputPhoneNumber = request.getParameter("InputPhoneNumber");
        String getDateAndDepartment = request.getParameter("DateAndDepartment");
        String getOrderOrCancel = request.getParameter("OrderOrCancel");
        RequestDispatcher view;
        if (phoneNumberCheck.numberLegal(getInputPhoneNumber)) {
            if (getOrderOrCancel.equals("Order")) {   //预约模块
                if (getDateAndDepartment.equals("TI")) {
                    if (internalMedicine.getTomorrow()) { //内科明天有号
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TI"))) {
                            phoneNumberCheck.addUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TI"));
                            internalMedicine.setTomorrow(false);
                            view = request.getRequestDispatcher("OrderSucess.jsp");
                            view.forward(request, response);
                        } else {
                            request.setAttribute("submitDD", "TI");
                            request.setAttribute("OOC", "Order");
                            view = request.getRequestDispatcher("OrderPhoneNumberRepetition.jsp");
                            view.forward(request, response);
                        }
                    } else {
                        view = request.getRequestDispatcher("noOrderNumber.jsp");
                        view.forward(request, response);
                    }

                } else if (getDateAndDepartment.equals("TS")) {
                    if (surgery.getTomorrow()) {   //外科明天有号
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TS"))) {
                            phoneNumberCheck.addUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TS"));
                            surgery.setTomorrow(false);
                            view = request.getRequestDispatcher("OrderSucess.jsp");
                            view.forward(request, response);
                        } else {
                            request.setAttribute("submitDD", "TS");
                            request.setAttribute("OOC", "Order");
                            view = request.getRequestDispatcher("OrderPhoneNumberRepetition.jsp");
                            view.forward(request, response);
                        }
                    } else {
                        view = request.getRequestDispatcher("noOrderNumber.jsp");
                        view.forward(request, response);
                    }
                } else if (getDateAndDepartment.equals("TATI")) {
                    if (internalMedicine.getAfterTomorrow()) {//内科后天有号
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATI"))) {
                            phoneNumberCheck.addUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATI"));
                            internalMedicine.setAffterTomorrow(false);
                            view = request.getRequestDispatcher("OrderSucess.jsp");
                            view.forward(request, response);
                        } else {
                            request.setAttribute("submitDD", "TATI");
                            request.setAttribute("OOC", "Order");
                            view = request.getRequestDispatcher("OrderPhoneNumberRepetition.jsp");
                            view.forward(request, response);
                        }
                    } else {
                        view = request.getRequestDispatcher("noOrderNumber.jsp");
                        view.forward(request, response);
                    }

                } else if (getDateAndDepartment.equals("TATS")) {
                    if (surgery.getAfterTomorrow()) {  //外科后天有号
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATS"))) {
                            phoneNumberCheck.addUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATS"));
                            surgery.setAffterTomorrow(false);
                            view = request.getRequestDispatcher("OrderSucess.jsp");
                            view.forward(request, response);
                        } else {
                            request.setAttribute("submitDD", "TATS");
                            request.setAttribute("OOC", "Order");
                            view = request.getRequestDispatcher("OrderPhoneNumberRepetition.jsp");
                            view.forward(request, response);
                        }
                    } else {
                        view = request.getRequestDispatcher("noOrderNumber.jsp");
                        view.forward(request, response);
                    }
                }
            } else if (getOrderOrCancel.equals("Cancel")) {  //取消模块
                if (getDateAndDepartment.equals("TI")) {
                    if (internalMedicine.getTomorrow()) { //明天内科有号，也就是明天内科没有预约号码
                        view = request.getRequestDispatcher("noCancelError.jsp");
                        view.forward(request, response);
                    } else {
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TI"))) {//检查此号码没有预约过
                            request.setAttribute("submitDD", "TI");
                            request.setAttribute("OOC", "Cancel");
                            view = request.getRequestDispatcher("CancelError.jsp");
                            view.forward(request, response);
                        } else { //此号码预约过
                            phoneNumberCheck.removeUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TI"));
                            internalMedicine.setTomorrow(true);
                            view = request.getRequestDispatcher("CancelSucess.jsp");
                            view.forward(request, response);
                        }
                    }
                } else if (getDateAndDepartment.equals("TS")) {
                    if (surgery.getTomorrow()) { //明天外科有号，也就是明天外科没有预约号码
                        view = request.getRequestDispatcher("noCancelError.jsp");
                        view.forward(request, response);
                    } else {
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TS"))) {//检查此号码没有预约过
                            request.setAttribute("submitDD", "TS");
                            request.setAttribute("OOC", "Cancel");
                            view = request.getRequestDispatcher("CancelError.jsp");
                            view.forward(request, response);
                        } else { //此号码预约过
                            phoneNumberCheck.removeUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TS"));
                            surgery.setTomorrow(true);
                            view = request.getRequestDispatcher("CancelSucess.jsp");
                            view.forward(request, response);
                        }
                    }
                } else if (getDateAndDepartment.equals("TATI")) {
                    if (internalMedicine.getAfterTomorrow()) { //后天内科有号，也就是后天内科没有预约号码
                        view = request.getRequestDispatcher("noCancelError.jsp");
                        view.forward(request, response);
                    } else {
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATI"))) {//检查此号码没有预约过
                            request.setAttribute("submitDD", "TATI");
                            request.setAttribute("OOC", "Cancel");
                            view = request.getRequestDispatcher("CancelError.jsp");
                            view.forward(request, response);
                        } else { //此号码预约过
                            phoneNumberCheck.removeUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATI"));
                            internalMedicine.setAffterTomorrow(true);
                            view = request.getRequestDispatcher("CancelSucess.jsp");
                            view.forward(request, response);
                        }
                    }
                } else if (getDateAndDepartment.equals("TATS")) {
                    if (surgery.getAfterTomorrow()) { //后天内科有号，也就是后天内科没有预约号码
                        view = request.getRequestDispatcher("noCancelError.jsp");
                        view.forward(request, response);
                    } else {
                        if (phoneNumberCheck.checkUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATS"))) {//检查此号码没有预约过
                            request.setAttribute("submitDD", "TATS");
                            request.setAttribute("OOC", "Cancel");
                            view = request.getRequestDispatcher("CancelError.jsp");
                            view.forward(request, response);
                        } else { //此号码预约过
                            phoneNumberCheck.removeUserPhone(getInputPhoneNumber, phoneNumberCheck.getUserPhoneNumber("TATS"));
                            surgery.setAffterTomorrow(true);
                            view = request.getRequestDispatcher("CancelSucess.jsp");
                            view.forward(request, response);
                        }
                    }
                }
            }
        } else {
            if (getOrderOrCancel.equals("Order")) {
                if (getDateAndDepartment.equals("TI")) {
                    request.setAttribute("submitDD", "TI");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TS")) {
                    request.setAttribute("submitDD", "TS");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TATI")) {
                    request.setAttribute("submitDD", "TATI");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TATS")) {
                    request.setAttribute("submitDD", "TATS");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                }
            } else if (getOrderOrCancel.equals("Cancel")) {
                if (getDateAndDepartment.equals("TI")) {
                    request.setAttribute("submitDD", "TI");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TS")) {
                    request.setAttribute("submitDD", "TS");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TATI")) {
                    request.setAttribute("submitDD", "TATI");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                } else if (getDateAndDepartment.equals("TATS")) {
                    request.setAttribute("submitDD", "TATS");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumberError.jsp");
                    view.forward(request, response);
                }
            }
        }
    }
}
