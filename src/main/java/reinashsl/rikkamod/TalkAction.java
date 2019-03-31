package reinashsl.rikkamod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.SpeechBubble;

public class TalkAction extends AbstractGameAction {
    private String msg;
    private boolean used;
    private float bubbleDuration;
    private boolean player;

    public TalkAction(AbstractCreature source, String text, float duration, float bubbleDuration) {
        this.used = false;// 11
        this.player = false;// 13
        this.setValues(source, source);// 16
        if (Settings.FAST_MODE) {// 17
            this.duration = Settings.ACTION_DUR_MED;// 18
        } else {
            this.duration = duration;// 20
        }

        this.msg = text;// 23
        this.actionType = ActionType.TEXT;// 24
        this.bubbleDuration = bubbleDuration;// 25
        this.player = false;// 26
    }// 27

    public TalkAction(AbstractCreature source, String text) {
        this(source, text, 2.0F, 2.0F);// 30
    }// 31

    public TalkAction(boolean isPlayer, String text, float duration, float bubbleDuration) {
        this(AbstractDungeon.player, text, duration, bubbleDuration);// 34
        this.player = isPlayer;// 35
    }// 36

    public void update() {
        if (!this.used) {// 40
            if (this.player) {// 41
                AbstractDungeon.effectList.add(new SpeechBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, this.bubbleDuration, this.msg, this.source.isPlayer));// 42
            } else {
                AbstractDungeon.effectList.add(new SpeechBubble(0F + 400F, 0 + 200F, this.bubbleDuration, this.msg, this.source.isPlayer));// 50
            }

            this.used = true;// 58
        }

        this.tickDuration();// 61
    }// 62
}
