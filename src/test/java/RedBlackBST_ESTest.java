/*
 * This file was automatically generated by EvoSuite
 * Fri Dec 13 15:14:14 GMT 2019
 */


import com.optum.fs.rest.service.util.RedBlackBST;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.NoSuchElementException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RedBlackBST_ESTest extends RedBlackBST_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "");
      int int0 = redBlackBST0.size("w&n", "w&n");
      assertEquals(1, redBlackBST0.size());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      int int0 = redBlackBST0.size("first argument to size() is null", "first argument to size() is null");
      assertEquals(2, redBlackBST0.size());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RedBlackBST<Integer, String> redBlackBST0 = new RedBlackBST<Integer, String>();
      Integer integer0 = new Integer((-1));
      redBlackBST0.put(integer0, "");
      Integer integer1 = new Integer((-1));
      int int0 = redBlackBST0.size(integer0, integer1);
      assertEquals(1, redBlackBST0.size());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      int int0 = redBlackBST0.size("EZB|bFWR0'!}'7", "first argument to size() is null");
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      int int0 = redBlackBST0.rank("w&n");
      assertEquals(1, redBlackBST0.height());
      assertEquals(2, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      Integer integer0 = new Integer((-18));
      redBlackBST0.put("hSDf/c\"~G!Z8dJ~", integer0);
      redBlackBST0.put("@", "");
      redBlackBST0.put("57*l|f`>Wzw4s5HuH1P", "57*l|f`>Wzw4s5HuH1P");
      redBlackBST0.put("l(=k6Gf", "57*l|f`>Wzw4s5HuH1P");
      redBlackBST0.select(3);
      assertEquals(4, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "");
      redBlackBST0.put("l(=k6Gf", "");
      // Undeclared exception!
      try { 
        redBlackBST0.select(2);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to select() is invalid: 2
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.put("[xJ*qE3dBNKBt?lyoL", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.put("Subtree counts not consistent", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.delete("[xJ*qE3dBNKBt?lyoL");
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      Integer integer0 = new Integer((-18));
      redBlackBST0.put("hSDf/c\"~G!Z8dJ~", integer0);
      int int0 = redBlackBST0.size();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      int int0 = redBlackBST0.height();
      assertEquals(2, redBlackBST0.size());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RedBlackBST<Integer, String> redBlackBST0 = new RedBlackBST<Integer, String>();
      Integer integer0 = new Integer((-1));
      redBlackBST0.put(integer0, "");
      redBlackBST0.get(integer0);
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.contains((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to get() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      Integer integer0 = new Integer(899);
      redBlackBST0.put("O^w=PG1D3>FR5n::", integer0);
      redBlackBST0.max();
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      Integer integer0 = new Integer(1081);
      redBlackBST0.put("<~V+TDz~B/zJ1P=ey", integer0);
      redBlackBST0.min();
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.put("l(=k6Gf", "57*l|f`>Wzw4s5HuH1P");
      int int0 = redBlackBST0.rank("m\"K`)`l");
      assertEquals(1, redBlackBST0.height());
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      boolean boolean0 = redBlackBST0.contains("");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(1765);
      redBlackBST0.put(integer0, integer0);
      boolean boolean0 = redBlackBST0.contains(integer0);
      assertEquals(1, redBlackBST0.size());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(3095);
      Object object0 = redBlackBST0.get(integer0);
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      Integer integer0 = new Integer(1081);
      redBlackBST0.put("<~V+TDz~B/zJ1P=ey", integer0);
      redBlackBST0.isEmpty();
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      boolean boolean0 = redBlackBST0.isEmpty();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      int int0 = redBlackBST0.size();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      int int0 = redBlackBST0.size("w&n", "first argument to size() is null");
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Integer integer0 = new Integer((-20));
      RedBlackBST<Integer, String> redBlackBST0 = new RedBlackBST<Integer, String>();
      // Undeclared exception!
      try { 
        redBlackBST0.size(integer0, (Integer) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // second argument to size() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.size((Integer) null, (Integer) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // first argument to size() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.keys("@", "");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      redBlackBST0.put("?b_[%tF|8dE<cg-hR", "second argument to size() is null");
      redBlackBST0.keys("second argument to size() is null", "?b_[%tF|8dE<cg-hR");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.keys("'h", (String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // second argument to keys() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.keys((String) null, "first argument to size() is null");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // first argument to keys() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      Iterable<String> iterable0 = redBlackBST0.keys();
      assertNotNull(iterable0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      redBlackBST0.put("calls min() with empty symbol table", "calls min() with empty symbol table");
      int int0 = redBlackBST0.size("", "");
      assertEquals(1, redBlackBST0.size());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      // Undeclared exception!
      try { 
        redBlackBST0.rank((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to rank() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      int int0 = redBlackBST0.rank("first argument to size() is null");
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.select(0);
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.select((-795));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to select() is invalid: -795
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.ceiling("");
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("LmWQWA-", redBlackBST0);
      redBlackBST0.ceiling("LmWQWA-");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument toceiling() is null");
      redBlackBST0.ceiling("first argument to size() is null");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      // Undeclared exception!
      try { 
        redBlackBST0.ceiling((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to ceiling() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.ceiling("first argument to size() is null");
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // calls ceiling() with empty symbol table
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "");
      redBlackBST0.put("", "");
      redBlackBST0.put("l(=k6Gf", "");
      redBlackBST0.floor("l(=k6Gf");
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("57*l|f`>Wzw4s5HuH1P", "57*l|f`>Wzw4s5HuH1P");
      redBlackBST0.floor("EZB|bFWR0'!}'7");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument toceiling() is null");
      redBlackBST0.floor("EZB|bFqR0's_!}'7");
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.floor((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to floor() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.floor("EZB|bFqR0's_!}'7");
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // calls floor() with empty symbol table
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to ceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.put("57*l|f`>Wzw4s5HuH1P", "57*l|f`>Wzw4s5HuH1P");
      redBlackBST0.keys();
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      RedBlackBST<String, Integer> redBlackBST0 = new RedBlackBST<String, Integer>();
      // Undeclared exception!
      try { 
        redBlackBST0.max();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // calls max() with empty symbol table
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      RedBlackBST<String, String> redBlackBST0 = new RedBlackBST<String, String>();
      // Undeclared exception!
      try { 
        redBlackBST0.min();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // calls min() with empty symbol table
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to rank() is null", "argument to rank() is null");
      int int0 = redBlackBST0.height();
      assertEquals(1, redBlackBST0.size());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument to select() is invalid: ");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.put("", "first argument to size() is null");
      redBlackBST0.put("57*l|f`>Wzw4s5HuH1P", "57*l|f`>Wzw4s5HuH1P");
      redBlackBST0.deleteMax();
      assertFalse(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(3095);
      Integer integer1 = new Integer(947);
      redBlackBST0.put(integer0, integer1);
      Integer integer2 = new Integer(0);
      redBlackBST0.put(integer2, integer2);
      Integer integer3 = new Integer((-1));
      Object object0 = new Object();
      redBlackBST0.put(integer3, object0);
      redBlackBST0.put(integer1, "j?");
      redBlackBST0.deleteMin();
      assertFalse(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "");
      redBlackBST0.put("", "");
      redBlackBST0.put("l(=k6Gf", "");
      redBlackBST0.delete("");
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer((-20));
      Integer integer1 = new Integer(2849);
      redBlackBST0.put(integer1, integer1);
      Object object0 = new Object();
      redBlackBST0.put(integer0, object0);
      redBlackBST0.delete(integer0);
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.delete((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to delete() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("argument to select() is invalid: ", "argument toceiling() is null");
      redBlackBST0.put("first argument to size() is null", "first argument to size() is null");
      redBlackBST0.deleteMax();
      assertFalse(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.deleteMax();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // BST underflow
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("", "");
      redBlackBST0.deleteMax();
      assertEquals(0, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(3095);
      Integer integer1 = new Integer((-20));
      redBlackBST0.put(integer0, integer1);
      Integer integer2 = new Integer(0);
      redBlackBST0.put(integer2, integer2);
      Integer integer3 = new Integer((-795));
      Object object0 = new Object();
      redBlackBST0.put(integer3, object0);
      redBlackBST0.put(integer1, "j?");
      redBlackBST0.deleteMin();
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer((-20));
      Integer integer1 = new Integer(2849);
      redBlackBST0.put(integer1, integer1);
      Object object0 = new Object();
      redBlackBST0.put(integer0, object0);
      redBlackBST0.deleteMin();
      assertFalse(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.deleteMin();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // BST underflow
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("@", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.put("[xJ*qE3dBNKBt?lyoL", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.put("l(=k6Gf", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.delete("[xJ*qE3dBNKBt?lyoL");
      assertEquals(1, redBlackBST0.height());
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("3TKC7AAvFEWC F", (Object) null);
      assertTrue(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      Object object0 = new Object();
      // Undeclared exception!
      try { 
        redBlackBST0.put((String) null, object0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // first argument to put() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      redBlackBST0.put("[xJ*qE3dBNKBt?lyoL", "[xJ*qE3dBNKBt?lyoL");
      redBlackBST0.delete("[xJ*qE3dBNKBt?lyoL");
      assertTrue(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer((-20));
      Integer integer1 = new Integer(2849);
      redBlackBST0.put(integer1, integer1);
      redBlackBST0.delete(integer0);
      assertEquals(1, redBlackBST0.size());
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.get((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to get() is null
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(3095);
      redBlackBST0.put(integer0, integer0);
      redBlackBST0.deleteMin();
      assertTrue(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer(3095);
      redBlackBST0.put(integer0, integer0);
      Integer integer1 = new Integer(0);
      redBlackBST0.put(integer1, integer1);
      Integer integer2 = new Integer((-1));
      Object object0 = new Object();
      redBlackBST0.put(integer2, object0);
      redBlackBST0.put(integer0, "j?");
      assertFalse(redBlackBST0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      int int0 = redBlackBST0.height();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      RedBlackBST<String, Object> redBlackBST0 = new RedBlackBST<String, Object>();
      // Undeclared exception!
      try { 
        redBlackBST0.select(4950);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // argument to select() is invalid: 4950
         //
         verifyException("RedBlackBST", e);
      }
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      RedBlackBST<Integer, Object> redBlackBST0 = new RedBlackBST<Integer, Object>();
      Integer integer0 = new Integer((-20));
      redBlackBST0.put(integer0, integer0);
      Integer integer1 = new Integer((-795));
      Object object0 = new Object();
      redBlackBST0.put(integer1, object0);
      redBlackBST0.delete(integer0);
      assertFalse(redBlackBST0.isEmpty());
  }
}