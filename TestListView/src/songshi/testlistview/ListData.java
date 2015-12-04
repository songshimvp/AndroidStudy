package songshi.testlistview;

public class ListData {

	private String userName = "Li";
	private String sex = "女";
	private int age = 0;
	
	public ListData(String userName, String sex, int age) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getUserName();
	}
}
