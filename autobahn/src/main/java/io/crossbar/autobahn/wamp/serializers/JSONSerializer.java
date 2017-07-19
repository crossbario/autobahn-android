///////////////////////////////////////////////////////////////////////////////
//
//   AutobahnJava - http://crossbar.io/autobahn
//
//   Copyright (c) Crossbar.io Technologies GmbH and contributors
//
//   Licensed under the MIT License.
//   http://www.opensource.org/licenses/mit-license.php
//
///////////////////////////////////////////////////////////////////////////////

package io.crossbar.autobahn.wamp.serializers;

import com.fasterxml.jackson.core.JsonFactory;

import io.crossbar.autobahn.wamp.interfaces.ISerializer;


public class JSONSerializer extends ISerializer {

    public JSONSerializer() {
        super(new JsonFactory());
    }
}