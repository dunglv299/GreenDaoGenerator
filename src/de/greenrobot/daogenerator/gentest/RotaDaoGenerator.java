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
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class RotaDaoGenerator {

	public static void main(String[] args) throws Exception {
		Schema schema = new Schema(1, "com.dunglv.calendar.dao");
		addNote(schema);

		new DaoGenerator().generateAll(schema, "../Caldroid/src");
	}

	private static void addNote(Schema schema) {
		Entity rota = schema.addEntity("Rota");
		rota.addIdProperty().autoincrement().primaryKey();
		rota.addStringProperty("name");
		rota.addLongProperty("dateStarted");
		rota.addStringProperty("color");
		rota.addIntProperty("weekReapeat");
		rota.addStringProperty("timeRepeat");

		Entity weekTime = schema.addEntity("WeekTime");
		// weekTime.setTableName("WeekTime"); // "ORDER" is a reserved keyword
		weekTime.addIdProperty();
		weekTime.addIntProperty("weekId");
		Property rotaId = weekTime.addLongProperty("rotaId").notNull()
				.getProperty();
		// Add weekday
		weekTime.addStringProperty("monday");
		weekTime.addStringProperty("tuesday");
		weekTime.addStringProperty("wednesday");
		weekTime.addStringProperty("thursday");
		weekTime.addStringProperty("friday");
		weekTime.addStringProperty("saturday");
		weekTime.addStringProperty("sunday");

		weekTime.addToOne(rota, rotaId);
		rota.addToMany(weekTime, rotaId);
	}
}
