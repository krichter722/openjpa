/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.enhance;

import junit.framework.TestCase;
import serp.bytecode.BCClass;
import serp.bytecode.BCField;
import serp.bytecode.BCMethod;
import serp.bytecode.Project;

public class TestPCEnhancerFindField
    extends TestCase {

    private String field;

    public String myMethod() {
        if (Math.abs(1) == 1)
            return field;
        else
            return field;
    }

    public void testPCEnhancerFindField() {
        Project proj = new Project();
        BCClass bc = proj.loadClass(getClass());
        BCMethod meth = bc.getMethods("myMethod")[0];
        BCField field = PCEnhancerSerp.getReturnedField(meth);
        assertEquals("field", field.getName());
    }
}
