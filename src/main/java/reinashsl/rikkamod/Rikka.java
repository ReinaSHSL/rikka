package reinashsl.rikkamod;

import basemod.ClickableUIElement;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.TipHelper;

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

    public void doNotHarassTheWaifu() {
        AbstractDungeon.actionManager.addToBottom(new TalkAction(AbstractDungeon.player,
                harassmentLines.get(AbstractDungeon.miscRng.random(harassmentLines.size() - 1)),
                2F, 2F));
    }
}
