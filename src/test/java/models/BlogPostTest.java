package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {

    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("B001")
                .authorId("P001")
                .postContent("This is a blog post.")
                .build();
        assertNotNull(post);
    }

    @Test
    void testBlogPostCreationWithNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BlogPost.builder().id(null).authorId("P001").postContent("Sample content").build()
        );
        assertEquals("ID cannot be null", exception.getMessage());
    }
}
