package com.example.cristianvillamil.pruebaspatrones.commons.interfaces;

import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public interface BaseActivity {
    void getUIElements(@Nullable View view);
    void setEventsLogics();
}
