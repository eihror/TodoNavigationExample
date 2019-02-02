package com.eihror.todoappnavigationexample.feature.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eihror.todoappnavigationexample.R
import com.eihror.todoappnavigationexample.persistence.models.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

class MainAdapter(
    var finalList: ArrayList<Todo>,
    val listenerItemClick: (Todo) -> Unit,
    val listenerLongItemClick: (Todo) -> Unit,
    val listenerBottom: () -> Unit,
    val listenerEmpty: (isEmpty: Boolean) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    init {
        listenerEmpty(finalList.isEmpty() || finalList.size == 0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = finalList[position]
        holder.bindView(item, listenerItemClick, listenerLongItemClick)

        if (holder.adapterPosition == finalList.size - 1) {
            listenerBottom()
        }
    }

    override fun getItemCount(): Int = finalList.size

    fun addItems(list: List<Todo>) {
        for (item in list) {
            if (!finalList.contains(item)) {
                finalList.add(item)
            }
        }
        notifyDataSetChanged()

        listenerEmpty(finalList.isEmpty() || finalList.size == 0)
    }

    fun clearAll() {
        finalList.clear()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            item: Todo,
            listenerItemClick: (Todo) -> Unit,
            listenerLongItemClick: (Todo) -> Unit
        ) {
            itemView.tv_todo.text = item.title

            itemView.item_todo.setOnClickListener {
                listenerItemClick(item)
            }

            itemView.item_todo.setOnLongClickListener {
                listenerLongItemClick(item)
                return@setOnLongClickListener true
            }

        }
    }
}