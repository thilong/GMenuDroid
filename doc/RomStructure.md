# GMenuDroid rom structure

## Roms folder

```
roms
├   gba
│ ├  platform.yml                   (platform meta file)
│ ├  roms.yml                       (rom meta file)
│ └  imgs                           (preview image, boxart folder)
│ │         ├ kofm.zip.png  
│ │         └ mario.zip.png
│ ├  kofm.zip                       (rom file)
│ ├  mario.zip  
│ └  rpg                            (sub folder)
│       ├  roms.yml
│       ├  dq3.zip
│       └  imgs                           (preview image, boxart folder)
│ │         └ dq3.zip.png  
├   sfc
└   ps
```



## platform.yml
``` yml
name: gba
fullName: game boy advance
desc: nintendo game boy advance
emulators:
    - name: mgba
      desc: mGBA is a new generation of Game Boy Advance emulator. 
      cmd: am start -n mba.emu -r {ROM_PATH} -c full_screen
    - name: vba next
      desc: Optimized port of VBA-M to Libretro.
      cmd: am start -n retro -l vba-next -r {ROM_PATH} -c full_screen
```


## roms.yml

``` yml
- name: Super Mario
  file: mario.zip
  desc: super mario is a very nice act game powered by nintendo.
  emulator: mgba

- name: Super Mario
  file: mario.zip
  desc: super mario is a very nice act game powered by nintendo.

- name: Super Mario
  file: mario.zip
```
