package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 /jsp파일에 /servlet-mvc/members/save라는 경로에 파일이 없지만
 /이미 앞에 form controller에서 /servlet-mvc/members/new-form에서 상대경로로 /servlet-mvc/members/save 로 액션을 취하게 하므로 
 / 이 컨트롤러로 올수 있음
 */
@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 비즈니스 로직 
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        // 모델에 데이터를 보낸다.
        request.setAttribute("member", member);
        String viewPath = "/WEB-INF/views/save-result.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
