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
public class Alliance7Generator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.dp.alliance7.dao");
        addNote(schema);
        new DaoGenerator().generateAll(schema, "../Alliance 7/Alliance 7/src");
    }

    private static void addNote(Schema schema) {
        Entity article = schema.addEntity("Article");
        article.addLongProperty("ArticleId").primaryKey();
        article.addIntProperty("CategoryId");
        article.addIntProperty("MyCategoryId");
        article.addStringProperty("Label");
        article.addStringProperty("Summary");
        article.addStringProperty("Body");
        article.addStringProperty("PublishTime");
        article.addStringProperty("EndTime");
        article.addStringProperty("Createtime");

        Entity document = schema.addEntity("Document");
        document.addLongProperty("DocumentId").primaryKey();
        document.addLongProperty("ArticleId");
        document.addStringProperty("Label");
        document.addStringProperty("Url");
        document.addIntProperty("Size");
        document.addStringProperty("Extension");
        document.addStringProperty("ExtensionType");
        document.addStringProperty("Type");
        document.addStringProperty("CreateTime");
        document.addBooleanProperty("IsDownloaded");

        // Alert
        Entity alert = schema.addEntity("Alert");
        alert.addLongProperty("NotificationId").primaryKey();
        alert.addStringProperty("Title");
        alert.addStringProperty("Details");
        alert.addIntProperty("Level");
        alert.addStringProperty("CreateTime");

    }
}
