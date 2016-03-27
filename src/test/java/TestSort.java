import com.sddr.SortTool;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvyong on 2016/3/24.
 */
public class TestSort {

    @Test
    public void testMapSort(){
        List sortList = new ArrayList();

        Map map = new HashMap();
        map.put("name", "1");
        map.put("age", "1");

        Map map2 = new HashMap();
        map2.put("name", "2");
        map2.put("age", "13");

        Map map1 = new HashMap();
        map1.put("name", "2");
        map1.put("age", "12");

        List list = new ArrayList();
        list.add(map);
        list.add(map1);
        list.add(map2);

        //return sort(list, "age", "asc");
        List li = SortTool.sortParam2(list, "name", "age", "asc");
        System.out.println(li.size());
    }
}
