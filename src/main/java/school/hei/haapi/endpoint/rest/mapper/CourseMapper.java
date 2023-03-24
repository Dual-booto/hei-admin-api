package school.hei.haapi.endpoint.rest.mapper;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.CrupdateCourse;
import school.hei.haapi.model.User;
import school.hei.haapi.repository.CourseRepository;
import school.hei.haapi.repository.UserRepository;

@Component
@AllArgsConstructor
public class CourseMapper {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CourseRepository courseRepository;

    public Course toRest(school.hei.haapi.model.Course domain) {
        return new Course()
                .id(domain.getId())
                .code(domain.getCode())
                .name(domain.getName())
                .credits(domain.getCredits())
                .totalHours(domain.getTotalHours())
                .mainTeacher(userMapper.toRestTeacher(domain.getMainTeacher()));
    }

}
