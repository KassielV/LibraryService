import java.util.*;

public class LibraryService {

    private static Map<Long, Book> books = new HashMap<>();
    private static Map<Long, User> users = new HashMap<>();
    private static Map<User, List<Book>> userBorrowedBooks = new HashMap<>();

    public static void setBooks(Long bookId, Book book) {
        LibraryService.books.put(bookId, book);
    }

    public static void setUsers(Long userId, User user) {
        LibraryService.users.put(userId, user);
    }

    public static Map<User, List<Book>> getUserBorrowedBooks() {
        return userBorrowedBooks;
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public static List<Object> getAllAvailableBooks() {
        Set<Map.Entry<Long, Book>> set = books.entrySet();
        Object[] array = set.stream().filter(Book -> Book.getValue().isAvailable()).toArray();
        List<Object> list = Arrays.asList(array);
        return new ArrayList<>(list);
    }

    public static List<Book> getUserBooks(String userId) {
        Long along = Long.parseLong(userId);
        Set<Map.Entry<User, List<Book>>> set = userBorrowedBooks.entrySet();
        for (Map.Entry<User, List<Book>> longUserEntry : set) {
            if (longUserEntry.getKey().getUserId().equals(along)) {
               return longUserEntry.getValue();
            }
        }
        return null;
    }

    public static void takeBook(Long userId, Long bookId) {
        Set<Map.Entry<Long, Book>> set = books.entrySet();
        Set<Map.Entry<Long, User>> set1 = users.entrySet();
        List<Map.Entry<Long, Book>> list = set.stream().filter(Book -> !Book.getValue().isAvailable()).toList();
        for (Map.Entry<Long, Book> longBookEntry : list) {
            for (Map.Entry<Long, User> longUserEntry : set1) {
                if (longUserEntry.getValue().getUserId().equals(userId) && longBookEntry.getValue().getBookId().equals(bookId)) {
                    return;
                }
            }
        }
        for (Map.Entry<Long, Book> longBookEntry : set) {
            for (Map.Entry<Long, User> longUserEntry : set1) {
                if (longBookEntry.getValue().getBookId().equals(bookId) && longUserEntry.getValue().getUserId().equals(userId)) {
                    longBookEntry.getValue().setAvailable(false);
                    longUserEntry.getValue().getBorrowedBooks().add(longBookEntry.getValue());
                    userBorrowedBooks.put(longUserEntry.getValue(), longUserEntry.getValue().getBorrowedBooks());
                }
            }
        }
    }
    public static void returnBook(String userId, String bookId) {
        Set<Map.Entry<Long, Book>> set = books.entrySet();
        Set<Map.Entry<Long, User>> set1 = users.entrySet();
        for (Map.Entry<Long, Book> longBookEntry : set) {
            for (Map.Entry<Long, User> longUserEntry : set1) {
                if (longBookEntry.getValue().getBookId().equals(Long.parseLong(bookId)) && longUserEntry.getValue().getUserId().equals(Long.parseLong(userId))) {
                    longBookEntry.getValue().setAvailable(true);
                    longUserEntry.getValue().getBorrowedBooks().remove(longBookEntry.getValue());
                    userBorrowedBooks.replace(longUserEntry.getValue(), longUserEntry.getValue().getBorrowedBooks());
                }
            }
        }
    }
}
