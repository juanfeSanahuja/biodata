/*
 * Copyright 2015 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.biodata.models.variant.exceptions;

/**
 *
 * @author Cristina Yenyxe Gonzalez Garcia &lt;cyenyxe@ebi.ac.uk&gt;
 */
public class NonStandardCompliantSampleField extends Exception {

    /**
     * Constructs an instance of <code>NonStandardCompliantSampleField</code>
     * for a field, and with the specified detail message.
     *
     * @param field non-compliant field
     * @param value non-compliant value
     * @param msg the detail message.
     */
    public NonStandardCompliantSampleField(String field, String value, String msg) {
        super(String.format("Field %s=%s is non-compliant with the VCF specification: %s", field, value, msg));
    }
}
