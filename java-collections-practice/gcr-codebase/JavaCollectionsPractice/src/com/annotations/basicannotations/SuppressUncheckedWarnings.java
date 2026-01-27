package com.annotations.basicannotations;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add(10);
        list.add("Hello");
        list.add(3.14);

        System.out.println(list);
    }
}

