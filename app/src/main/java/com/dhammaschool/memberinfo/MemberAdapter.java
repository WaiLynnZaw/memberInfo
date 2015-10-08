package com.dhammaschool.memberinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by WaiLynnZaw on 8/31/15.
 */
public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Member> mList;

    public MemberAdapter(ArrayList<Member> al){
        this.mList = al;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
        if(vh instanceof ViewHolder) {
            ((ViewHolder)vh).name.setText(mList.get(position).name);
            ((ViewHolder)vh).phone.setText(mList.get(position).phone);
            ((ViewHolder)vh).email.setText(mList.get(position).email);
            ((ViewHolder)vh).address.setText(mList.get(position).address);
        }
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.member_name)
        TextView name;
        @Bind(R.id.member_phone)
        TextView phone;
        @Bind(R.id.member_email)
        TextView email;
        @Bind(R.id.member_address)
        TextView address;
        @Bind(R.id.call_phone)
        ImageView callBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            callBtn.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            String url = "tel:" + (phone);
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
            callBtn.getContext().startActivity(intent);
        }
    }
}
