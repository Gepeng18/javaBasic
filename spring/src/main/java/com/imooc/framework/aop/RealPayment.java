package interview.framework.aop;

public class RealPayment implements Payment {
    @Override
    public void pay(){
        System.out.println("作为用户，我只关心支付功能");
    }
}
