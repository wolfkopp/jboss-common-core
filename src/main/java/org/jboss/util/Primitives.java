/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc., and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.util;

/**
 * Primitive utilities.
 *
 * @version <tt>$Revision$</tt>
 * @author  <a href="mailto:jason@planet57.com">Jason Dillon</a>
 */
public final class Primitives
{
   /**
    * Get a Boolean from a boolean, equivalent to the java 1.4 method Boolean.valueOf(boolean)
    *
    * @param value the boolean
    * @return the Boolean equivalent
    */
   public static Boolean valueOf(boolean value)
   {
      if (value)
         return Boolean.TRUE;
      else
         return Boolean.FALSE;
   }

   /**
    * Test the equality of two doubles by converting their values into
    * IEEE 754 floating-point "double format" long values.
    *
    * @param a    Double to check equality with.
    * @param b    Double to check equality with.
    * @return     True if a equals b.
    */
   public static boolean equals(final double a, final double b) {
      return Double.doubleToLongBits(a) == Double.doubleToLongBits(b);
   }

   /**
    * Test the equality of two doubles by converting their values into
    * IEEE 754 floating-point "single precision" bit layouts.
    *
    * @param a    Float to check equality with.
    * @param b    Float to check equality with.
    * @return     True if a equals b.
    */
   public static boolean equals(final float a, final float b) {
      return Float.floatToIntBits(a) == Float.floatToIntBits(b);
   }

   /**
    * Test the equality of a given sub-section of two byte arrays.
    *
    * @param a       The first byte array.
    * @param abegin  The begining index of the first byte array.
    * @param b       The second byte array.
    * @param bbegin  The begining index of the second byte array.
    * @param length  The length of the sub-section.
    * @return        True if sub-sections are equal.
    */
   public static boolean equals(final byte a[], final int abegin,
                                final byte b[], final int bbegin,
                                final int length)
   {
      try {
         int i=length;
         while (--i >= 0) {
            if (a[abegin + i] != b[bbegin + i]) {
               return false;
            }
         }
      }
      catch (ArrayIndexOutOfBoundsException e) {
         return false;
      }

      return true;
   }

   /**
    * Test the equality of two byte arrays.
    *
    * @param a    The first byte array.
    * @param b    The second byte array.
    * @return     True if the byte arrays are equal.
    */
   public static boolean equals(final byte a[], final byte b[]) {
      if (a == b) return true;
      if (a == null || b == null) return false;
      if (a.length != b.length) return false;

      try {
         for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
               return false;
            }
         }
      }
      catch (ArrayIndexOutOfBoundsException e) {
         return false;
      }

      return true;
   }

}
