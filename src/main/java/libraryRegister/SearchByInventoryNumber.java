package libraryRegister;

import java.util.Optional;

public interface SearchByInventoryNumber {
    Optional<LibraryItem> searchByInventoryNumber(int inventoryNumber);
}

