package com.functionalinterface.defaultmethod.paymentgatewayintegration;

public class UsePaymentGateway {

    public static void main(String[] args) {

        PaymentProcessor upi = new UpiProcessor();
        PaymentProcessor card = new CardProcessor();
        PaymentProcessor wallet = new WalletProcessor();

        upi.pay(500);
        upi.refund(200);     

        card.pay(1000);
        card.refund(300);   

        wallet.pay(700);
        wallet.refund(400); 
    }
}
