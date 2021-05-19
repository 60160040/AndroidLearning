package com.zonew.wordlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {
    List<String> list; // รายการที่ต้องการแสดงผล
    LayoutInflater li;
    Context ct;

    // Constructor
    public WordListAdapter(Context c, LinkedList<String> l){
        list = l;
        li = LayoutInflater.from(c);
        ct = c;
    }

    // เชื่อม Data
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tvWord =(TextView) li.inflate(R.layout.word_item_layout,parent,false);
        WordViewHolder wvh = new WordViewHolder(ct,tvWord);
        return wvh;
    }

    // Set ข้อความที่จะแสดง
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.tvWordItem.setText(list.get(position));
    }

    // List Size
    @Override
    public int getItemCount() {
        return list.size();
    }

}


//