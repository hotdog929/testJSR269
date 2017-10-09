package hd929;

import hd929.TestAnnotation;

@TestAnnotation("Main Class")
public class Main {

    public static void main(String args[]) {
        new Main();
    }

    @TestAnnotation("Main Class Constructor")
    public Main() {

    }

    @TestAnnotation("Main Class echo")
    public String echo(String msg) {
        return "Main : " + msg;
    }
}