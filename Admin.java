public class Admin extends Person {
    private String shift;
    public Admin(String id, String name, String shift) { super(id, name); this.shift = shift; }
    @Override
    public void showRole() { System.out.println("Admin: " + name + " | Shift: " + shift); }
}