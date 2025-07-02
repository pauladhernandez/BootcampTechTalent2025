package com.hellospring.app;

import com.hellospring.model.Mensaje;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Mensaje m = context.getBean("mensaje", Mensaje.class);
        m.saludar();
    }
}