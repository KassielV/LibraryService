public final class Book {
    private final String title;
    private final String author;
    private final int year;
    private final Long bookId;
    private boolean isAvailable;

    public Book(String title, String author, int year, Long bookId) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookId = bookId;
        isAvailable = true;
        LibraryService.setBooks(bookId, this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Long getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
