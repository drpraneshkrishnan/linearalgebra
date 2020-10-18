package linearalgebra;

/**
 * The Vector class provides basic vector operations for 
 * arrays of real numbers. All operations assume that vectors 
 */
 
public class Vector {
   /**
    * v contains the entries in the vector
    */
   private double[] v;
   
   /**
    * Constructor makes a copy of the array passed.
    * @param v an array containing the entries in the vector
    */
   public Vector(double[] v) {
      this.v = new double[v.length];
      for (int i = 0; i < v.length; i++) {
         this.v[i] = v[i];      
      }
   }
   
   /**
    * add method accepts a vector and adds it to the current vector
    * @param u the vector to add onto the calling vector.
    * @return a Vector object whose entries are the element-wise sums
    *    of the calling vector and the argument
    */
   public Vector add(Vector u) {
      return Vector.sum(this, u);
   }
   
   /**
    * multiply method accepts a scalar to and multiplies each entry
    * in v by it.
    * @param u the vector to add onto the calling vector.
    * @return a Vector object whose entries are the element-wise sums
    *    of the calling vector and the argument
    */
   public Vector multiply(double scalar) {
      return Vector.product(this, scalar);
   }
   
   /**
    * normL1 accepts a Vector and returns the L1 norm (the sum
    * of the absolute values of the vector's entries)
    * @param u a Vector object
    * @return the L1 norm of the vector
    */
   public static double normL1(Vector u) {
      double sum = 0;
      
      for (int i = 0; i < u.length(); i++) {
         sum += Math.abs(u.get(i));
      }
      
      return sum;
   }
   
   /**
    * an instance method that calls normL1 on the current object.
    * @return the L1 norm of the calling vector.
    */
   public double normL1() {
      return Vector.normL1(this);
   }

   /**
    * normL2 accepts a Vector and returns the L1 norm (the sum
    * of the squares of the vector's entries)
    * @param u a Vector object
    * @return the L2 norm of the vector
    */
   public static double normL2(Vector u) {
      double sum = 0;
      
      for (int i = 0; i < u.length(); i++) {
         sum += Math.pow(u.get(i), 2);
      }
      
      return sum;
   }
   
   /**
    * an instance method that calls normL1 on the current object.
    * @return the L2 norm of the calling vector.
    */
   public double normL2() {
      return Vector.normL2(this);
   }

   /**
    * product accepts a Vector object and a scalar and returns
    * a Vector whose entries are the entries of the Vector, multiplied
    * by the scalar.
    * @param vector a Vector object
    * @param scalar a real number
    * @return the scalar product of the vector and the scalar
    */
   public static Vector product(Vector vector, double scalar) {
      double[] products = new double[vector.length()];
      
      for (int i = 0; i < products.length; i++) {
         products[i] = scalar * vector.get(i);
      }
      
      return new Vector(products);
   }
   
   /**
    * sum method accepts two vectors and returns their element-wise
    * sum in a new Vector object. Assumes v1 and v2 have the same 
    * length.
    * @param v1 a Vector object
    * @param v2 a Vector object
    */
   public static Vector sum(Vector u1, Vector u2) {
      double[] sums = new double[u1.length()];
      
      for (int i = 0; i < sums.length; i++) {
         sums[i] = u1.get(i) + u2.get(i);
      }
      
      return new Vector(sums);
   }
   
   // Setters, getters, and overridden methods.
   
   /**
    * Returns the entry in the passed position.
    * @param position the position to return
    * @return the value in v[position]
    */
   public double get(int position) {
      return v[position];
   }
   
   /**
    * getLength method returns the number of entries in the 
    * vector.
    * @return the length of v
    */
   public int length() {
      return this.v.length;
   }
      
   /**
    * Returns a copy of v, not a reference to v.
    * @return a copy of the array v
    */
   public double[] getV() {
      double[] v = new double[this.v.length];
      
      for (int i = 0; i < this.v.length; i++) {
         v[i] = this.v[i];
      }
      
      return v;
   }
   
   /**
    * Sets the values in the v array.
    * @param v an array of doubles
    */
   public void setV(double[] v) {
      this.v = new double[v.length];
      
      for (int i = 0; i < v.length; i++) {
         this.v[i] = v[i];
      }
   }
   
   /**
    * Return a String containing the vector represented as a row in brackets.
    * @return a String representation of the vector
    */
   @Override
   public String toString() {
      String str = "[";
      String sep = "  ";
      
      for (int i = 0; i < this.v.length; i++) {
         str += this.v[i];
         
         if (i < (this.v.length - 1)) { // if we're not at the last entry
            str += sep;
         } else {
            str += "]";
         }
      }
      
      return str;
   }
}