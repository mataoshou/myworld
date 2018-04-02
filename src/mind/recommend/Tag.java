package mind.recommend;
//标签
public class Tag
{
	int id = 0;//标签id
	
	String name;//标签名称
	
	double score=0;//标签默认分数
	
	public Tag()
	{
		
	}
	public Tag(int id,String name,int score)
	{
		this.id = id;
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString()
	{
		return String.format("tag:[id:%s , name:%s , score:%s]", this.id,this.name,this.score);
	}
	
	
}
