import java.util.ArrayList;
import java.util.List;

public final class User {
    private final String name;
    private final int age;
    private final Long userId;
    private List<Book> borrowedBooks;

    public User(String name, int age, Long userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
        borrowedBooks = new ArrayList<>();
        LibraryService.setUsers(userId, this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return name;
    }
}
