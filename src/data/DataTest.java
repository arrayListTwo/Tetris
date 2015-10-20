package data;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author arrayListTwo
 *
 */
public class DataTest {
	
	private Map<String, Integer> players = null;

	public DataTest() {
		
		players = new HashMap<String, Integer>();
		players.put("xiaoqiang", 500);
		players.put("wangcai", 800);
		players.put("zhangsan", 600);
		players.put("lisi", 670);
		players.put("wangwu", 580);
		players.put("zhaoliu", 900);
		
	}
	
	public Map<String, Integer> loadData(){
		return null;
	}

}
