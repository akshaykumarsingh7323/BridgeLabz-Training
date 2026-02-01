package com.streamapi.filteringexpiringmembership;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class GymMember {
    String name;
    LocalDate expiryDate;

    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

