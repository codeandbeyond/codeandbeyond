/*
 * This file was automatically generated by EvoSuite
 * Mon Dec 16 14:08:19 GMT 2019
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
public class Insertion_ESTest extends Insertion_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer((-1493));
      integerArray0[0] = integer0;
      integerArray0[1] = integerArray0[0];
      integerArray0[2] = integer0;
      integerArray0[3] = integer0;
      Integer integer1 = new Integer((-1614));
      integerArray0[4] = integer1;
      // Undeclared exception!
      try { 
        Insertion.sort(integerArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Insertion.exchange(integerArray0, 0, 0);
      assertEquals(9, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      // Undeclared exception!
      try { 
        Insertion.isLess((Comparable) null, (Comparable) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer((-1493));
      integerArray0[1] = integer0;
      integerArray0[2] = integerArray0[1];
      // Undeclared exception!
      try { 
        Insertion.isLess(integerArray0[2], ";raTpk'%zI");
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      // Undeclared exception!
      try { 
        Insertion.exchange((Comparable[]) null, 2324, 2324);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.misc.Insertion", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer(1);
      Integer integer1 = new Integer(0);
      integerArray0[2] = integer1;
      boolean boolean0 = Insertion.isLess(integerArray0[2], integer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Comparable<Object> comparable0 = (Comparable<Object>) mock(Comparable.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(comparable0).compareTo(any());
      Comparable<String> comparable1 = (Comparable<String>) mock(Comparable.class, new ViolatedAssumptionAnswer());
      boolean boolean0 = Insertion.isLess(comparable0, comparable1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer((-1493));
      integerArray0[0] = integer0;
      integerArray0[1] = integer0;
      integerArray0[2] = integer0;
      integerArray0[3] = integerArray0[0];
      integerArray0[4] = integerArray0[0];
      integerArray0[5] = integer0;
      integerArray0[6] = integerArray0[5];
      integerArray0[7] = integer0;
      integerArray0[8] = integerArray0[1];
      Insertion.sort(integerArray0);
      assertEquals(9, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer((-1493));
      integerArray0[0] = integer0;
      Integer integer1 = new Integer(1008);
      integerArray0[1] = integer1;
      Integer integer2 = new Integer((-1493));
      integerArray0[2] = integer2;
      // Undeclared exception!
      try { 
        Insertion.sort(integerArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Integer[] integerArray0 = new Integer[0];
      Insertion.sort(integerArray0);
      assertEquals(0, integerArray0.length);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Integer[] integerArray0 = new Integer[0];
      // Undeclared exception!
      try { 
        Insertion.exchange(integerArray0, 0, 0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 0
         //
         verifyException("com.misc.Insertion", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Insertion insertion0 = new Insertion();
  }
}
