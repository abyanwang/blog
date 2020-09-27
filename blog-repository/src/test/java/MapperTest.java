import com.fuyu.domain.bo.BlogUserDO;
import com.fuyu.repository.BlogRepositoryApplication;
import com.fuyu.repository.mybatis.mapper.BlogUserDOMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogRepositoryApplication.class)
@Transactional
public class MapperTest {
    @Autowired
    private BlogUserDOMapper blogUserDOMapper;

    @Test
    public void test() {
        BlogUserDO userDO = new BlogUserDO();
        userDO.setUid(111L);
        userDO.setUserName("zz");
        userDO.setPassword("zz");
        userDO.setAvatar("xx");
        Assert.assertEquals(1, blogUserDOMapper.insertSelective(userDO));
    }
}
