package reinashsl.rikkamod;

import basemod.BaseMod;
import basemod.interfaces.PreRenderSubscriber;
import basemod.interfaces.RenderSubscriber;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
public class RikkaMod implements RenderSubscriber {
    public static Rikka rikka = new Rikka();

    @SuppressWarnings("unused")
    public static void initialize() {
        BaseMod.subscribe(new RikkaMod());
    }


    @Override
    public void receiveRender(SpriteBatch sb) {
        if (CardCrawlGame.dungeon != null
                && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            rikka.render(sb);
        }
    }
}
