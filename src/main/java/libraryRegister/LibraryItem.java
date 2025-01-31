package libraryRegister;

public abstract class LibraryItem {
    private static int counter = 1;
    private final int inventoryNumber;
    private final String title;
    private final String author;

    public LibraryItem(String title, String author) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым.");
        }

        this.inventoryNumber = counter++;
        this.title = title;
        this.author = author;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return  "Инвентарный номер: " + inventoryNumber +
                ", Название: " + title +
                ", Автор: " + author;
    }
}