package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = null;
        List<BlogPost> blogPosts = null;

        try {
            people = objectMapper.readValue(new File("person.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            blogPosts = objectMapper.readValue(new File("blogPosts.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, BlogPost.class));
        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
            return;
        }

        Blog blog = Blog.builder()
                .posts(blogPosts)
                .contributors(people)
                .build();

        Integer ageToSearch = 30; // Example age to search
        List<String> postIds = blog.getPostsByAuthorAge(ageToSearch);
        System.out.println("Blog Posts by Author with Age " + ageToSearch + ": " + postIds);

        System.out.println("Total blog posts: " + blogPosts.size());
        System.out.println("Total contributors: " + people.size());
    }
}
