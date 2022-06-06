// Generated by view binder compiler. Do not edit!
package com.example.fragments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fragments.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHw2Binding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnStarthw2;

  @NonNull
  public final Button btnStarthw2cat;

  @NonNull
  public final Button btnToScale;

  @NonNull
  public final EditText etNumber;

  @NonNull
  public final FrameLayout frgHw2;

  @NonNull
  public final TextView introRange;

  @NonNull
  public final TextView tvRangeOfNumber;

  @NonNull
  public final TextView tvSummOfNumbers;

  @NonNull
  public final TextView tvSummOfValues;

  private FragmentHw2Binding(@NonNull FrameLayout rootView, @NonNull Button btnStarthw2,
      @NonNull Button btnStarthw2cat, @NonNull Button btnToScale, @NonNull EditText etNumber,
      @NonNull FrameLayout frgHw2, @NonNull TextView introRange, @NonNull TextView tvRangeOfNumber,
      @NonNull TextView tvSummOfNumbers, @NonNull TextView tvSummOfValues) {
    this.rootView = rootView;
    this.btnStarthw2 = btnStarthw2;
    this.btnStarthw2cat = btnStarthw2cat;
    this.btnToScale = btnToScale;
    this.etNumber = etNumber;
    this.frgHw2 = frgHw2;
    this.introRange = introRange;
    this.tvRangeOfNumber = tvRangeOfNumber;
    this.tvSummOfNumbers = tvSummOfNumbers;
    this.tvSummOfValues = tvSummOfValues;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHw2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHw2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment__hw2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHw2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_starthw2;
      Button btnStarthw2 = ViewBindings.findChildViewById(rootView, id);
      if (btnStarthw2 == null) {
        break missingId;
      }

      id = R.id.btn_starthw2cat;
      Button btnStarthw2cat = ViewBindings.findChildViewById(rootView, id);
      if (btnStarthw2cat == null) {
        break missingId;
      }

      id = R.id.btn_toScale;
      Button btnToScale = ViewBindings.findChildViewById(rootView, id);
      if (btnToScale == null) {
        break missingId;
      }

      id = R.id.et_number;
      EditText etNumber = ViewBindings.findChildViewById(rootView, id);
      if (etNumber == null) {
        break missingId;
      }

      FrameLayout frgHw2 = (FrameLayout) rootView;

      id = R.id.introRange;
      TextView introRange = ViewBindings.findChildViewById(rootView, id);
      if (introRange == null) {
        break missingId;
      }

      id = R.id.tv_rangeOfNumber;
      TextView tvRangeOfNumber = ViewBindings.findChildViewById(rootView, id);
      if (tvRangeOfNumber == null) {
        break missingId;
      }

      id = R.id.tv_summOfNumbers;
      TextView tvSummOfNumbers = ViewBindings.findChildViewById(rootView, id);
      if (tvSummOfNumbers == null) {
        break missingId;
      }

      id = R.id.tv_summOfValues;
      TextView tvSummOfValues = ViewBindings.findChildViewById(rootView, id);
      if (tvSummOfValues == null) {
        break missingId;
      }

      return new FragmentHw2Binding((FrameLayout) rootView, btnStarthw2, btnStarthw2cat, btnToScale,
          etNumber, frgHw2, introRange, tvRangeOfNumber, tvSummOfNumbers, tvSummOfValues);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
