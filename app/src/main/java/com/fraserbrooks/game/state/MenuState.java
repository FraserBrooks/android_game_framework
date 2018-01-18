package com.fraserbrooks.game.state;

import android.view.MotionEvent;

import com.fraserbrooks.android_gdf.GameMainActivity;
import com.fraserbrooks.framework.util.Painter;
import com.fraserbrooks.android_gdf.Assets;

/**
 * Created by Fraser on 19/12/2017.
 */

class MenuState extends State {

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.welcome_por, 0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
