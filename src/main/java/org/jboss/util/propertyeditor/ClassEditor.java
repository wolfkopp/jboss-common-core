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
package org.jboss.util.propertyeditor;

import org.jboss.util.NestedRuntimeException;

/**
 * A property editor for {@link java.lang.Class}.
 *
 * @version <tt>$Revision$</tt>
 * @author  <a href="mailto:jason@planet57.com">Jason Dillon</a>
 */
public class ClassEditor extends TextPropertyEditorSupport
{
   /**
    * Returns a Class for the input object converted to a string.
    *
    * @return a Class object
    *
    * @throws NestedRuntimeException   Failed to create Class instance.
    */
   public Object getValue()
   {
      try
      {
         ClassLoader loader = Thread.currentThread().getContextClassLoader();
         String classname = getAsText();
         Class<?> type = loader.loadClass(classname);

         return type;
      }
      catch (Exception e)
      {
         throw new NestedRuntimeException(e);
      }
   }
}
