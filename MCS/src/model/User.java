package model;

public class Users{

	//Atributes
	private String username;
	private String password;
	private String age;
	private Category category;

	public Users(String username, String password, String age, String category){
		this.username = username;
		this.password = password;
		this.age = age;
		this.category = Category.valueOf(category);
	}

	//Gets
	public String getUsername(){
		return username;
	}

	public String getPasswprd(){
		return password;
	}

	public String getAge(){
		return age;
	}

	public Category getCategory(){
		return category;
	}

	//Sets

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setAge(String age){
		this.age = age;
	}

	public void setCategory(String category){
		this.category = Category.valueOf(category);
	}

}