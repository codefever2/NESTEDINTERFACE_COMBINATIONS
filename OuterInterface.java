public interface OuterInterface
{
    public void outerMsg();
    interface InnerInterface
    {
        public void msg1();
         default void msg()
        {
            System.out.println("inner interfacev is called");
        }
    }
}
interface ClassInsideInterface
{
    public class C
    {
        public void nsg()
        {
            System.out.println("class inside interface method is called");
        }
    }
}
class A
{
    interface B
    {
        public void Bm1();
    }
}
class Main extends ClassInsideInterface.C implements OuterInterface.InnerInterface, A.B, OuterInterface
{
    @Override
    public void nsg() {
        System.out.println("nsg from class inside interface is called");
    }

    @Override
    public void outerMsg() {
        System.out.println("outer interface method is called");
    }

    @Override
    public void msg1()
    {
        System.out.println("msg1 is overriden");
    }

    @Override
    public void Bm1() {
        System.out.println("Nested interface method  inside a class is called");
    }

    public static void main(String[] args)
    {
        OuterInterface.InnerInterface inner = new Main();
        inner.msg();
        inner.msg1();
        A.B b = new Main();
        ClassInsideInterface.C classes = new Main();
        classes.nsg();
    }

}

