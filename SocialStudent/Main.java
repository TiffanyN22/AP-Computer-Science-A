/*
Author: Tiffany Nguyen

Instructions (by Mr. Kuszmaul:
In this assignment you are to create a class called SocialStudent. An instance of a SocialStudent has the attributes of age, name, and friend. A friend is another SocialStudent. 
It must be possible to create an instance of a SocialStudent that has a default age of 18, no friend, and the name "Jane". It must be possible to compare two SocialStudents using the equals method, and for that method to return true when they have the same name and age. The toString method must be supported so that a default instance will return "Name: Jane, Age: 18, Friend: None"  It should be possible to set the name of an instance, and increment the age. For our purposes, we will not allow a SocialStudent to change their name. This means you will need to have at least two constructors
*/

class Main {
  static int pass = 0;
  static int totalTestCases = 0;

  public static void main(String[] args) {
    System.out.println("Hello world!");

    SocialStudent student1 = new SocialStudent();
    SocialStudent student2 = new SocialStudent(18, "Jane", new SocialStudent[] {student1});
    SocialStudent student3 = new SocialStudent(17, "Tiffany", new SocialStudent[] {student1, student2});
    SocialStudent student4 = new SocialStudent(16, "Tina", null);
    SocialStudent student5 = new SocialStudent(18, "Ava", new SocialStudent[] {student3, student1});
    SocialStudent[] allStudents = {student1, student2, student3, student4, student5};

    System.out.println("Students Information: ");
    testToString(allStudents);

    testEquals(student1, student2, true);
    testEquals(student3, student4, false);
    testEquals(student5, student2, false);
    
    
    testIncrementAge(student1);
    testIncrementAge(student4);

    System.out.println("Information after adding friends: ");
    student5.addFriend(student4);
    student4.addFriend(student5);
    checkDescriptions(student5, "Name: Ava, Age: 18, Friends: Tiffany, Jane, Tina");
    checkDescriptions(student4, "Name: Tina, Age: 17, Friends: Ava");
    

    System.out.println("Passed " + pass + " out of " + totalTestCases + " test cases!");

  }

  //input: an array of SocialStudent to testEquals
  //output: this is a void method
  //effect: for all objects of SocialStudent in the passed in array, calls Main's checkDescriptions to compare with with hard-coded expected results
  public static void testToString(SocialStudent[] studentList){

    String[] descriptionIntendedResult = new String[5];
    descriptionIntendedResult[0] = "Name: Jane, Age: 18, Friends: None";
    descriptionIntendedResult[1] = "Name: Jane, Age: 18, Friends: Jane"; 
    descriptionIntendedResult[2] = "Name: Tiffany, Age: 17, Friends: Jane, Jane";
    descriptionIntendedResult[3] = "Name: Tina, Age: 16, Friends: None";
    descriptionIntendedResult[4] = "Name: Ava, Age: 18, Friends: Tiffany, Jane";

    for(int i = 0; i < studentList.length; i++){
      checkDescriptions(studentList[i], descriptionIntendedResult[i]);
    }
  }

  //input: an object of SocialStudent  and a strring for the expected desecription
  //output: void method
  //effect: descriptions from  SocialStudent's toString() by printing the object and checks if calling SocialStudent's toString() method returns the same result as the expecedDescription.  if it is, increments pass, and if it is'nt, prints out both the desired and actual result.  In both cases, it also increments totalTestCases
  public static void checkDescriptions(SocialStudent student, String expectedDescription){
    System.out.println(" " + student);

    if (student.toString().equals(expectedDescription)){
      pass++;
    }    
    else{
      System.out.println("Error comparing descriptions:");
      System.out.println(" Desired result: " + expectedDescription);
      System.out.println(" Actual result:  " + student.toString());
    }
    totalTestCases++;
  }

  //input: an object of Social Student
  //output: this is a void method
  //effect: calls SocialStudent's incrementAge() method (which increases the student's age by one), prints out the student's new age, increments pass if the new age is one more than the original age, prints out the original and new age if it isn't, and increments totalTestCases
  public static void testIncrementAge(SocialStudent student){
    int originalAge = student.getAge();
    student.incrementAge();
    System.out.println(student.getName() + " is now " + student.getAge() + " years old!");
    if ((originalAge + 1) == student.getAge()){
      pass++;
    }
    else{
      System.out.println("Error incrementing age: Student was " + originalAge + " and is now " + student.getAge());
    }
    totalTestCases++;
  }

  //input: 2 objects of the SocialStudent class and a boolean representing the intended result when comparing them
  //output: this is a void method
  //effect: prints out a statement if the two students have have the same name and age, increments pass if the actual result using SocialStudent's equal method matches the intended result, and prints out the intended and actual results if they don't match 
  public static void testEquals(SocialStudent student1, SocialStudent student2, boolean intendedResult){
    boolean sameInfo = student1.equals(student2);

    //print out result
    if (sameInfo){
      System.out.println(student1.getName() + " and " + student2.getName() + " have the same name and age");
    }

    if (sameInfo == intendedResult){
      pass++;
    }
    else{
      System.out.println("Error comparing equals for " + student1.getName() + "and " + student2.getName());
      System.out.println(" Intended Result: " + intendedResult);
      System.out.println(" Actual Result: " + sameInfo);   
    }
    totalTestCases++;
  }

}