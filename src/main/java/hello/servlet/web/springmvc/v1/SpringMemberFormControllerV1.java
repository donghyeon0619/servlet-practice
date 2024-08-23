package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 스프링 부트 3.0(스프링 프레임워크 6.0) 부터는 클래스 레벨에 @RequestMapping이 있어도
 * 스프링 컨트롤러로 인식하지 않음
 * 오직 @Controller가 있어야지 스프링 컨트롤러로 인식하므로 예전 코드처럼 클래스 레벨에
 * @RequestMapping만으로는 Spring컨트롤러로 인식하지 않음
 * */
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
