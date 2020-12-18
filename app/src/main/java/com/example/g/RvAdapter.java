package com.example.g;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g.model.Photo;

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
                imageView = itemView.findViewById(R.id.item_image_view);
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

/*      String s = photo.getTitle();
        String str = s.substring(0,14);*/
            photoHolder.title.setText(photo.getTitle());
            Picasso.get()
                    .load(photo.url_s)
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
                Photo photo = (Photo) view.getTag();
                Photo ph = new Photo();

                ph.setId(photo.getId());
                ph.setOwner(photo.getOwner());
                ph.setSecret(photo.getSecret());
                ph.setServer(photo.getServer());
                ph.setFarm(photo.getFarm());
                ph.setTitle(photo.getTitle());
                ph.setUrl_s(photo.getUrl_s());
                GalleryActivity.db.photoDao().insert(photo);
            }
        };
    }

}
