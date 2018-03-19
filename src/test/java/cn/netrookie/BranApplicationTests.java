package cn.netrookie;

import cn.netrookie.Entity.Film;
import cn.netrookie.Entity.User;
import cn.netrookie.repository.FilmRepository;
import cn.netrookie.repository.UserRepository;
import cn.netrookie.service.FilmService;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BranApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmService filmService;

	private Logger logger = Logger.getLogger(BranApplicationTests.class);
	@Test
	public void contextLoads() {
	}
	@Test
	public void test() throws Exception {
		// 创建10条记录
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 30));
		userRepository.save(new User("DDD", 40));
		userRepository.save(new User("EEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));
		// 测试findAll, 查询所有
		Assert.assertEquals(10, userRepository.findAll().size());
		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge());
		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge());
		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());
		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));
		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());
	}

	@Test
	public void findTest(){
		List<User> jxl = userRepository.findAll();
		if(null == jxl){System.out.println("fffucdddk");}
		for(int i=0;i<jxl.size();i++){
			User user = jxl.get(i);
			if(null == user){System.out.println("fffuck");}
			System.out.println(user.getName()+"\t"+user.getAge());
		}
	}
	@Test
	public void insertTxt(){
		try{
			String URL_REGEX = "链接：http(s)?://pan.baidu.com/s/[0-9a-zA-Z_-]+ 密码：[0-9a-zA-Z_-]+";
			Pattern urlPattern = Pattern.compile(URL_REGEX);
			//Map<String,String> urlmap = new HashMap<String, String>();
			List<String> list =  IOUtils.readLines(BranApplicationTests.class.getResourceAsStream("/pan.txt"),"UTF-8");
			for(int i=0;i<list.size();i++){
				String str = list.get(i);
				if(!str.contains("链接")){continue;}
				String name = str.substring(0,str.indexOf("链")).replace(" ","").replace("：","").replace(":","") ;
				Matcher matcher = urlPattern.matcher(str);
				if (matcher.find()){
					if(filmRepository.findByName(name).isEmpty()){
						filmRepository.save(new Film(name,matcher.group()));
						System.out.println("此处插入 ： "+ name);
					}
				}
			}
		}catch(Exception e ){e.printStackTrace();}
	}
	@Test
	public void showall(){
		List<Film> list = filmService.getFilmList();
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++){
				logger.info(list.get(i).getName()+"   "+list.get(i).getUrl());
			}
		}
	}
}
