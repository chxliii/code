//public class Test {
//    public static void main(String[] args) {
//        System.out.print(B.c);
//    }
//}
//
//class A {
//    static {
//        System.out.print("A");
//    }
//}
//
//class B extends A{
//    static {
//        System.out.print("B");
//    }
//    public final static String c = "C";
//}

//public class Test {
//
//    public static void main(String[] args) {
//        System.out.println(Test2.a);
//    }
//
//}
//class Test2{
//    static {
//        System.out.print("OK");
//    }
//
//    public static final String a=new String("JD");
//
//}

//public class Test {
//
//    public static void main(String[] args) {
//        System.out.println(Test2.a);
//    }
//
//}
//class Test2{
//    public static final String a=new String("JD");
//
//    static {
//        System.out.print("OK");
//    }
//
//}

//public class Test {
//
//    public static void main(String[] args) {
//        System.out.println(Test2.a);
//    }
//
//}
//class Test2{
//    public static final String a="JD";
//
//    static {
//        System.out.print("OK");
//    }
//
//}

public class Test {

    public static void main(String[] args) {
        System.out.println("A");
        new Test();
        new Test();
    }

    public Test() {
        System.out.println("B");
    }

    {
        System.out.println("C");
    }

    static {
        System.out.println("D");
    }
}