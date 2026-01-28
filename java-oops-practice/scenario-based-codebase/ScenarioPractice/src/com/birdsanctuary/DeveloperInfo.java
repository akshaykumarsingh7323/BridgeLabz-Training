package com.birdsanctuary;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DeveloperInfo {
    String developer();
    String version();
}

