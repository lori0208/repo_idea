import com.zxz.dao.CourseMapper;
import com.zxz.domain.Course;
import com.zxz.service.CourseService;
import com.zxz.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName ServiceTest
 * @Description TODO
 * @Creat 2021-12-30  10:59:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class ServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void test01(){

        List<Course> courseList = courseService.findByCondition(null);
        for (Course course : courseList) {
            System.out.println(courseList);
        }
    }
}
