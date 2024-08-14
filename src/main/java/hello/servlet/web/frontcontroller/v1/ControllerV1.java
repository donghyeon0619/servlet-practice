package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 다형성을 활용하기 위한 컨트롤러 인터페이스 구현
 * */

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
