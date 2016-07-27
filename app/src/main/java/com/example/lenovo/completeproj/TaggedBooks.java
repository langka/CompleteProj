package com.example.lenovo.completeproj;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2016/7/25.
 */
public class TaggedBooks extends Fragment {
    List<Book> books;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.taggedbooks,null);
        ListView lv = (ListView)v.findViewById(R.id.taggedBookListView);
        Myadapter myadapter = new Myadapter(books,getActivity());
        lv.setAdapter(myadapter);
        return v;
    }
    public void setTaggedBooks(int tag){
        switch (tag){
            case 1:
                books = BookData.initialBooks().subList(0,3);
                break;
            case 2:
                books = BookData.initialBooks().subList(3,6);
                break;
            case 3:
                books = BookData.initialBooks().subList(6,9);
        }
    }
    public static  TaggedBooks newInstance(int tag){
        TaggedBooks taggedBooks = new TaggedBooks();
        taggedBooks.setTaggedBooks(tag);
        return taggedBooks;
    }
}
class Myadapter extends BaseAdapter{
    List<Book> books;
    Context mcontext;
    class ViewHolder{
        Button button;
        TextView content;
    }
    public Myadapter(List<Book> books,Context mcontext) {
        this.books = books;
        this.mcontext=mcontext;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView=LayoutInflater.from(mcontext).inflate(R.layout.bookitem,null);
            viewHolder.button=(Button)convertView.findViewById(R.id.bookbutton);
            viewHolder.content = (TextView)convertView.findViewById(R.id.booktv);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.button.setFocusable(false);
        viewHolder.button.setText(books.get(position).name);
        viewHolder.content.setText(books.get(position).content);
        return convertView;
    }
}
