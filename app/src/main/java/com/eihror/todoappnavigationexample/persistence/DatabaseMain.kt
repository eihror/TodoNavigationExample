package com.eihror.todoappnavigationexample.persistence

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class DatabaseMain(context: Context) {

    companion object {
        val NAME_REALM: String = "todo.realm"
        val VERSION: Int = 1
    }

    init {

        Realm.init(context)

        val colorsConfig = RealmConfiguration.Builder()
            .name(DatabaseMain.NAME_REALM)
            .schemaVersion(DatabaseMain.VERSION.toLong())
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(colorsConfig)
        Realm.getInstance(colorsConfig)

    }

}