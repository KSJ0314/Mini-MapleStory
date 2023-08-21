package frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import unit.Askill;
import unit.Attack;
import unit.Block;
import unit.Dskill;
import unit.Exp;
import unit.Hp;
import unit.HpMp;
import unit.Level;
import unit.LevelUp;
import unit.Lof;
import unit.Mob;
import unit.Mob_Snail;
import unit.Mp;
import unit.Player;
import unit.SnailAt;
import unit.Sskill;
import unit.SwingAt;
import unit.UltAt;

public class MainPanel extends JPanel {
	public Image background = new ImageIcon(MyFrame.class.getResource("../image/map1.png")).getImage(); // 배경화면
	public HpMp hpmp;
	public Hp hp;
	public Mp mp;
	public Askill askill;
	public Sskill sskill;
	public Dskill dskill;
	public Level level;
	public Exp exp;
	public Player pl;
	public Mob[] mob = new Mob[6];
	public Block[] block = new Block[12];
	public Lof[] lof = new Lof[3];
	public LevelUp levelUp;
	public Attack[] attack = new Attack[4];

	public MainPanel() {
		setSize(736, 542); // 사이즈 조정
		setLayout(null); // layout 자유설정 (id,pass 입력필드, 버튼 위치 상세조정을 위해 필요)
		setVisible(false);
		hpmp = new HpMp();
		hp = new Hp();
		mp = new Mp();
		askill = new Askill();
		sskill = new Sskill();
		dskill = new Dskill();
		level = new Level();
		exp = new Exp();
		pl = new Player();
		levelUp = new LevelUp(0, 0);
		attack[0] = new SnailAt();
		attack[1] = new SnailAt();
		attack[2] = new SwingAt();
		attack[3] = new UltAt();
		for (int i = 0; i < attack.length; i++) {
			add(attack[i]);
			add(attack[i].hitJl);
		}
		for (JLabel i : attack[3].uthitJl) {
			add(i);
		}
		add(levelUp);
		add(level);
		add(hpmp);
		add(hp);
		add(mp);
		add(askill);
		add(sskill);
		add(dskill);
		add(exp);
		addBlock();
		mob[0] = new Mob_Snail(132, 65, 50);
		mob[1] = new Mob_Snail(548, 65, 50);
		mob[2] = new Mob_Snail(92, 174, 40);
		mob[3] = new Mob_Snail(592, 174, 40);
		mob[4] = new Mob_Snail(110, 394, 55);
		mob[5] = new Mob_Snail(573, 394, 55);
		mob[0].right = true;
		mob[3].right = true;
		mob[5].right = true;
		for (int i = 0; i < 6; i++) {
			addMop(mob[i]);
		}
		add(pl);

	}

	public void addBlock() {
		block[0] = new Block(0, 420, 720);
		block[1] = new Block(0, 200, 220);
		block[2] = new Block(500, 200, 220);
		block[3] = new Block(32, 91, 240);
		block[4] = new Block(448, 91, 240);
		block[5] = new Block(295, 128, 130);
		block[6] = new Block(242, 165, 80);
		block[7] = new Block(398, 165, 80);
		block[8] = new Block(140, 347, 80);
		block[9] = new Block(500, 347, 80);
		block[10] = new Block(190, 383, 80);
		block[11] = new Block(450, 383, 80);
		for (Block i : block) {
			add(i);
		}
		lof[0] = new Lof(96, 206, 144);
		lof[1] = new Lof(590, 206, 144);
		lof[2] = new Lof(278, 0, 60);
		for (Lof i : lof) {
			add(i);
		}
	}

	public void addMop(Mob mob) {
		add(mob);
		add(mob.jl);
		add(mob.j2);
	}

	public void reMop(Mob mob) {
		mob.hp = mob.prehp;
		mob.xStart = mob.prexStart;
		mob.yStart = mob.preyStart;
		mob.x = mob.prex;
		mob.y = mob.prey;
		mob.right = false;
		mob.isDie = false;
		mob.setIcon(mob.move[0]);
		mob.stayCount = 0;
		mob.hittime = 0;
		mob.setVisible(true);
		mob.jl.setVisible(true);
		mob.j2.setVisible(true);
	}
	
	public void removeMop(Mob mob) {
		mob.setVisible(false);
		mob.jl.setVisible(false);
		mob.j2.setVisible(false);
	}

	public void paintComponent(Graphics g) { // 백그라운드 이미지 설정
		g.drawImage(background, 0, 0, null);
	}

}
