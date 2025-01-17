// Source code is decompiled from a .class file using FernFlower decompiler.
package directory;

public class TotalObjects {
   private static int numObjects = 0;

   public TotalObjects() {
      numObjects = 0;
   }

   public void objectAdded() {
      ++numObjects;
   }

   public int getTotalObjects() {
      return numObjects;
   }
}
