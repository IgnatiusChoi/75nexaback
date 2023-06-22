package kr.co.seoulit.account.sys.common.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class XplatformViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        System.out.println("xplatformviewResolver 실행");
        return (map, httpServletRequest, httpServletResponse) -> {};
    }
}
