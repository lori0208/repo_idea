import com.zxz.dao.CourseMapper;
import com.zxz.dao.TestMapper;
import com.zxz.dao.UserMapper;
import com.zxz.domain.Course;
import com.zxz.domain.CourseVo;
import com.zxz.domain.Menu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName DaoTest
 * @Description TODO
 * @Creat 2021-12-30  10:20:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class DaoTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test() throws IOException {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        List<com.zxz.domain.Test> testList = testMapper.findAll();
        for (com.zxz.domain.Test test : testList) {
            System.out.println(test);
        }
    }

    @Test
    public void test01() throws IOException {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseName("大");
        courseVo.setStatus(1);
        List<Course> courseList = courseMapper.findByCondition(courseVo);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void test02(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        List<Menu> menuList = mapper.findParentMenuByRid(list);
        System.out.println(menuList);
    }

}
