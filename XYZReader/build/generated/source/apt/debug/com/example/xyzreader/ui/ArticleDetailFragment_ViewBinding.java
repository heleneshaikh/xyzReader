// Generated code from Butter Knife. Do not modify!
package com.example.xyzreader.ui;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.xyzreader.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ArticleDetailFragment_ViewBinding<T extends ArticleDetailFragment> implements Unbinder {
  protected T target;

  public ArticleDetailFragment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.titleView = finder.findRequiredViewAsType(source, R.id.article_title, "field 'titleView'", TextView.class);
    target.bylineView = finder.findRequiredViewAsType(source, R.id.article_byline, "field 'bylineView'", TextView.class);
    target.bodyView = finder.findRequiredViewAsType(source, R.id.article_body, "field 'bodyView'", TextView.class);
    target.photoView = finder.findRequiredViewAsType(source, R.id.photo, "field 'photoView'", ImageView.class);
    target.photoContainerView = finder.findRequiredView(source, R.id.photo_container, "field 'photoContainerView'");
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.titleView = null;
    target.bylineView = null;
    target.bodyView = null;
    target.photoView = null;
    target.photoContainerView = null;

    this.target = null;
  }
}
