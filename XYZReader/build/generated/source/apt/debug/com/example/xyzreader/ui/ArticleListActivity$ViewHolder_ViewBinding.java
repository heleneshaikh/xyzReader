// Generated code from Butter Knife. Do not modify!
package com.example.xyzreader.ui;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.xyzreader.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ArticleListActivity$ViewHolder_ViewBinding<T extends ArticleListActivity.ViewHolder> implements Unbinder {
  protected T target;

  public ArticleListActivity$ViewHolder_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.thumbnailView = finder.findRequiredViewAsType(source, R.id.thumbnail, "field 'thumbnailView'", DynamicHeightNetworkImageView.class);
    target.titleView = finder.findRequiredViewAsType(source, R.id.article_title, "field 'titleView'", TextView.class);
    target.subtitleView = finder.findRequiredViewAsType(source, R.id.article_subtitle, "field 'subtitleView'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.thumbnailView = null;
    target.titleView = null;
    target.subtitleView = null;

    this.target = null;
  }
}
