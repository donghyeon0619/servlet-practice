package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {


    private ObjectMapper objectMapper = new ObjectMapper();
    @Override

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // json형식으로 보낼때는 필요함 (스프링에서는 알아서 해주긴함)
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("yoon");

        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
