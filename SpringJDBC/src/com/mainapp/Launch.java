package com.mainapp;

import com.repository.Crud;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        Crud crud = (Crud) ac.getBean("crud");

        //crud.insert(11, "foo");

        //crud.update(11, "koo");

        //crud.delete(11);

        //crud.readAllDefault();

        //crud.readAllPojo();

        crud.readSingleRecord(11);

    }
}
