package LLoydsInterviewQuestions;

public class Problem2 {
    public static void main(String[] ar) {
        new B().go();
    }
}

class A {
    public String type = "A";

    A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    B() {
        System.out.println("B constructor");
    }

    String type = "B";

    void go() {
        System.out.println(this.type+"  "+super.type);
    }
}


/*
A constructor
B constructor
B  A
 */