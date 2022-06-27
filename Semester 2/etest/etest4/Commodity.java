package programming2test.etest4;

public class Commodity extends MyAssets implements Portfolio{
    public int totalShares;

    public Commodity(String symbol, double curPrice)
    {
        super(symbol, curPrice);
    }

    public void purchase(int share, double price){
        this.totalShares = share;
        totalCost = share * price;
    }

    public void setCurrentPrice(double price){
        this.curPrice = price;
    }

    @Override
    public String toString(){
        return this.symbol + " ( " + this.totalShares + " shares, $ "
                + this.totalCost + "0" + " total cost )";//reset the output line
    }

    public double marketVal(){
        return this.curPrice * totalShares;
    }

    @Override
    public double profit(){
        return super.curPrice * this.totalShares - this.totalCost;
    }


}
