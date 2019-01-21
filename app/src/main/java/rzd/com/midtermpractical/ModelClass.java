package rzd.com.midtermpractical;

import java.io.Serializable;

public class ModelClass implements Serializable {
    private String CustomerName;
    private String ServerName;
    private float PaymentAmount;
    private float TipPercentage;
    private float TipTotal;

    public float getTipPercentage() {
        return TipPercentage;
    }

    public void setTipPercentage(float tipPercentage) {
        TipPercentage = tipPercentage;
    }

    public ModelClass(){}
    public ModelClass(String CustomerName, String ServerName, float PaymentAmount){
        this.CustomerName = CustomerName;
        this.ServerName = ServerName;
        this.PaymentAmount = PaymentAmount;
    }
    public ModelClass(String CustomerName, String ServerName, float PaymentAmount, float TipPercentage, float TipTotal){
        this.CustomerName = CustomerName;
        this.ServerName = ServerName;
        this.PaymentAmount = PaymentAmount;
        this.TipPercentage = TipPercentage;
        this.TipTotal = TipTotal;
    }
    public ModelClass(float PaymentAmount){
        this.PaymentAmount = PaymentAmount;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getServerName() {
        return ServerName;
    }

    public void setServerName(String serverName) {
        ServerName = serverName;
    }

    public float getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        PaymentAmount = paymentAmount;
    }


    public float getTipTotal() {
        return TipTotal;
    }

    public void setTipTotal(float tipTotal) {
        TipTotal = tipTotal;
    }
}
