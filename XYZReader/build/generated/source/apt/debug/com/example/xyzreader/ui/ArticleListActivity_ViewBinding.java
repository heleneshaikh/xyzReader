// Generated code from Butter Knife. Do not modify!
package com.example.xyzreader.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.xyzreader.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ArticleListActivity_ViewBinding<T extends ArticleListActivity> implements Unbinder {
  protected T target;

  public ArticleListActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.toolbar = finder.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.swipeRefreshLayout = finder.findRequiredViewAsType(source, R.id.swipe_refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.recyclerView = finder.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.swipeRefreshLayout = null;
    target.recyclerView = null;

    this.target = null;
  }
}
