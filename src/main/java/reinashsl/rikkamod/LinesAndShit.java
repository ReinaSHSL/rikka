package reinashsl.rikkamod;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.SpeechBubble;


public class LinesAndShit {

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "damage"
    )
    public static class Dmg {
        public static void Prefix(AbstractPlayer __instance, DamageInfo useless) {
            AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale, "Daijoubu?", true));
        }
    }

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "applyStartOfTurnRelics"
    )
    public static class StartTurn {
        public static void Prefix(AbstractPlayer __instance) {
            if (AbstractDungeon.miscRng.random(99) < 30) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale, "Ganbarimasu!", true));
            } else if (AbstractDungeon.miscRng.random(99) < 50) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale, "Senpai!", true));
            }
        }
    }
}
