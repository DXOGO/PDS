import java.util.List;
import java.util.ArrayList;


abstract class Subject<T>{
    protected List<Observer> observers = new ArrayList<>();
    protected T state;
    private long timeInAuction = 0;


    public void attach(Observer obs){
        observers.add(obs);
    }

    public void setState(T s){
        this.state = s;
        if(this.state == ProdutoState.AUCTION){
            this.timeInAuction = System.nanoTime(); 
        }else{
            this.timeInAuction = System.nanoTime() - this.timeInAuction;
        }
    };
}