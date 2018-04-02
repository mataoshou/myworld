package mind.recommend;

public class ItemToUser implements Comparable<ItemToUser>
{
	int userId = 0;
	int itemId = 0;
	Item item;
	double score;
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return String.format("item related user : [userId :%s , itemId :%s ,score:%s ,item:[%s] ]",
				this.userId,this.itemId,this.score,this.item);
	}
	@Override
	public int compareTo(ItemToUser o)
	{
		if(this.score<=o.score) return 1;
		return -1;
	}


}
