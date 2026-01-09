public class Member extends Person {
    public Member(String id, String name) { super(id, name); }
    @Override
    public void showRole() { System.out.println("Member: " + name); }
}