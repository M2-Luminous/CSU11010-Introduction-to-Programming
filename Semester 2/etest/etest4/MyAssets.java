package programming2test.etest4;

public abstract class MyAssets implements Portfolio{
        public String symbol;
        public double totalCost;
        public double curPrice;

        public abstract double profit();

        public MyAssets(String symbol , double curPrice)
        {
            this.symbol = symbol;
            this.curPrice = curPrice;
        }

        public void  purchase(int share , double price){
            totalCost = share * price;
        }

    }

