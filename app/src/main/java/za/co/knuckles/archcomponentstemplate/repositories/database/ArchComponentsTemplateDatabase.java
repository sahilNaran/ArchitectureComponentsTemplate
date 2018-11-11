package za.co.knuckles.archcomponentstemplate.repositories.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import za.co.knuckles.archcomponentstemplate.repositories.database.converters.DateConverter;

@Database(entities = {}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class ArchComponentsTemplateDatabase extends RoomDatabase {
    private static volatile ArchComponentsTemplateDatabase INSTANCE;
}
