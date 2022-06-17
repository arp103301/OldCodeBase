package Z.com.anup.designPatterns.observer;
//Read more: https://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz7WTvYBsmA
public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsPaper printMedia = new NewsPaper();
        Internet onlineMedia = new Internet();

        Loan personalLoan = new Loan("Personal Loan", 12.5f,
                     "Standard Charterd");
        personalLoan.registerObserver(printMedia);
        personalLoan.registerObserver(onlineMedia);
        personalLoan.setInterest(3.5f);



	}

}
