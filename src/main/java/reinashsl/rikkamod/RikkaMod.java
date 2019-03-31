package reinashsl.rikkamod;

import basemod.BaseMod;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.PreRenderSubscriber;
import basemod.interfaces.RenderSubscriber;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
public class RikkaMod implements RenderSubscriber, PostInitializeSubscriber {
    public static Rikka rikka;

    @SuppressWarnings("unused")
    public static void initialize() {
        BaseMod.subscribe(new RikkaMod());
    }


    @Override
    public void receiveRender(SpriteBatch sb) {
        if (AbstractDungeon.player != null && CardCrawlGame.dungeon != null && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (!AbstractDungeon.isScreenUp) {
                rikka.render(sb);
                rikka.update();
            }
        }
    }

    @Override
    public void receivePostInitialize() {
        rikka = new Rikka(TextureLoader.getTexture("rikka/rikka.png"));
    }
}
