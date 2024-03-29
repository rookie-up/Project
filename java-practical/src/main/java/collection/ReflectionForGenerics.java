package collection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
class ReflectionForGenerics {
  public static void toString(Class<?> k) {
    System.out.println(k + " (toString)");
    for (Field f : k.getDeclaredFields())
      System.out.println(f.toString());
    for (Constructor c : k.getDeclaredConstructors())
      System.out.println(c.toString());
    for (Method m : k.getDeclaredMethods())
      System.out.println(m.toString());
    System.out.println();
  }

  public static void toGenericString(Class<?> k) {
    System.out.println(k + " (toGenericString)");
    for (Field f : k.getDeclaredFields())
      System.out.println(f.toGenericString());
    for (Constructor c : k.getDeclaredConstructors())
      System.out.println(c.toGenericString());
    for (Method m : k.getDeclaredMethods())
      System.out.println(m.toGenericString());
    System.out.println();
  }

  public static void main(String[] args)
          throws ClassNotFoundException {
    for (String name : args) {
      Class<?> k = Class.forName(name);
      toString(k);
      toGenericString(k);
    }
  }
}