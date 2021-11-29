import dao.impl.StudentDao;
import entity.Student;
import org.junit.Test;

public class StudentDaoTest {
    StudentDao sdao=new StudentDao();
    @Test
    public void test(){
        StudentDao user=new StudentDao();
        user.Login("小明","2999");
        user.getAll();
    }
}
