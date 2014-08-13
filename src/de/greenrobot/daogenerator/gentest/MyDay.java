/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * <p/>
 * Run it as a Java application (not Android).
 *
 * @author Markus
 */
public class MyDay {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.teusoft.myday.dao");
        addItem(schema);
        new DaoGenerator().generateAll(schema, "../MyDay/MyDay/src");
    }

    private static void addItem(Schema schema) {
        Entity entity = schema.addEntity("MyDay");
        entity.addIdProperty().autoincrement().primaryKey();
        entity.addIntProperty("day");
        entity.addIntProperty("lovelife");
        entity.addIntProperty("work");
        entity.addIntProperty("workout");
        entity.addIntProperty("diet");
        entity.addLongProperty("timeStamp");
    }
}
