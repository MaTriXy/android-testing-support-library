/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.test.filters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a specific test or class should not be run on certain API levels.
 *
 * <p>Test(s) will be skipped when executed on Android platforms with SDK API level:
 *
 * <ul>
 *   <li>less than specified minSdkVersion OR
 *   <li>greater than specified maxSdkVersion OR
 *   <li>in the excludedSdks list.
 * </ul>
 *
 * <p>If {@code @SdkSuppress} is applied at both the class and test method, the test method
 * annotation takes precedence, and the class level {@code @SdkSuppress} is ignored.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SdkSuppress {
  /** The minimum API level to execute (inclusive) */
  int minSdkVersion() default 1;
  /** The maximum API level to execute (inclusive) */
  int maxSdkVersion() default Integer.MAX_VALUE;

  /** The (additional) list of SDK versions to exclude */
  int[] excludedSdks() default {};

  /**
   * The {@link android.os.Build.VERSION.CODENAME} to execute on. This is intended to be used to run
   * on a pre-release SDK, where the {@link android.os.Build.VERSION.SDK_INT} has not yet been
   * finalized. This is treated as an OR operation with respect to the minSdkVersion and
   * maxSdkVersion attributes.
   *
   * <p>For example, to filter a test so it runs on only the prerelease R SDK: <code>
   * {@literal @}SdkSuppress(minSdkVersion = Build.VERSION_CODES.R, codeName = "R")
   * </code>
   */
  String codeName() default "unset";
}
