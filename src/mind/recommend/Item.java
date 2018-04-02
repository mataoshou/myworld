package mind.recommend;

import java.util.HashMap;
import java.util.Map;

//素材
public class Item
{
	int id = 0; 
	String name;// 名称
	int category = 0;// 分类
	Map<Integer, Tag> map = new HashMap();// 标签
	@Override
	public String toString()
	{
		return String.format("item:[id:%s , name:%s , tags:%s]", this.id,this.name,this.map.values().size());
	}
	
	
}
