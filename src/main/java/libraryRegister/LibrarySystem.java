package libraryRegister;

import java.util.Optional;

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        // Создаю и добавляю элементы
        catalog.addItem(new Book("Война и мир", "Лев Толстой"));
        catalog.addItem(new Book("Преступление и наказание", "Фёдор Достоевский"));
        catalog.addItem(new Magazine("Мурзилка", "Редакция"));
        catalog.addItem(new Letter("Письмо другу", "Антон Чехов"));
        catalog.addItem(new Microfilm("Секретный архив", "Неизвестный"));

        // Попытка добавления пустого объекта
        try {
            catalog.addItem(new Book("", ""));
        } catch (IllegalArgumentException e){
            System.out.println("\nОшибка при добавлении книги, название и автор не могут быть пустыми");;
        }

        // Поиск по автору
        System.out.println("\nПоиск по автору Лев Толстой:");
        catalog.searchByAuthor("Лев Толстой").forEach(System.out::println);

        // Поиск по пустому автору
        System.out.println("\nПоиск по пустому автору: ");
        catalog.searchByAuthor("").forEach(System.out::println);

        // Поиск по несуществующему автору
        System.out.println("\nПоиск по автору Сергей Есенин:");
        catalog.searchByAuthor("Сергей Есенин");

        // Поиск по инвентарному номеру
        System.out.println("\nПоиск по инвентарному номеру 5:");
        Optional<LibraryItem> item = catalog.searchByInventoryNumber(5);
        if (item.isPresent()) {
            System.out.println(item.get());
        } else {
            System.out.println("Ничего не найдено.");
        }

        // Попытка поиска по некорректному инвентарному номеру
        System.out.println("\nПоиск по инвентарному номеру -1:");
        catalog.searchByInventoryNumber(-1);
    }
}
