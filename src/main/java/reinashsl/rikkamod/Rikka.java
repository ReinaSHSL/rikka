package reinashsl.rikkamod;

import basemod.ClickableUIElement;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.helpers.input.InputHelper;

import java.util.ArrayList;

public class Rikka extends ClickableUIElement {
    private ArrayList<String> harassmentLines = new ArrayList<String>() {
        {
            add("That hurts!");
            add("Not like this.");
            add("Pervert!");
            add("Where do you think you're touching?");
            add("thicc");
            add("Hands off!");
            add("Just this once...");
            add("Hnn..");
            add("Eh...");
            add("Please...");
            add("...!");
            add("I'm calling the cops.");
        }
    };
    private String s = "Hey!";
    private float timer = 2;
    private static float x = 0;
    private static float y = 300f;

    public Rikka(Texture img) {
        super(img, x, y, 300F, 300F);
    }

    @Override
    protected void onHover() {
        timer -= Gdx.graphics.getDeltaTime();
        if (timer <= 0) {
            s = harassmentLines.get(AbstractDungeon.miscRng.random(harassmentLines.size() - 1));
            timer = 2;
        }
        TipHelper.renderGenericTip(50.0f * Settings.scale, 380.0f * Settings.scale,
                "Rikka Takarada:", s);
    }

    @Override
    protected void onUnhover() {

    }

    @Override
    protected void onClick() {

    }

}
