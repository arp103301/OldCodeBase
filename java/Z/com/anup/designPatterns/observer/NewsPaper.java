package Z.com.anup.designPatterns.observer;

public class NewsPaper implements Observer {
    @Override
    public void update(float interest) {
           System.out.println("Newspaper: Interest Rate updated, new Rate is: "
                        + interest);
    }
}


//Read more: https://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz7WTvEh7R4

