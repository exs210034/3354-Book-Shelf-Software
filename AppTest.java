package Deliverable2.test_unit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static final String TEST_BOOKS_FILE = "test_books.txt";
    private BookTracker bookTracker;

    @BeforeEach
    public void setUp() {
        // Create a test file with sample book records
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_BOOKS_FILE))) {
            bw.write("Book 1:50\n");
            bw.write("Book 2:32\n");
            bw.write("Book 3:78\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Initialize the BookTracker instance with the test file path
        bookTracker = new BookTracker(TEST_BOOKS_FILE);
    }

    @Test
    public void testGetLastPage() {
        // Test the getLastPage method with various book titles
        assertEquals(50, bookTracker.getLastPage("Book 1"));
        assertEquals(32, bookTracker.getLastPage("Book 2"));
        assertEquals(78, bookTracker.getLastPage("Book 3"));
        assertEquals(-1, bookTracker.getLastPage("Nonexistent Book"));
    }
}
