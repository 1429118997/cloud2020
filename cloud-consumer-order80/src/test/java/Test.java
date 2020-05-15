import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RunWith(SpringRunner.class)
public class Test {

    @org.junit.Test
    public void test(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(null, "123");
        stringStringHashMap.put("123", null);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(null);
        HashSet<String> strings1 = new HashSet<>();
        strings1.add(null);
    }
}
