package models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> contributors.stream()
                        .anyMatch(person -> person.getId().equals(post.getAuthorId()) && person.getAge().equals(age)))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
