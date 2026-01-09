public abstract class Person {
    protected String id, name;
    public Person(String id, String name) { this.id = id; this.name = name; }
    public abstract void showRole();
}