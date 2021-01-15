// Generated code from Butter Knife. Do not modify!
package com.developers.hand.second.navigationdrawerexercise;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.navigationView = Utils.findRequiredViewAsType(source, R.id.mDrawerLayout, "field 'navigationView'", NavigationView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", FrameLayout.class);
    target.myToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'myToolbar'", Toolbar.class);
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbarTitle, "field 'toolbarTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationView = null;
    target.container = null;
    target.myToolbar = null;
    target.toolbarTitle = null;
  }
}
