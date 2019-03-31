package reinashsl.rikkamod;

import basemod.ClickableUIElement;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.TipHelper;

public class Rikka extends ClickableUIElement {

    public Rikka() {
        super(TextureLoader.getTexture("rikka/rikka.png"), -1150F, 0, 230F, 240F);
    }

    @Override
    protected void onHover() {
        TipHelper.renderGenericTip(50.0f * Settings.scale, 380.0f * Settings.scale,
                "Rikka Takarada", "Your trusty Waifu. Gives you encouragement.");
    }

    @Override
    protected void onUnhover() {

    }

    @Override
    protected void onClick() {
        doNotHarassTheWaifu();
    }
}
