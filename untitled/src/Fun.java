
public class Fun {

    private Double Val;
    private  Double val2;

    double VatPriceFuncton(double val, double val2){

        this.Val=val;
        this.val2=val2;
        double total;

        total=val*(100+val2)/100;
        System.out.println(total);

        return total;
    }





}
