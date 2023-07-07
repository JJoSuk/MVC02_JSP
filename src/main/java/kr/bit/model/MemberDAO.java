package kr.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    // JDBC -> myBatis, JPA
    // 초반만 JDBC 를 쓰고 나중에 다른걸로 넘어갈거임
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
}
