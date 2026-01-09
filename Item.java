public abstract class Item {
    protected String title;
    public Item(String title) { this.title = title; }
    public abstract void displayInfo();
    public String getTitle() { return title; }
}