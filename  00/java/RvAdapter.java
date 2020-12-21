package com.example.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PhotoHolder> {
        private final List<Photo> list;

        public RvAdapter(List<Photo> items) {
            list = items;
        }

        public class PhotoHolder extends RecyclerView.ViewHolder {
            final ImageView imageView;

            public PhotoHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            Photo photo = list.get(position);
            Picasso.get()
                    .load(photo.getUrlS())
                    .placeholder(R.drawable.bill_up_close)
                    .into(photoHolder.imageView);
            photoHolder.itemView.setTag(list.get(position));
            photoHolder.itemView.setOnClickListener(onClickListener);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }

        final private View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        };
    }