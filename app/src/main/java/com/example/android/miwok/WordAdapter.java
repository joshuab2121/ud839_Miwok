package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Word} objects.
 * Created by Josh on 1/23/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    /**
     * Custom constructor (Does not mirror a superclass constructor)
     *
     * @param context The current context.  Used to inflate the layout file
     * @param words   A list of Word objects to display in a list
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId= colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultWord.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageview);
        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer  = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(mColorResourceId);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

        return listItemView;
    }
}