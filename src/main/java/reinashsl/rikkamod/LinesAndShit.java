package reinashsl.rikkamod;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.SpeechBubble;


public class LinesAndShit {

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "damage"
    )
    public static class Dmg {
        public static void Prefix(AbstractPlayer __instance, DamageInfo useless) {
            AbstractDungeon.effectList.add(new SpeechBubble(Rikka.x + 50F, Rikka.y + 100F, "Daijoubu?", false));
        }
    }

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "applyStartOfTurnRelics"
    )
    public static class StartTurn {
        public static void Prefix(AbstractPlayer __instance) {
            if (AbstractDungeon.miscRng.random(99) < 30) {
                AbstractDungeon.effectList.add(new SpeechBubble(Rikka.x + 50F, Rikka.y + 100F, "Ganbarimasu!", false));
            } else if (AbstractDungeon.miscRng.random(99) < 50) {
                AbstractDungeon.effectList.add(new SpeechBubble(Rikka.x + 50F, Rikka.y + 100F, "Senpai!", false));
            }
        }
    }
}
