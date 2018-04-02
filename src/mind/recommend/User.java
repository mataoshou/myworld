package mind.recommend;

import java.util.HashMap;
import java.util.Map;
//用户
public class User
{
	int id;//用户id
	String name;//用户名称
	Map<Integer,Tag> map=new HashMap();//标签
}
