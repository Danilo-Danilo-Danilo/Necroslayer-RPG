package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Thief;
import com.nilo.necroslayer.jobs.WhiteMage;

public class Lenna extends Charac {
	public Lenna(){
		this.setNumber(1);
		this.setLevel(1);
		this.setName("Kath");
		this.setMaxHp(35);
		this.setHp(this.getMaxHp());
		this.setMaxMp(5);
		this.setMp(this.getMaxMp());
		this.setStrenght(25);
		this.setAgility(26);
		this.setStamina(25);
		this.setMagic(28);
		this.setAtk(6);
		this.setDef(1);
		this.setEvade(0);
		this.setMdef(1);
		this.setMevade(0);
		this.setSprites(new TextureAtlas(Gdx.files.internal("lenna.atlas")));
		this.setrHand(new Weapon("Cajado", "pedaço de madeira que encontrei no chao", 6,3));
		this.setJob(new WhiteMage(this));
		this.setTexture(new Texture(Gdx.files.internal("char2.png")));
		this.setOnlySprite(new Sprite(this.getTexture(),31,32));
	}

}
