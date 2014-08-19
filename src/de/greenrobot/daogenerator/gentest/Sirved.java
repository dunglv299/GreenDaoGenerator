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
public class Sirved {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.teusoft.sirved.dao");
        addItem(schema);
        new DaoGenerator().generateAll(schema, "../Sirved/Sirved/src");
    }

    private static void addItem(Schema schema) {
        Entity food = schema.addEntity("Food");
        food.addIdProperty().autoincrement().primaryKey();
        food.addStringProperty("name");
        food.addLongProperty("category_id");
        food.addStringProperty("price");
        food.addStringProperty("thumb_path");
        food.addStringProperty("image_path");
        food.addStringProperty("content");

        Entity order = schema.addEntity("FoodOrder");
        order.addLongProperty("foodId").primaryKey();
        order.addIntProperty("quantity");
        order.addStringProperty("type");
    }
}
