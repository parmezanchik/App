package com.example.primarynotesapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.primarynotesapp.data.dp.entity.NotesEntity
import com.example.primarynotesapp.databinding.RecyclerviewItemBinding

class TextAdapter : ListAdapter<NotesEntity, TextAdapter.TextViewHolder>(TextDiffCallback()) {

    class TextViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(textEntity: NotesEntity?) {
            binding.textView.text = textEntity?.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TextDiffCallback : DiffUtil.ItemCallback<NotesEntity>() {
    override fun areItemsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
        return oldItem.text == newItem.text
    }
}