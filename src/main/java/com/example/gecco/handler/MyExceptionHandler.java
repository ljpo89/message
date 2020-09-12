//package com.example.gecco.handler;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@ControllerAdvice
//public class MyExceptionHandler {
//    public static final String IMOOC_ERROR_VIEW = "error";
//
//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest reqest,
//                               HttpServletResponse response, Exception e) throws Exception {
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("exception", e);
//            mav.addObject("url", reqest.getRequestURL());
//            mav.setViewName(IMOOC_ERROR_VIEW);
//            return mav;
//    }
//}
