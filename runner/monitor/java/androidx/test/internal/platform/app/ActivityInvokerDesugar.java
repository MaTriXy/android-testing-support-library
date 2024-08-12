package androidx.test.internal.platform.app;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;

/**
 * Handles default implementation for ActivityInvoker#getIntentForActivity
 *
 * <p> See the {@link ActivityInvoker$$CC} javadoc for prior history.
 *
 * <p> Starting in androidx.test:monitor:1.6.X, a new version of the desugar tooling was used
 * that generated a ActivityInvoker$-CC class. Class names with hyphens are rejected by javac,
 * so we cannot directly declare a ActivityInvoker$-CC class here. So instead we use a
 * placeholder name, and use jarjar to rename the class after the javac step.
 *
 * @hide
 */
@RestrictTo(Scope.LIBRARY_GROUP)
public final class ActivityInvokerDesugar {

  private ActivityInvokerDesugar() {}

  public static Intent $default$getIntentForActivity(ActivityInvoker invoker,
            Class<? extends Activity> activityClass) {
    Intent intent =
        Intent.makeMainActivity(
            new ComponentName(getInstrumentation().getTargetContext(), activityClass));
    if (getInstrumentation().getTargetContext().getPackageManager().resolveActivity(intent, 0)
        != null) {
      return intent;
    }
    return Intent.makeMainActivity(
        new ComponentName(getInstrumentation().getContext(), activityClass));
  }
}
