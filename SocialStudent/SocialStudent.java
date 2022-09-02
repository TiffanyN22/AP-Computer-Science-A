public class SocialStudent{
  private int age;
  private String name;
  private SocialStudent[] friend;

  private int friendUsedIndex; ///holds size of array without counting extra positions from append adding multiple spaces at once to make it more efficient

  //input: no input
  //output: this is a constructor
  //effect: sets the default value for all fields (age is 18, name is Name, friend is null for no friends)
  public SocialStudent(){
    age = 18;
    name = "Jane";
    friend = null;
  }

  //intput: an integer for the student's age, a string for name, a an object of SocialStudent for friend
  //output: this is a constructor
  //effect: sets the value for age, name, and friend based on the input
  public SocialStudent(int _age, String _name, SocialStudent[] _friend){
    age = _age;
    name = _name;
    friend = _friend;
    if (_friend == null){
      friendUsedIndex = 0;
    }
    else{
      friendUsedIndex = _friend.length;
    }
  }

  //input: an obejct of social student to compare
  //output: a boolean stating whether or not the two students (the object calling the method and the object passed in) have the same name and age
  //effect: no side effect
  public boolean equals(SocialStudent student2){
    boolean sameAge = (age == student2.age);
    boolean sameName = (name == student2.name);
    return (sameAge && sameName);
  }

  //input: none
  //output: a string stating the name, age, and friend of the student
  //effect: none
  public String toString(){
    String friendString = "";
    if (friend == null){
      friendString = "None";
    }
    else{
      for (int i = 0; i < numOfFriends(); i++){
        if(i == 0){
          friendString = friend[i].getName();
        }
        else{
          friendString += ", " + friend[i].getName();
        }
      }
    }
    return "Name: " + getName() + ", Age: " + getAge() + ", Friends: " + friendString;
  }

  //input: none
  //output: none
  //effect: increments the age by 1
  public void incrementAge(){
    age++;
  }

  //intput: none
  //output: a string for the name
  //effect: no side effect
  public String getName(){
    return name;
  }

  //input: none
  //output: an integer for age
  //effect: no side effect
  public int getAge(){
    return age;
  }

  //input: an object of SocialStudent for the new friend
  //output: void method
  //effect: Adds the passed in friend into the array of friend for the calling object.  To increase efficiency, if friend is full, increases the size of friend by 5 and adds the passed in value at the first new position, Otherwise, it adds the passed in value at the next available position using friendUsedIndex.  In both cases, increment friendUsedIndex to account for the newly added value
  public void addFriend(SocialStudent newFriend){
    if (friend == null){
      friend = new SocialStudent[5]; 
      friend[0] = newFriend;
    }
    else if (friendUsedIndex == friend.length){
      int lastIndex = friend.length;
      SocialStudent[] oldRepArrray = friend;
      friend = new SocialStudent[lastIndex + 5];  
      for(int i = 0; i < lastIndex; i++){
        friend[i] = oldRepArrray[i];
      }
      friend[lastIndex] = newFriend;
    }
    else{
      friend[friendUsedIndex] = newFriend;
    }

    friendUsedIndex++;
  }

  public int numOfFriends(){
    return friendUsedIndex;
  }
}

