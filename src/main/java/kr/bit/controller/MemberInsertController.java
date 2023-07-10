package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 깨짐 현상이 있을 경우 추가
        req.setCharacterEncoding("utf-8");
        // 1. 파라메터 수집(VO)
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

//        new MemberVO(String id, String pass, String name, int age, String email, String phone);
        // 가장 기본적인 파라미터 수집 방식이다.
        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPass(pass);
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        // System.out.println(vo); // vo.toString()
        // Model 과 연동부분
        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberInsert(vo);
        PrintWriter out = resp.getWriter();
        if (cnt > 0) {
            // 가입 성공
            out.println("insert success");
        }
        // 가입 실패 -> 예외객체를 만들어서 WAS 에게 던지자.
        throw new ServletException("not insert");
    }
}
