package kr.co.seoulit.account.sys.common.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import kr.co.seoulit.account.sys.common.interceptor.LoggerInterceptor;

import javax.servlet.Filter;
import java.nio.charset.Charset;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    LoggerInterceptor loggerInterceptor;
    XplatformInterceptor xplatformInterceptor;

    //인터셉터 관련
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("WebMvcConfig 실행");
        System.out.println("로그인터셉터, 엑플인터셉터, 컨트롤러 전에 실행 (common>configuration>WebMvcConfig.java)");
        //위에서 생성한 interceptor 등록.
//        registry.addInterceptor(loggerInterceptor);
//        registry.addInterceptor(xplatformInterceptor);

		registry.addInterceptor(new LoggerInterceptor())
		.excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");
		registry.addInterceptor(new XplatformInterceptor()).excludePathPatterns("/error");
        //기존에 있던 로그인 인터셉터 - 비교를 위해 그냥 둠.
        //registry.addInterceptor(new LoginInterceptor())
        //       .addPathPatterns("/*")
        //       .addPathPatterns("/*/*.html")
        //       .excludePathPatterns("/hr/empinsertForm.html")
        //       .excludePathPatterns("/loginForm.html")
        //       .excludePathPatterns("/*login*")
        //       .excludePathPatterns("/*logout*")
        //       .excludePathPatterns("/*/hello*");
        //registry.addInterceptor(new LoggerInterceptor());   //로깅 인터셉터
        //WebMvcConfigurer.super.addInterceptors(registry);

    }
    /**
     * View Resolver 경로 설정
     */
//  @Override
// public void configureViewResolvers(ViewResolverRegistry registry) {
// registry.jsp("/WEB-INF/", ".jsp");
//   }
//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
    /**
     * 루트 "/" 접속시 index 페이지로 포워딩
     */
//    @Override
//    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
//    public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/").setViewName("forward:/index.html");
//    }
//  
//    /**
//     * Web Resource 경로 설정
//     */
//    @Override
//    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//      registry.addResourceHandler("/_resource_/**").addResourceLocations("classpath:/_resource_/");
//      registry.addResourceHandler("/FrameBase/**").addResourceLocations("classpath:/FrameBase/");
//      registry.addResourceHandler("/nexacro17lib/**").addResourceLocations("classpath:/nexacro17lib/");
//      registry.addResourceHandler("/*.json").addResourceLocations("classpath:/");
//      registry.addResourceHandler("/*.html").addResourceLocations("classpath:/");
//      registry.addResourceHandler("/*.js").addResourceLocations("classpath:/");
//    } 
    //파일 인코딩 설정, 업로드 되는 파일 크기 제한
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("UTF-8");
//        commonsMultipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024);
//        return commonsMultipartResolver;
//
//    }
//
//    // 2개의 빈은 인코딩 관련.
//    @Bean
//    public Filter characterEncodingFilter() {
//
//        //CharacterEncodingFilter는 스프링이 제공하는 클래스로 웹에서 주고받는 데이터의 헤더값을 UTF-8로 인코딩 해줌.
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);  //기본값은 false로 설정되어 있음.
//
//        return characterEncodingFilter;
//    }
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//
//        //StringHttpMessageConverter는 @ResponseBody를 이용하여 결과를 출력할 때 결과를 UTF-8 로 설정함.
//        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") .allowedOrigins("*");
    }

}
