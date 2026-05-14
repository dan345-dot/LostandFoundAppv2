package com.example.lostandfoundappv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter <Items>
{
    public ItemsAdapter(Context context, int resource, List<Items> itemsList)
    {
        super(context,resource,itemsList);
    }

}









