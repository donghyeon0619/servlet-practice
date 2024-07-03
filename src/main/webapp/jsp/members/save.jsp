<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%--  <%@ page import="hello.servlet.domain.member.MemberRepository" %>는 자바의 import문 과 같음 --%>
<%--
  Created by IntelliJ IDEA.
  User: YoonDongHyeon
  Date: 2024-07-03
  Time: 오전 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <% ~~ %>는 자바 코드를 넣을 수 있음 --%>
<%
  // request, response 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  System.out.println("member = " + member);
  memberRepository.save(member);
%>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
성공
<%-- <%= ~~ %>  이 부분에는 자바 코드를 출력할 수 있다.--%>
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
