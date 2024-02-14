import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/*
* Задание 2.
* У вас есть класс BookService, который использует интерфейс BookRepository для получения информации
* о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания
* мок-объекта BookRepository.
*/

class BookServiceTest {

    BookRepository mockBookRepository;
    BookService bookService;

    @BeforeEach
    void setUp() {
        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    void correctFindBookById() {
        Book book = new Book("1");
        when(mockBookRepository.findById(anyString())).thenReturn(book);

        Book result = bookService.findBookById(anyString());

        assertThat(result).isEqualTo(book);
    }

    @Test
    void correctFindAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1", "Book1", "Author1"));
        bookList.add(new Book("2", "Book2", "Author2"));
        when(mockBookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.findAllBooks();

        assertThat(result).isEqualTo(bookList);
    }
}