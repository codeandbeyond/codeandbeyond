/*
 * This file was automatically generated by EvoSuite
 * Fri Dec 13 15:22:44 GMT 2019
 */


import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Student_ESTest extends Student_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      student0.key = 1;
      student0.setKey((-1379));
      assertEquals((-1379), student0.getKey());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      student0.name = "";
      student0.name = null;
      student0.getName();
      assertEquals((-1379), student0.getKey());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Student student0 = new Student("zW`USHPdfn", 0);
      String string0 = student0.getName();
      assertEquals(0, student0.getKey());
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Student student0 = new Student("zW`USHPdfn", 0);
      int int0 = student0.getKey();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      student0.key = 1;
      int int0 = student0.getKey();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      String string0 = student0.getName();
      assertNotNull(string0);
      assertEquals((-1379), student0.getKey());
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      int int0 = student0.getKey();
      assertEquals((-1379), int0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Student student0 = new Student("", (-1379));
      student0.setName("");
      assertEquals((-1379), student0.getKey());
  }
}