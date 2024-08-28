package task12;

public class NumberPair {
    int value1;
    int value2;

    NumberPair(int n1, int n2){
        this.value1 = n1;
        this.value2 = n2;
    }

    public int getValue1(){
        return value1;
    }

    public int getValue2(){
        return value2;
    }

    @Override
    public String toString(){
        return "Number Pair (" + value1 + " " + value2 + ")";
    }
}
