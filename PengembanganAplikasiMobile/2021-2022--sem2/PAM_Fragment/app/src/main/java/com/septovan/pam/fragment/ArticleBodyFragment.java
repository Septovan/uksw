package com.septovan.pam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ArticleBodyFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = 0;

    private TextView article;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        view = inflater.inflate(R.layout.article_view, container, false);
        article = view.findViewById(R.id.article);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else {
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int postion) {
        article.setText(ArticleModel.articleBody[postion]);
        mCurrentPosition = postion;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
