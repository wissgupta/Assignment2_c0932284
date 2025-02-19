package models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;
}
