package kr.bit.controller;

import kr.bit.model.MyCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc.do")
// servlet 은 controller 역할을 담당한다.
public class CalcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 클라이언트에서 넘어오는 폼 파라메터를 받기(파라메터 수집, su1, su2)
        int su1 = Integer.parseInt(req.getParameter("su1"));
        int su2 = Integer.parseInt(req.getParameter("su2"));

        // su1 ~ su2 = ?
        // 비즈니스 로직을 model 에 따로 분리
        // int sum = 0;
        // for (int i = su1; i < su2; i++) {
        // sum += i;
        // }
        MyCalc my = new MyCalc();
        int sum = my.hap(su1, su2);

        // 응답하는 부분을(프레젠테이션 로직 = View = JSP) JSP 로 따로 분리
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>TOTAL</td>");
        out.println("<td>");
        out.println(sum);
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
