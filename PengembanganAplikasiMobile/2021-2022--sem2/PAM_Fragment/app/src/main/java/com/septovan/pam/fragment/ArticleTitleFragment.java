package com.septovan.pam.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class ArticleTitleFragment extends ListFragment {

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {
        void onArticleSelected(int position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
           layout = android.R.layout.simple_list_item_activated_1;
        } else {
            layout = android.R.layout.simple_list_item_1;
        }

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                layout,
                ArticleModel.articleTitle));
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.article_body) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement OnHeadlineSelectedListener");
        }
    }
}
