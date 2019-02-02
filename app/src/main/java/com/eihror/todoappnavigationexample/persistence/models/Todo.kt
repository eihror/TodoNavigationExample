package com.eihror.todoappnavigationexample.persistence.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable

@RealmClass
open class Todo(

    @PrimaryKey
    var id: Int = 1,
    var title: String? = null,
    var status: String? = null

) : RealmObject(), Serializable