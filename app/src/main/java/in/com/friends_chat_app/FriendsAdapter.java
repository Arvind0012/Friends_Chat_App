package in.com.friends_chat_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {

    private final ArrayList<FriendsData> friendsData;
    private LayoutInflater mInflater;

    public FriendsAdapter(Context context, ArrayList<FriendsData> friendsData) {
        this.friendsData = friendsData;
        this.mInflater = LayoutInflater.from(context);
    }

    class FriendsViewHolder extends RecyclerView.ViewHolder {
        public final TextView friendItemview;
        public final CircleImageView imageView;
        final FriendsAdapter mAdapter;


        public FriendsViewHolder(View itemView, FriendsAdapter adapter){
            super(itemView);
            friendItemview = itemView.findViewById(R.id.tvitem);
            imageView = itemView.findViewById(R.id.civfriends);
            this.mAdapter = adapter;
        }
    }



    @NonNull
    @Override
    public FriendsAdapter.FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.friend_list,
                parent, false);
        return new FriendsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsAdapter.FriendsViewHolder holder, int position) {
        String mCurrent = friendsData.get(position).getName();
        holder.friendItemview.setText(mCurrent);
        String mUrl = friendsData.get(position).getUrl();
        Picasso.get().load(friendsData.get(position).getUrl()).into(holder.imageView);

        itemView.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               Intent i =new Intent(mInflater.getContext(),Friends_Window.class);
               i.putExtra("name",mCurrent);
               i.putExtra("photo",mUrl);

               mInflater.getContext().startActivity(i);
           }
        });



    }

    @Override
    public int getItemCount() {
        return friendsData.size();
    }
}
