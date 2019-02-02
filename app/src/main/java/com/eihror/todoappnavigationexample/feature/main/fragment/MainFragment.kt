package com.eihror.todoappnavigationexample.feature.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.eihror.todoappnavigationexample.R
import com.eihror.todoappnavigationexample.extensions.toolbar
import com.eihror.todoappnavigationexample.feature.main.adapter.MainAdapter
import com.eihror.todoappnavigationexample.persistence.models.Todo
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.querySorted
import io.realm.Sort
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private var adapter: MainAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar("Home", false) {}

        btn_newtodo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_todo)
        }

    }

    override fun onResume() {
        super.onResume()
        setupRecycler()
    }

    private fun setupRecycler() {

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_todo.layoutManager = layoutManager

        adapter = MainAdapter(
            getListTodo(),
            {
                //listenerItemClick
                Toast.makeText(context, "Short click", Toast.LENGTH_SHORT).show()
            },
            {
                //listenerLongItemClick
                Toast.makeText(context, "Long click", Toast.LENGTH_SHORT).show()
            },
            {
                //listenerBottom

            },
            {
                //listenerEmpty

            })

        rv_todo.adapter = adapter
    }

    private fun getListTodo(): ArrayList<Todo> {
        var listReturn = Todo().querySorted("id", Sort.DESCENDING)
        return ArrayList(listReturn)
    }

}
