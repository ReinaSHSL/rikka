package reinashsl.rikkamod;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.SpeechBubble;

@SpirePatch(
        clz = AbstractPlayer.class,
        method = "damage"
)
public class DamagePatch {
    public static void Prefix(AbstractPlayer __instance, DamageInfo useless) {
        AbstractDungeon.effectList.add(new SpeechBubble(Rikka.x + 50F, Rikka.y + 100F, "Daijoubu?", false));
    }
}
