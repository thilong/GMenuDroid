package com.aidootk.rtlviewpager;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressLint("NotifyDataSetChanged")
public class GroupedRtlPagerAdapter<T> extends PagerAdapter {

    public interface ViewGenerateCallback<T> {
        View createGroupedListItemView(ViewGroup parent, int viewType);

        void bindGroupedListItemView(View view, int position, List<T> items);
    }

    private final GroupedRtlPagerAdapter.ViewGenerateCallback<T> generateCallback;

    private int itemCountPerGroup = 6;
    private final ArrayList<T> data = new ArrayList<>();
    private final ArrayList<View> cachedPageView = new ArrayList<>();

    public GroupedRtlPagerAdapter(int capPerGroup, GroupedRtlPagerAdapter.ViewGenerateCallback<T> generator) {
        generateCallback = generator;
        itemCountPerGroup = capPerGroup;
    }

    public int getFakePageCount() {
        int page = data.size() / itemCountPerGroup;
        if (data.size() % itemCountPerGroup > 0) page++;
        return page;
    }

    public int getRealItemCount() {
        return data.size();
    }

    public boolean hasAnyData() {
        return data.size() > 0;
    }

    public List<T> getGroupedItemsAtPage(int page) {
        if (data.size() == 0) return data.subList(0, 0);
        int minIndex = page * itemCountPerGroup;
        minIndex = Math.max(0, minIndex);
        int maxIndex = minIndex + itemCountPerGroup;
        maxIndex = Math.min(data.size(), maxIndex);

        return data.subList(minIndex, maxIndex);
    }

    public T getItemAtPosition(int group, int position) {
        int idx = group * itemCountPerGroup + position;
        if (idx < data.size())
            return data.get(idx);
        return null;
    }

    public void addItem(T entry) {
        addItems(Collections.singletonList(entry));
    }

    public void addItems(Collection<T> entries) {
        data.addAll(entries);

        notifyDataSetChanged();
    }

    public void removeAllItem() {
        data.clear();
        notifyDataSetChanged();
    }

    public final ArrayList<View> getCachedPageView() {
        return cachedPageView;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return getFakePageCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (cachedPageView.size() == 0) {
            for (int idx = 0; idx < 4; idx++) {
                View view = generateCallback.createGroupedListItemView(container, 0);
                cachedPageView.add(view);
            }
        }

        int realPos = position % 4;
        View itemView = cachedPageView.get(realPos);
        generateCallback.bindGroupedListItemView(itemView, position, getGroupedItemsAtPage(position));

        if (itemView.getParent() == null)
            container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        int realPos = position % 4;
        View itemView = cachedPageView.get(realPos);
        container.removeView(itemView);
    }


}
