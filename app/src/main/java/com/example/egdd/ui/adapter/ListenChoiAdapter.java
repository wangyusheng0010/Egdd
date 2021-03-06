package com.example.egdd.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Firsthttp.ListenBottomBean;
import com.example.egdd.http.listenhttp.Firsthttp.ListenImageBean;
import com.example.egdd.http.listenhttp.Firsthttp.ZhongBean;
import com.example.egdd.ui.activity.ListenUpActivity;

import java.util.ArrayList;

public class ListenChoiAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ZhongBean> zhongBeans;
    private ArrayList<ListenBottomBean> bottomBeans;
    private ArrayList<ListenImageBean> imageBeans;

    public ListenChoiAdapter(Context context, ArrayList<ZhongBean> zhongBeans, ArrayList<ListenBottomBean> bottomBeans, ArrayList<ListenImageBean> imageBeans) {
        this.context = context;
        this.zhongBeans = zhongBeans;
        this.bottomBeans = bottomBeans;
        this.imageBeans = imageBeans;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.listen_rcy_item1, null);
            return new ViewHolder1(view);
        } else if (viewType == 1) {
            View view = View.inflate(context, R.layout.listen_rcy_item2, null);
            return new ViewHolder2(view);
        } else {
            View view = View.inflate(context, R.layout.listen_rcy_item3, null);
            return new ViewHolder3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0){
            ViewHolder1 holder1 = (ViewHolder1) holder;
            if (imageBeans.size()>0) {
                Glide.with(context).load(imageBeans.get(0).getImage_url()).into(holder1.first_hali);
                Glide.with(context).load(imageBeans.get(1).getImage_url()).into(holder1.first_pig);
                Glide.with(context).load(imageBeans.get(2).getImage_url()).into(holder1.first_monkey);

                holder1.first_hali.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ListenUpActivity.class);
                        intent.putExtra("hali",imageBeans.get(0));
                        context.startActivity(intent);
                    }
                });
                holder1.first_pig.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ListenUpActivity.class);
                        intent.putExtra("hali",imageBeans.get(1));
                        context.startActivity(intent);
                    }
                });
                holder1.first_monkey.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ListenUpActivity.class);
                        intent.putExtra("hali",imageBeans.get(2));
                        context.startActivity(intent);
                    }
                });


            }
        }else if (getItemViewType(position) == 1){
            ArrayList<ZhongBean> zhong = new ArrayList<>();
            for (int i = 0; i < this.zhongBeans.size(); i++) {
                if (i > 5){
                    break;
                }else {
                    zhong.add(this.zhongBeans.get(i));
                }
            }
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.listen_choi_rcy.setLayoutManager(new GridLayoutManager(context,3));
            ListenZhongAdapter adapter = new ListenZhongAdapter(R.layout.listen_zhong_item, zhong);
            holder2.listen_choi_rcy.setAdapter(adapter);
        }else {
            ViewHolder3 holder3 = (ViewHolder3) holder;
            ListenBottomBean bean = bottomBeans.get(position - 2);
            Glide.with(context).load(bean.getImage()).into(holder3.listen_iv);
            holder3.listen_title.setText(bean.getName());
            holder3.listen_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转fragment
                }
            });
            holder3.listen_bottom_rcy.setLayoutManager(new GridLayoutManager(context,3));
            ListenBottomAdapter adapter = new ListenBottomAdapter(R.layout.listen_bottom_rcy, bottomBeans.get(position - 2).getPlaylists());
            holder3.listen_bottom_rcy.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return bottomBeans.size() + 2;
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView first_hali;
        public ImageView first_pig;
        public ImageView first_monkey;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.first_hali = (ImageView) rootView.findViewById(R.id.first_hali);
            this.first_pig = (ImageView) rootView.findViewById(R.id.first_pig);
            this.first_monkey = (ImageView) rootView.findViewById(R.id.first_monkey);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView listen_choi_rcy;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.listen_choi_rcy = (RecyclerView) rootView.findViewById(R.id.listen_choi_rcy);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView listen_iv;
        public TextView listen_title;
        public LinearLayout listen_more;
        public RecyclerView listen_bottom_rcy;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.listen_iv = (ImageView) rootView.findViewById(R.id.listen_iv);
            this.listen_title = (TextView) rootView.findViewById(R.id.listen_title);
            this.listen_more = (LinearLayout) rootView.findViewById(R.id.listen_more);
            this.listen_bottom_rcy = (RecyclerView) rootView.findViewById(R.id.listen_bottom_rcy);
        }

    }
}
