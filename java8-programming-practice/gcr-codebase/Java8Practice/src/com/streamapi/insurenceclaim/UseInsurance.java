package com.streamapi.insurenceclaim;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UseInsurance {

    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("C101", "Health", 200000),
                new InsuranceClaim("C102", "Health", 300000),
                new InsuranceClaim("C103", "Vehicle", 150000),
                new InsuranceClaim("C104", "Vehicle", 250000),
                new InsuranceClaim("C105", "Life", 800000),
                new InsuranceClaim("C106", "Life", 600000)
        );

        InsuranceClaimService service = new InsuranceClaimService();
        Map<String, Double> averageClaims = service.getAverageClaimAmountByType(claims);

        averageClaims.forEach((type, avg) ->
                System.out.println(type + " Average Claim Amount = " + avg)
        );
    }
}
