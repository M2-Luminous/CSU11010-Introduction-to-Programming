package programming2test.etest4;

public class Currency implements Portfolio{
    public double amount;


    public Currency(double amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Case ( $ " + this.amount + "0" + " )";//reset the output line
    }

    public double marketVal(){
        return amount;
    }

    public double profit(){
        return 0.0;
    }


}
