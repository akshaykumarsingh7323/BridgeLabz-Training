package com.streamapi.insurenceclaim;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

class InsuranceClaimService {

    public Map<String, Double> getAverageClaimAmountByType(List<InsuranceClaim> claims) {
        return claims.stream()
                .collect(Collectors.groupingBy(
                        InsuranceClaim::getClaimType,
                        Collectors.averagingDouble(InsuranceClaim::getAmount)
                ));
    }
}