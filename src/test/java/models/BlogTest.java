package models;

import models.Blog;
import models.BlogPost;
import models.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class BlogTest {

    @Test
    void testGetPostsByAuthorAgeWithValidAge() {
        Person person = Person.builder().id("P001").firstName("John").lastName("Doe").age(30).gender("Male").build();
        BlogPost post = BlogPost.builder().id("B001").authorId("P001").postContent("Content").build();

        Blog blog = Blog.builder()
                .posts(Arrays.asList(post))
                .contributors(Arrays.asList(person))
                .build();

        List<String> postIds = blog.getPostsByAuthorAge(30);
        assertEquals(1, postIds.size());
        assertEquals("B001", postIds.get(0));
    }

    @Test
    void testGetPostsByAuthorAgeWithNoMatchingAge() {
        Person person = Person.builder().id("P001").firstName("John").lastName("Doe").age(30).gender("Male").build();
        BlogPost post = BlogPost.builder().id("B001").authorId("P001").postContent("Content").build();

        Blog blog = Blog.builder()
                .posts(Arrays.asList(post))
                .contributors(Arrays.asList(person))
                .build();

        List<String> postIds = blog.getPostsByAuthorAge(25); // Age doesn't match
        assertEquals(0, postIds.size());
    }

    @Test
    void testGetPostsByAuthorAgeWithMissingAuthor() {
        Person person = Person.builder().id("P001").firstName("John").lastName("Doe").age(30).gender("Male").build();
        BlogPost post = BlogPost.builder().id("B001").authorId("P002").postContent("Content").build(); // Author ID doesn't match

        Blog blog = Blog.builder()
                .posts(Arrays.asList(post))
                .contributors(Arrays.asList(person))
                .build();

        List<String> postIds = blog.getPostsByAuthorAge(30);
        assertEquals(0, postIds.size());
    }

    @Test
    void testGetPostsByAuthorAgeWithEmptyData() {
        Blog blog = Blog.builder()
                .posts(Arrays.asList())
                .contributors(Arrays.asList())
                .build();

        List<String> postIds = blog.getPostsByAuthorAge(30);
        assertEquals(0, postIds.size());
    }
}
