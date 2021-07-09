/*
 * This file was automatically generated by EvoSuite
 * Fri Dec 13 15:20:28 GMT 2019
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Selection_ESTest extends Selection_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer[] integerArray0 = new Integer[3];
      Integer integer0 = new Integer(4044);
      assertNotNull(integer0);
      assertEquals(4044, (int)integer0);
      
      integerArray0[0] = integer0;
      Integer integer1 = new Integer(3055);
      assertNotNull(integer1);
      assertEquals(3055, (int)integer1);
      assertFalse(integer1.equals((Object)integer0));
      
      integerArray0[1] = integer1;
      // Undeclared exception!
      try { 
        Selection.sort(integerArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Selection", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try { 
        Selection.isLess((Comparable) null, (Comparable) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Selection", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer integer0 = Integer.valueOf(0);
      assertNotNull(integer0);
      assertEquals(0, (int)integer0);
      
      Comparable<String> comparable0 = (Comparable<String>) mock(Comparable.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        Selection.isLess(integer0, comparable0);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      // Undeclared exception!
      try { 
        Selection.exchange((Comparable[]) null, 1393, 1393);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Selection", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      int int0 = (-1);
      // Undeclared exception!
      try { 
        Selection.exchange(integerArray0, 0, int0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("Selection", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Integer integer0 = new Integer(0);
      assertNotNull(integer0);
      assertEquals(0, (int)integer0);
      
      Integer integer1 = new Integer((-1));
      assertNotNull(integer1);
      assertEquals((-1), (int)integer1);
      assertFalse(integer1.equals((Object)integer0));
      
      boolean boolean0 = Selection.isLess(integer1, integer0);
      assertTrue(boolean0);
      assertFalse(integer0.equals((Object)integer1));
      assertFalse(integer1.equals((Object)integer0));
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      Integer integer0 = new Integer(0);
      assertNotNull(integer0);
      assertEquals(0, (int)integer0);
      
      integerArray0[0] = integer0;
      boolean boolean0 = Selection.isLess(integerArray0[0], integerArray0[0]);
      assertFalse(boolean0);
      assertEquals(2, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      int int0 = 0;
      Selection.exchange(integerArray0, 0, int0);
      assertEquals(2, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      Integer integer0 = new Integer(0);
      integerArray0[0] = integer0;
      Integer integer1 = new Integer((-1));
      integerArray0[1] = integer1;
      Selection.sort(integerArray0);
      Selection.sort(integerArray0);
      assertEquals(2, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      Selection selection0 = new Selection();
  }
}
