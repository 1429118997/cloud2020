import com.cloud.IdSnowFlakeFlUntils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
public class test {

    @Value("${mybatis.mapper-locations}")
    public String mapperLocations;

    @Autowired
    public IdSnowFlakeFlUntils idSnowFlakeFlUntils;

    @Test
    public void config(){
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for (int i=0;i<20;i++){
            executorService.submit(()->{
                System.out.println(idSnowFlakeFlUntils.snowflakeId());
            });
        }
        executorService.shutdown();
    }
}
