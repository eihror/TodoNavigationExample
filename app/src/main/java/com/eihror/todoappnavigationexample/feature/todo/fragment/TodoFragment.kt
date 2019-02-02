package com.eihror.todoappnavigationexample.feature.todo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eihror.todoappnavigationexample.R
import com.eihror.todoappnavigationexample.extensions.afterTextChanged
import com.eihror.todoappnavigationexample.extensions.enable
import com.eihror.todoappnavigationexample.extensions.isFilled
import com.eihror.todoappnavigationexample.extensions.toolbar
import com.eihror.todoappnavigationexample.persistence.models.Todo
import com.vicpin.krealmextensions.queryLast
import com.vicpin.krealmextensions.save
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar("Adicionar Item", true) {
            activity?.onBackPressed()
        }

        configureView()

    }

    private fun configureView() {
        btn_save.enable(false)
        edt_name.afterTextChanged { validateToUnlock() }

        btn_save.setOnClickListener { it ->

            var nextID: Int
            val lastItem : Todo? = Todo().queryLast()

            nextID = if(lastItem != null) lastItem.id + 1 else 1

            Todo(id = nextID, title = edt_name.text.toString(), status = "open").save()
            activity?.onBackPressed()
        }
    }

    private fun validateToUnlock() {
        btn_save.enable(edt_name.isFilled())
    }

}
