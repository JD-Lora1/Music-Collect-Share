package model;

public class User{

	//Attributes
	private String username;
	private String password;
	private String age;
	private Category category;

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> username is initialized.<br>
	* <b>pre #2:</b> password is initialized.<br>
	* <b>pre #3:</b> age is initialized.<br>
	* <b>pre #4:</b> category is initialized.<br>
	* @param username . username != null.
	* @param password . password != null.
	* @param age . age != null.
	*/
	public User(String username, String password, String age){
		this.username = username;
		this.password = password;
		this.age = age;
		category = Category.NEWBIE;
	}

	//Gets
	/**
	* Get username .<br>
	* @return a String with the user name.
	*/
	public String getUsername(){
		return username;
	}
	/**
	* Get username .<br>
	* @return a String with the user's password.
	*/
	public String getPasswprd(){
		return password;
	}
	/**
	* Get username .<br>
	* @return a String with the user's age.
	*/
	public String getAge(){
		return age;
	}
	/**
	* Get username .<br>
	* @return a String with the user's category.
	*/
	public Category getCategory(){
		return category;
	}

	//Sets
	/**
	* change the user name.<br>
	* <b>pre #1:</b> username is initialized (is not null).<br>
	* @param username used to set the username. user != null.
	*/
	public void setUsername(String username){
		this.username = username;
	}
	/**
	* change the password.<br>
	* <b>pre #1:</b> password is initialized (is not null).<br>
	* @param password used to set the password. password != null.
	*/
	public void setPassword(String password){
		this.password = password;
	}
	/**
	* change the user age.<br>
	* <b>pre #1:</b> age is initialized (is not null).<br>
	* @param age used to set the age. age != null.
	*/
	public void setAge(String age){
		this.age = age;
	}
	/**
	* change the user category.<br>
	* <b>pre #1:</b> category is initialized (is not null).<br>
	* @param category used to set the categogry. category != null.
	*/
	public void setCategory(Category category){
		this.category = category;
	}
	/**
	* Show user info .<br>
	* <b>pre #1:</b> username is initialized (is not null).<br>
	* <b>pre #2:</b> age is initialized (is not null).<br>
	* <b>pre #3:</b> category is initialized (is not null).<br>
	* @return a String with user's information.
	*/
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