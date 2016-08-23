// Generated code from Butter Knife. Do not modify!
package com.example.xyzreader.ui;

import android.support.v4.view.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.xyzreader.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ArticleDetailActivity_ViewBinding<T extends ArticleDetailActivity> implements Unbinder {
  protected T target;

  public ArticleDetailActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.pager = finder.findRequiredViewAsType(source, R.id.pager, "field 'pager'", ViewPager.class);
    target.upButtonContainer = finder.findRequiredView(source, R.id.up_container, "field 'upButtonContainer'");
    target.upButton = finder.findRequiredView(source, R.id.action_up, "field 'upButton'");
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.pager = null;
    target.upButtonContainer = null;
    target.upButton = null;

    this.target = null;
  }
}
