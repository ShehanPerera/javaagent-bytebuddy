# javaagent-bytebuddy
This include several agents created using Byte-Buddy. Using this project we can get an idea how to create effective agents with byte-buddy.

<h2><b>How to use</b></h2>

<b>1. Download iavaagent-bytebuddy project</b>

`git clone https://github.com/ShehanPerera/javaagent-bytebuddy.git`

<b>2. Install the project </b>

`mvn clean package`

<b>3.Run example java progaram </b>
* Go to the directory 

`javaagent-bytebuddy/samples/example-run/target`

* Run project 

`java -jar example-run-1.0-SNAPSHOT.jar`

Please read My blog '<a href="https://medium.com/@shehanperera.office/java-agents-with-byte-buddy-93185305c9e9">Java Agents with Byte-Buddy</a>' to get an idea how the codes working.

<h2><b>Use agents with Byte-Buddy</b></h2>

<b>1. Get all methods running in program </b>

* Copy `get-methods-1.0-SNAPSHOT.jar` form `javaagent-bytebuddy/samples/get-methods/target` to 
`javaagent-bytebuddy/samples/example-run/target`

* Run example with agent 
 
 `java -javaagent:get-methods-1.0-SNAPSHOT.jar -jar example-run-1.0-SNAPSHOT.jar`
 
 * Results 
 
  
  ``` Agent for get all methods
      This is Sample main
      This is constructor 
      This is Method 1
      public void com.github.shehanperera.example.Method.method1()
      This is Method 2
      public void com.github.shehanperera.example.Method.method2()
      String :parameters and number :4 and boolean :true
      public void com.github.shehanperera.example.Method.method4(int,java.lang.String,boolean)
      public static void com.github.shehanperera.example.Sample.main(java.lang.String[])
  ```    
<b>2. Get execution time of all methods </b>

* Copy `execution-time-1.0-SNAPSHOT.jar` form `javaagent-bytebuddy/samples/execution-time/target` to 
`javaagent-bytebuddy/samples/example-run/target`

* Run example with agent 
 
 `java -javaagent:execution-time-1.0-SNAPSHOT.jar -jar example-run-1.0-SNAPSHOT.jar`
 
 * Results 
 
  
  ``` Agent for time measure
      This is Sample main
      This is constructor 
      This is Method 1
      public void com.github.shehanperera.example.Method.method1() took 500 milliseconds 
      This is Method 2
      public void com.github.shehanperera.example.Method.method2() took 1000 milliseconds 
      String :parameters and number :4 and boolean :true
      public void com.github.shehanperera.example.Method.method4(int,java.lang.String,boolean) took 1 milliseconds 
      public static void com.github.shehanperera.example.Sample.main(java.lang.String[]) took 1522 milliseconds 
```
Simillary we can use all other agents (get-parameters ,constructor-instrument ,add-field,add-method,ignore-class) as above way.
Just copy agnet to  `javaagent-bytebuddy/samples/example-run/target`  and run it with agent 

`java -javaagent:***-1.0-SNAPSHOT.jar -jar example-run-1.0-SNAPSHOT.jar`
 
