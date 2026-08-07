package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfigurationfile;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationfile.class);
        
        Student std = (Student)context.getBean("stdId1");
        std.display();
        
        System.out.println("-----------------------");
        
        Student std1 = context.getBean(Student.class);
        std1.display();
    }
}
