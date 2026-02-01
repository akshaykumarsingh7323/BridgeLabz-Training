package com.foreach.loggingtransaction;

import java.time.LocalDateTime;
import java.util.*;

public class LoggingTransaction {
	public static void main(String[] args) {
		List<Number> transactions = Arrays.asList(1212, 3223, 4342, 2322, 4532, 1233, 6435);
		transactions.forEach(transaction -> System.out.println(LocalDateTime.now() + " Rs " + transaction));
	}
}
