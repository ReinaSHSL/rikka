package reinashsl.rikkamod;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.VelvetChoker;
import com.megacrit.cardcrawl.vfx.SpeechBubble;


public class LinesAndShit {

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "damage"
    )
    public static class Dmg {
        public static void Prefix(AbstractPlayer __instance, DamageInfo useless) {
            AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                    "Daijoubu?", true));
        }
    }

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "applyStartOfTurnRelics"
    )
    public static class StartTurn {
        public static void Prefix(AbstractPlayer __instance) {
            if (AbstractDungeon.miscRng.random(99) < 30) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                        "Ganbarimasu!", true));
            } else if (AbstractDungeon.miscRng.random(99) < 50) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                        "Senpai!", true));
            } else if (AbstractDungeon.miscRng.random(99) < 60) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                        "Suki desu...", true));
            }
        }
    }

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "applyStartOfCombatLogic"
    )
    public static class StartBattle {
        public static void Postfix(AbstractPlayer __instance) {
            AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                    "Yoroshiku~", true));
        }
    }

    @SpirePatch(
            clz = AbstractPlayer.class,
            method = "onVictory"
    )
    public static class Victory {
        public static void Prefix(AbstractPlayer __instance) {
            AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                    "Yoku dekimashita!", true));
        }
    }

    @SpirePatch(
            clz = VelvetChoker.class,
            method = "onPlayCard"
    )
    public static class Choker {
        public static void Postfix(VelvetChoker __instance, AbstractCard useless, AbstractMonster useless2) {
            if (__instance.counter == 6) {
                AbstractDungeon.effectList.add(new SpeechBubble((Rikka.x + 200F) * Settings.scale, (Rikka.y + 300F) * Settings.scale,
                        "Yamete...", true));
            }
        }
    }
}
