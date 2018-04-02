package mind.recommend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class ItemCF
{

	Map<Integer, Tag> tags = new HashMap();
	Map<Integer, Item> items = new HashMap();

	// 获取用户的素材
	public void cf(User u)
	{
		List<ItemToUser> list = new ArrayList();
		// 遍历素材
		for (Entry<Integer, Item> e : items.entrySet())
		{
			int id = e.getKey();
			Item item = e.getValue();
			ItemToUser itu = new ItemToUser();
			itu.userId = u.id;
			itu.itemId = item.id;
			itu.item = item;
			// 遍历素材标签
			for (Entry<Integer, Tag> t : item.map.entrySet())
			{
				if (u.map.containsKey(t.getValue()))
				{
					itu.score += t.getValue().score;
				} else
				{
					itu.score += t.getValue().score / 10;
				}
			}
			list.add(itu);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	// 构建素材
	public void initItem()
	{
		items.clear();
		Random r = new Random();
		RandomHan h = new RandomHan();

		for (int i = 0; i < 20; i++)
		{
			Item item = new Item();
			item.id = i + 1;
			item.name = h.getRandName(3);

			for (int j = 0; j < 3; j++)
			{
				int id = r.nextInt(100);
				item.map.put(id, tags.get(id));
			}

			items.put(item.id, item);
			System.out.println(item);
		}
	}

	// 构建标签
	public void initTag()
	{
		tags.clear();
		Random r = new Random();
		RandomHan h = new RandomHan();
		for (int i = 0; i < 100; i++)
		{
			Tag t = new Tag();
			t.id = i + 1;
			t.score = r.nextInt(100);
			String name = h.getRandName(3);

			t.name = name;
			System.out.println(t);
			tags.put(t.id, t);
		}
	}

	public static void main(String[] args)
	{
		Random r = new Random();
		RandomHan h = new RandomHan();

		ItemCF cf = new ItemCF();
		cf.initTag();
		cf.initItem();

		User u = new User();
		u.id = 1;
		u.name = h.getRandName(3);
		for (int j = 0; j < 5; j++)
		{
			int id = r.nextInt(100);
			u.map.put(id, cf.tags.get(id));
		}

		cf.cf(u);
	}
}
