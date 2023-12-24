package com.zaurtregulov.spring.AOP;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {
//    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }
}
