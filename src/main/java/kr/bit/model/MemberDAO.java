package kr.bit.model;

import java.sql.*;

public class MemberDAO {
    // JDBC -> myBatis, JPA
    // 초반만 JDBC 를 쓰고 나중에 다른걸로 넘어갈거임
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // 데이터베이스 연결객체 생성
    public void getConnect() {
        // 데이터베이스 접속 URL
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Dksrudwo1!!";

        // MySQL Driver Loading
        try {
            // DriverManager driver = new com.mysql.jdbc.Driver();
            // 동적 로딩(실행지점에서 객체를 생성하는 방법)
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제가 발생" + e.getMessage());
            e.printStackTrace();
        }
    }
    // 회원저장 동작
    public int memberInsert(MemberVO vo) {
        String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
        getConnect();
        // SQL 문장을 전송하는 객체 생성
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL); // 미리 컴파일을 시킨다.
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPass());
            ps.setString(2, vo.getName());
            ps.setInt(3, vo.getAge());
            ps.setString(4, vo.getEmail());
            ps.setString(5, vo.getPhone());

            // 전송(실행)
            cnt = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt; // 1 or 0
    }
}
