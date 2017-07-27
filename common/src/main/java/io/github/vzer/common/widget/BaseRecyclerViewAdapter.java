package io.github.vzer.common.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: Vzer.
 * @date: 2017/7/26. 17:46
 * @email: vzer@qq.com
 */

public abstract class BaseRecyclerViewAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected List<T> dataList;
    protected Context context;
    protected LayoutInflater inflater;
    private OnItemClicked<T, V> onItemClickedListener;

    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    /**
     * 设置数据
     *
     * @param data 数据
     */
    public void setData(Collection<T> data) {
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 添加一条数据
     *
     * @param t 数据
     */
    public void add(T t) {
        this.dataList.add(t);
        notifyDataSetChanged();
    }

    /**
     * 添加多条数据
     *
     * @param collection 数据
     */
    public void addAll(Collection<T> collection) {
        this.dataList.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 移除数据
     *
     * @param t 移除的数据
     */
    public void remove(T t) {
        this.dataList.remove(t);
        notifyDataSetChanged();
    }

    /**
     * 清空列表
     */
    public void clear() {
        this.dataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 刷新页面
     */
    public void refresh() {
        notifyDataSetChanged();
    }

    /**
     * 获取当前列表的数据
     *
     * @return
     */
    public List<T> getListData() {
        return this.dataList;
    }


    /**
     * 获取position 处数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return dataList.get(position);
    }


    @Override
    public void onBindViewHolder(final V holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClicked(dataList.get(position), holder);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public void setOnItemClickedListener(OnItemClicked<T, V> onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    interface OnItemClicked<T, V> {
        void onItemClicked(T data, V holder);
    }
}
