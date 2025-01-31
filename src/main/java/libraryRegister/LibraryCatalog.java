package libraryRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryCatalog implements ObjectSearchService {
    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить пустой объект.");
        }
        items.add(item);
    }

    @Override
    public List<LibraryItem> searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Ошибка: Автор не может быть пустым.");
            return List.of(); // Возвращаем пустой список
        }

        List<LibraryItem> foundItems = items.stream()
                .filter(item -> item.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        if (foundItems.isEmpty()) {
            System.out.println("Объекты автора \"" + author + "\" не найдены.");
        }
        return foundItems;
    }

    @Override
    public Optional<LibraryItem> searchByInventoryNumber(int inventoryNumber) {
        if (inventoryNumber <= 0) {
            System.out.println("Ошибка: Инвентарный номер должен быть положительным числом.");
            return Optional.empty();
        }

        return items.stream()
                .filter(item -> item.getInventoryNumber() == inventoryNumber)
                .findFirst()
                .or(() -> {
                    System.out.println("Объект с инвентарным номером " + inventoryNumber + " не найден.");
                    return Optional.empty();
                });
    }
}
