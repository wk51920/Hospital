package web;

import model.*;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by wk_51920 on 2014/11/15.
 */
public class OrderServlet extends HttpServlet {
    private OrderControl orderControl = new OrderControl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getParameter("year"));
        sb.append("-");
        sb.append(request.getParameter("month"));
        sb.append("-");
        sb.append(request.getParameter("day"));
        String inputDate = sb.toString();
        String inputDepartment = request.getParameter("department");
        String orderOrCancel = request.getParameter("OrderOrCancel");
        RequestDispatcher view;
        if (orderOrCancel.equals("Order")) { //选择预约
            switch (orderControl.haveOrder(inputDate, inputDepartment)) {
                case 1:
                    request.setAttribute("DateAndDepartment", "TI");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 2:
                    view = request.getRequestDispatcher("noOrderNumber.jsp");
                    view.forward(request, response);
                    break;
                case 3:
                    request.setAttribute("DateAndDepartment", "TS");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 4:
                    view = request.getRequestDispatcher("noOrderNumber.jsp");
                    view.forward(request, response);
                    break;
                case 5:
                    request.setAttribute("DateAndDepartment", "TATI");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 6:
                    view = request.getRequestDispatcher("noOrderNumber.jsp");
                    view.forward(request, response);
                    break;
                case 7:
                    request.setAttribute("DateAndDepartment", "TATS");
                    request.setAttribute("OOC", "Order");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 8:
                    view = request.getRequestDispatcher("noOrderNumber.jsp");
                    view.forward(request, response);
                    break;
                case 9:
                    view = request.getRequestDispatcher("DateError.jsp");
                    view.forward(request, response);
                    break;
            }
        }else if(orderOrCancel.equals("Cancel"))   //选择取消预约
        {
            switch (orderControl.haveOrder(inputDate, inputDepartment)) {
                case 1:
                case 2:
                    request.setAttribute("DateAndDepartment", "TI");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 3:
                case 4:
                    request.setAttribute("DateAndDepartment", "TS");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 5:
                case 6:
                    request.setAttribute("DateAndDepartment", "TATI");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 7:
                case 8:
                    request.setAttribute("DateAndDepartment", "TATS");
                    request.setAttribute("OOC", "Cancel");
                    view = request.getRequestDispatcher("InputPhoneNumber.jsp");
                    view.forward(request, response);
                    break;
                case 9:
                    view = request.getRequestDispatcher("DateError.jsp");
                    view.forward(request, response);
                    break;
            }
        }
    }
}
