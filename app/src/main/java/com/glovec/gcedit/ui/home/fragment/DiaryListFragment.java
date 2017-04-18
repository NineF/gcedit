package com.glovec.gcedit.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.glovec.gcedit.R;
import com.glovec.gcedit.bean.Diary;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class DiaryListFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_diary_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
    }


    public class DiaryListAdater extends RecyclerView.Adapter<DiaryListAdater.DiaryHolder> {

        public static final int TYPE_HEADER = 0;  //说明是带有Header的
        public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
        public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的

        private View mHeaderView;
        private View mFooterView;

        private Context context;
        private List<Diary> list;

        public DiaryListAdater(Context context, List<Diary> list) {
            this.context = context;
            this.list = list;
        }

        public View getHeaderView() {
            return mHeaderView;
        }

        public void setHeaderView(View headerView) {
            mHeaderView = headerView;
            notifyItemInserted(0);
        }

        public View getFooterView() {
            return mFooterView;
        }

        public void setFooterView(View footerView) {
            mFooterView = footerView;
            notifyItemInserted(getItemCount() - 1);
        }

        @Override
        public DiaryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mHeaderView != null && viewType == TYPE_HEADER)
                return new DiaryHolder(mHeaderView);
            else if (mFooterView != null && viewType == TYPE_FOOTER)
                return new DiaryHolder(mFooterView);
            else
                return new DiaryHolder(LayoutInflater.from(context).inflate(R.layout.diary_item, parent, false));
        }

        @Override
        public void onBindViewHolder(DiaryHolder holder, int position) {
            if (getItemViewType(position) == TYPE_NORMAL) {
                if (holder instanceof DiaryHolder) {
                    //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                    ((DiaryHolder) holder).diaryImg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context, "yyy", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
            } else if (getItemViewType(position) == TYPE_HEADER) {
                return;
            } else {
                return;
            }
        }

        @Override
        public int getItemViewType(int position) {

            if (mHeaderView == null && mFooterView == null) {
                return TYPE_NORMAL;
            }
            if (position == 0) {
                //第一个item应该加载Header
                return TYPE_HEADER;
            }
            if (position == getItemCount() - 1) {
                //最后一个,应该加载Footer
                return TYPE_FOOTER;
            }
            return TYPE_NORMAL;
        }

        @Override
        public int getItemCount() {
            if (mHeaderView == null && mFooterView == null) {
                return list.size();
            } else if (mHeaderView == null && mFooterView != null) {
                return list.size() + 1;
            } else if (mHeaderView != null && mFooterView == null) {
                return list.size() + 1;
            } else {
                return list.size() + 2;
            }
        }

        class DiaryHolder extends RecyclerView.ViewHolder {
            TextView diaryTitle;
            TextView diaryContent;
            ImageView diaryImg;

            public DiaryHolder(View itemView) {
                super(itemView);
                //如果是headerview或者是footerview,直接返回
                if (itemView == mHeaderView) {
                    return;
                }
                if (itemView == mFooterView) {
                    return;
                }
                diaryTitle= (TextView) itemView.findViewById(R.id.diary_title);
                diaryContent= (TextView) itemView.findViewById(R.id.diary_content);
                diaryImg= (ImageView) itemView.findViewById(R.id.diary_img);
            }
        }
    }
}
