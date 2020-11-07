package model;

public class User{

	//Attributes
	private String username;
	private String password;
	private String age;
	private Category category;

	//Constructor
	public User(String username, String password, String age){
		this.username = username;
		this.password = password;
		this.age = age;
		category = Category.NEWBIE;
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

	public void setCategory(Category category){
		this.category = category;
	}

	//User Info

	public String showInfo(){
		String message;

		message= "*************  User **************\n"+
				"**  UserName: "+username+"\n"+
				"**  Age: "+age+"\n"+
				"**  Category: "+category.toString()+"\n"+
				"***********************************\n";
		return message;
	}

}