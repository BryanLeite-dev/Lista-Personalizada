package com.example.listapersonalizada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<dtoMeme> localDataSet;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView Nome;
        private final TextView Ano;
        private final ImageView Meme;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            Nome = (TextView) view.findViewById(R.id.Nome);
            Ano = (TextView) view.findViewById(R.id.Ano);
            Meme = (ImageView) view.findViewById(R.id.Meme);
        }

        public TextView getNome() {
            return Nome;
        }

        public TextView getAno() {
            return Ano;
        }

        public ImageView getMeme() {
            return Meme;
        }

    }
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(ArrayList<dtoMeme> dataSet) {

        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista, viewGroup, false);
        return new ViewHolder(view);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getNome().setText(localDataSet.get(position).nome);
        viewHolder.getAno().setText(localDataSet.get(position).ano);
        viewHolder.getMeme().setImageDrawable(localDataSet.get(position).imagem);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();

    }
}
