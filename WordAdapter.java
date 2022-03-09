package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int ColorResourceID; // for background color
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, words); // words is the data source
        this.ColorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView; // convertView is one of the views of the listItem
        if(listItemView == null) {  // no scrolling occurs
            listItemView = LayoutInflater.from(getContext()).inflate( // inflates UI defined in list_item
                    R.layout.list_item, parent, false); // list_item is a single row in listView
        }

        /**

        The LayoutInflater class is used to instantiate the
        contents of layout XML files into their corresponding View objects.
        In other words, it takes an XML file as input and builds the View objects from it.

        So <TextView> defined in XMl is created into a View TextView object and so on...

        If the view already exists, then use findViewById. If not, then create it with a LayoutInflater

         */

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // getItem(0) will return the first Word object and so on....

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.text1);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.text2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId()); // setImageResource() expects an image from Drawable, and that is an int
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textViews); // entire container that has 2 textViews and 1 imageView
        int color = ContextCompat.getColor(getContext(),ColorResourceID);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}
