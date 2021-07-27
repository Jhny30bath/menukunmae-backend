public class User {

    private String username;
    private int age;
    private float user_height;
    private float user_weight;

    public User(String username){
        this.username = username;
    }
    public  User(String username, int age){
        this.username = username;
        this.age = age;
    }
    public User(String username, int age, float user_height, float user_weight){
        this.username = username;
        this.age = age;
        this.user_height = user_height;
        this.user_weight = user_weight;
    }

    public void setUserName(String username){
        this.username = username;
    }

    public String getUserName(){
        return  this.username;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return  this.age;
    }

    public void setUser_height(float user_height){
        this.user_height = user_height;
    }

    public float getUser_height({
        return this.user_height;
    }

    public void setUser_weight(float user_weight){
        this.user_weight = user_weight;
    }

    public float getUser_weight(){
        return this.user_weight;
    }

}
