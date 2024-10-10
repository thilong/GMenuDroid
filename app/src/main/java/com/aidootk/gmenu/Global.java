package com.aidootk.gmenu;

import android.content.Context;

import com.aidootk.model.DBCommonDao;
import com.aidootk.model.DBContext;
import com.aidootk.model.db.Platform;
import com.aidootk.model.db.Setting;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private static Global instance;

    public static Global shared() {
        if (instance == null) {
            instance = new Global();
        }
        return instance;
    }

    private Context context;

    public void init(Context context) {
        this.context = context;
        initDatabase();
    }

    private void initDatabase() {
        DBCommonDao<Setting, String> setting = new DBCommonDao<>(context, Setting.class);
        setting.add(new Setting("platform.default", "gb,gba,gbc,fc,sfc,md,ps,nds,ps2,psp,wsc,ws,ngp,ngc,dc,ss,3ds,switch"));
        setting.add(new Setting("platform.gb", "{}"));
    }


    private ArrayList<Platform> defaultPlatforms;

    public List<Platform> getDefaultPlatforms() {
        if (defaultPlatforms == null) {
            defaultPlatforms = new ArrayList<>();
            defaultPlatforms.add(new Platform("gb", "Nintendo Gameboy"));
            defaultPlatforms.add(new Platform("gbc", "Nintendo Gameboy Color"));
            defaultPlatforms.add(new Platform("gba", "Nintendo Gameboy Advance"));
            defaultPlatforms.add(new Platform("fc", "Nintendo Famicom"));
            defaultPlatforms.add(new Platform("sfc", "Nintendo Super Famicom"));
            defaultPlatforms.add(new Platform("md", "Sega Mega Drive"));
            defaultPlatforms.add(new Platform("ps", "Sony PlayStation"));
            defaultPlatforms.add(new Platform("nds", "Nintendo DS"));
            defaultPlatforms.add(new Platform("ps2", "Sony PlayStation 2"));
            defaultPlatforms.add(new Platform("psp", "Sony PlayStation Portable"));
            defaultPlatforms.add(new Platform("wsc", "WonderSwan Color"));
            defaultPlatforms.add(new Platform("ws", "WonderSwan"));
            defaultPlatforms.add(new Platform("ngp", "Neo Geo Pocket"));
            defaultPlatforms.add(new Platform("ngc", "Nintendo GameCube"));
            defaultPlatforms.add(new Platform("dc", "Sega Dreamcast"));
            defaultPlatforms.add(new Platform("ss", "Sega Saturn"));
            defaultPlatforms.add(new Platform("3ds", "Nintendo 3DS"));
            defaultPlatforms.add(new Platform("switch", "Nintendo Switch"));
            defaultPlatforms.add(new Platform("mame", "MAME"));
            defaultPlatforms.add(new Platform("fbn", "FinalBurn Neo"));
            defaultPlatforms.add(new Platform("arcade", "Arcade"));
            defaultPlatforms.add(new Platform("cps", "Capcom Play System"));
            defaultPlatforms.add(new Platform("cps2", "Capcom Play System II"));
            defaultPlatforms.add(new Platform("cps3", "Capcom Play System III"));
            defaultPlatforms.add(new Platform("neogeo", "Neo Geo"));
            defaultPlatforms.add(new Platform("pce", "PC Engine"));
            defaultPlatforms.add(new Platform("msx", "MSX"));
            defaultPlatforms.add(new Platform("c64", "Commodore 64"));
            defaultPlatforms.add(new Platform("atari2600", "Atari 2600"));
            defaultPlatforms.add(new Platform("atari7800", "Atari 7800"));
            defaultPlatforms.add(new Platform("lynx", "Atari Lynx"));
            defaultPlatforms.add(new Platform("vectrex", "Vectrex"));
            defaultPlatforms.add(new Platform("ngp", "Neo Geo Pocket"));
        }
        return defaultPlatforms;
    }


}
